/**
 * Represents a knight chess piece that moves in an L-shape pattern.
 */
public class Knight extends AbstractChessPiece {

  /**
   * Constructs a {@code Knight} object.
   *
   * @param row   the row on the chess board
   * @param col   the column on the chess board
   * @param color the color of the knight
   * @throws IllegalArgumentException if the position is invalid
   */
  public Knight(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
    if ((row < 0) || (col < 0)) {
      throw new IllegalArgumentException("Illegal position");
    }
  }

  /**
   * Determines whether the knight can move to the given position.
   *
   * @param row the target row on the chess board
   * @param col the target column on the chess board
   * @return true if the knight can move to the specified position, false otherwise
   */
  @Override
  public boolean canMove(int row, int col) {
    if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
      return false;
    }

    int rowDiff = Math.abs(this.row - row);
    int colDiff = Math.abs(this.col - col);

    return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
  }
} 