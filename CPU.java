import java.util.*;

public class CPU
{
   int color;
   String name;
   int inSafe;
   
   Peg cpuPeg1 = new Peg();
   Peg cpuPeg2 = new Peg();
   Peg cpuPeg3 = new Peg();
   Peg cpuPeg4 = new Peg();

   
   public CPU()
   {
      name = "CPU";
      color = 4;
      createPegs(4);
      inSafe = 0;
   }

   public void createPegs(int pColor)
   {
      cpuPeg1.setColor(pcolor);
      cpuPeg2.setColor(pcolor);
      cpuPeg3.setColor(pcolor);
      cpuPeg4.setColor(pcolor);
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

