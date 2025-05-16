public abstract class AbstractDuration implements Duration {

  @Override
  public String asHms() {
    return String.format("%02d:%02d:%02d", this.hoursOf(this.inSeconds()), this.minutesOf(this.inSeconds()), this.secondsOf(this.inSeconds()));
  }

  @Override
  public int compareTo(Duration other) {
    long difference = this.inSeconds() - other.inSeconds();
    if (difference < 0) {
      return -1;
    } else if (difference > 0) {
      return 1;
    }
    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Duration)) {
      return false;
    }
    Duration other = (Duration) o;
    return this.inSeconds() == other.inSeconds();
  }

  @Override
  public int hashCode() {
    return Long.hashCode(this.inSeconds());
  }

  protected int hoursOf(long seconds) {
    return (int) (seconds / 3600);
  }

  protected int secondsOf(long seconds) {
    return (int) (seconds % 60);
  }

  protected int minutesOf(long seconds) {
    return (int) (seconds % 3600 / 60);
  }

  @Override
  public Duration add(Duration other) {
    return fromDuration(this.inSeconds() + other.inSeconds());
  }

  protected abstract Duration fromDuration(long seconds);
}
