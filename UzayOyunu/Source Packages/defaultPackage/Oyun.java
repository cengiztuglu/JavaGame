package defaultPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
  
	
	Timer timer=new Timer(1,this);


	private int gecen_sure=0;
	private int harcanan_ates=0;
	private BufferedImage image;
	private ArrayList<Ates> atesler=new ArrayList<Ates>();
	private int atesdirY=3;
	private int topX=2;
	private int topdirX=4;
	private int UzayGemisiX=0;
	private int dirUzayX=30;
	public boolean check()
	{
		for(Ates ates:atesler)
		{
			if (new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle(topX,0,20,20)))
			{
				return true;
				
			}
			
		}
		return false;
	}
	
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
	setBackground(Color.DARK_GRAY);
    
	
    timer.start();
   
       
	
	
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		gecen_sure+=5;
		
		g.setColor(Color.red);
		g.fillOval(topX, 0, 20, 20);
		g.drawImage(image, UzayGemisiX,490,image.getWidth()/10,getHeight()/7,this);
		 JLabel süre = new JLabel();
		 JLabel atessayi = new JLabel();
		
		
		 süre.setText(Double.toString(gecen_sure/1000.0));
		 süre.setForeground(Color.RED);
		 süre.setBackground(Color.WHITE);
		  süre.setBounds(0, 0, 400, 30);
		  süre.paint(g);
		  atessayi.setText(Integer.toString(harcanan_ates));
			 atessayi.setForeground(Color.RED);
			 atessayi.setBackground(Color.WHITE);
			 atessayi.setBounds(70, 100, 400, 60);
			 atessayi.paint(g);
		for(Ates ates:atesler)
		{
			if(ates.getY()<0)
			{
				atesler.remove(ates);
			}
		}
		g.setColor(Color.ORANGE);
		for(Ates ates:atesler)
		{
		g.fillRect(ates.getX(),ates.getY(), 10,20);
	
			
		}
		if(check())
		{
			timer.stop();
			String message="Kazandınız....\n"+
			                "harcanan ates:"+harcanan_ates+
			                "gecen süre:" + gecen_sure/1000.0;
			JOptionPane.showMessageDialog(this, message);
			System.exit(UzayGemisiX);
			  
					
		}
	}
	

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(Ates ates:atesler)
		{
			ates.setY((ates.getY())-atesdirY);
			
		}
		 
		topX+=topdirX;
		if(topX>=750)
		{
			topdirX=-topdirX;
		}
		if(topX<=0)
		{
			topdirX=-topdirX;
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}

	@Override
	public void keyPressed(KeyEvent e) {//uzay gemisi hareket ettirme 
		 int c=e.getKeyCode();
		 if(c==KeyEvent.VK_LEFT)
		 {
			 if(UzayGemisiX<=0)
			 {                           // x eksenini eksi yönde geçmemesi için 
			 UzayGemisiX=0;
			
		 }
			 else
			 {
				 UzayGemisiX-=dirUzayX;
			 }
			 }
		 else if (c==KeyEvent.VK_RIGHT)
		 {
			 if(UzayGemisiX>=720)
			 {
				 UzayGemisiX=720;
			 }
			 else
			 {
				 UzayGemisiX+=dirUzayX;
			 }
		 }
			 
			 else if (c==KeyEvent.VK_CONTROL) 
			 {
				 atesler.add(new Ates(UzayGemisiX+20,470));//ateşin uzay gemisinden çıkma komutları
				 harcanan_ates++;
				
			}
		 }
		
	

	@Override
	public void keyReleased(KeyEvent e) {
	
		
	}
		
}
