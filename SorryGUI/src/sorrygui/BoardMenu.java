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
import java.util.concurrent.TimeUnit;
import static sorrygui.PlayMenu.createImageIcon;
/**
 *
 * @author hchangqu
 */
public class BoardMenu implements ActionListener
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
    
    public static JLabel tempRule, tempCard;
    public boolean myTurn;
    
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
        c1Rules = new JLabel("<html> <p align=\"justify\"> 1. (a) Move a pawn from Start or (b) move a pawn one space forward. </p><html>");
        c2Rules = new JLabel("<html> <p align=\"justify\"> 2. (a) Move a pawn from Start or (b) move a pawn two spaces forward. "
                + "Drawing a two entitles the player to draw again at the end of his or her turn."
                + " If you cannot use two, you can still draw again.</p><html>");
        c3Rules = new JLabel("<html> <p align=\"justify\"> 3. Move a pawn three spaces forward. Choose which peg do you want to move. </p><html> ");
        c4Rules = new JLabel("<html> <p align=\"justify\"> 4. Move a pawn four spaces backward. Choose which peg do you want to move. </p><html> ");
        c5Rules = new JLabel("<html> <p align=\"justify\"> 5. Move a pawn five spaces forward. Choose which peg do you want to move. </p><html> ");
        c7Rules = new JLabel("<html> <p align=\"justify\"> 7. (a) Move one pawn seven spaces forward or "
                + "(b) split the seven spaces between two pawns. </p><html> ");
        c8Rules = new JLabel("<html> <p align=\"justify\"> 8. Move a pawn eight spaces forward. Choose which peg do you want to move. </p><html> ");
        c10Rules = new JLabel("<html> <p align=\"justify\"> 10. (a) Move a pawn 10 spaces forward or (b) one space backward. "
                + "If a player cannot go forward 10 spaces, then one pawn must go back one space. </p><html>");
        c11Rules = new JLabel("<html> <p align=\"justify\"> 11. (a) Move 11 spaces forward or (b) switch places with one opposing pawn. "
                + "If you can't move 11 spaces you aren't forced to switch and instead can forfeit the turn. "
                + "(Click on the deck to forfeit) </p><html>");
        c12Rules = new JLabel("<html> <p align=\"justify\"> 12. Move a pawn 12 spaces forward. Choose which peg do you want to move. </p><html>");
        cSRules = new JLabel("<html> <p align=\"justify\"> Sorry!. Move any one pawn from Start to a square occupied by any opponent, "
                + "sending it back to its own Start. "
                + "If there are no pawns on the player's Start, or no opponent's pawns on any squares, the turn is lost."
                + " (Click on the deck to continue if you can't choose any pegs) </p><html>");
        firstTurn = new JLabel("<html> <p align=\"justify\"> Your Turn! Click on the deck to Draw a card. </p><html>");
        choosePeg = new JLabel("<html> <p align=\"justify\"> Choose which peg do you want to move. "
                + "(or switch, if the card number is 11 or if is the Sorry! card). </p><html>");
        chooseAgain = new JLabel("<html> <p align=\"justify\"> Choose which enemy peg do you want to switch places with. </p><html>");
        numPlayerHome = new JLabel("H: 0"); 
        numPlayerStart = new JLabel("T: 2");
        numCompHome = new JLabel("H: 0"); 
        numCompStart = new JLabel("T: 2");
        myTurn = true;
        b2 = new JButton("(a)");
        b3 = new JButton("(b)");
        
        p1 = new JButton("(1)");
        p2 = new JButton("(2)");
        p3 = new JButton("(3)");
        p4 = new JButton("(4)");
           
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
            blue4 = ImageIO.read(new File("C:\\Users\\hchangqu\\Documents\\NetBeansProjects\\SorryGUI\\src\\sorrygui\\images\\blue4.png"));
            
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
            
            turnLabel = new JLabel(new ImageIcon(turn));
            //cDLabel = new JLabel(new ImageIcon(cD));  
            cDButton = new JButton(new ImageIcon(cD));
            
            //set frame attributes and background
            frame.setSize(width, height);
            frame.setContentPane(new JLabel(new ImageIcon(background))); 
            frame.setLayout(null);
        } 
        catch (IOException exp) 
        {
            exp.printStackTrace();
        }
        cDButton.setEnabled(false);
        frame.setVisible(true); 
        frame.setEnabled(true);  
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    //Set the menu and it's items properties
         
    public void setMenuProperties(int fontSize, int card)
    {        
           //initializing labels and buttons     
            blueLabel1 = new JLabel(new ImageIcon(blue1));
            blueLabel2 = new JLabel(new ImageIcon(blue2));
            blueLabel4 = new JLabel(new ImageIcon(blue4));
            greenLabel2 = new JLabel(new ImageIcon(green2));
            greenLabel3 = new JLabel(new ImageIcon(green3));
            
            switch(card){
                case 1:
                    c1Label = new JLabel(new ImageIcon(c1));
                    c1Label.setLocation(-90,330);
                    c1Rules.setFont(new Font("SGK100", Font.BOLD, fontSize));
                    c1Label.setSize(1000,400);
                    c1Rules.setSize(400,400);
                    c1Rules.setLocation(360,640);
                    setButtonsProperties(fontSize, false); 
                    break;
                case 2:
                    c2Label = new JLabel(new ImageIcon(c2));
                    c2Label.setLocation(-90,330);
                    c2Rules.setFont(new Font("SGK100", Font.BOLD, fontSize));
                    c2Label.setSize(1000,400);
                    c2Rules.setSize(400,400);
                    c2Rules.setLocation(360,665);
                    setButtonsProperties(fontSize, false);   
                    break;
                case 3:
                    c3Label = new JLabel(new ImageIcon(c3));
                    c3Label.setLocation(-90,330);
                    c3Rules.setFont(new Font("SGK100", Font.BOLD, fontSize));
                    c3Label.setSize(1000,400);
                    c3Rules.setSize(400,400);
                    c3Rules.setLocation(360,640);
                    setButtonsProperties(fontSize, true); 
                    break;
                case 4:
                    c4Label = new JLabel(new ImageIcon(c4));
                    c4Label.setLocation(-90,330);
                    c4Rules.setFont(new Font("SGK100", Font.BOLD, fontSize));
                    c4Label.setSize(1000,400);
                    c4Rules.setSize(400,400);
                    c4Rules.setLocation(360,640);
                    setButtonsProperties(fontSize, true);          
                    break;
                case 5:
                    c5Label = new JLabel(new ImageIcon(c5));
                    c5Label.setLocation(-90,330);
                    c5Rules.setFont(new Font("SGK100", Font.BOLD, fontSize));
                    c5Label.setSize(1000,400);
                    c5Rules.setSize(400,400);
                    c5Rules.setLocation(360,640);
                    setButtonsProperties(fontSize, true); 
                    break;
                case 7:
                    c7Label = new JLabel(new ImageIcon(c7));
                    c7Label.setLocation(-90,330);
                    c7Rules.setFont(new Font("SGK100", Font.BOLD, fontSize));
                    c7Label.setSize(1000,400);
                    c7Rules.setSize(400,400);
                    c7Rules.setLocation(360,640);
                    setButtonsProperties(fontSize, false); 
                    break;
                case 8:
                    c8Label = new JLabel(new ImageIcon(c8));
                    c8Label.setLocation(-90,330);
                    c8Rules.setFont(new Font("SGK100", Font.BOLD, fontSize));
                    c8Label.setSize(1000,400);
                    c8Rules.setSize(400,400);
                    c8Rules.setLocation(360,640);
                    setButtonsProperties(fontSize, true); 
                    break;
                case 10:
                    c10Label = new JLabel(new ImageIcon(c10));
                    c10Label.setLocation(-90,330);
                    c10Rules.setFont(new Font("SGK100", Font.BOLD, fontSize));
                    c10Label.setSize(1000,400);
                    c10Rules.setSize(400,400);
                    c10Rules.setLocation(360,660);
                    setButtonsProperties(fontSize, false);     
                    break;
                case 11:
                    c11Label = new JLabel(new ImageIcon(c11));
                    c11Label.setLocation(-90,330);
                    c11Rules.setFont(new Font("SGK100", Font.BOLD, fontSize - 2));
                    c11Label.setSize(1000,400);
                    c11Rules.setSize(400,400);
                    c11Rules.setLocation(360,660);
                    setButtonsProperties(fontSize, false);    
                    break;
                case 6:
                    c12Label = new JLabel(new ImageIcon(c12));
                    c12Label.setLocation(-90,330);
                    c12Rules.setFont(new Font("SGK100", Font.BOLD, fontSize));
                    c12Label.setSize(1000,400);
                    c12Rules.setSize(400,400);
                    c12Rules.setLocation(360,640);
                    setButtonsProperties(fontSize, true); 
                    break;
                case 9:
                    cSLabel = new JLabel(new ImageIcon(cS));
                    cSLabel.setLocation(-90,330);
                    cSRules.setFont(new Font("SGK100", Font.BOLD, fontSize - 3));
                    cSLabel.setSize(1000,400);
                    cSRules.setSize(400,400);
                    cSRules.setLocation(360,660);
                    setButtonsProperties(fontSize, false);   
                    break;
            }
            
            cDButton.setLocation(320,215);
            
            //choosePeg.setFont(new Font("SGK100", Font.BOLD, fontSize));
            chooseAgain.setFont(new Font("SGK100", Font.BOLD, fontSize));
            
            //choosePeg.setLocation(360,645);
            chooseAgain.setLocation(360,645);
            
            numPlayerHome.setFont(new Font("SGK100", Font.BOLD, fontSize));
            numPlayerStart.setFont(new Font("SGK100", Font.BOLD, fontSize));
            numCompHome.setFont(new Font("SGK100", Font.BOLD, fontSize));
            numCompStart.setFont(new Font("SGK100", Font.BOLD, fontSize));
            //b1.setFont(new Font("Arial", Font.PLAIN, 12));
            //blue
            numPlayerHome.setLocation(273,665);
            numPlayerStart.setLocation(273,640);
            
            //green
            numCompHome.setLocation(120,760);
            numCompStart.setLocation(120,735);
            
            //b1.setLocation(373,316);
       
            //turn labels location
            //yellow
            turnLabel.setLocation(238,860);  
            //blue
            turnLabel.setLocation(238,760);  
            //red
            turnLabel.setLocation(86,760);  
            //green
            turnLabel.setLocation(86,860); 
            
            //set peg location in the board (1)
            int x = 368;
            int y = -459;
            
            blueLabel1.setLocation(y,x);
            blueLabel2.setLocation(y,x + 48*4);
            blueLabel4.setLocation (y, x - 48*11);
            greenLabel2.setLocation (y + 48*15, x - 48*11);
            greenLabel3.setLocation (y + 48*15, x + 48*4);
                    
            blueLabel1.setSize(1000, 400);   
            blueLabel2.setSize(1000, 400);
            blueLabel4.setSize(1000, 400);
            greenLabel2.setSize(1000, 400);
            greenLabel3.setSize(1000, 400);
            
            cDButton.setSize(185,90);
            chooseAgain.setSize(400,450);
            
          
            numPlayerHome.setSize(1000,400);
            numPlayerStart.setSize(1000,400);
            numCompHome.setSize(1000,400);
            numCompStart.setSize(1000,400);
            
            //b1.setSize(65,40);
       
            turnLabel.setSize(100,100);
            
            frame.setResizable(false);    
    }
    
    public void setButtonsProperties(int fontSize, boolean isSelectPeg)
    {
        if(!isSelectPeg)
        {
         b2.setFont(new Font("SGK100", Font.PLAIN, fontSize - 4));
         b3.setFont(new Font("SGK100", Font.PLAIN, fontSize - 4));
         b2.setSize(50,40);
         b3.setSize(50,40);
         b2.setLocation(500,915);
         b3.setLocation(570,915);
        }
        else
        {
            p1.setFont(new Font("SGK100", Font.PLAIN, fontSize - 3));
            p2.setFont(new Font("SGK100", Font.PLAIN, fontSize - 3));
            p3.setFont(new Font("SGK100", Font.PLAIN, fontSize - 3));
            p4.setFont(new Font("SGK100", Font.PLAIN, fontSize - 3));
            p1.setLocation(500,910);
            p2.setLocation(570,910);  
            p3.setLocation(640,910); 
            p4.setLocation(710,910);         
            p1.setSize(50,40);
            p2.setSize(50,40);
            p3.setSize(50,40);
            p4.setSize(50,40);
        }
        
    }
 
    
    //add the items to the main menu's frame
        
    public void addItemsToFrame(int card)
    {
            cDButton.addActionListener(this);
            p1.addActionListener(this);
            p2.addActionListener(this);
            p3.addActionListener(this);
            p4.addActionListener(this);
            
            b2.addActionListener(this);
            b3.addActionListener(this);
            
            cDButton.setActionCommand(Integer.toString(0));
            cDButton.setMnemonic(KeyEvent.VK_0);
            p1.setActionCommand(Integer.toString(1));
            p1.setMnemonic(KeyEvent.VK_1);
            p2.setActionCommand(Integer.toString(2));
            p2.setMnemonic(KeyEvent.VK_2);
            p3.setActionCommand(Integer.toString(3));
            p3.setMnemonic(KeyEvent.VK_3);
            p4.setActionCommand(Integer.toString(4));
            p4.setMnemonic(KeyEvent.VK_4);
            b2.setActionCommand(Integer.toString(5));
            b2.setMnemonic(KeyEvent.VK_4);
            b3.setActionCommand(Integer.toString(6));
            b3.setMnemonic(KeyEvent.VK_4);
        
            frame.getContentPane().add(greenLabel2); 
            frame.getContentPane().add(blueLabel1);
            frame.getContentPane().add(blueLabel2);
            frame.getContentPane().add(greenLabel3); 
            frame.getContentPane().add(blueLabel4); 
            
            frame.getContentPane().add(cDButton); 
            
            if(tempRule != null)
                 frame.getContentPane().remove(choosePeg); 
            
            switch(card){
                case 1:
                    frame.getContentPane().add(c1Label);
                    frame.getContentPane().add(c1Rules); 
                    addButtonsToFrame(false);
                    tempCard = c1Label;
                    tempRule = c1Rules;
                    break;
                case 2:
                    frame.getContentPane().add(c2Label);
                    frame.getContentPane().add(c2Rules); 
                    addButtonsToFrame(false);
                    tempCard = c2Label;
                    tempRule = c2Rules;
                    break;
                case 3:
                    frame.getContentPane().add(c3Label); 
                    frame.getContentPane().add(c3Rules);
                    addButtonsToFrame(true);
                    tempCard = c3Label;
                    tempRule = c3Rules;
                    break;
                case 4:
                    frame.getContentPane().add(c4Label);
                    frame.getContentPane().add(c4Rules);
                    addButtonsToFrame(true);
                    tempCard = c4Label;
                    tempRule = c4Rules;
                    break;
                case 5:
                    frame.getContentPane().add(c5Label);  
                    frame.getContentPane().add(c5Rules);
                    addButtonsToFrame(true);
                    tempCard = c5Label;
                    tempRule = c5Rules;
                    break;
                case 7:
                    frame.getContentPane().add(c7Label);
                    frame.getContentPane().add(c7Rules);  
                    addButtonsToFrame(false);
                    tempCard = c7Label;
                    tempRule = c7Rules;
                    break;
                case 8:
                    frame.getContentPane().add(c8Label);  
                    frame.getContentPane().add(c8Rules);
                    addButtonsToFrame(true);
                    tempCard = c8Label;
                    tempRule = c8Rules;
                    break;
                case 10:
                    frame.getContentPane().add(c10Label);  
                    frame.getContentPane().add(c10Rules);
                    addButtonsToFrame(false);
                    tempCard = c10Label;
                    tempRule = c10Rules;
                    break;
                 case 11:
                    frame.getContentPane().add(c11Label);  
                    frame.getContentPane().add(c11Rules);
                    addButtonsToFrame(false);
                    tempCard = c11Label;
                    tempRule = c11Rules;
                    break;
                 case 6:
                    frame.getContentPane().add(c12Label);  
                    frame.getContentPane().add(c12Rules);
                    tempCard = c12Label;
                    tempRule = c12Rules;
                    addButtonsToFrame(true);
                    break;
                 case 9:
                    frame.getContentPane().add(cSLabel);  
                    frame.getContentPane().add(cSRules);
                    addButtonsToFrame(false);
                    tempCard = cSLabel;
                    tempRule = cSRules;
                    break;
            }

            //frame.getContentPane().add(choosePeg);  
            //frame.getContentPane().add(chooseAgain);  
            
            frame.getContentPane().add(numPlayerHome); 
            frame.getContentPane().add(numPlayerStart); 
            frame.getContentPane().add(numCompHome); 
            frame.getContentPane().add(numCompStart); 
            //frame.getContentPane().add(b1); 
            //frame.getContentPane().add(b2); 
            //frame.getContentPane().add(b3); 

            frame.getContentPane().add(turnLabel); 
            
            frame.setVisible(true); 
            frame.setEnabled(true);        
    }
    
    public void addButtonsToFrame(boolean isSelectPeg)
    {
        if(!isSelectPeg)
        {
            frame.getContentPane().add(b2); 
            frame.getContentPane().add(b3); 
        }
        else
        {
            frame.getContentPane().add(p1); 
            frame.getContentPane().add(p2); 
            frame.getContentPane().add(p3); 
            frame.getContentPane().add(p4);    
        }
        
    }
    
     public void actionPerformed(ActionEvent e) {
         if(Integer.parseInt(e.getActionCommand()) == 0)
         {
            myTurn = !myTurn;
            frame.getContentPane().remove(p1); 
            frame.getContentPane().remove(p2); 
            frame.getContentPane().remove(p3); 
            frame.getContentPane().remove(p4); 
            
            cDButton.setEnabled(false);
            
            frame.getContentPane().remove(tempCard);  
            frame.getContentPane().remove(tempRule);
            frame.getContentPane().remove(turnLabel);
            int randomNum = 1 + (int)(Math.random() * 11); 
            setMenuProperties(20, randomNum);
            addItemsToFrame(randomNum);

            
            frame.setVisible(true); 
            if(myTurn)
               turnLabel.setLocation(86,860);
            else
               turnLabel.setLocation(238,760); 
             
            frame.getContentPane().add(turnLabel);
         }
         else if(Integer.parseInt(e.getActionCommand()) == 5 || Integer.parseInt(e.getActionCommand()) == 6 )
         {
                setButtonsProperties(20, true); 
                addButtonsToFrame(true); 
                frame.getContentPane().remove(tempRule);       
                choosePeg.setSize(400,450);
                choosePeg.setFont(new Font("SGK100", Font.BOLD, 20));
                choosePeg.setLocation(360,645);
                frame.getContentPane().add(choosePeg);
                frame.setVisible(true); 
                cDButton.setEnabled(false);
                frame.getContentPane().remove(b2); 
                frame.getContentPane().remove(b3); 
         }
         else if(Integer.parseInt(e.getActionCommand()) == 1 || 
                 Integer.parseInt(e.getActionCommand()) == 2 ||
                 Integer.parseInt(e.getActionCommand()) == 3 || 
                 Integer.parseInt(e.getActionCommand()) == 4)
         {
            cDButton.setEnabled(true);
            frame.setVisible(true); 
         }
    }
}
