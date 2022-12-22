package defaultPackage;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
public class OyunEkrani extends JFrame 
{
	
	
 public OyunEkrani(String title) throws HeadlessException {
		super(title);
		
	}

public static void main(String[] args) {
	 OyunEkrani ekran=new OyunEkrani("Uzay Oyunu");
	 String a;
	 ekran.setResizable(false);
	 ekran.setFocusable(false);
   
	
	 ekran.setSize(800,600);
	 ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Oyun oyun=new Oyun();
	 oyun.requestFocus();
     oyun.addKeyListener(oyun); //klavyedeki verileri algılama
    
    
   
  	 oyun.setFocusable(true);//odağı jpanele verdik
  	 oyun.setFocusTraversalKeysEnabled(false); //klavyedeki verileri algılama
  	 
  	 ekran.add(oyun);
  	 ekran.setVisible(true);
}

}
