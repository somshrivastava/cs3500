/**
 * Represents a rook chess piece that moves horizontally and vertically.
 */
public class Rook extends AbstractChessPiece {

  /**
   * Constructs a {@code Rook} object.
   *
   * @param row   the row on the chess board
   * @param col   the column on the chess board
   * @param color the color of the rook
   * @throws IllegalArgumentException if the position is invalid
   */
  public Rook(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
    if ((row < 0) || (col < 0)) {
      throw new IllegalArgumentException("Illegal position");
    }
  }

  /**
   * Determines whether the rook can move to the given position.
   *
   * @param row the target row on the chess board
   * @param col the target column on the chess board
   * @return true if the rook can move to the specified position, false otherwise
   */
  @Override
  public boolean canMove(int row, int col) {
    if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
      return false;
    }
    return ((this.row == row) || (this.col == col));
  }
}
