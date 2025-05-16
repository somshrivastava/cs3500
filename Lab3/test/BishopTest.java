/**
 * Tests for the Bishop chess piece implementation.
 */
public class BishopTest extends AbstractChessPieceTest {

  /**
   * Creates a new Bishop piece with the given position and color.
   *
   * @param row the row position
   * @param col the column position
   * @param color the piece color
   * @return a new Bishop instance
   */
  @Override
  protected ChessPiece createPiece(int row, int col, Color color) {
    return new Bishop(row, col, color);
  }

  /**
   * Calculates and marks valid diagonal moves for a bishop at the given position.
   *
   * @param row the current row position of the bishop
   * @param col the current column position of the bishop
   */
  @Override
  protected void setupResults(int row, int col) {
    for (int i = 0; i < 8; i++) {
      if ((row + i) < 8 && (col + i) < 8) {
        results[row + i][col + i] = true;
      }
      if ((row + i) < 8 && col >= i) {
        results[row + i][col - i] = true;
      }
      if (row >= i && (col + i) < 8) {
        results[row - i][col + i] = true;
      }
      if (row >= i && col >= i) {
        results[row - i][col - i] = true;
      }
    }
  }
}