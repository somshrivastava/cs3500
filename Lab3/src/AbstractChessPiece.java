/**
 * Represents an abstract chess piece.
 */
public abstract class AbstractChessPiece implements ChessPiece {
  int row;
  int col;
  Color color;

  /**
   * Constructs a {@code AbstractChessPiece}.
   *
   * @param row   the row on the chess board
   * @param col   the column on the chess board
   * @param color the color on the chess board
   */
  public AbstractChessPiece(int row, int col, Color color) {
    this.row = row;
    this.col = col;
    this.color = color;
  }

  /**
   * Gets the row of the chess piece on the chess board.
   *
   * @return the row
   */
  @Override
  public int getRow() {
    return this.row;
  }

  /**
   * Gets the column of the chess piece on the chess board.
   *
   * @return the column
   */
  @Override
  public int getColumn() {
    return this.col;
  }

  /**
   * Gets the color of the chess piece.
   *
   * @return the color
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * Determines whether the piece can kill the given piece.
   *
   * @param piece the piece that may or may not be killed by this piece
   * @return true if the piece can be killed
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    return (this.getColor() != piece.getColor()) && canMove(
            piece.getRow(),
            piece.getColumn());
  }
}
