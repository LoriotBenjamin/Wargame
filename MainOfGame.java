package wargame;

import java.awt.EventQueue;

import wargame.Menu;

public class MainOfGame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//Interface I =new Interface();
	}

	}


