/**
 * Represents a custom date with non-negative year, month, and day.
 * Supports validating dates, advancing or receding by days,
 * and formatting as a YYYY-MM-DD string.
 * Leap years follow the rule:
 * - Divisible by 4, and
 * (not divisible by 100, or divisible by 400).
 */
public class MyDate {
  private int day;
  private int month;
  private int year;

  /**
   * Constructs a new MyDate with the given day, month, and year.
   * Throws IllegalArgumentException if the date is invalid.
   *
   * @param day   the day of the month (1–31 depending on month/year)
   * @param month the month of the year (1–12)
   * @param year  the non-negative year (≥0)
   */
  public MyDate(int day, int month, int year) {
    if (!isValidDate(day, month, year)) {
      throw new IllegalArgumentException("Invalid date");
    }
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * Advances (or recedes) the date by the given number of days.
   * If advancing backward past 0000-01-01, clamps at that date.
   *
   * @param days the number of days to adjust (can be negative)
   */
  public void advance(int days) {
    int totalDays = this.toAbsoluteDays() + days;
    if (totalDays < 0) {
      totalDays = 0;
    }
    this.fromAbsoluteDays(totalDays);
  }

  /**
   * Returns the date formatted as a string in YYYY-MM-DD format,
   * padded with leading zeros if needed.
   *
   * @return the formatted date string
   */
  @Override
  public String toString() {
    return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
  }

  private boolean isLeapYear(int y) {
    if (y % 4 != 0) {
      return false;
    }
    if (y % 100 != 0) {
      return true;
    }
    return y % 400 == 0;
  }

  private int daysInMonth(int month, int year) {
    if (month == 2) {
      if (isLeapYear(year)) {
        return 29;
      } else {
        return 28;
      }
    } else if ((month <= 7 && month % 2 == 1) || (month >= 8 && month % 2 == 0)) {
      return 31;
    } else {
      return 30;
    }
  }

  private boolean isValidDate(int day, int month, int year) {
    if (year < 0 || month < 1 || month > 12 || day < 1) {
      return false;
    }
    int dim = daysInMonth(month, year);
    return day <= dim;
  }

  private int toAbsoluteDays() {
    int days = 0;
    int y = 0;
    while (y < this.year) {
      if (isLeapYear(y)) {
        days += 366;
      } else {
        days += 365;
      }
      y++;
    }

    int m = 1;
    while (m < this.month) {
      days += daysInMonth(m, this.year);
      m++;
    }

    days += this.day - 1;
    return days;
  }

  private void fromAbsoluteDays(int absoluteDays) {
    int yearCounter = 0;
    while (true) {
      int daysInYear;
      if (isLeapYear(yearCounter)) {
        daysInYear = 366;
      } else {
        daysInYear = 365;
      }
      if (absoluteDays < daysInYear) {
        break;
      }
      absoluteDays -= daysInYear;
      yearCounter++;
    }
    this.year = yearCounter;

    int monthCounter = 1;
    while (true) {
      int dim = daysInMonth(monthCounter, this.year);
      if (absoluteDays < dim) {
        break;
      }
      absoluteDays -= dim;
      monthCounter++;
    }
    this.month = monthCounter;
    this.day = absoluteDays + 1;
  }
}
