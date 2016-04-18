import java.util.*;

public class Peg
{
   int color;
   int steps;
   int pos;
   
   public Peg()
   {
      color = 0;
      steps = 0;
      pos = 0;
   }
   
   public Peg(int playerColor)
   {
      color = playerColor;
      
      steps = 0;
      
      switch (playerColor) 
      {
         case 1: pos = r;
                 break;
         case 2: pos = b;
                 break;
         case 3: pos = y;
                 break;
         case 4: pos = g;                 
                 break;         

      }
      
   } //end of peg creator method
   
   /* set functions used to set the variables during play */
   
   public void setPos(int boardSpace)
   {
   
      pos = boardSpace;
      
   } //end of setPos
   
   public void setSteps(int boardSteps)
   {
   
      steps = boardSteps;
      
   } //end of setSteps
   
   public void setColor(int newColor)
   {
   
      color = newColor;
      
   } //end of setColor
   
   
   
   
   
   /* set of functions used to get the value in variales for play */
   
   public int getPos()
   {
   
      return pos;
      
   } //end of getPos
   
   public int getSteps()
   {
   
      return steps;
      
   } //end of getSteps
   
   public int getColor()
   {
   
      return color;
      
   }//end of getColor
   
   
   
   
   
   /* Method used to move a peg */
   
   public int move(int numToMove)
   {
   
      /* variables hold the number of steps allowed */
      /* stepsLeft is the number of moves before turns over */
      
      //int numToMove = numToMove;
      int stepsLeft = 0;
      
      /* while statement moves the peg */
      
      while (stepsLeft < numToMove)
      {
      
      /* switch statement controls the specials spaces */
      
         switch(steps)
         {
         
         /*-- 0 holds the start space and moves them out -----*/
         
            case 0:
            
               if (pos == r0)
               {
                  pos += r1;
                  steps += 1;
                  stepsLeft++;
                  
               }
               
         /*------------------------------------------------------*/      
               
               else if (pos == g0)
               {
                  pos += r1;
                  steps += 1;
                  stepsLeft++;
                  
               }
               
          /*---------------------------------------------*/

               else if (pos == b0)
               {
                  pos += r1;
                  steps += 1;
                  stepsLeft++;
                  
               }
               
          /*---------------------------------------------*/
               
               else if (pos == y0)
               {
                  pos += r1;
                  steps += 1;
                  stepsLeft++;
                  
               }
               
               break;
               
          /*--- case 59 moves the peg onto the safe lane ----*/

            case 59:
            
               if (pos == r59)
               {
                  pos = rSafeLane;
                  steps += 1;
                  stepsLeft++;
               }
               
          /*---------------------------------------------*/
               
               else if (pos == b59)
               {
                  pos = bSafeLane;
                  steps += 1;
                  stepsLeft++;
               }
           
           /*---------------------------------------------*/
               
               else if (pos == g59)
               {
                  pos = gSafeLane;
                  steps += 1;
                  stepsLeft++;
               }
               
           /*---------------------------------------------*/
               
               else if (pos == y59)
               {
                  pos = ySafeLane;
                  steps += 1;
                  stepsLeft++;
               }
               break;
               
           /*---- case 64 moves peg from safe lane to safe zone ----*/
               
            case 64:
               
               if (pos == r64)
               {
                  pos = rSafe;
                  steps += 1;
                  stepsLeft++;
               }
               
           /*---------------------------------------------*/
               
               else if (pos == b64)
               {
                  pos = bSafe;
                  steps += 1;
                  stepsLeft++;
               }
               
           /*---------------------------------------------*/
               
               else if (pos == g64)
               {
                  pos = gSafe;
                  steps += 1;
                  stepsLeft++;
               }
               
           /*---------------------------------------------*/
               
               else if (pos == y64)
               {
                  pos = ySafeLane;
                  steps += 1;
                  stepsLeft++;
               }
               
           /*---------------------------------------------*/
               break;
               
        /*---- case 65 finishes the moves -----*/
             
            case 65:
               stepsLeft++;
               break;
   
         } //end of switch statement 
         
         /* moves the peg if not on one of the special spaces */
         
         pos += 1;
         steps += 1;
         stepsLeft++;
         
      } //End of while statement 
      
      /*-- switch statements to determine if landing on slide --*/
      
      switch(steps)
      {
         case sS1:
            pos += 3;
            steps += 3;
            break;
            
            /*---------------------------------------------*/
            
         case sS2:
            pos += 3;
            steps += 3;
            break;
            
            /*---------------------------------------------*/
            
         case sS3:
            pos += 3;
            steps += 3;
            break;
            
            /*---------------------------------------------*/
            
         case sS4:
            pos += 3;
            steps += 3;
            break;
            
            /*---------------------------------------------*/
            
         case lL1:
            pos += 4;
            steps += 4;
            break;
            
            /*---------------------------------------------*/
            
         case lL2:
            pos += 4;
            steps += 4;
            break;
            
            /*---------------------------------------------*/

         case lL3:
            pos += 4;
            steps += 4;
            break;
            
            /*---------------------------------------------*/
            
         case lL4:
            pos += 4;
            steps += 4;
            break;
            
            /*---------------------------------------------*/
      
      } //end of switch for slide
      
   } // end of Move() method
   
   public void backToStart()
   {
      switch(color)
      {
         case 1:
            
         case 2:
         
         case 3:
       
         case 4:
      }
   }

}