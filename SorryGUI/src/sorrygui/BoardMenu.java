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
public class BoardMenu extends JPanel
{

    private BufferedImage background;
    private BufferedImage red;
    private JLabel redLabel;
    private JFrame frame;
    /**
     * @param args the command line arguments
     */
    
    //Creates the basic intiial menu frame
    
    public BoardMenu() 
    {
        frame = new JFrame("Sorry! - Game");
    }
    
    public JFrame getFrame(){
        return this.frame;
    }

    public void setFrame(int width, int height)
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
            //Load the background image
            background = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\sorryboard.png"));
            red = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\red.png"));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
            frame.setSize(width, height);
            frame.setContentPane(new JLabel(new ImageIcon(background))); 
            redLabel = new JLabel(new ImageIcon(red));
            frame.getContentPane().add(redLabel); 
            redLabel.setSize(1000, 400);
            frame.setLayout(null);
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
    }
    
    //add the items to the main menu's frame
        
    public void addItemsToFrame(int Xspace, int Yspace)
    {
        frame.setVisible(true); 
        frame.setEnabled(true);        
    }

}
