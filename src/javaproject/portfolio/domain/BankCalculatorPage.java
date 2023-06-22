package javaproject.portfolio.domain;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javaproject.portfolio.DTO.PortFolio;
import javaproject.portfolio.DTO.ProductName;

public class BankCalculatorPage extends Page{
	//센터영역
	JPanel p_center;
	
	//검색영역
	JPanel p_center_top;
	JComboBox box_search1;
	JComboBox box_search2;
	JTextField t_search;
	JButton bt_search;
	
	//테이블 영역
	JPanel p_center_down;
	JTable table;
	JScrollPane scroll;
	
	//동쪽 영역
	JPanel p_east;
	
	//계산기 영역
	//계산영역
	JPanel p_east_top;
	JLabel l_ctitle;
	JLabel l_bankname;
	JTextField t_bankname;
	JLabel l_productType;
	JTextField t_productType;
	JLabel l_productName;
	JTextField t_productName;
	JLabel l_jlimit;
	JTextField t_jlimit;
	JLabel l_period;
	JComboBox box_period;
	JLabel l_irtype;
	JTextField t_irtype;
	JLabel l_ir;
	JComboBox box_ir;
	JLabel l_amount;
	JTextField t_amount;
    JButton bt_cal;
	
	//출력 영역
	JPanel p_east_down;
	JLabel l_rtitle;
	JLabel l_totalAmount;
	JTextField t_totalAmount;
	JLabel l_ibtd;
	JTextField t_ibtd;
	JLabel l_taxAmount;
	JTextField t_taxAmount;
	JLabel l_atra;
	JTextField t_atra;
	JButton bt_add;
	
	//포트폴리오로 이동하기
	JButton bt_move;
	
	ProductNameModel model;
	ProductName productName;//선택한 record
	
	public BankCalculatorPage(PortfolioMain portfolioMain) {
		super(portfolioMain);
		//센터영역
		p_center=new JPanel();
		
		//검색영역
		p_center_top= new JPanel();
		box_search1=new JComboBox();
		box_search2=new JComboBox();
		t_search=new JTextField();
		bt_search=new JButton("검색하기");
		
		//테이블 영역
		p_center_down=new JPanel();
		table=new JTable(model=new ProductNameModel());
		scroll=new JScrollPane(table);
		
		//테이블 디자인
		table.getColumnModel().getColumn(0).setPreferredWidth(8);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(15);
		table.getColumnModel().getColumn(3).setPreferredWidth(220);
		table.getColumnModel().getColumn(4).setPreferredWidth(32);
		table.getColumnModel().getColumn(5).setPreferredWidth(12);
		table.getColumnModel().getColumn(6).setPreferredWidth(12);
		table.getColumnModel().getColumn(7).setPreferredWidth(12);
		table.getColumnModel().getColumn(8).setPreferredWidth(12);
		
		//동쪽 영역
		p_east=new JPanel();
		
		//계산기 영역
		//계산영역
		p_east_top=new JPanel();
		l_ctitle=new JLabel("         금융계산기");
		l_bankname=new JLabel("은행이름");
		t_bankname=new JTextField(10);
		l_productType=new JLabel("상품종류");
		t_productType=new JTextField(10);
		l_productName= new JLabel("상품이름");
		t_productName=new JTextField(10);
		l_jlimit=new JLabel("가입제한");
		t_jlimit=new JTextField(10);
		l_period=new JLabel("기       간");
		box_period=new JComboBox();
		l_irtype=new JLabel("금리유형");
		t_irtype=new JTextField(10);
		l_ir=new JLabel("금       리");
		box_ir=new JComboBox();
		l_amount=new JLabel("금       액");
		t_amount=new JTextField("10000", 10);
		bt_cal=new JButton("계산하기");
		
		//출력 영역
		p_east_down=new JPanel();
		l_rtitle=new JLabel("            계산결과");
		l_totalAmount=new JLabel("원 금 합 계 ");
		t_totalAmount= new JTextField(10);
		l_ibtd=new JLabel("세 전 이 자 ");
		t_ibtd=new JTextField(10);
		l_taxAmount=new JLabel("이 자 과 세 ");
		t_taxAmount=new JTextField(10);
		l_atra=new JLabel("세후수령액 ");
		t_atra=new JTextField(10);
		bt_add=new JButton("포트폴리오 추가");
		bt_move=new JButton("포트폴리오 확인하기");
		
		//스타일
		//폰트설정
		Font dFont=new Font("맑은고딕", Font.BOLD, 13);
		l_bankname.setFont(dFont);
		l_productType.setFont(dFont);
		l_productName.setFont(dFont);
		l_jlimit.setFont(dFont);
		l_period.setFont(dFont);
		l_irtype.setFont(dFont);
		l_ir.setFont(dFont);
		l_amount.setFont(dFont);
		l_totalAmount.setFont(dFont);
		l_ibtd.setFont(dFont);
		l_taxAmount.setFont(dFont);
		l_atra.setFont(dFont);
		Font bFont=new Font("맑은고딕", Font.BOLD, 12);
		bt_search.setFont(bFont);
		bt_cal.setFont(bFont);
		bt_add.setFont(bFont);
		bt_move.setFont(bFont);
		
		//센터영역
		p_center.setPreferredSize(new Dimension(900,650));
		//센터-검색영역
		p_center_top.setPreferredSize(new Dimension(900,50)); 
		box_search1.setFont(new Font("맑은고딕", Font.BOLD, 13));
		box_search1.setPreferredSize(new Dimension(100,20));
		
		box_search2.setFont(new Font("맑은고딕", Font.BOLD, 13));
		box_search2.setPreferredSize(new Dimension(100,20));
		t_search.setPreferredSize(new Dimension(585,20));
		//센터-테이블 영역
		p_center_down.setPreferredSize(new Dimension(900,600)); 
		scroll.setPreferredSize(new Dimension(900,550)); 
		
		//계산기영역
		p_east.setPreferredSize(new Dimension(200,650));
		//계산영역
		p_east_top.setPreferredSize(new Dimension(200,300));
		l_ctitle.setPreferredSize(new Dimension(200,50));
		l_rtitle.setPreferredSize(new Dimension(200,50));
		Font font_title=new Font("맑은고딕", Font.BOLD, 20);
		l_ctitle.setFont(font_title);
		l_rtitle.setFont(font_title);
		box_period.setPreferredSize(new Dimension(115,20));
		box_ir.setPreferredSize(new Dimension(115,20));
		//계산기-출력 영역
		p_east_down.setPreferredSize(new Dimension(200,350));
		
		//검색영역 부착
		p_center_top.add(box_search1);
		p_center_top.add(box_search2);
		p_center_top.add(t_search);
		p_center_top.add(bt_search);
		
		//테이블영역 부착
		p_center_down.add(scroll);
		
		//계산기 영역 부착
		p_east_top.add(l_ctitle);
		p_east_top.add(l_bankname);
		p_east_top.add(t_bankname);
		p_east_top.add(l_productType);
		p_east_top.add(t_productType);
		p_east_top.add(l_productName);
		p_east_top.add(t_productName);
		p_east_top.add(l_jlimit);
		p_east_top.add(t_jlimit);
		p_east_top.add(l_period);
		p_east_top.add(box_period);
		p_east_top.add(l_irtype);
		p_east_top.add(t_irtype);
		p_east_top.add(l_ir);
		p_east_top.add(box_ir);
		p_east_top.add(l_amount);
		p_east_top.add(t_amount);
		p_east_top.add(bt_cal);
		
		//출력 영역
		p_east_down.add(l_rtitle);
		p_east_down.add(l_totalAmount);
		p_east_down.add(t_totalAmount);
		p_east_down.add(l_ibtd);
		p_east_down.add(t_ibtd);
		p_east_down.add(l_taxAmount);
		p_east_down.add(t_taxAmount);
		p_east_down.add(l_atra);
		p_east_down.add(t_atra);
		p_east_down.add(bt_add);
		p_east_down.add(bt_move);
		
		p_center.add(p_center_top, BorderLayout.NORTH);
		p_center.add(p_center_down, BorderLayout.SOUTH);
		
		p_east.add(p_east_top, BorderLayout.NORTH);
		p_east.add(p_east_down, BorderLayout.SOUTH);
		
		add(p_center);
		add(p_east, BorderLayout.EAST);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(table.getRowSelectionAllowed()) {//테이블의 컬럼을 선택했을때 정보 반영
					String value=(String)table.getValueAt(table.getSelectedRow(), 0);
					getDetail(Integer.parseInt(value));
					reset();
				}
			}
		});
		
		bt_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t_totalAmount.getText().equals("")||t_ibtd.getText().equals("")||t_taxAmount.getText().equals("")||t_atra.getText().equals("")) {
					JOptionPane.showMessageDialog(portfolioMain, "상품정보를 확인해주세요.", "안내", JOptionPane.INFORMATION_MESSAGE);
				}else {
					//버튼 누를때 정보 DTO에 담기
					saveResult();
					reset();
				}
			}
		});
		
		bt_move.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortfolioPage portfolioPage=(PortfolioPage)portfolioMain.pages[PortfolioMain.PORTFOLIOPAGE];
				portfolioPage.table.updateUI();
				portfolioMain.showHide(portfolioMain.PORTFOLIOPAGE);
			}
		});
		
		bt_cal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t_bankname.getText().equals("")||t_productType.getText().equals("")||t_productName.getText().equals("")||t_amount.getText().equals("")) {
					JOptionPane.showMessageDialog(portfolioMain, "상품이 선택되지 않았습니다.", "경고", JOptionPane.ERROR_MESSAGE);
					
				}else {
					//금액설정(최소한도~최대한도)
					int amount=Integer.parseInt(t_amount.getText());
					int maxAmount=productName.getMax_amount();
					if(amount>=10000&amount<=maxAmount) {
						
						//기간설정(기간 이상만 가능, 미만은 불가능)
						int month=Integer.parseInt(box_period.getSelectedItem().toString());
						int period=productName.getPeriod();
						if(month>=period) {
							if(t_productType.getText().equals("적금")) {//선택한 상품이 적금인 경우						
								savingCal();
							}else{//선택한 상품이 예금인 경우
								depositCal();
							}
						}else {
							JOptionPane.showMessageDialog(portfolioMain, "기간을 확인해주세요.", "안내", JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(portfolioMain, "금액을 확인해주세요.", "안내", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		bt_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		
		createBoxItem();
		productList();
	}
	
	public void saveResult() {
		PortFolio portFolio=new PortFolio();//클릭한 상품 정보 및 이자 계산 내용을 옮길 DTO
		portFolio.setBank_name(t_bankname.getText());
		portFolio.setProduct_type(t_productType.getText());
		portFolio.setProduct_name(t_productName.getText());
		portFolio.setPeriod(Integer.parseInt(box_period.getSelectedItem().toString()));
		portFolio.setTotalAmount(Integer.parseInt(t_totalAmount.getText()));
		portFolio.setIbtd(Integer.parseInt(t_ibtd.getText()));
		portFolio.setTaxAmount(Integer.parseInt(t_taxAmount.getText()));
		portFolio.setAtra(Integer.parseInt(t_atra.getText()));
		
		int ibtd=Integer.parseInt(t_ibtd.getText());
		int taxAmount=Integer.parseInt(t_taxAmount.getText());
		int irat=ibtd-taxAmount;
		portFolio.setIrat(irat);
		
		PortfolioPage portfolioPage=(PortfolioPage)portfolioMain.pages[PortfolioMain.PORTFOLIOPAGE];
		portfolioPage.model.list.add(portFolio);
		int productNum=portfolioPage.model.list.size();
		
		JOptionPane.showMessageDialog(portfolioMain, "상품이 추가되었습니다.\n포트폴리오에 담긴 상품의 수 : "+productNum);
	}
	public void depositCal() {//예금 계산식-단리
		if(t_irtype.getText().equals("단리")) {
			int amount=Integer.parseInt(t_amount.getText());//금액
			double ir=(double)box_ir.getSelectedItem()/100;//금리	
			int month=Integer.parseInt(box_period.getSelectedItem().toString());//기간
			double tax=15.4/100;
			//예금계산식
			int result=(int)(amount*ir)/12*month;
			//원금 합
			t_totalAmount.setText(Integer.toString(amount));
			//세전이자
			t_ibtd.setText(Integer.toString(result));
			//이자과세
			t_taxAmount.setText(Integer.toString((int) (result*tax)));
			//세후 수령액
			t_atra.setText(Integer.toString((int)(amount+(result-(result*tax)))));		
		}else {//예금 계산식-연복리
			int amount=Integer.parseInt(t_amount.getText());//금액
			double ir=(double)box_ir.getSelectedItem()/100;//금리	
			int mm=Integer.parseInt(box_period.getSelectedItem().toString());
			int month=mm/12;//기간
			double tax=15.4/100;
			//예금계산식
			double result = Math.pow(((double)1+ir), month); 
			int  totalAmount=(int) ((int)amount*result);
			//원금 합
			t_totalAmount.setText(Integer.toString(amount));
			//세전이자
			t_ibtd.setText(Integer.toString(totalAmount-amount));
			//이자과세
			int ibtd=totalAmount-amount;
			t_taxAmount.setText(Integer.toString((int) (ibtd*tax)));
			//세후 수령액
			t_atra.setText(Integer.toString((int)(amount+(ibtd-(ibtd*tax)))));	
			
		}
	}
	
	public void savingCal() {//적금 계산식-단리
		if(t_irtype.getText().equals("단리")) {
			int amount=Integer.parseInt(t_amount.getText());//금액
			double ir=(double)box_ir.getSelectedItem()/100;//금리	
			int month=Integer.parseInt(box_period.getSelectedItem().toString());//기간
			int mm=month;//적금계산 기간
			double tax=15.4/100;
			int sum = 0;//적금 계산결과
			
			//적금계산식-단리
			for(int i=1;i<=month;i++) {
				int mmir=(int)(amount*ir*mm)/month;
				sum=(int)(sum+mmir);
				mm--;
			}
			//원금 합
			t_totalAmount.setText(Integer.toString(amount*month));
			//세전이자
			t_ibtd.setText(Integer.toString(sum));
			//이자과세
			t_taxAmount.setText(Integer.toString((int) (sum*tax)));
			//세후 수령액
			t_atra.setText(Integer.toString((int)((amount*month)+(sum-(int)(sum*tax)))));		
		}else {//복리인경우
			//적금 및 예금 계산
			int amount=Integer.parseInt(t_amount.getText());//금액
			double ir=(double)box_ir.getSelectedItem()/100;//금리	
			int month=Integer.parseInt(box_period.getSelectedItem().toString());//기간
			int mm=month;//적금계산 기간
			double tax=15.4/100;
			int sum = 0;//적금 계산결과
			
			//적금계산식-월복리
			 for(int i=1;i<=month;i++) {
	    		 double result = Math.pow(((double)1+ir/12), mm); //5의제곱
	    		 int mmir=(int) (amount*result);
	    		 sum=sum+mmir;
	    		 mm--;
	    	 }
			//원금 합
			t_totalAmount.setText(Integer.toString(amount*month));
			//세전이자
			t_ibtd.setText(Integer.toString(sum-(amount*month)));
			//이자과세
			int ibtd=Integer.parseInt(t_ibtd.getText());
			t_taxAmount.setText(Integer.toString((int) (ibtd*tax)));
			//세후 수령액
			t_atra.setText(Integer.toString((int)((amount*month)+(ibtd-(int)(ibtd*tax)))));		
			 
		}
	}
	
	public void getDetail(int productname_idx) {
		productName=new ProductName();
		productName=portfolioMain.productNameDAO.select(productname_idx);
		t_bankname.setText(productName.getProductType().getBankName().getBank_name());
		t_productType.setText(productName.getProductType().getProduct_type());
		t_productName.setText(productName.getName());
		t_jlimit.setText(productName.getJlimit());
		
		int period=productName.getPeriod();
		if(period==1) {
			box_period.setSelectedIndex(0);
		}else if(period==3) {
			box_period.setSelectedIndex(1);
		}else if(period==6) {
			box_period.setSelectedIndex(2);
		}else if(period==12) {
			box_period.setSelectedIndex(3);
		}else if(period==24){
			box_period.setSelectedIndex(4);
		}else if(period==36){
			box_period.setSelectedIndex(5);
		}
		t_irtype.setText(productName.getIrtype());
		
		box_ir.removeAllItems();
		box_ir.addItem(productName.getDefault_ir());
		box_ir.addItem(productName.getMax_ir());
		
		double ir=productName.getDefault_ir();
		if(ir==productName.getDefault_ir()) {
			box_ir.setSelectedIndex(0);
		}else {
			box_ir.setSelectedIndex(1);
		}	
	}
	
	public void productList() {//페이지로 오는 순간 상품 보이기
		model.list=portfolioMain.productNameDAO.bankSelectAll();
		table.updateUI();
	}
	
	public void createBoxItem() {
		box_search1.addItem("상품종류");
		box_search1.addItem("적금");
		box_search1.addItem("예금");
		
		box_search2.addItem("기간");
		box_search2.addItem("1");
		box_search2.addItem("3");
		box_search2.addItem("6");
		box_search2.addItem("12");
		box_search2.addItem("24");
		box_search2.addItem("36");
		
		box_period.addItem("1");
		box_period.addItem("3");
		box_period.addItem("6");
		box_period.addItem("12");
		box_period.addItem("24");
		box_period.addItem("36");
	}
	
	public void reset() {
		t_totalAmount.setText("");
		t_ibtd.setText("");
		t_taxAmount.setText("");
		t_atra.setText("");
	}
	
	public void search() {
		if(box_search1.getSelectedIndex()==0 & box_search2.getSelectedIndex()==0) {//아무것도 선택되지 않았을때
			JOptionPane.showMessageDialog(portfolioMain, "카테고리를 선택해주세요", "알림", JOptionPane.INFORMATION_MESSAGE);
		}else {
			String ptype=box_search1.getSelectedItem().toString();
			int period=Integer.parseInt(box_search2.getSelectedItem().toString());
			String content=t_search.getText();
				
			model.list=portfolioMain.productNameDAO.bankSelect(ptype, period, content);
			table.updateUI();
			}
		}
	}

