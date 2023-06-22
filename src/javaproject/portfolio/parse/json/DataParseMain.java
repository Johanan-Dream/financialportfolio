package javaproject.portfolio.parse.json;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataParseMain extends JFrame{
	JPanel p_west;
	JTextField t_url;
	JButton bt_load;

	JPanel p_north;
	JButton bt_down;
	
	DataParseModel model;
	JTable table;
	JScrollPane scroll;
	
	JFileChooser chooser;
	
	ArrayList<ProductData> productList;
	
	public DataParseMain() {
		chooser= new JFileChooser("C:/java_data/networkapp/data");

		p_west=new JPanel();
		t_url=new JTextField(70);//json링크를 디폴트로 넣기
		bt_load=new JButton("Load");
		p_west.add(bt_load);
		p_west.setPreferredSize(new Dimension(150,700));
		add(p_west, BorderLayout.WEST);
		
		p_north= new JPanel();
		bt_down= new JButton("엑셀로 저장하기");
		p_north.add(t_url);
		p_north.add(bt_down);
		add(p_north, BorderLayout.NORTH);
		
		
		table=new JTable(model=new DataParseModel());
		scroll=new JScrollPane(table);
		add(scroll);
		
		setSize(1000,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String jsonData=loadDaraFromURL(t_url.getText());

				List list=parseData(jsonData);
				System.out.println(list.size());

				model.productList=(ArrayList) list;

				table.updateUI();

				productList=(ArrayList)list;
			}
		});
		
		t_url.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					String jsonData=loadDaraFromURL(t_url.getText());
	
					List list=parseData(jsonData);
					System.out.println(list.size());
	
					model.productList=(ArrayList) list;
	
					table.updateUI();
	
					productList=(ArrayList)list;
				 }
			}
			
		});
		bt_down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAsFile();
			}
		});
	}
	
	
	
	public void saveAsFile() {
		int result=chooser.showSaveDialog(this);
		if(result!=JFileChooser.APPROVE_OPTION) {
			return;
		}

		File file=chooser.getSelectedFile();
		String path=file.getAbsolutePath();
		System.out.println(path);
		
		HSSFWorkbook book= new HSSFWorkbook();
		
		HSSFSheet sheet=book.createSheet();
		
		HSSFRow row=sheet.createRow(0);
		
		String[] columnName= {"bank_name", "product_name", "jlimit", "period", "irtype", "default_ir", "max_ir", "maxAmount"};
		for(int i=0;i<columnName.length;i++) {
			HSSFCell cell=row.createCell(i);

			cell.setCellValue(columnName[i]);
		}
		

		for(int i=0;i<productList.size();i++) {

			ProductData product=productList.get(i);
			
			HSSFRow record=sheet.createRow(i+1);
			
			HSSFCell bank_name=record.createCell(0);
			HSSFCell product_name=record.createCell(1);
			HSSFCell jlimit=record.createCell(2);
			HSSFCell period=record.createCell(4);
			HSSFCell irtype=record.createCell(5);
			HSSFCell default_ir=record.createCell(6);
			HSSFCell max_ir=record.createCell(7);
			HSSFCell maxAmount=record.createCell(7);
			
			bank_name.setCellValue(product.getBank_name());
			product_name.setCellValue(product.getProduct_name());
			jlimit.setCellValue(product.getProduct_name());
			maxAmount.setCellValue(product.getMax_amount());
		}
		
		FileOutputStream fos=null;
		
		try {
			fos=new FileOutputStream(file);
			book.write(fos);
			JOptionPane.showMessageDialog(this, "엑셀파일 저장완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String loadDaraFromURL(String url) {
		InputStream is=null;
		InputStreamReader reader=null;
		BufferedReader buffr=null;
		
		StringBuilder sb= new StringBuilder();
		try {
			URL urlObj=new URL(url);
			is=urlObj.openStream();
			reader=new InputStreamReader(is);
			buffr=new BufferedReader(reader);
			
			String data=null;
			while(true) {
				data=buffr.readLine();
				if(data==null)break;
				sb.append(data);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(buffr!=null) {
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
	public List parseData(String data) {
		ArrayList<ProductData> list=new ArrayList<ProductData>();
		JSONParser jsonParser=new JSONParser();//파서생성
		try {
			JSONObject json=(JSONObject)jsonParser.parse(data);
			JSONObject result=(JSONObject)json.get("result");
			JSONArray array1=(JSONArray)result.get("baseList");
			JSONArray array2=(JSONArray)result.get("optionList");
			
			System.out.println("파싱결과 총 "+array1.size()+"개 입니다.");
			
			for(int i=0;i<array1.size();i++) {
				JSONObject product1=(JSONObject)array1.get(i);
				ProductData dto=new ProductData();
				dto.setBank_name((String)product1.get("kor_co_nm"));
				dto.setProduct_name((String)product1.get("fin_prdt_nm"));
				dto.setJlimit((String)product1.get("join_deny"));
				
				list.add(dto);
			}
			
			for(int a=0;a<array2.size();a++) {
				JSONObject product2=(JSONObject)array2.get(a);
				ProductData dto=new ProductData();
				
				dto.setProduct_name((String)product2.get("fin_co_no"));
				dto.setIrtype((String)product2.get("intr_rate_type_nm"));
				dto.setDefault_ir(String.valueOf(product2.get("intr_rate")));
				dto.setMax_ir(String.valueOf(product2.get("intr_rate2")));
				dto.setJlimit((String)product2.get("max_limit"));
				dto.setPeriod((String)product2.get("save_trm"));
	
				list.add(dto);
			}
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		new DataParseMain();
	}
}
