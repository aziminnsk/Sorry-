/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorrygui;

import javax.swing.JButton;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author hchangqu
 */

public class PlayMenu implements ActionListener{
    
    private JRadioButton redButton, blueButton, greenButton, yellowButton;
    private BufferedImage background;
    private JLabel inputText;
    private JLabel colorText;
    private JTextField input;
    private JFrame frame;
    private JButton b1, b2;
    private JLabel picture;
    private MainMenu menu;
     
    //Creates the name input and color selection menu to get ready to play
     
    public PlayMenu(JFrame frame) 
    {    
        b1 = new JButton("Ready!");
        b2 = new JButton("Back");
        redButton = new JRadioButton();
        blueButton = new JRadioButton();
        greenButton = new JRadioButton();
        yellowButton = new JRadioButton();
        picture = new JLabel();
        inputText = new JLabel("Input username:");
        colorText = new JLabel("Select color:");
        input = new JTextField();
        this.frame = frame;
    }
    
    //Set the menu and it's items properties.
    
    public void setMenuProperties(int fontSize, int X, int Y)
    {
        redButton.setActionCommand(Integer.toString(1));
        redButton.setMnemonic(KeyEvent.VK_R);
        blueButton.setActionCommand(Integer.toString(2));
        blueButton.setMnemonic(KeyEvent.VK_B);
        yellowButton.setActionCommand(Integer.toString(3));
        yellowButton.setMnemonic(KeyEvent.VK_Y);
        greenButton.setActionCommand(Integer.toString(4));
        greenButton.setMnemonic(KeyEvent.VK_G);
        inputText.setFont(new Font("Arial", Font.BOLD, fontSize - 10));
        colorText.setFont(new Font("Arial", Font.BOLD, fontSize - 10));
        input.setFont(new Font("Arial", Font.CENTER_BASELINE, fontSize - 20));
        inputText.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorText.setAlignmentX(Component.CENTER_ALIGNMENT);
        input.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setFont(new Font("Arial", Font.PLAIN, fontSize));
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.setFont(new Font("Arial", Font.PLAIN, fontSize));
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        input.setMaximumSize(new Dimension(X,  Y)); 
    }
    
    //add the items to the main menu's frame
    
    public void addItemsToFrame(int Xspace, int Yspace)
    { 
        frame.add(Box.createRigidArea(new Dimension(200, 170)));
        ButtonGroup group = new ButtonGroup();
        b1.addActionListener(this);
        b1.setActionCommand(Integer.toString(5));
        b2.addActionListener(this);
        b2.setActionCommand(Integer.toString(6));
        group.add(redButton);
        group.add(blueButton);
        group.add(greenButton);
        group.add(yellowButton);
        
        redButton.setBackground(Color.RED);
        blueButton.setBackground(Color.BLUE);
        greenButton.setBackground(Color.GREEN);
        yellowButton.setBackground(Color.yellow);
        
        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        greenButton.addActionListener(this);
        yellowButton.addActionListener(this);
        
        frame.getContentPane().add(inputText); 
        frame.getContentPane().add(input); 
        frame.add(Box.createRigidArea(new Dimension(100, 20)));
        frame.getContentPane().add(colorText); 
        frame.add(Box.createRigidArea(new Dimension(27,25)));
        frame.getContentPane().add(redButton); 
        frame.add(Box.createRigidArea(new Dimension(100, 18)));
        frame.getContentPane().add(blueButton); 
        frame.add(Box.createRigidArea(new Dimension(100, 18)));
        frame.getContentPane().add(yellowButton); 
        frame.add(Box.createRigidArea(new Dimension(100, 18)));
        frame.getContentPane().add(greenButton); 
        frame.add(Box.createRigidArea(new Dimension(27,40)));
        frame.getContentPane().add(b1);
        frame.add(Box.createRigidArea(new Dimension(27,40)));
        frame.getContentPane().add(b2);
        frame.setVisible(true); 
        frame.setEnabled(true);        
    }
    
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = PlayMenu.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        if(Integer.parseInt(e.getActionCommand()) == 1)
        {
             frame.setVisible(true); 
             frame.setEnabled(true); 
        }
        else if(Integer.parseInt(e.getActionCommand()) == 5)
        {
            frame.setVisible(false); 
            frame.setEnabled(false);
            frame.getContentPane().removeAll();
            BoardMenu menu = new BoardMenu();
            menu.setFrame(808, 1020);
        }
        else if(Integer.parseInt(e.getActionCommand()) == 6)
        {
            frame.setVisible(false); 
            frame.setEnabled(false);
            frame.getContentPane().removeAll();
            MainMenu menu = new MainMenu();
            menu.setFrame(-1, 1080, 720);
            menu.setMenuProperties(40, 216, 72);
            menu.addItemsToFrame(54, 36);
        }
    }
   
}
