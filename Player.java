/* Alex Ziminski */
import java.util.*;

/* This class is used to control the player */

public class Player
{
   int color;
   String name;
   int inSafe;
   
/* Create peg objects to be used by player */
   
   Peg peg1 = new Peg();
   Peg peg2 = new Peg();
   Peg peg3 = new Peg();
   Peg peg4 = new Peg();

/* Create player and set color and name and give pegs a color*/
   
   public Player(int setColor, String pName)
   {
      name = pName;
      color = setColor;
      createPegs(setColor);
      inSafe = 0;
   }

/* create pegs function used to give pegs color */

   public void createPegs(int pColor)
   {
      peg1.setColor(pcolor);
      peg2.setColor(pcolor);
      peg3.setColor(pcolor);
      peg4.setColor(pcolor);
   }
   
/* Set color function for necessity */
      
   public void setColor(int colorNum)
   {
      color = colorNum;
   }
   
/* Set name function for necessity */
   
   public void setName(String pName)
   {
      name = pName;
   }

/* get color function for necessity */
   
   public int getColor()
   {
      return color;
   }

/* get color function for necessity */
   
   public String getName()
   {
      return name;
   }

/* Method used to move a peg. Peg is chosen then moved. */
   
   public void move(int peg, int toMove)
   {
      switch(peg)
      {
         case 1:
            peg1.move(toMove);
            break;
         case 2:
            peg2.move(toMove);
            break;
         case 3:
            peg3.move(toMove);
            break;
         case 4:
            peg4.move(toMove);
            break;
            
      }
   } // end of move method
   
   
   
   
}

