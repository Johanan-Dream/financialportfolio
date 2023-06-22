package javaproject.portfolio.domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import javaproject.portfolio.DTO.Pmember;

public class SignUpPage extends Page {
	JPanel container_north;// 디자인용 컨테이너
	JPanel container_south;// 디자인용 컨테이너
	JPanel container_west;// 디자인용 컨테이너
	JPanel container_east;// 디자인용 컨테이너
	JPanel etc1;
	JPanel etc2;
	JPanel etc3;
	JPanel etc4;
	JPanel etc5;
	JPanel etc6;
	
	JPanel container;
	JLabel l_title;
	JLabel l_id;
	JTextField t_id;
	JLabel l_pass;
	JPasswordField t_pass;
	JLabel l_name;
	JTextField t_name;
	JLabel l_phone;
	JTextField t_phone;
	JLabel l_mail;
	JTextField t_mail;
	JButton bt_signUp;

	public SignUpPage(PortfolioMain portfolioMain) {
		super(portfolioMain);
		setLayout(new BorderLayout());
		container_north = new JPanel();
		container_south = new JPanel();
		container_west = new JPanel();
		container_east = new JPanel();
		etc1=new JPanel();
		etc2=new JPanel();
		etc3=new JPanel();
		etc4=new JPanel();
		etc5=new JPanel();
		etc6=new JPanel();
		
		container = new JPanel();
		l_title = new JLabel("                  회원가입");
		l_id = new JLabel("아  이  디");
		t_id = new JTextField(20);
		l_pass = new JLabel("비밀번호");
		t_pass = new JPasswordField(20);

		l_name = new JLabel("이        름");
		t_name = new JTextField(20);
		l_phone = new JLabel("휴  대  폰");
		t_phone = new JTextField(20);
		l_mail = new JLabel("이  메  일");
		t_mail = new JTextField(20);

		bt_signUp = new JButton("회원가입");

		// 폰트
		Font font_title = new Font("맑은고딕", Font.BOLD, 30);
		l_title.setFont(font_title);
		Font font_others = new Font("맑은고딕", Font.BOLD, 25);
		l_id.setFont(font_others);
		l_pass.setFont(font_others);
		l_name.setFont(font_others);
		l_phone.setFont(font_others);
		l_mail.setFont(font_others);
		Font font_bt = new Font("맑은고딕", Font.BOLD, 20);
		bt_signUp.setFont(font_bt);

		// 스타일
		Border signup=BorderFactory.createTitledBorder("회원가입");
		l_title.setPreferredSize(new Dimension(400, 65));
		container_north.setPreferredSize(new Dimension(1200, 60));
		container_south.setPreferredSize(new Dimension(1200, 200));
		container_west.setPreferredSize(new Dimension(400, 300));
		container_east.setPreferredSize(new Dimension(400, 300));
		container.setPreferredSize(new Dimension(400, 300));
		
		etc1.setPreferredSize(new Dimension(390, 5));
		etc2.setPreferredSize(new Dimension(390, 5));
		etc3.setPreferredSize(new Dimension(390, 5));
		etc4.setPreferredSize(new Dimension(390, 5));
		etc5.setPreferredSize(new Dimension(390, 5));
		
		container.setBorder(signup);
		Dimension d1 = new Dimension(150, 30);
		t_id.setPreferredSize(d1);
		t_pass.setPreferredSize(d1);
		t_name.setPreferredSize(d1);
		t_phone.setPreferredSize(d1);
		t_mail.setPreferredSize(d1);
		
		container.add(l_title);
		container.add(l_id);
		container.add(t_id);
		container.add(etc1);
		container.add(l_pass);
		container.add(t_pass);
		container.add(etc2);
		container.add(l_name);
		container.add(t_name);
		container.add(etc3);
		container.add(l_phone);
		container.add(t_phone);
		container.add(etc4);
		container.add(l_mail);
		container.add(t_mail);
		container.add(etc5);
		container.add(bt_signUp);

		add(container_north, BorderLayout.NORTH);
		add(container_south, BorderLayout.SOUTH);
		add(container_west, BorderLayout.WEST);
		add(container_east, BorderLayout.EAST);
		add(container);

		bt_signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (t_id.getText().equals("") || t_pass.getPassword().equals("") || t_name.getText().equals("")
						|| t_phone.getText().equals("") || t_mail.getText().equals("")) {
					
					JOptionPane.showMessageDialog(portfolioMain, "입력되지 않은 정보가 있습니다.", "가입 오류", JOptionPane.WARNING_MESSAGE);
				} else {
					int result = regist();
					if (result > 0) {
						JOptionPane.showMessageDialog(portfolioMain, "회원가입을 축하드립니다", "가입 성공", JOptionPane.INFORMATION_MESSAGE);
						t_id.setText("");
						t_pass.setText("");
						t_name.setText("");
						t_phone.setText("");
						t_mail.setText("");
						// result 결과가 있다면 page 전환
						portfolioMain.showHide(portfolioMain.LOGINPAGE);

					}
				}
			}
		});
	}

	public int regist() {
		Pmember pmember = new Pmember();
		pmember.setId(t_id.getText());
		pmember.setPass(new String(t_pass.getPassword()));
		pmember.setName(t_name.getText());
		pmember.setPhone(Integer.parseInt(t_phone.getText()));
		pmember.setEmail(t_mail.getText());

		int result = portfolioMain.pmemberDAO.regist(pmember);
		return result;
	}
}
