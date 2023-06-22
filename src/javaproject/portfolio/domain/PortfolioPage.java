package javaproject.portfolio.domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.knowm.xchart.PieChart;



import javaproject.portfolio.DTO.PortFolio;

public class PortfolioPage extends Page {
	PrintExcel printExcel;
	JFileChooser chooser;
	
	// 서쪽 영역
	JPanel p_west;

	// 서쪽-위
	JPanel p_west_top;
	JLabel l_west_title;
	// 서쪽-중앙
	JPanel p_west_center;
	JScrollPane scroll;
	JTable table;
	JButton bt_del;
	JButton bt_back_bank;
	JButton bt_back_savingsbank;

	JButton bt_con;

	// 센터영역
	JPanel p_center;

	// 센터-위
	JPanel p_center_top;
	JLabel l_center_title;

	// 센터-중앙
	JPanel p_center_center;
	JPanel p_center_center_west;// 그래프가 출력될 영역

	JPanel p_center_center_east;// 만기 금액 및 은행 정보가 출력될 영역
	JLabel l_1mm;
	JTextField t_1mm;
	JLabel l_3mm;
	JTextField t_3mm;
	JLabel l_6mm;
	JTextField t_6mm;
	JLabel l_1yy;
	JTextField t_1yy;
	JLabel l_2yy;
	JTextField t_2yy;
	JLabel l_3yy;
	JTextField t_3yy;
	JLabel l_total;
	JTextField t_total;
	
	JLabel l_short;
	JTextField t_short;	
	JLabel l_long;
	JTextField t_long;
	
	// 센터-아래
	JPanel p_center_down;
	JButton bt_print;

	PortfolioModel model;

	BankNameChart bankNameChart;
	PeriodChart periodChart;

	// bankname chart
	PieChart chart;
	int kmNum;
	int nhNum;
	int sNum;
	int shNum;
	int wNum;
	int jNum;
	int hsNum;
	int scNum;
	int hnNum;
	int kNum;
	int kaNum;
	int tNum;
	int knNum;
	int bsNum;
	int kjNum;
	int jbNum;
	int dgNum;
	int jjNum;
	int shortPeriod;
	int longPeriod;

	public PortfolioPage(PortfolioMain portfolioMain) {
		super(portfolioMain);
		printExcel=new PrintExcel(this);
		
		chooser=new JFileChooser();
		// 서쪽 영역
		p_west = new JPanel();

		// 서쪽-위
		p_west_top = new JPanel();
		l_west_title = new JLabel("상품목록");

		// 서쪽-중앙
		p_west_center = new JPanel();
		table = new JTable(model = new PortfolioModel(this));
		scroll = new JScrollPane(table);
		bt_del = new JButton("삭제");
		bt_back_bank = new JButton("금융계산기(은행)");
		bt_back_savingsbank = new JButton("금융계산기(저축은행)");
		bt_con = new JButton("적용");

		// 센터영역
		p_center = new JPanel();

		// 센터-위
		p_center_top = new JPanel();
		l_center_title = new JLabel("나만의 금융상품 포트폴리오");

		// 센터-중앙
		p_center_center = new JPanel();
		p_center_center_west = new JPanel();// 그래프가 출력될 영역
		bankNameChart=new BankNameChart();
		periodChart=new PeriodChart();
		
		p_center_center_east = new JPanel();
		l_1mm = new JLabel("1개월 후 만기금액");
		t_1mm = new JTextField("0", 10);
		l_3mm = new JLabel("3개월 후 만기금액");
		t_3mm = new JTextField("0", 10);
		l_6mm = new JLabel("6개월 후 만기금액");
		t_6mm = new JTextField("0", 10);
		l_1yy = new JLabel("1년 후 만기금액");
		t_1yy = new JTextField("0", 10);
		l_2yy = new JLabel("2년 후 만기 금액");
		t_2yy = new JTextField("0", 10);
		l_3yy = new JLabel("3년 후 만기 금액");
		t_3yy = new JTextField("0", 10);
		l_total = new JLabel("총 합산 금액");
		t_total = new JTextField("0", 10);
		l_short=new JLabel("단기 상품 금액");
		t_short=new JTextField("0", 10);
		l_long=new JLabel("장기 상품 금액");
		t_long=new JTextField("0", 10);

		p_center_down = new JPanel();
		bt_print = new JButton("출력");
		// 스타일
		
		//폰트적용
		Font tfont=new Font("맑은고딕", Font.BOLD, 20);
		l_west_title.setFont(tfont);
		l_center_title.setFont(tfont);
		Font dfont=new Font("맑은고딕", Font.BOLD, 13);
		Font btfont=new Font("맑은고딕", Font.BOLD, 12);
		
		bt_del.setFont(btfont);
		bt_back_bank.setFont(btfont);
		bt_back_savingsbank.setFont(btfont);
		bt_con.setFont(btfont);
		l_1mm.setFont(dfont);
		l_3mm.setFont(dfont);
		l_6mm.setFont(dfont);
		l_1yy.setFont(dfont);
		l_2yy.setFont(dfont);
		l_3yy.setFont(dfont);
		l_total.setFont(dfont);
		l_short.setFont(dfont);
		l_long.setFont(dfont);
		bt_print.setFont(btfont);
		// 서쪽 영역
		p_west.setPreferredSize(new Dimension(300, 950));
		// 서쪽-위
		p_west_top.setPreferredSize(new Dimension(300, 30));
		// 서쪽-중앙
		p_west_center.setPreferredSize(new Dimension(350, 600));
		scroll.setPreferredSize(new Dimension(300, 500));
		
		// 센터영역
		p_center.setPreferredSize(new Dimension(800, 950));
		// 센터-위
		p_center_top.setPreferredSize(new Dimension(800, 30));
		// 센터-중앙
		p_center_center.setPreferredSize(new Dimension(800, 505));
		// 그래프가 부착될 영역
		p_center_center_west.setPreferredSize(new Dimension(500, 490));

		bankNameChart.setPreferredSize(new Dimension(500, 250));
		periodChart.setPreferredSize(new Dimension(500, 240));
		
		// 만기금액이 출력될 영역
		TitledBorder amountBorder=BorderFactory.createTitledBorder("총금액");
		p_center_center_east.setBorder(amountBorder);
		p_center_center_east.setPreferredSize(new Dimension(290, 490));
		

		Dimension d_label = new Dimension(150, 30);
		l_1mm.setPreferredSize(d_label);
		l_3mm.setPreferredSize(d_label);
		l_6mm.setPreferredSize(d_label);
		l_1yy.setPreferredSize(d_label);
		l_2yy.setPreferredSize(d_label);
		l_3yy.setPreferredSize(d_label);
		l_total.setPreferredSize(d_label);
		l_short.setPreferredSize(d_label);
		l_long.setPreferredSize(d_label);

		//chart = new PieChart(400, 200);
		//getChartData();
		
		// 만기금액 내용 부착
		p_center_center_east.add(l_1mm);
		p_center_center_east.add(t_1mm);
		p_center_center_east.add(l_3mm);
		p_center_center_east.add(t_3mm);
		p_center_center_east.add(l_6mm);
		p_center_center_east.add(t_6mm);
		p_center_center_east.add(l_1yy);
		p_center_center_east.add(t_1yy);
		p_center_center_east.add(l_2yy);
		p_center_center_east.add(t_2yy);
		p_center_center_east.add(l_3yy);
		p_center_center_east.add(t_3yy);
		p_center_center_east.add(l_total);
		p_center_center_east.add(t_total);
		p_center_center_east.add(l_short);
		p_center_center_east.add(t_short);
		p_center_center_east.add(l_long);
		p_center_center_east.add(t_long);

		// 출력 버튼 부착
		p_center_down.add(bt_print);
		// 센터-아래
		p_center_down.setPreferredSize(new Dimension(700, 50));
		// 상품영역 제목 부착
		p_west_top.add(l_west_title);
		// 상품 테이블 부착
		p_west_center.add(scroll);
		p_west_center.add(bt_back_bank);
		p_west_center.add(bt_back_savingsbank);
		p_west_center.add(bt_del);
		p_west_center.add(bt_con);

		// 포트폴리오 제목 부착
		p_center_top.add(l_center_title);
		p_center.add(p_center_top, BorderLayout.NORTH);

		// 그래프가 붙을 영역
		TitledBorder amountBorder2=BorderFactory.createTitledBorder("결과그래프");
		p_center_center_west.setBorder(amountBorder2);
		p_center_center_west.setLayout(new BorderLayout());
		p_center_center_west.add(bankNameChart, BorderLayout.NORTH);
		p_center_center_west.add(periodChart, BorderLayout.SOUTH);
		
		p_center_center.add(p_center_center_west, BorderLayout.WEST);
		// 만기금액이 붙을 영역
		p_center_center.add(p_center_center_east, BorderLayout.EAST);

		// 포트폴리오 내용이 붙을 영역
		p_center.add(p_center_center, BorderLayout.CENTER);
		// 출력버튼이 붙을 영역
		p_center.add(p_center_down, BorderLayout.SOUTH);

		p_west.add(p_west_top, BorderLayout.NORTH);
		p_west.add(p_west_center);

		add(p_west, BorderLayout.WEST);
		add(p_center);

		// 계산 화면으로 돌아가기
		bt_back_bank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				portfolioMain.showHide(portfolioMain.BANKCALCULATORPAGE);
			}
		});
		
		bt_back_savingsbank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				portfolioMain.showHide(portfolioMain.SAVINGSBANKCALCULATORPAGE);
			}
		});

		
		// 목록 삭제하기
		bt_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delList();
				amountBoxReset();
			}
		});

		// 테이블 내용 포트폴리오 합산에 적용하기
	      bt_con.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            if(model.list.size()>3) {
	               if(JOptionPane.showConfirmDialog(portfolioMain, "더 많은 서비스 이용을 위해 월 2,900원씩 결제되는 것에 동의하십니까?","구독 안내", JOptionPane.OK_OPTION )==JOptionPane.OK_OPTION) {
	                  JOptionPane.showInputDialog(portfolioMain, "카드번호를 입력해주세요.");
	                  printTotalAmount();
	                  
	                  nameData();
	                  bankNameChart.repaint();
	                  bankNumReset();
	                  
	                  periodData();
	                  periodChart .repaint();
	                  periodNumReset();
	                  
	                  bankNameChart.saveImage("name_chart", "png");
	                  periodChart.saveImage("period", "png");
	               }
	            }
	         }
	      });
		
		bt_print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(model.list.size()==0) {
					JOptionPane.showMessageDialog(portfolioMain, "상품목록을 확인해주세요.", "안내", JOptionPane.INFORMATION_MESSAGE);
				}else {
				
					//저장한 이미지 엑셀에 추가하기 
					printExcel.printPortfolio();
					//inputPDF.cratePDF();
				}
			}
		});
	}

	public void periodData() {
		for(int i=0;i<model.list.size();i++) {
			PortFolio portFolio=model.list.get(i);
			int period=portFolio.getPeriod();
			if(period<12) shortPeriod++;
			if(period>=12) longPeriod++;
		}
		periodChart.setNumbers(shortPeriod, longPeriod);
		
	}
	
	public void nameData() {
		for(int i=0;i<model.list.size();i++) {
			PortFolio portFolio=model.list.get(i);
			String name=portFolio.getBank_name();
			if(name.equals("국민은행")) kmNum++;
			if(name.equals("농협은행")) nhNum++;
			if(name.equals("신한은행")) sNum++;
			if(name.equals("수협은행")) shNum++;
			if(name.equals("우리은행")) wNum++;
			if(name.equals("중소기업은행")) jNum++;
			if(name.equals("한국산업은행")) hsNum++;
			if(name.equals("한국스탠다드차타드은행")) scNum++;
			if(name.equals("하나은행")) hnNum++;
			if(name.equals("케이뱅크")) kNum++;
			if(name.equals("카카오뱅크")) kaNum++;
			if(name.equals("토스뱅크")) tNum++;
			if(name.equals("경남은행")) knNum++;
			if(name.equals("부산은행")) bsNum++;
			if(name.equals("광주은행")) kjNum++;
			if(name.equals("전북은행")) jbNum++;
			if(name.equals("대구은행")) dgNum++;
			if(name.equals("제주은행")) jjNum++;
		}
		bankNameChart.setNumbers(kmNum,nhNum,sNum,shNum,wNum,jNum,hsNum,scNum,hnNum,kNum,kaNum,tNum,knNum,bsNum,kjNum,jbNum,dgNum,jjNum);
	}
	
	public void periodNumReset() {
		shortPeriod=0;
		longPeriod=0;
	}
	
	public void bankNumReset() {
		kmNum=0;
		nhNum=0;
		sNum=0;
		shNum=0;
		wNum=0;
		jNum=0;
		hsNum=0;
		scNum=0;
		hnNum=0;
		kNum=0;
		kaNum=0;
		tNum=0;
		knNum=0;
		bsNum=0;
		kjNum=0;
		jbNum=0;
		dgNum=0;
		jjNum=0;
	}

	public void printTotalAmount() {
		int listCountNum = table.getRowCount();
		int sum1 = 0;
		int sum3 = 0;
		int sum6 = 0;
		int sum12 = 0;
		int sum24 = 0;
		int sum36 = 0;

		for (int i = 0; i < listCountNum; i++) {
			PortFolio portFolio = model.list.get(i);
			int period = portFolio.getPeriod();

			if (period == 1) {
				int mm1 = portFolio.getAtra();
				sum1 = sum1 + mm1;
				t_1mm.setText(Integer.toString(sum1));
			} else if (period == 3) {
				int mm3 = portFolio.getAtra();
				sum3 = sum3 + mm3;
				t_3mm.setText(Integer.toString(sum3));
			} else if (period == 6) {
				int mm6 = portFolio.getAtra();
				sum6 = sum6 + mm6;
				t_6mm.setText(Integer.toString(sum6));
			} else if (period == 12) {
				int mm12 = portFolio.getAtra();
				sum12 = sum12 + mm12;
				t_1yy.setText(Integer.toString(sum12));
			} else if (period == 24) {
				int mm24 = portFolio.getAtra();
				sum24 = sum24 + mm24;
				t_2yy.setText(Integer.toString(sum24));
			} else if (period == 36) {
				int mm36 = portFolio.getAtra();
				sum36 = sum36 + mm36;
				t_3yy.setText(Integer.toString(sum36));
			}
		}
		int totalAmout = sum1 + sum3 + sum6 + sum12 + sum24 + sum36;
		// System.out.println(totalAmout);
		t_total.setText(Integer.toString(totalAmout));
		t_short.setText(Integer.toString(sum1+sum3+sum6));
		t_long.setText(Integer.toString(sum12+sum24+sum36));
	}

	public void delList() {
		int selectRow = table.getSelectedRow();
		if(selectRow>=0) {
			model.list.remove(selectRow);
			table.updateUI();
		}else {
			JOptionPane.showMessageDialog(portfolioMain, "삭제하실 상품을 선택해주세요.", "안내", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void amountBoxReset() {
		t_1mm.setText(Integer.toString(0));
		t_3mm.setText(Integer.toString(0));
		t_6mm.setText(Integer.toString(0));
		t_1yy.setText(Integer.toString(0));
		t_2yy.setText(Integer.toString(0));
		t_3yy.setText(Integer.toString(0));
		t_total.setText(Integer.toString(0));
		t_short.setText(Integer.toString(0));
		t_long.setText(Integer.toString(0));
	}

}
