package jFrameBeans;


import javax.swing.JFrame;

import common.Constants;

public class MyJframe extends JFrame{

	

	public MyJframe() {
		this.pack();

		this.setTitle(Constants.JFRAME_NAME);

		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {

	}

}
