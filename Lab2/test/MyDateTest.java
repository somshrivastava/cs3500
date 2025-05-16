import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Represents the examples and tests for the MyDate class.
 */
public class MyDateTest {

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidDayLow() {
    new MyDate(0, 1, 2020);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidMonthLow() {
    new MyDate(1, 0, 2020);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidMonthHigh() {
    new MyDate(1, 13, 2020);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidDayHighForMonth() {
    new MyDate(31, 4, 2020);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidDayFebruaryNonLeap() {
    new MyDate(29, 2, 2019);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidNegativeYear() {
    new MyDate(1, 1, -1);
  }

  @Test
  public void testAdvanceVariousCases() {
    MyDate date1 = new MyDate(10, 1, 2020);
    date1.advance(5);
    assertEquals("2020-01-15", date1.toString());

    MyDate date2 = new MyDate(30, 1, 2020);
    date2.advance(5);
    assertEquals("2020-02-04", date2.toString());

    MyDate date3 = new MyDate(31, 12, 2020);
    date3.advance(1);
    assertEquals("2021-01-01", date3.toString());

    MyDate date4 = new MyDate(15, 1, 2020);
    date4.advance(-5);
    assertEquals("2020-01-10", date4.toString());

    MyDate date5 = new MyDate(1, 3, 2020);
    date5.advance(-1);
    assertEquals("2020-02-29", date5.toString());

    MyDate date6 = new MyDate(1, 1, 2020);
    date6.advance(-1);
    assertEquals("2019-12-31", date6.toString());

    MyDate date7 = new MyDate(1, 1, 0);
    date7.advance(-10);
    assertEquals("0000-01-01", date7.toString());
  }

  @Test
  public void testToStringFormatting() {
    MyDate paddedDate = new MyDate(5, 3, 2020);
    assertEquals("2020-03-05", paddedDate.toString());

    MyDate noPaddingDate = new MyDate(15, 11, 2020);
    assertEquals("2020-11-15", noPaddingDate.toString());
  }
}
