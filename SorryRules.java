/**
Maggie Dinger
Sorry! Rules
April 2016
*/

import java.util.*;

//    
//    /**movePawn moves the peg the number of spaces validateCard has determined
//    */  
//    public movePawn(){
//   
//    }
// }

public class SorryRules{
      //hold the value of the card
   private int cardValue;
      //hold the rule of the card
   private String rule;

public SorryRules(int cardValue){

   //this.cardValue = cardValue;
   if (cardValue == 0 | cardValue == 11 | cardValue == 22 | cardValue == 33){
      this.cardValue = 0;
   }
   if (cardValue == 1 | cardValue == 12 | cardValue == 23 | cardValue == 34){
      this.cardValue = 1;
   }
   if (cardValue == 2 | cardValue == 13 | cardValue == 24 | cardValue == 35){
      this.cardValue = 2;
   }
   if (cardValue == 3 | cardValue == 14 | cardValue == 25 | cardValue == 36){
      this.cardValue = 3;
   }
   if (cardValue == 4 | cardValue == 15 | cardValue == 26 | cardValue == 37){
      this.cardValue = 4;
   }
   if (cardValue == 5 | cardValue == 16 | cardValue == 27 | cardValue == 38){
      this.cardValue = 5;
   }
   if (cardValue == 6 | cardValue == 17 | cardValue == 28 | cardValue == 39){
      this.cardValue = 7;
   }  
   if (cardValue == 7 | cardValue == 18 | cardValue == 29 | cardValue == 40){
      this.cardValue = 11;
   } 
   if (cardValue == 8 | cardValue == 19 | cardValue == 30 | cardValue == 41){
      this.cardValue = 8;
   }
   if (cardValue == 9 | cardValue == 20 | cardValue == 31 | cardValue == 42){
      this.cardValue = 12;
   }
   if (cardValue == 10 | cardValue == 21 | cardValue == 32 | cardValue == 43){
      this.cardValue = 10;
   }
   Rule();

}

public void Rule(){
   
   switch(cardValue){
   
      case 0:
         rule = "SORRY!\nTake one of your pegs from start and switch it onto any space occupied by opponenen.\nNOTE: If there is no peg on your start or your opponenet does not have any pegs on spaces, you forfeit your turn.";
   
      case 1: 
         rule = "EITHER:\nStart a peg\nOr\nMove one peg forward 1 space.";
         break;
      
      case 2: 
         rule = "EITHER:\nStart a peg\nOR\nMove one peg forward 2 spaces.";
         break;
      
      case 3: 
         rule = "Must one peg forward 3 spaces.";
         break;
      
      case 4: 
         rule = "Must one peg backward 4 spaces.";
         break;
      
      case 5: 
         rule = "Move one peg forward 5 spaces.";
         break;
      
      case 7: 
         rule = "EITHER:\n move one peg forward 7 spaces\nOR\nsplit 7 spaces between any two pegs.";
         break;
      
      case 8:
         rule = "Move one peg forward 8 spaces.";
         break;
      
      case 10: 
         rule = "EITHER:\nMove one peg forward 10 spaces\nOR\nMove one peg back 1 space.";
         break;
      
      case 11: 
         rule = "EITHER:\nMove one peg foward 11 spaces\nOR\nchange spaces of any one of your pegs with any one of your opponents pegs.\n YOU MAY FORFEIT YOUR MOVE: if you do not wish to take your turn\nOR\nif you are unable to move 11 spaces forward.";
         break;
      
      case 12: 
         rule = "Move one peg 12 spaces";
         break;
      
      default: 
         rule = "There is no rule. Invalid";
         break;
     }
   
   }
   
   public int getCardValue(){
      return cardValue;
   }
   
   public String getCardRule(){
      return rule;
   }
}