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
    
    //Background Image
    private BufferedImage background;
    
    //4 pegs for each color
    private BufferedImage red1, red2, red3, red4;
    private BufferedImage blue1, blue2, blue3, blue4;
    private BufferedImage green1, green2, green3, green4;
    private BufferedImage yellow1, yellow2, yellow3, yellow4;
    private JLabel redLabel1, redLabel2, redLabel3, redLabel4;
    private JLabel blueLabel1, blueLabel2, blueLabel3, blueLabel4;
    private JLabel greenLabel1, greenLabel2, greenLabel3, greenLabel4;
    private JLabel yellowLabel1,  yellowLabel2, yellowLabel3,  yellowLabel4;
    
    //12 cards + Deck, image and rules
    private BufferedImage c1, c2, c3, c4, c5, c7, c8, c10, c11, c12, cS, cD;
    private JLabel c1Label, c2Label, c3Label, c4Label, c5Label, c7Label, c8Label, c10Label, c11Label, c12Label, cSLabel;
    private JLabel c1Rules, c2Rules, c3Rules, c4Rules, c5Rules, c7Rules, c8Rules, c10Rules, c11Rules, c12Rules, cSRules;
    private JButton cDButton;
    
    //Image to indicate the current turn;
    private BufferedImage turn;
    private JLabel turnLabel;
    
    //numbers to see how many pegs are in the start (for the computer and the player)
    private JLabel numPlayerHome, numPlayerStart, numCompHome, numCompStart;
    
    //extra text to help players
    private JLabel firstTurn, choosePeg, chooseAgain;
    
    //buttons to choose between a card different choices
    private JButton b2, b3;
    
    //buttons to select which peg the player wants to move.
    private JButton p1, p2, p3, p4;
    
    private JFrame frame;
    /**
     * @param args the command line arguments
     */
    
    //Creates the basic intiial menu frame
    
    public BoardMenu() 
    {
        //Initialize title and all the text in the game;
        frame = new JFrame("Sorry! - Game");
        c1Rules = new JLabel("<html> <p align=\"justify\"> 1. Move a pawn from Start or move a pawn one space forward. </p><html>");
        c2Rules = new JLabel("<html> <p align=\"justify\"> 2. (a) Move a pawn from Start or (b) move a pawn two spaces forward. "
                + "Drawing a two entitles the player to draw again at the end of his or her turn."
                + " If you cannot use two, you can still draw again.</p><html>");
        c3Rules = new JLabel("<html> <p align=\"justify\"> 3. Move a pawn three spaces forward. </p><html> ");
        c4Rules = new JLabel("<html> <p align=\"justify\"> 4. Move a pawn four spaces backward. </p><html> ");
        c5Rules = new JLabel("<html> <p align=\"justify\"> 5. Move a pawn five spaces forward. </p><html> ");
        c7Rules = new JLabel("<html> <p align=\"justify\"> 7. (a) MMove one pawn seven spaces forward or "
                + "(b) split the seven spaces between two pawns. </p><html> ");
        c8Rules = new JLabel("<html> <p align=\"justify\"> 8. Move a pawn eight spaces forward. </p><html> ");
        c10Rules = new JLabel("<html> <p align=\"justify\"> 10. (a) Move a pawn 10 spaces forward or (b) one space backward. "
                + "If a player cannot go forward 10 spaces, then one pawn must go back one space. </p><html>");
        c11Rules = new JLabel("<html> <p align=\"justify\"> 11. (a) Move 11 spaces forward or (b) switch places with one opposing pawn. "
                + "A player that cannot move 11 spaces is not forced to switch and instead can forfeit the turn. "
                + "(Click on the deck to forfeit) </p><html>");
        c12Rules = new JLabel("<html> <p align=\"justify\"> 12. Move a pawn 12 spaces forward. </p><html>");
        cSRules = new JLabel("<html> <p align=\"justify\"> Sorry! Move any one pawn from Start to a square occupied by any opponent, "
                + "sending that pawn back to its own Start. "
                + "If there are no pawns on the player's Start, or no opponent's pawns on any squares, the turn is lost. </p><html>");
        firstTurn = new JLabel("<html> <p align=\"justify\"> Your Turn! Click on the deck to Draw a card. </p><html>");
        choosePeg = new JLabel("<html> <p align=\"justify\"> Choose which peg you want to move (or switch, if the card number is 11). </p><html>");
        chooseAgain = new JLabel("<html> <p align=\"justify\"> Choose which enemy peg do you want to switch places with. </p><html>");
        numPlayerHome = new JLabel("H: 0"); 
        numPlayerStart = new JLabel("T: 2");
        numCompHome = new JLabel("H: 0"); 
        numCompStart = new JLabel("T: 2");
        b2 = new JButton("(a)");
        b3 = new JButton("(b)");
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
            
            //Load some of the pegs's images
            blue1 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\blue1.png"));
            blue2 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\blue2.png"));
            blue4 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\blue3.png"));
            
            green2 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\green2.png"));
            green3 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\green3.png"));
            
            //load all the cards's images and the "turn: picture.
            c1 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\card1.png"));
            c2 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\card2.png"));
            c3 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\card3.png"));
            c4 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\card4.png"));
            c5 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\card5.png"));
            c7 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\card7.png"));
            c8 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\card8.png"));
            c10 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\card10.png"));
            c11 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\card11.png"));
            c12 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\card12.png"));
            cS = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\cardsorry.png"));
            cD = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\carddeck.png"));      
            turn = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\turn.png"));
            
            //set frame attributes and background
            frame.setSize(width, height);
            frame.setContentPane(new JLabel(new ImageIcon(background))); 
            
            //initializing labels and buttons
            blueLabel1 = new JLabel(new ImageIcon(blue1));
            blueLabel2 = new JLabel(new ImageIcon(blue2));
            blueLabel4 = new JLabel(new ImageIcon(blue4));
            greenLabel2 = new JLabel(new ImageIcon(green2));
            greenLabel3 = new JLabel(new ImageIcon(green3));
            
            c1Label = new JLabel(new ImageIcon(c1));
            c2Label = new JLabel(new ImageIcon(c2));
            c3Label = new JLabel(new ImageIcon(c3));
            c4Label = new JLabel(new ImageIcon(c4));
            c5Label = new JLabel(new ImageIcon(c5));
            c7Label = new JLabel(new ImageIcon(c7));
            c8Label = new JLabel(new ImageIcon(c8));
            c10Label = new JLabel(new ImageIcon(c10));
            c11Label = new JLabel(new ImageIcon(c11));
            c12Label = new JLabel(new ImageIcon(c12));
            cSLabel = new JLabel(new ImageIcon(cS));
            turnLabel = new JLabel(new ImageIcon(turn));
            //cDLabel = new JLabel(new ImageIcon(cD));  
            cDButton = new JButton(new ImageIcon(cD));
            
            cDButton.setLocation(320,215);
            c2Label.setLocation(-90,330);

            //c1Rules.setFont(new Font("Arial", Font.BOLD, 17));
            c2Rules.setFont(new Font("SGK100", Font.BOLD, 19));
            //c1Rules.setLocation(350,650);
            c2Rules.setLocation(360,640);
            
            numPlayerHome.setFont(new Font("SGK100", Font.BOLD, 20));
            numPlayerStart.setFont(new Font("SGK100", Font.BOLD, 20));
            numCompHome.setFont(new Font("SGK100", Font.BOLD, 20));
            numCompStart.setFont(new Font("SGK100", Font.BOLD, 20));
            //b1.setFont(new Font("Arial", Font.PLAIN, 12));
            b2.setFont(new Font("SGK100", Font.PLAIN, 16));
            b3.setFont(new Font("SGK100", Font.PLAIN, 16));
            
            //blue
            numPlayerHome.setLocation(273,665);
            numPlayerStart.setLocation(273,640);
            
            //green
            numCompHome.setLocation(120,760);
            numCompStart.setLocation(120,735);
            
            //b1.setLocation(373,316);
            b2.setLocation(400,910);
            b3.setLocation(460,910);    
            
            //turn labels location
            //yellow
            turnLabel.setLocation(238,860);  
            //blue
            turnLabel.setLocation(238,760);  
            //red
            turnLabel.setLocation(86,760);  
            //green
            turnLabel.setLocation(86,860); 
            
            //set peg location in the board
            int x = 32;
            int y = -459;
            
            blueLabel1.setLocation(y,x);
           
            for (int i = 0; i <12; i++)
            {
                if (i == 10)
                    y = y + 48; //goes to the right
                
                if (i == 9)
                {
                    y = y + 4*48;
                    greenLabel2.setLocation(y,x);
                    y = y - 4*48;
                }
                
                if (i == 6)
                    blueLabel4.setLocation(y,x);
                    
                    //y = y - 49; //goes to the left
                greenLabel3.setLocation(y,x);
                x = x + 48; //goes down
                //x = x- - 48;//goes up
            }
            frame.getContentPane().add(greenLabel2); 
            frame.getContentPane().add(blueLabel1); 
            frame.getContentPane().add(greenLabel3); 
            frame.getContentPane().add(blueLabel4); 
            
            frame.getContentPane().add(cDButton); 
            frame.getContentPane().add(c2Label);
            //frame.getContentPane().add(c1Rules); 
            frame.getContentPane().add(c2Rules); 
            frame.getContentPane().add(numPlayerHome); 
            frame.getContentPane().add(numPlayerStart); 
            frame.getContentPane().add(numCompHome); 
            frame.getContentPane().add(numCompStart); 
            //frame.getContentPane().add(b1); 
            frame.getContentPane().add(b2); 
            frame.getContentPane().add(b3); 
            frame.getContentPane().add(turnLabel); 
            frame.setResizable(false);
            
            blueLabel1.setSize(1000, 400);           
            blueLabel4.setSize(1000, 400);
            greenLabel2.setSize(1000, 400);
            greenLabel3.setSize(1000, 400);
            
            cDButton.setSize(185,90);
            c2Label.setSize(1000,400);
            c1Rules.setSize(400,400);
            c2Rules.setSize(400,450);
          
            numPlayerHome.setSize(1000,400);
            numPlayerStart.setSize(1000,400);
            numCompHome.setSize(1000,400);
            numCompStart.setSize(1000,400);
            
            //b1.setSize(65,40);
            b2.setSize(50,40);
            b3.setSize(50,40);
            
            turnLabel.setSize(100,100);
            
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
