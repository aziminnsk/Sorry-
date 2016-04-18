/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorrygui;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

/**
 *
 * @author hchangqu
 */
public class HelpMenu  implements ActionListener{
    
    private JLabel l1, l2;
    private JButton b1;
    private JFrame frame;
    private MainMenu menu;
     
    //Creates the help menu with an brief explanation of the game's basic rules
     
    public HelpMenu(JFrame frame) 
    {    
        b1 = new JButton("Back");
        l1 = new JLabel("<html> <p align=\"center\">Basic Rules </p> <html>");
        l2 = new JLabel("<html> <p align=\"justify\"> <ul> <li>Each player chooses four pawns of one color and one player is selected to play first.</li> \n" +
"<li> Each player in turn draws one card from the stack and follows its instructions. </li>"
                + "<li> To begin the game, all of a player's four pawns are restricted to Start; only a 1 or 2 card can release them to the rest of the board. </li> \n" +
"<li> A player can jump over any other pawn. However, two pawns cannot occupy the same square. </li>"
                + "<li> A pawn that lands on a square occupied by another \"bumps\" that pawn back to its own Start. </li>"
                + "<li> Players can not bump their own pawns back to Start. </li>"
                + "<li> If the only way to complete a move would result in a player bumping himself, the pawns remain in place and the player loses his or her turn. </li>\n" +
"<li> If a pawn lands at the start of a slide (except those of its own colour), it immediately moves to the last square of the slide. All pawns anywhere on the slide are sent back to their respective Starts. </li>\n" +
"<li> Access to the \"safety zone\" is limited to pawns of the same color. Pawns inside the zone are immune to being replaced. However, a pawn is vulnerable to being forcibly moved backward out of the safety zone. Also, you cannot move your pawn backwards and forwards and count it as a space, no matter what card you have. </li>"
                + "<li> Font: Wikipedia </li> </ul> </p><html>");
        this.frame = frame;
        this.menu = menu;
    }
    
    //Set the menu and it's items properties.
    
    public void setMenuProperties(int fontSize, int X, int Y)
    {
        l1.setFont(new Font("SGK100", Font.BOLD, fontSize - 5));
        l2.setFont(new Font("SGK100", Font.PLAIN, fontSize - 30));
        b1.setFont(new Font("SGK100", Font.PLAIN, fontSize));
        b1.setMaximumSize(new Dimension(X,  Y));         
        l2.setMaximumSize(new Dimension(X + 480,  Y + 250));
        
        b1.setLocation(450, 610);  
        l1.setLocation(450, 80);  
        l2.setLocation(180, 100);
        b1.setSize(180,60);
        l1.setSize(200, 200);  
        l2.setSize(720, 650);
    }
    
    //add the items to the main menu's frame
    
    public void addItemsToFrame()
    { 
        b1.addActionListener(this);
        b1.setActionCommand(Integer.toString(1));
        b1.setMnemonic(KeyEvent.VK_R);
        frame.getContentPane().add(l1); 
        frame.getContentPane().add(l2); 
        frame.getContentPane().add(b1);
        frame.setLayout(null);
        frame.setVisible(true); 
        frame.setEnabled(true);        
    }
    
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        frame.getContentPane().removeAll();
        MainMenu menu = new MainMenu();
        menu.setFrame(-1, 1080, 720);
        menu.setMenuProperties(60, 216, 72);
        menu.addItemsToFrame(54, 36);
    }
    
}
