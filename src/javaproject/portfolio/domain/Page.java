package javaproject.portfolio.domain;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Page extends JPanel{
	PortfolioMain portfolioMain;
	public Page(PortfolioMain portfolioMain) {
		this.portfolioMain=portfolioMain;
		this.setPreferredSize(new Dimension(1200, 660));
	}
}
