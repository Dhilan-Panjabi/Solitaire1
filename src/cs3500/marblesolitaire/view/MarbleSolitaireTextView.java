package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * to view the state of the board.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  MarbleSolitaireModelState arg;

  /**
   * Takes in the state.
   *
   * @param arg state
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState arg) {
    this.arg = arg;
  }

  /**
   * loops through the positions on the board and checks the state to append a different position.
   * depending on the slotstate.
   *
   * @return toString of string builder
   */
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < arg.getBoardSize(); i = i + 1) {
      boolean initMarble = false;
      for (int j = 0; j < arg.getBoardSize(); j = j + 1) {

        switch (arg.getSlotAt(i, j)) {
          case Empty:
            if (j < arg.getBoardSize() && j > 0) {
              s.append(" ");
            }
            s.append("_");
            break;
          case Invalid:
            if (!initMarble) {
              if (j < arg.getBoardSize() && j > 0) {
                s.append(" ");
              }
              s.append(" ");
            }
            break;
          case Marble:
            initMarble = true;
            if (j < arg.getBoardSize() && j > 0) {
              s.append(" ");
            }
            s.append("O");
            break;
          default:
            s.append("");
            break;
        }
      }
      if (i < arg.getBoardSize() - 1) {
        s.append("\n");
      }
    }
    return s.toString();
  }
}



