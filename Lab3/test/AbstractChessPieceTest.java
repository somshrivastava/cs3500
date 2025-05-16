import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Abstract test class for chess pieces.
 */
public abstract class AbstractChessPieceTest {
  protected boolean[][] results;

  protected abstract ChessPiece createPiece(int row, int col, Color color);

  protected abstract void setupResults(int row, int col);

  /**
   * Sets up the test environment before each test method.
   */
  @Before
  public void setup() {
    results = new boolean[8][8];
  }

  /**
   * Verifies that the piece's movement matches the expected valid moves.
   *
   * @param piece the chess piece to test
   */
  protected void verifyMoveResults(ChessPiece piece) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if ((i == piece.getRow()) && (j == piece.getColumn())) {
          continue;
        }
        assertEquals(results[i][j], piece.canMove(i, j));
      }
    }
  }

  /**
   * Verifies that the piece's kill works correctly.
   *
   * @param piece the chess piece to test
   */
  protected void verifyKillResults(ChessPiece piece) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if ((i == piece.getRow()) && (j == piece.getColumn())) {
          continue;
        }
        ChessPiece another = createPiece(i, j,
                Color.values()[(piece.getColor().ordinal() + 1) % Color.values().length]);
        assertEquals(
                results[i][j], piece.canKill(another));
      }
    }
  }

  /**
   * Tests the getter methods of the chess piece class.
   */
  @Test()
  public void testGetters() {
    ChessPiece piece;
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        for (Color c : Color.values()) {
          piece = createPiece(row, col, c);
          assertEquals( row,
                  piece.getRow());
          assertEquals(
                  col, piece.getColumn());
          assertEquals(
                  c, piece.getColor());
        }
      }
    }
  }

  /**
   * Tests the constructor's validation of invalid positions.
   */
  @Test()
  public void testInvalidConstructions() {
    ChessPiece piece;
    for (Color c : Color.values()) {
      for (int i = 0; i < 8; i++) {
        try {
          piece = createPiece(i, -1, c);
          fail("Did not throw an exception when piece is created with invalid column");
        } catch (IllegalArgumentException e) {
          //passes
        }

        try {
          piece = createPiece(-1, i, c);
          fail("Did not throw an exception when piece is created with invalid row");
        } catch (IllegalArgumentException e) {
          //passes
        }
      }
    }
  }

  /**
   * Tests the piece's movement rules.
   */
  @Test()
  public void testPieceMoves() {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        initializeResults();
        ChessPiece piece = createPiece(row, col, Color.BLACK);
        setupResults(row, col);
        verifyMoveResults(piece);
      }
    }
  }

  /**
   * Tests the piece's capture mechanics.
   */
  @Test()
  public void testPieceKills() {
    for (Color c : Color.values()) {
      for (int row = 0; row < 8; row++) {
        for (int col = 0; col < 8; col++) {
          initializeResults();
          ChessPiece piece = createPiece(row, col, c);
          setupResults(row, col);
          verifyKillResults(piece);
        }
      }
    }
  }

  /**
   * Initializes the results array to track valid moves.
   */
  private void initializeResults() {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        results[row][col] = false;
      }
    }
  }
} 