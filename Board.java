import java.util.*;

public class Board
{
   ArrayList<Space> board = new ArrayList<Space>();
   
   public Board()
   {
      for (int i = 0; i < 80; i++) {
         board.add(new Space(i));
      }
   }
   
   public void move (int startIndex, int endIndex) {
      if (board.get(endIndex).getIsSlideStartSpace() == true && board.get(endIndex).getSlideStartColor() != board.get(startIndex).getPeg().getColor()) {
         for (int k = endIndex; k <= board.get(endIndex).getSlideEndIndex(); k++) {
            board.get(k).setPeg(null);
         }
         endIndex = board.get(endIndex).getSlideEndIndex();
      }
      board.get(endIndex).setPeg(board.get(startIndex).getPeg());
      board.get(startIndex).setPeg(null);
   }
   
   public ArrayList<Space> getBoard () {
      return board;
   }

}