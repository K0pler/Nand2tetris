package main;

import gui.JavaAssemblerGUI;

public class Assembler {

	public static void main(String[] args) {
		
		JavaAssemblerGUI gui = new JavaAssemblerGUI();
		
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                gui.createAndShowGUI();
	            }
	        });
	}

}
