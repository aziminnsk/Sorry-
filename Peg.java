import java.util.*;

public class Peg
{
   int color;
   int index;
   
   public Peg(int i)
   {
      color = i;
	  index = 0;
   }
   
   public int getIndex() {
	   return index;
   }
   
   public int getColor() {
	   return color;
   }
   
   public void setIndex(int i) {
	   index = i;
   }
   
   public void setColor(int i) {
	   color = i;
   }
}