package javaproject.portfolio.domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javaproject.portfolio.DAO.ProductNameDAO;
import javaproject.portfolio.util.DBManager;
import javaproject.portfolio.DAO.PmemberDAO;

public class PortfolioMain extends JFrame {
	JPanel container;
	JPanel menu;
	JPanel topcategory;
	JPanel subcategory;
	Page[] pages=new Page[5];
	boolean flag=false;//하위카테고리 보이기 안보이기
	TopCategoryMenu[] topMenus=new TopCategoryMenu[3];
	SubCategoryMenu[] subMenus=new SubCategoryMenu[2];
	
	public static final int LOGINPAGE=0;
	public static final int BANKCALCULATORPAGE=1;
	public static final int SAVINGSBANKCALCULATORPAGE=2;
	public static final int PORTFOLIOPAGE=3;
	public static final int SIGNUPPAGE=4;
	
	
	DBManager dbManager=DBManager.getInstance();
	PmemberDAO pmemberDAO=new PmemberDAO(this);
	ProductNameDAO productNameDAO=new ProductNameDAO(this);
	public boolean loginFlag=false;
	
	//InputPDF createPDF;
	
	public PortfolioMain() {
		super("http://www.financeportfolio.com");
		container=new JPanel();
		menu=new JPanel();
		topcategory=new JPanel();
		subcategory=new JPanel();
		
		
		//스타일
		menu.setLayout(new BorderLayout());
		menu.setPreferredSize(new Dimension(1200,80));
		topcategory.setPreferredSize(new Dimension(1200,40));
		topcategory.setLayout(null);
		subcategory.setPreferredSize(new Dimension(1200,40));
		subcategory.setVisible(flag);
		subcategory.setLayout(null);

		pages[0]=new LoginPage(this);
		pages[1]=new BankCalculatorPage(this);
		pages[2]=new SavingBankjCalculatorPage(this);
		pages[3]=new PortfolioPage(this);
		pages[4]=new SignUpPage(this);
		
		for(int i=0;i<pages.length;i++) {
			container.add(pages[i]);
		}
		
		topMenus[0]=new TopCategoryMenu("금융상품계산기", this, BANKCALCULATORPAGE);
		topMenus[1]=new TopCategoryMenu("포트폴리오", this, PORTFOLIOPAGE);
		topMenus[2]=new TopCategoryMenu("로그인", this, LOGINPAGE);

		
		topMenus[0].setBounds(800, 0, 120, 40);
		topMenus[1].setBounds(920, 0, 120, 40);
		topMenus[2].setBounds(1050, 0, 120, 40);
		
		for(int i=0;i<topMenus.length;i++) {
			topcategory.add(topMenus[i]);
		}
		
		subMenus[0]=new SubCategoryMenu("은행상품", this, BANKCALCULATORPAGE);
		subMenus[1]=new SubCategoryMenu("저축은행상품", this, SAVINGSBANKCALCULATORPAGE);
		subMenus[0].setBounds(790, 0, 100, 40);
		subMenus[1].setBounds(890, 0, 100, 40);
		for(int i=0;i<subMenus.length;i++) {
			subcategory.add(subMenus[i]);
		}
		//createPDF=new CreatePDF(this);
		
		menu.add(topcategory, BorderLayout.NORTH);
		menu.add(subcategory, BorderLayout.SOUTH);
		add(menu, BorderLayout.NORTH);
		add(container);
		
		setSize(1200, 780);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		showHide(LOGINPAGE);//나중에 로그인 페이지로 바꾸기
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dbManager.release(dbManager.getConnection());
				System.exit(0);
			}
		});
		
		//카테고리 디자인
		//상위 카테고리
		topcategory.addMouseListener(new MouseAdapter() {
			//마우스가 올라갈때 색변환
			public void mouseEntered(MouseEvent e) {
				topcategory.setBackground(Color.WHITE);
			}
			//마우스가 나갈때 색변환
			public void mouseExited(MouseEvent e) {
				topcategory.setBackground(new Color(238	, 238, 238));
			}
		});
		
		//하위 카테고리
		subcategory.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				subcategory.setBackground(Color.WHITE);
				topcategory.setBackground(new Color(238, 238, 238));
				flag=!flag;
				subcategory.setVisible(flag);
			}
		});
		//메뉴
		subMenus[0].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				BankCalculatorPage bankCalculatorPage=(BankCalculatorPage)pages[BANKCALCULATORPAGE];
				bankCalculatorPage.productList();
			}
		});
		subMenus[1].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SavingBankjCalculatorPage savingBankjCalculatorPage=(SavingBankjCalculatorPage)pages[SAVINGSBANKCALCULATORPAGE];
				savingBankjCalculatorPage.productList();
			}
		});
		
		
		topMenus[0].addMouseListener(new MouseAdapter() {
			//마우스가 올라갈때 색변환
			public void mouseEntered(MouseEvent e) {
				topcategory.setBackground(Color.WHITE);
			}
			
			public void mouseClicked(MouseEvent e) {
				flag=!flag;
				subcategory.setVisible(flag);
				subcategory.setBackground(Color.WHITE);
				BankCalculatorPage bankCalculatorPage=(BankCalculatorPage)pages[BANKCALCULATORPAGE];
				bankCalculatorPage.productList();
			}
		});
		
		for(int i=1;i<topMenus.length;i++) {
		topMenus[i].addMouseListener(new MouseAdapter() {
			//마우스가 올라갈때 색변환
			public void mouseEntered(MouseEvent e) {
				topcategory.setBackground(Color.WHITE);
			}
			//마우스가 나갈때 색변환
			public void mouseExited(MouseEvent e) {
				topcategory.setBackground(new Color(238	, 238, 238));
			}
		});
		}
		

		
	}
	
	public void showHide(int n) {
		for(int i=0;i<pages.length;i++) {
			if(n==i) {
				pages[i].setVisible(true);
			}else {
				pages[i].setVisible(false);
			}
		}
	}
	
	public void checkLogin(int currentPage) {
		if(currentPage==0 || currentPage==4) {
			showHide(currentPage);
		}else {
			if(loginFlag==false) {
				JOptionPane.showMessageDialog(this, "로그인이 필요한 서비스입니다. ");
			}else {
				showHide(currentPage);
			}
		}
	}
	
	public static void main(String[] args) {
		new PortfolioMain();
	}
}
