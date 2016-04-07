/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorrygui;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author hchangqu
 */
public class SorryGUI{
    /**
     * @param args the command line arguments
     */
    //Creates the basic GUI of the game and keeps it running
    
    public static void main(String[] args) {    
        MainMenu menu = new MainMenu();
        menu.setFrame(-1, 1080, 720);
        menu.setMenuProperties(40, 216, 72);
        menu.addItemsToFrame(54, 36);
    }
    
}
