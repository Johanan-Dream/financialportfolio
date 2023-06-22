package javaproject.portfolio.domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import javaproject.portfolio.DTO.Pmember;

public class LoginPage extends Page{
	JPanel container_north;//디자인용 컨테이너
	JPanel container_south;// 디자인용 컨테이너
	JPanel container_west;// 디자인용 컨테이너
	JPanel container_east;// 디자인용 컨테이너
	JPanel etc1;
	JPanel etc2;
	
	JPanel container;
	JLabel l_title;
	JLabel l_id;
	JTextField t_id;
	JLabel l_pass;
	JPasswordField t_pass;
	JButton bt_login;
	JButton bt_signUp;
	
	
	public LoginPage(PortfolioMain portfolioMain) {
		super(portfolioMain);
		setLayout(new BorderLayout());
		container_north=new JPanel();
		container_south = new JPanel();
		container_west = new JPanel();
		container_east = new JPanel();
		etc1= new JPanel();
		etc2= new JPanel();

		container=new JPanel();
		l_title=new JLabel("       금융상품 포트폴리오");
		l_id=new JLabel("아  이  디");
		t_id=new JTextField(20);
		l_pass=new JLabel("비밀번호");
		t_pass=new JPasswordField(20);
		bt_login=new JButton("로그인");
		bt_signUp=new JButton("회원가입");
		
		//폰트
		Font font_title=new Font("맑은고딕", Font.BOLD, 30);
		l_title.setFont(font_title);
		Font font_idPass=new Font("맑은고딕", Font.BOLD, 25);
		l_id.setFont(font_idPass);
		l_pass.setFont(font_idPass);
		Font font_bt=new Font("맑은고딕", Font.BOLD, 20);
		bt_login.setFont(font_bt);
		bt_signUp.setFont(font_bt);
		
		Border loginBorder=BorderFactory.createTitledBorder("로그인");
		//스타일
		l_title.setPreferredSize(new Dimension(400,110));
		etc1.setPreferredSize(new Dimension(390,15));
		etc2.setPreferredSize(new Dimension(390,60));
		Dimension d1 = new Dimension(150, 30);
		t_id.setPreferredSize(d1);
		t_pass.setPreferredSize(d1);
		container_north.setPreferredSize(new Dimension(1200, 60));
		container_south.setPreferredSize(new Dimension(1200, 200));
		container_west.setPreferredSize(new Dimension(400, 300));
		container_east.setPreferredSize(new Dimension(400, 300));
		container.setPreferredSize(new Dimension(400, 300));
		container.setBorder(loginBorder);
		
		container.add(l_title);
		container.add(l_id);
		container.add(t_id);
		container.add(etc1);
		container.add(l_pass);
		container.add(t_pass);
		container.add(etc2);
		container.add(bt_login);
		container.add(bt_signUp);
		
		add(container_north, BorderLayout.NORTH);
		add(container_south, BorderLayout.SOUTH);
		add(container_west, BorderLayout.WEST);
		add(container_east, BorderLayout.EAST);
		add(container);
		
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		
		bt_signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				portfolioMain.showHide(portfolioMain.SIGNUPPAGE);
			}
		});
	}
	
	public void checkLogin() {
		Pmember pmember=new Pmember();
		pmember.setId(t_id.getText());
		pmember.setPass(new String(t_pass.getPassword()));
		
		List list=portfolioMain.pmemberDAO.loginCheck(pmember);
		
		//로그인에 성공하면
		if(list.size()>0) {
			portfolioMain.showHide(PortfolioMain.BANKCALCULATORPAGE);
		}else {
			JOptionPane.showMessageDialog(portfolioMain, "로그인 정보가 올바르지 않습니다.", "로그인 오류", JOptionPane.WARNING_MESSAGE);
		}
	}
}
