package defaultPackage;

import java.awt.HeadlessException;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class OyunEkrani extends JFrame 
{
	
	
 public OyunEkrani(String title) throws HeadlessException {
		super(title);
		
		
		
		
	}

 
public static void main(String[] args) {
	
	
	
	
	
	OyunEkrani ekran=new OyunEkrani("Uzay Oyunu");
	   
	   ekran.setResizable(false);
		 ekran.setFocusable(false);
		 Oyun oyun=new Oyun();
		 

		 
		 ekran.setSize(800,600);
		 ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 oyun.requestFocus();
	     oyun.addKeyListener(oyun); //klavyedeki verileri algılama
	    
		 ekran.setVisible(isDefaultLookAndFeelDecorated());
	    
	   
	  	 oyun.setFocusable(true);//odağı jpanele verdik
	  	 oyun.setFocusTraversalKeysEnabled(false); //klavyedeki verileri algılama
	  	 
	  	 ekran.add(oyun);
	  	 
	    
	    
	  	 ekran.setVisible(true);
  }

}
