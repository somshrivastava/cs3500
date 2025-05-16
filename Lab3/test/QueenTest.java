/**
 * Tests for the Queen chess piece implementation.
 */
public class QueenTest extends AbstractChessPieceTest {

  /**
   * Creates a new Queen piece with the given position and color.
   *
   * @param row the row position
   * @param col the column position
   * @param color the piece color
   * @return a new Queen instance
   */
  @Override
  protected ChessPiece createPiece(int row, int col, Color color) {
    return new Queen(row, col, color);
  }

  /**
   * Calculates and marks valid moves for a queen at the given position.
   *
   * @param row the current row position of the queen
   * @param col the current column position of the queen
   */
  @Override
  protected void setupResults(int row, int col) {
    // Mark all positions in the same row and column (like a rook)
    for (int i = 0; i < 8; i++) {
      results[i][col] = true;  // Same column
      results[row][i] = true;  // Same row
    }

    // Mark all diagonal positions (like a bishop)
    for (int i = 0; i < 8; i++) {
      // Down-right diagonal
      if ((row + i) < 8 && (col + i) < 8) {
        results[row + i][col + i] = true;
      }
      // Down-left diagonal
      if ((row + i) < 8 && col >= i) {
        results[row + i][col - i] = true;
      }
      // Up-right diagonal
      if (row >= i && (col + i) < 8) {
        results[row - i][col + i] = true;
      }
      // Up-left diagonal
      if (row >= i && col >= i) {
        results[row - i][col - i] = true;
      }
    }
  }
}