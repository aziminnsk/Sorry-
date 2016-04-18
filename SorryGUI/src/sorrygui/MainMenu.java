/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorrygui;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static sorrygui.PlayMenu.createImageIcon;
/**
 *
 * @author hchangqu
 */
public class MainMenu implements ActionListener
{
      private JButton b1, b2, b3, b4;
      private JFrame frame;
      private BufferedImage background;
      private HelpMenu help;
      private PlayMenu play;
    /**
     * @param args the command line arguments
     */
    
    //Creates the basic intiial menu frame
    
    public MainMenu() 
    {    
        frame = new JFrame("Sorry! - Game");
        b1 = new JButton("Play!");
        b2 = new JButton("Stats");
        b3 = new JButton("Help");
        b4 = new JButton("Exit");
    }
    
    public JFrame getFrame(){
        return this.frame;
    }

    public void setFrame(int choice, int width, int height)
    {      
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
        {
            
        }
        
        try
        {
            // Load the background image
            if(choice == -1)
                background = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\Sorry_Background.png"));
            else if(choice == 0)
                background = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\sprite_0.png"));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
            frame.setSize(width, height);
            frame.setContentPane(new JLabel(new ImageIcon(background))); 
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            frame.setResizable(false);
        } 
        catch (IOException exp) 
        {
            exp.printStackTrace();
        }
        
        frame.setVisible(true); 
        frame.setEnabled(true);  
    }
    
    //Set the menu and it's items properties
         
    public void setMenuProperties(int fontSize, int X, int Y)
    {
        b1.setFont(new Font("SGK100", Font.PLAIN, fontSize));
        b2.setFont(new Font("SGK100", Font.PLAIN, fontSize));
        b3.setFont(new Font("SGK100", Font.PLAIN, fontSize));
        b4.setFont(new Font("SGK100", Font.PLAIN, fontSize));
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setMaximumSize(new Dimension(X,  Y));
        b2.setMaximumSize(new Dimension(X,  Y));         
        b3.setMaximumSize(new Dimension(X,  Y));   
        b4.setMaximumSize(new Dimension(X,  Y));           
    }
    
    //add the items to the main menu's frame
        
    public void addItemsToFrame(int Xspace, int Yspace)
    {
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b1.setActionCommand(Integer.toString(1));
        b1.setMnemonic(KeyEvent.VK_R);
        b2.setActionCommand(Integer.toString(2));
        b2.setMnemonic(KeyEvent.VK_B);
        b3.setActionCommand(Integer.toString(3));
        b3.setMnemonic(KeyEvent.VK_Y);
        b4.setActionCommand(Integer.toString(4));
        b4.setMnemonic(KeyEvent.VK_G);
        frame.add(Box.createRigidArea(new Dimension(324, 217)));
        frame.getContentPane().add(b1); 
        frame.add(Box.createRigidArea(new Dimension(54,36)));
        frame.getContentPane().add(b2); 
        frame.add(Box.createRigidArea(new Dimension(54,36)));
        frame.getContentPane().add(b3); 
        frame.add(Box.createRigidArea(new Dimension(54,36)));
        frame.getContentPane().add(b4); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
        frame.setEnabled(true);        
    }
    
     public void actionPerformed(ActionEvent e) {
        if(Integer.parseInt(e.getActionCommand()) == 1)
        {
            frame.setVisible(false);
            frame.getContentPane().removeAll();
            this.setFrame(0, 1080, 720);
            play = new PlayMenu(this.frame);
            play.setMenuProperties(45, 246, 36);
            play.addItemsToFrame();
            frame.setVisible(true); 
            frame.setEnabled(true); 
        }
        else if(Integer.parseInt(e.getActionCommand()) == 3)
        {
            frame.setVisible(false);
            frame.getContentPane().removeAll();
            help = new HelpMenu(this.frame);
            help.setMenuProperties(50, 216, 72);
            help.addItemsToFrame();
            frame.setVisible(true); 
            frame.setEnabled(true); 
        }
        else if(Integer.parseInt(e.getActionCommand()) == 4)
            System.exit(0);
    }
        
}
