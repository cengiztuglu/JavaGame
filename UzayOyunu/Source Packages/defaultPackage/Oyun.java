package defaultPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.JPanel;
class Ates{
	private int x;
	private int y;
	public Ates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}

public class Oyun extends JPanel implements KeyListener, ActionListener{
  


	private int gecen_sure=0;
	private int harcanan_ates=0;
	private BufferedImage image;
	private ArrayList<Ates> atesler=new ArrayList<Ates>();
	private int atesdirY=1;
	private int topX=2;
	private int topdirX=2;
	private int UzayGemisiX=0;
	private int dirUzay=20;
	
	
	public Oyun() {
	try {
		image=ImageIO.read(new FileImageOutputStream(new File("uzaygemisi.png")));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setBackground(Color.BLACK);
	
	
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.red);
		g.fillOval(topX, 0, 20, 20);
		g.drawImage(image, UzayGemisiX,490,image.getWidth()/10,getHeight()/7,this);
	}
	

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
		
	}
		
}
