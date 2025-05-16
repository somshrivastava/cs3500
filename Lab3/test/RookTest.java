/**
 * Tests for the Rook chess piece implementation.
 */
public class RookTest extends AbstractChessPieceTest {

  /**
   * Creates a new Rook piece with the given position and color.
   *
   * @param row the row position
   * @param col the column position
   * @param color the piece color
   * @return a new Rook instance
   */
  @Override
  protected ChessPiece createPiece(int row, int col, Color color) {
    return new Rook(row, col, color);
  }

  /**
   * Calculates and marks valid horizontal and vertical moves for a rook at the given position.
   *
   * @param row the current row position of the rook
   * @param col the current column position of the rook
   */
  @Override
  protected void setupResults(int row, int col) {
    for (int i = 0; i < 8; i++) {
      results[i][col] = true;
      results[row][i] = true;
    }
  }
}