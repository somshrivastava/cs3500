/**
 * Represents a bishop chess piece that moves diagonally.
 */
public class Bishop extends AbstractChessPiece {

  /**
   * Constructs a {@code Bishop} object.
   *
   * @param row   the row on the chess board
   * @param col   the column on the chess board
   * @param color the color of the bishop
   * @throws IllegalArgumentException if the position is invalid
   */
  public Bishop(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
    if ((row < 0) || (col < 0)) {
      throw new IllegalArgumentException("Illegal position");
    }
  }

  /**
   * Determines whether the bishop can move to the given position.
   *
   * @param row the target row on the chess board
   * @param col the target column on the chess board
   * @return true if the bishop can move to the specified position, false otherwise
   */
  @Override
  public boolean canMove(int row, int col) {
    if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
      return false;
    }
    return (Math.abs(this.row - row) == Math.abs(this.col - col));
  }
}
