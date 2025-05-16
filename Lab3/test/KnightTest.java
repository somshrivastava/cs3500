/**
 * Tests for the Knight chess piece implementation.
 */
public class KnightTest extends AbstractChessPieceTest {
  /**
   * Creates a new Knight piece with the given position and color.
   *
   * @param row the row position
   * @param col the column position
   * @param color the piece color
   * @return a new Knight instance
   */
  @Override
  protected ChessPiece createPiece(int row, int col, Color color) {
    return new Knight(row, col, color);
  }

  /**
   * Calculates and marks valid L-shaped moves for a knight at the given position.
   *
   * @param row the current row position of the knight
   * @param col the current column position of the knight
   */
  @Override
  protected void setupResults(int row, int col) {
    int[][] moves = {
        {-2, -1}, {-2, 1},
        {-1, -2}, {-1, 2},
        {1, -2}, {1, 2},
        {2, -1}, {2, 1}
    };

    // Check each possible move
    for (int[] move : moves) {
      int newRow = row + move[0];
      int newCol = col + move[1];
      
      // Only mark the move as valid if it's within the board boundaries
      if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
        results[newRow][newCol] = true;
      }
    }
  }
} 