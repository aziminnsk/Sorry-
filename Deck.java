/* Import java utilities used for ArrayList and Random */

import java.util.*;
import java.util.Random;

/* The Deck Class holds the cards and allows users to draw
   cards from the deck while removing them from the deck */

public class Deck
{
   /* Initialized ArrayLists*/
   /* deck holds cards in order 0 to 49 */
   /* shuffledDeck holds a deck of shuffled cards */
   /* numForShuffle initalizes the number generator */
   
   ArrayList<Integer> deck = new ArrayList();
   ArrayList<Integer> shuffledDeck = new ArrayList();
   Random numForShuffle = new Random();
   
   /* Initializes deck that creates a deck of 50 ordered cards and adds it to the 
      Deck ArrayList */
      
   public Deck()
   {
      for (int i = 0; i < 49; i++)
      {
         deck.add(i);
      }
   }
   
   /*Draws the top card from the shuffledDeck ArrayList and removes it from the 
     ArrayList */
   
   public int draw()
   {
      int cardNum = shuffledDeck.get(0);
      shuffledDeck.remove(0);
      return cardNum;
   }
   
   /* Shuffles the cards in the Deck ArrayList and adds them to the shuffledDeck.
      Also removes the cards from the Deck ArrrayList */
   
   public void shuffle()
   {
      int heldCard;
      
      while (deck.size() > 0)
      {
         heldCard = numForShuffle.nextInt(deck.size());
         shuffledDeck.add(heldCard);
         deck.remove(heldCard);
      }
   }
   
   public int size()
   {
      
         int deckSize = shuffledDeck.size();
         return deckSize;
   }
   
   /* Test function that ensure deck is created */
   /* Creates deck and then shuffles, draws cards */
   
   public static void main(String[] args)
   {

     Deck deck = new Deck();
     deck.shuffle();
     
     System.out.println(deck.size());
     
     int a = deck.draw();
     int b = deck.draw();
     
     System.out.println(a);
     System.out.println(b);
     
     System.out.println(deck.size());
     
   }
   
}