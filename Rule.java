import java.util.*;

public class Rule
{
//test
//    public static void main(String args[]){
//       int cardsDrawn;
//       cardsDrawn = 0;
//       new Rule(3, (cardsDrawn));
//       cardsDrawn ++;
//       new Rule(2, (cardsDrawn));
//       cardsDrawn ++;
//       new Rule(7, (cardsDrawn));
//       cardsDrawn ++;
//       
//       
//    }
   
   public Rule (int c, int cardsDrawn) {
      int card;
      int cardCounter;
      card = c;
      cardCounter = cardsDrawn;
      
         //if cards have been chosen already
      if (cardCounter != 0 || card == 1 || card == 2){
         cardCounter ++ ;
         cardCounter = cardCounter;
         System.out.println(card);
         System.out.println(cardCounter);
         move(2,(card));
      }
         //if the card is not a one and you are on start
      if (cardCounter == 0 && card != 1){
      
         if (card == 2){
            cardCounter ++;
            cardCounter = cardCounter;
         }
            //if the card is not a 2 either
         if (card != 2){
            cardCounter ++ ;
            cardCounter = cardCounter;
            System.out.println("Sorry, you did not choose a 1 or 2, which is needed to start.");
            System.out.println(cardCounter);
         }
      }
      
   }
   
   public ArrayList<Pair> move (int color, int card) {
      Board sorryBoard = new Board();
      ArrayList<Space> board = sorryBoard.getBoard();
      ArrayList<Pair> indexes = new ArrayList<Pair>();
      // first card drawn 1 or 2 to get off start space 
      
         //start a peg
         //move a peg forward one spot
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

      
         //start a peg
         //OR move a peg forward 2 spaces  
      if (card == 2) {
         for (int i = 0; i < 80; i++) {
            if (board.get(i).getIsOccupied() == true) {
               if (board.get(i).getPeg().getColor() == color) {
                  int colorIndex = -2;
                  if (color == 0) {
                     colorIndex = board.get(i).getRedIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getRedIndex() == (colorIndex + 2)) {
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
                        if (board.get(j).getBlueIndex() == (colorIndex + 2)) {
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
                        if (board.get(j).getGreenIndex() == (colorIndex + 2)) {
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
                        if (board.get(j).getYellowIndex() == (colorIndex + 2)) {
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

         //move pag forward 3 spaces
      if (card == 3) {
         for (int i = 0; i < 80; i++) {
            if (board.get(i).getIsOccupied() == true) {
               if (board.get(i).getPeg().getColor() == color) {
                  int colorIndex = -2;
                  if (color == 0) {
                     colorIndex = board.get(i).getRedIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getRedIndex() == (colorIndex + 3)) {
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
                        if (board.get(j).getBlueIndex() == (colorIndex + 3)) {
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
                        if (board.get(j).getGreenIndex() == (colorIndex + 3)) {
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
                        if (board.get(j).getYellowIndex() == (colorIndex + 3)) {
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
      
         //Move peg backward 4 spaces
      if (card == 4) {
         for (int i = 0; i < 80; i++) {
            if (board.get(i).getIsOccupied() == true) {
               if (board.get(i).getPeg().getColor() == color) {
                  int colorIndex = -2;
                  if (color == 0) {
                     colorIndex = board.get(i).getRedIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getRedIndex() == (colorIndex - 4)) {
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
                        if (board.get(j).getBlueIndex() == (colorIndex - 4)) {
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
                        if (board.get(j).getGreenIndex() == (colorIndex - 4)) {
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
                        if (board.get(j).getYellowIndex() == (colorIndex - 4)) {
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

      
         //Move peg forward 5 spaces
      if (card == 5) {
         for (int i = 0; i < 80; i++) {
            if (board.get(i).getIsOccupied() == true) {
               if (board.get(i).getPeg().getColor() == color) {
                  int colorIndex = -2;
                  if (color == 0) {
                     colorIndex = board.get(i).getRedIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getRedIndex() == (colorIndex + 5)) {
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
                        if (board.get(j).getBlueIndex() == (colorIndex + 5)) {
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
                        if (board.get(j).getGreenIndex() == (colorIndex + 5)) {
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
                        if (board.get(j).getYellowIndex() == (colorIndex + 5)) {
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

      
         //move peg forward 7 spaces 
         //OR split 7 spaces between 2 pegs
      if (card == 7) {
         for (int i = 0; i < 80; i++) {
            if (board.get(i).getIsOccupied() == true) {
               if (board.get(i).getPeg().getColor() == color) {
                  int colorIndex = -2;
                  if (color == 0) {
                     colorIndex = board.get(i).getRedIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getRedIndex() == (colorIndex + 7)) {
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
                        if (board.get(j).getBlueIndex() == (colorIndex + 7)) {
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
                        if (board.get(j).getGreenIndex() == (colorIndex + 7)) {
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
                        if (board.get(j).getYellowIndex() == (colorIndex + 7)) {
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

      
         //move peg forward 8 spaces
      if (card == 8) {
         for (int i = 0; i < 80; i++) {
            if (board.get(i).getIsOccupied() == true) {
               if (board.get(i).getPeg().getColor() == color) {
                  int colorIndex = -2;
                  if (color == 0) {
                     colorIndex = board.get(i).getRedIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getRedIndex() == (colorIndex + 8)) {
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
                        if (board.get(j).getBlueIndex() == (colorIndex + 8)) {
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
                        if (board.get(j).getGreenIndex() == (colorIndex + 8)) {
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
                        if (board.get(j).getYellowIndex() == (colorIndex + 8)) {
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

      
         //move peg forward 10 spaces 
         //OR move peg backward 1 space
      if (card == 10) {
         for (int i = 0; i < 80; i++) {
            if (board.get(i).getIsOccupied() == true) {
               if (board.get(i).getPeg().getColor() == color) {
                  int colorIndex = -2;
                  if (color == 0) {
                     colorIndex = board.get(i).getRedIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getRedIndex() == (colorIndex + 10)) {
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
                        if (board.get(j).getBlueIndex() == (colorIndex + 10)) {
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
                        if (board.get(j).getGreenIndex() == (colorIndex + 10)) {
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
                        if (board.get(j).getYellowIndex() == (colorIndex + 10)) {
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

         //move peg forward 11 spaces
         //OR change one peg spaces with one of opponents peg
      if (card == 11) {
         for (int i = 0; i < 80; i++) {
            if (board.get(i).getIsOccupied() == true) {
               if (board.get(i).getPeg().getColor() == color) {
                  int colorIndex = -2;
                  if (color == 0) {
                     colorIndex = board.get(i).getRedIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getRedIndex() == (colorIndex + 11)) {
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
                        if (board.get(j).getBlueIndex() == (colorIndex + 11)) {
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
                        if (board.get(j).getGreenIndex() == (colorIndex + 11)) {
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
                        if (board.get(j).getYellowIndex() == (colorIndex + 11)) {
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
      
         //if the card is a 12, move forward 12 spaces
      if (card == 12) {
         for (int i = 0; i < 80; i++) {
            if (board.get(i).getIsOccupied() == true) {
               if (board.get(i).getPeg().getColor() == color) {
                  int colorIndex = -2;
                  if (color == 0) {
                     colorIndex = board.get(i).getRedIndex();
                     for (int j = 0; j < 80; j++) {
                        if (board.get(j).getRedIndex() == (colorIndex + 12)) {
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
                        if (board.get(j).getBlueIndex() == (colorIndex + 12)) {
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
                        if (board.get(j).getGreenIndex() == (colorIndex + 12)) {
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
                        if (board.get(j).getYellowIndex() == (colorIndex + 12)) {
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
      
         //Sorry card
//       else if (card >= 13 || card <= 0){
//          for (int i = 0; i < 80; i++) {
//             if (board.get(i).getIsOccupied() == true) {
//                if (board.get(i).getPeg().getColor() == color) {
//                   int colorIndex = -2;
//                   if (color == 0) {
//                      colorIndex = board.get(i).getRedIndex();
//                      for (int j = 0; j < 80; j++) {
//                         if (board.get(j).getRedIndex() == (colorIndex + 1)) {
//                            if (board.get(j).getIsOccupied() == false) {
//                               indexes.add(new Pair(i, j));
//                            } 
//                            else {
//                               if (board.get(j).getPeg().getColor() != color) {
//                                  indexes.add(new Pair(i, j));
//                               }
//                            }
//                         }
//                      }
//                   } 
//                   else if (color == 1) {
//                      colorIndex = board.get(i).getBlueIndex();
//                      for (int j = 0; j < 80; j++) {
//                         if (board.get(j).getBlueIndex() == (colorIndex + 1)) {
//                            if (board.get(j).getIsOccupied() == false) {
//                               indexes.add(new Pair(i, j));
//                            } 
//                            else {
//                               if (board.get(j).getPeg().getColor() != color) {
//                                  indexes.add(new Pair(i, j));
//                               }
//                            }
//                         }
//                      }
//                   } 
//                   else if (color == 2) {
//                      colorIndex = board.get(i).getGreenIndex();
//                      for (int j = 0; j < 80; j++) {
//                         if (board.get(j).getGreenIndex() == (colorIndex + 1)) {
//                            if (board.get(j).getIsOccupied() == false) {
//                               indexes.add(new Pair(i, j));
//                            } 
//                            else {
//                               if (board.get(j).getPeg().getColor() != color) {
//                                  indexes.add(new Pair(i, j));
//                               }
//                            }
//                         }
//                      }
//                   } 
//                   else {
//                      colorIndex = board.get(i).getYellowIndex();
//                      for (int j = 0; j < 80; j++) {
//                         if (board.get(j).getYellowIndex() == (colorIndex + 1)) {
//                            if (board.get(j).getIsOccupied() == false) {
//                               indexes.add(new Pair(i, j));
//                            } 
//                            else {
//                               if (board.get(j).getPeg().getColor() != color) {
//                                  indexes.add(new Pair(i, j));
//                               }
//                            }
//                         }
//                      }
//                   }
//                }
//             }
//          }
//       }
      return indexes;

                                                                  
   }
}