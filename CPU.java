import java.util.*;

/* This class is used to control the CPU */

public class CPU
{
   int color;
   String name;
   int inSafe;

/* Create peg objects to be used by CPU */
   
   Peg cpuPeg1 = new Peg();
   Peg cpuPeg2 = new Peg();
   Peg cpuPeg3 = new Peg();
   Peg cpuPeg4 = new Peg();

/* Create CPU and set color and name and give pegs a color*/
   
   public CPU()
   {
      name = "CPU";
      color = 4;
      createPegs(4);
      inSafe = 0;
   }

/* create pegs function used to give pegs color */

   public void createPegs(int pColor)
   {
      cpuPeg1.setColor(pcolor);
      cpuPeg2.setColor(pcolor);
      cpuPeg3.setColor(pcolor);
      cpuPeg4.setColor(pcolor);
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
            cpuPeg1.move(toMove);
         case 2:
            cpuPeg2.move(toMove);
         case 3:
            cpuPeg3.move(toMove);
         case 4:
            cpuPeg4.move(toMove);
            
      }
   } // end of move method
   
   
   
   
}

