package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import util.FileHandler;
import util.Parser;

public class JavaAssemblerGUI extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextArea asm = new JTextArea(30, 20);
	
	JTextArea hack = new JTextArea(30, 20);
	
	Icon loadIcon = new ImageIcon("F:\\eclipse\\workspace\\JavaAssembler\\src\\buttonicons\\fileopen.png");
    JButton loadButton = new JButton(loadIcon);
    
    Icon saveIcon = new ImageIcon("F:\\eclipse\\workspace\\JavaAssembler\\src\\buttonicons\\save.png");
    JButton saveButton = new JButton(saveIcon);
    
    Icon parseIcon = new ImageIcon("F:\\eclipse\\workspace\\JavaAssembler\\src\\buttonicons\\Gear.png");
    JButton parseButton = new JButton(parseIcon);
    
    JFileChooser fc = new JFileChooser();
    
    int returnVal;
    
    FileHandler fileToRead = new FileHandler();
    
    File file;
    
    Parser parser = new Parser();
    
    ArrayList<String> alllines = new ArrayList<String>();
	
	public void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("JavaAssembler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JScrollPane scrollPaneAsm = new JScrollPane(asm);
        JPanel asmPanel = new JPanel();
        asmPanel.add(scrollPaneAsm);
        
        JScrollPane scrollPaneHack = new JScrollPane(hack);
        JPanel hackPanel = new JPanel();
        hackPanel.add(scrollPaneHack);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createRigidArea(new Dimension(80,30)));
        
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadButton.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        loadButton.addActionListener(this);
        buttonPanel.add(loadButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,20)));
        
        parseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        parseButton.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        parseButton.addActionListener(this);
        buttonPanel.add(parseButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,20)));
        
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveButton.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        saveButton.addActionListener(this);
        buttonPanel.add(saveButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        
        asm.setEditable(false);
        hack.setEditable(false);
        
        frame.add(asmPanel, BorderLayout.WEST);
        frame.add(hackPanel, BorderLayout.EAST);
        frame.add(buttonPanel, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	public static void addText(ArrayList<String> list, JTextArea tArea) {
		tArea.setText("");
		for (String l: list) {
			tArea.append(l + "\n");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loadButton) {
            returnVal = fc.showOpenDialog(JavaAssemblerGUI.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File loadfile = fc.getSelectedFile();
                file = fc.getSelectedFile();
                alllines = fileToRead.readFileAll(loadfile.toPath());
                addText(alllines, asm);
            }
        } else if (e.getSource() == parseButton) {	
        	if (file != null) {
        		addText(parser.parsefile(fileToRead.readFile(file.toPath())), hack);
        	}
        //Handle save button action.
        } else if (e.getSource() == saveButton && file != null) {
            returnVal = fc.showSaveDialog(JavaAssemblerGUI.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File savefile = fc.getSelectedFile();
                fileToRead.saveFile(savefile.toPath(), parser.parsefile(fileToRead.readFile(file.toPath())));
        }
        }  
      
	}
	
}
