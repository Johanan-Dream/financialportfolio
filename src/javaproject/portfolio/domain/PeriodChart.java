package javaproject.portfolio.domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PeriodChart extends JPanel{
	int num1;
	int num2;
	BufferedImage bi;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawImage(bi, null, 0, 0);
		
		//g2.clearRect(0, 0, getWidth(), getHeight());

		if ((num1 < 0) || (num2 < 0)) 
			return;

		int total = num1 + num2 ;
		if (total == 0)
			return;

		int arc1 = (int) 360.0 * num1 / total;
		int arc2 = (int) 360.0 * num2 / total;
		
		g2.setColor(new Color(178, 223, 219));
		g2.fillArc(50, 30, 200, 200, 0, arc1); 
	
		g2.setColor(new Color(0, 105, 92));
		g2.fillArc(50, 30, 200, 200, arc1, 360-(arc1));
		
		float totalNum=	num1+num2;
		g2.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		g2.setColor(new Color(178, 223, 219));
		g2.fillRect(285, 30, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("단기상품 "+Math.round(num1/totalNum*100)+"%", 300, 40);
		
		g2.setColor(new Color(0, 105, 92));
		g2.fillRect(285, 45, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("장기상품 "+Math.round(num2/totalNum*100)+"%", 300, 55);
	}
	
	public void saveImage(String name,String type) {
		BufferedImage image = new BufferedImage(290,getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		paint(g2);
		
			try {
				ImageIO.write(image, type, new File("C:/java_data/"+name+"."+type));
				//System.out.println("성공");
				//System.out.println(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void setNumbers(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
}
