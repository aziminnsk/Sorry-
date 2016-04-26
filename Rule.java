import java.util.*;

public class Rule
{
   public static void main(String args[]){
      new Rule();
   }
   
   public Rule () {
      
   }
   
   public ArrayList<Pair> move (int color, int card) {
      Board sorryBoard = new Board();
      ArrayList<Space> board = sorryBoard.getBoard();
      ArrayList<Pair> indexes = new ArrayList<Pair>();
      if (card == 1) {
         for (int i = 0; i < 80; i++) {
            if (board.get(i).getIsOccupied() == true) {
               if (board.get(i).getPeg().getColor() == color) {
                  int colorIndex = -2;
                  if (color == 0) {
                     colorIndex = board.get(i).getRedIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getRedIndex() == (colorIndex + 1)) {
                           if (board.get(j).getIsOccupied() == false) {
                              indexes.add(new Pair(i, j));
                           } 
                           else {
                              if (board.get(j).getPeg().getColor() != color) {
                                 indexes.add(new Pair(i, j));
                              }
                           }
                        }
                     }
                  } 
                  else if (color == 1) {
                     colorIndex = board.get(i).getBlueIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getBlueIndex() == (colorIndex + 1)) {
                           if (board.get(j).getIsOccupied() == false) {
                              indexes.add(new Pair(i, j));
                           } 
                           else {
                              if (board.get(j).getPeg().getColor() != color) {
                                 indexes.add(new Pair(i, j));
                              }
                           }
                        }
                     }
                  } 
                  else if (color == 2) {
                     colorIndex = board.get(i).getGreenIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getGreenIndex() == (colorIndex + 1)) {
                           if (board.get(j).getIsOccupied() == false) {
                              indexes.add(new Pair(i, j));
                           } 
                           else {
                              if (board.get(j).getPeg().getColor() != color) {
                                 indexes.add(new Pair(i, j));
                              }
                           }
                        }
                     }
                  } 
                  else {
                     colorIndex = board.get(i).getYellowIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getYellowIndex() == (colorIndex + 1)) {
                           if (board.get(j).getIsOccupied() == false) {
                              indexes.add(new Pair(i, j));
                           } 
                           else {
                              if (board.get(j).getPeg().getColor() != color) {
                                 indexes.add(new Pair(i, j));
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
      return indexes;
   }
}