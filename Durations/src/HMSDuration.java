public class HMSDuration extends AbstractDuration {
  private final int hours, minutes, seconds;

  HMSDuration(int hours, int minutes, int seconds) {
    if (hours < 0) {
      throw new IllegalArgumentException("Hours cannot be negative");
    }
    if (minutes < 0) {
      throw new IllegalArgumentException("Minutes cannot be negative");
    }
    if (seconds < 0) {
      throw new IllegalArgumentException("Seconds cannot be negative");
    }

    minutes += seconds / 60;
    seconds = seconds % 60;

    hours += minutes / 60;
    minutes = minutes % 60;

    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }

  private HMSDuration(long inSeconds) {
    if (inSeconds < 0) {
      throw new IllegalArgumentException("Seconds cannot be negative");
    }

    this.hours = this.hoursOf(inSeconds);
    this.seconds = this.secondsOf(inSeconds);
    this.minutes = this.minutesOf(inSeconds);
  }

  @Override
  public long inSeconds() {
    return 3600 * (long) this.hours + 60 * this.minutes + this.seconds;
  }

  protected Duration fromDuration(long seconds) {
    return new HMSDuration(seconds);
  }
}
