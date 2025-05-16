public class CompactDuration extends AbstractDuration {
  private final long seconds;

  CompactDuration(long seconds) {
    if (seconds < 0) {
      throw new IllegalArgumentException("Seconds cannot be negative");
    }
    this.seconds = seconds;
  }

  @Override
  public long inSeconds() {
    return this.seconds;
  }

  protected Duration fromDuration(long seconds) {
    return new CompactDuration(seconds);
  }
}
