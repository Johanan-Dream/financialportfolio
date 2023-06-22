package javaproject.portfolio.domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BankNameChart extends JPanel{
	int num1;
	int num2;
	int num3;
	int num4;
	int num5;
	int num6;
	int num7;
	int num8;
	int num9;
	int num10;
	int num11;
	int num12;
	int num13;
	int num14;
	int num15;
	int num16;
	int num17;
	int num18;
    BufferedImage bi;
 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawImage(bi, null, 0, 0);
		
		//g2.clearRect(0, 0, getWidth(), getHeight());

		if ((num1 < 0) || (num2 < 0) || (num3 < 0) || (num4 < 0) || (num5 < 0) || (num6 < 0) || (num7 < 0) || (num8 < 0)
				|| (num9 < 0) || (num10 < 0) || (num11 < 0) || (num12 < 0) || (num13 < 0) || (num14 < 0) || (num15 < 0)
				|| (num16 < 0) || (num17 < 0) || (num18 < 0))
			return;

		int total = num1 + num2 + num3 + num5 + num6 + num7 + num8 + num9 + num10 + num11 + num12 + num13 + num14
				+ num15 + num16 + num17 + num18;
		if (total == 0)
			return;

		int arc1 = (int) 360.0 * num1 / total;
		int arc2 = (int) 360.0 * num2 / total;
		int arc3 = (int) 360.0 * num3 / total;
		int arc4 = (int) 360.0 * num4 / total;
		int arc5 = (int) 360.0 * num5 / total;
		int arc6 = (int) 360.0 * num6 / total;
		int arc7 = (int) 360.0 * num7 / total;
		int arc8 = (int) 360.0 * num8 / total;
		int arc9 = (int) 360.0 * num9 / total;
		int arc10 = (int) 360.0 * num10 / total;
		int arc11 = (int) 360.0 * num11 / total;
		int arc12 = (int) 360.0 * num12 / total;
		int arc13 = (int) 360.0 * num13 / total;
		int arc14 = (int) 360.0 * num14 / total;
		int arc15 = (int) 360.0 * num15 / total;
		int arc16 = (int) 360.0 * num16 / total;
		int arc17 = (int) 360.0 * num17 / total;
		int arc18 = (int) 360.0 * num18 / total;

		g2.setColor(new Color(252, 175, 23));
		g2.fillArc(50, 20, 200, 200, 0, arc1);
		g2.setColor(new Color(253, 186, 25));
		g2.fillArc(50, 20, 200, 200, arc1, arc2);
		g2.setColor(new Color(0, 70, 255));
		g2.fillArc(50, 20, 200, 200, arc1 + arc2, arc3);
		g2.setColor(new Color(0, 158, 223));
		g2.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3, arc4);
		g2.setColor(new Color(0, 131, 203));
		g2.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3 + arc4, arc5);
		g2.setColor(new Color(0, 154, 218));
		g2.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3 + arc4 + arc5, arc6);
		g2.setColor(new Color(125, 176, 222));
		g2.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3 + arc4 + arc5 + arc6, arc7);
		g2.setColor(new Color(56, 210, 0));
		g2.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7, arc8);
		g2.setColor(new Color(0, 148, 144));
		g2.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8, arc9);
		g2.setColor(new Color(190, 241, 0));
		g2.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8 + arc9, arc10);
		g2.setColor(new Color(255, 255, 0));
		g2.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8 + arc9 + arc10, arc11);
		g2.setColor(new Color(0, 70, 253));
		g2.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8 + arc9 + arc10 + arc11,
				arc12);
		g2.setColor(new Color(219, 48, 55));
		g2.fillArc(50, 20, 200, 200,
				arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8 + arc9 + arc10 + arc11 + arc12, arc13);
		g2.setColor(new Color(219, 48, 55));
		g2.fillArc(50, 20, 200, 200,
				arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8 + arc9 + arc10 + arc11 + arc12 + arc13, arc14);
		g2.setColor(new Color(13, 154, 216));
		g2.fillArc(50, 20, 200, 200,
				arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8 + arc9 + arc10 + arc11 + arc12 + arc13 + arc14,
				arc15);
		g2.setColor(new Color(13, 154, 216));
		g2.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8 + arc9 + arc10 + arc11 + arc12
				+ arc13 + arc14 + arc15, arc16);
		
		g2.setColor(new Color(0, 125, 198));
		g2.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8 + arc9 + arc10 + arc11 + arc12
				+ arc13 + arc14 + arc15 + arc16, arc17);
		
		g2.setColor(new Color(0, 70, 255));
		g2.fillArc(50, 20, 200, 200,
				arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8 + arc9 + arc10 + arc11 + arc12 + arc13 + arc14
						+ arc15 + arc16+arc17,
				360 - (arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8 + arc9 + arc10 + arc11 + arc12 + arc13
						+ arc14 + arc15 + arc16+arc17));
		
		float totalNum=(num1+num2+num3+num4+num5+num6+num7+num8+num9+num10+num11+num12+num13+num14+num15+num16+num17+num18);
		g2.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		g2.setColor(new Color(252, 175, 23));
		g2.fillRect(285, 20, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("국민은행 "+Math.round(num1/totalNum*100)+"%", 300, 30);
		
		g2.setColor(new Color(253, 186, 25));
		g2.fillRect(385, 20, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("농협은행 "+Math.round(num2/totalNum)*100+"%", 400, 30);
		
		g2.setColor(new Color(0, 70, 255));
		g2.fillRect(285, 35, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("신한은행 "+Math.round(num3/totalNum*100)+"%", 300, 45);
		
		g2.setColor(new Color(0, 158, 223));
		g2.fillRect(385, 35, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("수협은행 "+Math.round(num4/totalNum*100)+"%", 400, 45);
		
		g2.setColor(new Color(0, 131, 203));
		g2.fillRect(285, 50, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("우리은행 "+Math.round(num5/totalNum*100)+"%", 300, 60);
		
		g2.setColor(new Color(0, 70, 253));
		g2.fillRect(385, 50, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("토스뱅크"+Math.round(num12/totalNum*100)+"%", 400, 60);
		
		g2.setColor(new Color(219, 48, 55));
		g2.fillRect(285, 65, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("경남은행 "+Math.round(num13/totalNum*100)+"%", 300, 75);
		
		g2.setColor(new Color(219, 48, 55));
		g2.fillRect(385, 65, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("부산은행 "+Math.round(num14/totalNum*100)+"%", 400, 75);
		
		g2.setColor(new Color(13, 154, 216));
		g2.fillRect(285, 80, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("광주은행 "+Math.round(num15/totalNum*100)+"%", 300, 90);
		
		g2.setColor(new Color(13, 154, 216));
		g2.fillRect(385, 80, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("전북은행 "+Math.round(num16/totalNum*100)+"%", 400, 90);
		
		g2.setColor(new Color(0, 125, 198));
		g2.fillRect(285, 95, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("대구은행 "+Math.round(num17/totalNum*100)+"%", 300, 105);
		
		g2.setColor(new Color(0, 70, 255));
		g2.fillRect(385, 95, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("제주은행 "+Math.round(num18/totalNum*100)+"%", 400, 105);
		
		g2.setColor(new Color(0, 148, 144));
		g2.fillRect(285, 110, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("하나은행 "+Math.round(num9/totalNum*100)+"%", 300, 120);
		
		g2.setColor(new Color(190, 241, 0));
		g2.fillRect(385, 110, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("케이뱅크 "+Math.round(num10/totalNum*100)+"%", 400, 120);
		
		g2.setColor(new Color(255, 255, 0));
		g2.fillRect(285, 125, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("카카오뱅크 "+Math.round(num11/totalNum*100)+"%", 300, 135);
		
		g2.setColor(new Color(0, 154, 218));
		g2.fillRect(285, 140, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("중소기업은행 "+Math.round(num6/totalNum*100)+"%", 300, 150);
		
		g2.setColor(new Color(125, 176, 222));
		g2.fillRect(285, 155, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("한국산업은행 "+Math.round(num7/totalNum*100)+"%", 300, 165);
		
		g2.setColor(new Color(56, 210, 0));
		g2.fillRect(285, 170, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawString("한국스탠다드차타드은행 "+Math.round(num8/totalNum*100)+"%", 300, 180);
	}
	
	public void saveImage(String name,String type) {
		BufferedImage image = new BufferedImage(280,getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		paint(g2);
		try{
			ImageIO.write(image, type, new File("C:/java_workspace2/NetworkApp/"+name+"."+type));
			System.out.println("저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setNumbers(int num1, int num2, int num3, int num4, int num5, int num6, int num7, int num8, int num9,  int num10, int num11,
			int num12, int num13, int num14, int num15, int num16, int num17, int num18) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
		this.num6 = num6;
		this.num7 = num7;
		this.num8 = num8;
		this.num9 = num9;
		this.num10 = num10;
		this.num11 = num11;
		this.num12 = num12;
		this.num13 = num13;
		this.num14 = num14;
		this.num15 = num15;
		this.num16 = num16;
		this.num17 = num17;
		this.num18 = num18;
	}
}
