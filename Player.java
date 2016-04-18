import java.util.*;

public class Player
{
   int color;
   String name;
   int inSafe;
   
   Peg peg1 = new Peg();
   Peg peg2 = new Peg();
   Peg peg3 = new Peg();
   Peg peg4 = new Peg();

   
   public Player(int setColor, String pName)
   {
      name = pName;
      color = setColor;
      createPegs(setColor);
      inSafe = 0;
   }

   public void createPegs(int pColor)
   {
      peg1.setColor(pcolor);
      peg2.setColor(pcolor);
      peg3.setColor(pcolor);
      peg4.setColor(pcolor);
   }
   
      
   public void setColor(int colorNum)
   {
      color = colorNum;
   }
   
   public void setName(String pName)
   {
      name = pName;
   }
   
   public int getColor()
   {
      return color;
   }
   
   public String getName()
   {
      return name;
   }
   
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

