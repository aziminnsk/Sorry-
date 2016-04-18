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
    private JRadioButton easy, normal, hard;
    private BufferedImage background;
    private JLabel inputText;
    private JLabel colorText;
    private JLabel modeText;
    private JTextField input;
    private JFrame frame;
    private JButton b1, b2, b3, b4;
    private JLabel picture;
    private MainMenu menu;

    //Creates the name input and color selection menu to get ready to play
     
    public PlayMenu(JFrame frame) 
    {    
        b1 = new JButton("Ready!");
        b2 = new JButton("Back");
        b3 = new JButton("New Data");
        b4 = new JButton("Load Data");
        //b1.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        redButton = new JRadioButton();
        blueButton = new JRadioButton();
        greenButton = new JRadioButton();
        yellowButton = new JRadioButton();
        easy = new JRadioButton("Easy");
        normal = new JRadioButton("Normal");
        hard = new JRadioButton("Hard");
        picture = new JLabel();
        inputText = new JLabel("Input username:");
        colorText = new JLabel("Select color:");
        modeText = new JLabel("Select Difficulty Setting:");
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
        
        easy.setActionCommand(Integer.toString(7));
        easy.setMnemonic(KeyEvent.VK_E);
        normal.setActionCommand(Integer.toString(8));
        normal.setMnemonic(KeyEvent.VK_N);
        hard.setActionCommand(Integer.toString(9));
        hard.setMnemonic(KeyEvent.VK_H);
        
        inputText.setFont(new Font("SGK100", Font.BOLD, fontSize - 10));
        colorText.setFont(new Font("SGK100", Font.BOLD, fontSize - 10));
        modeText.setFont(new Font("SGK100", Font.BOLD, fontSize - 17));
        easy.setFont(new Font("SGK100", Font.BOLD, fontSize - 28));
        normal.setFont(new Font("SGK100", Font.BOLD, fontSize - 28));
        hard.setFont(new Font("SGK100", Font.BOLD, fontSize - 28));
        input.setFont(new Font("SGK100", Font.CENTER_BASELINE, fontSize - 20));
        b1.setFont(new Font("SGK100", Font.PLAIN, fontSize));
        b2.setFont(new Font("SGK100", Font.PLAIN, fontSize));
        b3.setFont(new Font("SGK100", Font.BOLD, fontSize - 28));
        b4.setFont(new Font("SGK100", Font.BOLD, fontSize - 28));
        input.setMaximumSize(new Dimension(X,  Y)); 
        
        inputText.setLocation(280, 50);  
       input.setLocation(520, 180);   
       modeText.setLocation(400, 200);
       
       b1.setLocation(350, 600);  
       b2.setLocation(580, 600);  
       b3.setLocation(410, 270);
       b4.setLocation(560, 270);
       
       easy.setLocation(400, 400);  
       normal.setLocation(500, 400); 
       hard.setLocation(600, 400); 
       
       redButton.setLocation(140, 250);
       blueButton.setLocation(140, 445);
       yellowButton.setLocation(900, 250);
       greenButton.setLocation(900, 445);
        
       inputText.setSize(300, 300);           
       input.setSize(250, 50);
       modeText.setSize(300, 300);
       redButton.setSize(25, 30);
       blueButton.setSize(25, 30);
       yellowButton.setSize(25, 30);
       greenButton.setSize(25, 30);
       
       b1.setSize(180,60);
       b2.setSize(150,60);
       b3.setSize(100,30);
       b4.setSize(100,30);
       
       easy.setSize(70,30);  
       normal.setSize(70,30);
       hard.setSize(70,30);
    }
    
    //add the items to the main menu's frame
    
    public void addItemsToFrame()
    { 
        ButtonGroup group = new ButtonGroup();
        b1.addActionListener(this);
        b1.setActionCommand(Integer.toString(5));
        b2.addActionListener(this);
        b2.setActionCommand(Integer.toString(6));
        b3.addActionListener(this);
        b3.setActionCommand(Integer.toString(10));
        b4.addActionListener(this);
        b4.setActionCommand(Integer.toString(11));
        group.add(redButton);
        group.add(blueButton);
        group.add(greenButton);
        group.add(yellowButton);
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(easy);
        group2.add(normal);
        group2.add(hard);
        
        redButton.setBackground(Color.RED);
        blueButton.setBackground(Color.BLUE);
        greenButton.setBackground(Color.GREEN);
        yellowButton.setBackground(Color.yellow);
        
        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        greenButton.addActionListener(this);
        yellowButton.addActionListener(this);
        
        easy.addActionListener(this);
        normal.addActionListener(this);
        hard.addActionListener(this);
        
        frame.getContentPane().add(inputText); 
        frame.getContentPane().add(input); 
        frame.getContentPane().add(colorText); 
        frame.getContentPane().add(redButton); 
        frame.getContentPane().add(blueButton); 
        frame.getContentPane().add(yellowButton); 
        frame.getContentPane().add(greenButton); 
        frame.getContentPane().add(modeText); 
        frame.getContentPane().add(b1);
        frame.getContentPane().add(b2);
        frame.getContentPane().add(b3);
        frame.getContentPane().add(b4);
        frame.getContentPane().add(easy); 
        frame.getContentPane().add(normal);
        frame.getContentPane().add(hard);

        frame.setLayout(null);
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
            menu.setMenuProperties(20);
            menu.addItemsToFrame();
        }
        else if(Integer.parseInt(e.getActionCommand()) == 6)
        {
            frame.setVisible(false); 
            frame.setEnabled(false);
            frame.getContentPane().removeAll();
            MainMenu menu = new MainMenu();
            menu.setFrame(-1, 1080, 720);
            menu.setMenuProperties(60, 216, 72);
            menu.addItemsToFrame(54, 36);
        }
    }
   
}
