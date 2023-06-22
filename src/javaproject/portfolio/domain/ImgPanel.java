package javaproject.portfolio.domain;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;


public class ImgPanel extends JPanel{
    BufferedImage bi;

    public ImgPanel(String filename){
        InputStream in = getClass().getResourceAsStream(filename);
        try {
            bi = ImageIO.read(in);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;

       g2d.drawImage(bi, null, 0, 0);
    }

    public void saveToPNG(String filename){
        BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics(); 
        this.paint(g2d);
        try{
            ImageIO.write(image,"png", new File(filename));
            JOptionPane.showMessageDialog(this, "파일저장 성공");

        }catch(Exception ex){
             ex.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
		new ImgPanel("chart");
	}
}

