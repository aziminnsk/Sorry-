import java.util.*;

public class Space
{
   int index; //the space that green pegs start on is 0, goes around to 59, then 60-64 is green safe zone, 65-69 is red, 70-74 is blue, 75-79 is yellow
   int greenIndex; //the color indexes are 0 where the pegs for that color enter the board, and follow the path that that color peg would take. (Let me know if you need me to explain this more, i know its confusing)
   int redIndex;
   int blueIndex;
   int yellowIndex;
   boolean isOccupied; //returns if there is a peg on the space
   boolean isSlideStartSpace; //is true if the space is the start of a slide
   int slideStartColor; //is -1 if isSlideStartSpace is false
   int slideEndIndex; //the index of the end of the slide. is also -1 if isSlideStartSpace is false
   Peg peg; //this will be null if there is no peg on the space
   
   public Space(int x)
   {
      index = x;
      peg = null;
      isOccupied = false;
      isSlideStartSpace = false;
      slideStartColor = -1;
      slideEndIndex = -1;
      //index 0 is the space that green pegs start on, then it wraps around the board to 59, then 60-64 is green safe space, 65-69 is red safe space, 70-74 is blue safe space, 75-79 is yollow safe space
      if (index > 74) {
         yellowIndex = index - 16;
         redIndex = -1;
         blueIndex = -1;
         greenIndex = -1;
      } else if (index > 69) {
         yellowIndex = -1;
         redIndex = -1;
         blueIndex = index - 11;
         greenIndex = -1;
      } else if (index > 64) {
         yellowIndex = -1;
         redIndex = index - 6;
         blueIndex = -1;
         greenIndex = -1;
      } else if (index > 59) {
         yellowIndex = -1;
         redIndex = -1;
         blueIndex = -1;
         greenIndex = index - 1;
      } else if (index == 59) {
         greenIndex = -1;
         redIndex = 44;
         blueIndex = 29;
         yellowIndex = 14;
      } else if (index == 44) {
         yellowIndex = -1;
         greenIndex = 44;
         redIndex = 29;
         blueIndex = 14;
      } else if (index == 29) {
         blueIndex = -1;
         yellowIndex = 44;
         greenIndex = 29;
         redIndex = 14;
      } else if (index == 14) {
         redIndex = -1;
         blueIndex = 44;
         yellowIndex = 29;
         greenIndex = 14;
      } else {
         greenIndex = index;
         if (index < 15) {
            redIndex = greenIndex + 45;
         } else {
            redIndex = greenIndex - 15;
         }
         if (index < 45) {
            yellowIndex = greenIndex + 15;
         } else {
            yellowIndex = greenIndex - 45;
         }
         if (index < 30) {
            blueIndex = greenIndex + 30;
         } else {
            blueIndex = greenIndex - 30;
         }
      }
      
      if (index == 57) {
         isSlideStartSpace = true;
         slideStartColor = 2;
         slideEndIndex = 0;
      }
      if (index == 5) {
         isSlideStartSpace = true;
         slideStartColor = 2;
         slideEndIndex = 9;
      }
      if (index == 12) {
         isSlideStartSpace = true;
         slideStartColor = 0;
         slideEndIndex = 15;
      }
      if (index == 20) {
         isSlideStartSpace = true;
         slideStartColor = 0;
         slideEndIndex = 24;
      }
      if (index == 27) {
         isSlideStartSpace = true;
         slideStartColor = 1;
         slideEndIndex = 30;
      }
      if (index == 35) {
         isSlideStartSpace = true;
         slideStartColor = 1;
         slideEndIndex = 39;
      }
      if (index == 42) {
         isSlideStartSpace = true;
         slideStartColor = 3;
         slideEndIndex = 45;
      }
      if (index == 50) {
         isSlideStartSpace = true;
         slideStartColor = 3;
         slideEndIndex = 54;
      }
   }
   
   public int getIndex () {
	   return index;
   }
   
   public int getGreenIndex () {
	   return greenIndex;
   }
   
   public int getRedIndex () {
	   return redIndex;
   }
   
   public int getBlueIndex () {
	   return blueIndex;
   }
   
   public int getYellowIndex () {
	   return yellowIndex;
   }
   
   public boolean getIsOccupied () {
	   return isOccupied;
   }
   
   public boolean getIsSlideStartSpace () {
	   return isSlideStartSpace;
   }
   
   public int getSlideStartColor () {
	   return slideStartColor;
   }
   
   public int getSlideEndIndex () {
	   return slideEndIndex;
   }
   
   public Peg getPeg () {
	   return peg;
   }
   
   public void setPeg (Peg p) {
	   peg = p;
	   if (peg == null) {
		   isOccupied = false;
	   } else {
		   isOccupied = true;
	   }
   }

}