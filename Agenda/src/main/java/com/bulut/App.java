package com.bulut;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.bulut.utils.AgendaUtility;

//@SuppressWarnings("serial")
public class App 
//extends JApplet 
{

//	public void init() {
//		try {
//			SwingUtilities.invokeAndWait(new Runnable() {
//				public void run() {
//					createGUI();
//					
//				}
//			});
//		} catch (Exception e) {
//			System.err.println("createGUI didn't complete successfully");
//			e.printStackTrace();
//		}
//	}
//
//	private void createGUI() {
//		UIManager.put("swing.boldMetal", Boolean.FALSE);
//
//		JFrame frame = new JFrame("asd");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		frame.setPreferredSize(new Dimension(800, 500));
//		MainPanel mainPanel = new MainPanel();
//		mainPanel.setOpaque(true);
//		frame.setContentPane(mainPanel);
//
//		frame.pack();
//		frame.setVisible(true);
//	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AgendaUtility.init();
				
				UIManager.put("swing.boldMetal", Boolean.FALSE);

				JFrame frame = new JFrame("asd");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.setPreferredSize(new Dimension(900, 400));
				
				AgendaUtility.getMainPanel().setOpaque(true);
				frame.setContentPane(AgendaUtility.getMainPanel());
				
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
