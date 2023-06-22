package javaproject.portfolio.domain;

import java.io.IOException;

import javax.swing.JFrame;

public class Test extends JFrame{
	ImgPanel imgPanel;

	public Test() {
		imgPanel=new ImgPanel("/chart.png");
		imgPanel.saveToPNG(getName());
		add(imgPanel);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	
	//예금 연복리 계산기
	    public static void main(String[] args)  {//1000만원, 3%, 3년 예금-성공
	
	    	 Test test=new Test();
	    	 
	    }
	    
	    
	    
	
}
