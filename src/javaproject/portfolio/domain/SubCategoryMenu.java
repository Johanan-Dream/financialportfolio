package javaproject.portfolio.domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubCategoryMenu extends JPanel{
	JLabel menuName=new JLabel();
	PortfolioMain portfolioMain;
	
	public SubCategoryMenu(String name, PortfolioMain portfolioMain, int pageNum) {
		menuName=new JLabel(name);
		
		menuName.setFont(new Font("맑은고딕", Font.BOLD, 13));
		
		this.portfolioMain=portfolioMain;
		
		add(menuName);
		
		setPreferredSize(new Dimension(100,40));
		setBackground(new Color(255,0,0,0));
		//setBackground(Color.YELLOW);
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				portfolioMain.topcategory.setBackground(new Color(238, 238, 238));
				portfolioMain.flag=!portfolioMain.flag;
				portfolioMain.subcategory.setVisible(portfolioMain.flag);
				portfolioMain.checkLogin(pageNum);
				//portfolioMain.showHide(pageNum);

			}
		});
	}
}
