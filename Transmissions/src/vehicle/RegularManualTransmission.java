package vehicle;

/**
 * Represents a regular manual transmission vehicle where the speed changes by 1 at a time and
 * supports exactly 5 gears, numbered 1 through 5.
 */
public class RegularManualTransmission implements ManualTransmission {
  private final int[][] gearSpeeds;
  private int speed;
  private int gear;
  private String status;

  /**
   * Constructs a {@code RegularManualTransmission} object.
   *
   * @param l1 the low speed of gear 1
   * @param h1 the high speed of gear 1
   * @param l2 the low speed of gear 2
   * @param h2 the high speed of gear 2
   * @param l3 the low speed of gear 3
   * @param h3 the high speed of gear 3
   * @param l4 the low speed of gear 4
   * @param h4 the high speed of gear 4
   * @param l5 the low speed of gear 5
   * @param h5 the high speed of gear 5
   * @throws IllegalArgumentException when any gear's low speed is greater than its high speed,
   *         when a gear's low speed is less than or equal to the previous gear's low speed,
   *         when a gear's low speed is greater than the previous gear's high speed,
   *         or when the first gear's low speed is not 0
   */
  public RegularManualTransmission(int l1, int h1,
                                   int l2, int h2,
                                   int l3, int h3,
                                   int l4, int h4,
                                   int l5, int h5) throws IllegalArgumentException {
    this.gearSpeeds = new int[5][2];
    this.gearSpeeds[0][0] = l1;
    this.gearSpeeds[0][1] = h1;
    this.gearSpeeds[1][0] = l2;
    this.gearSpeeds[1][1] = h2;
    this.gearSpeeds[2][0] = l3;
    this.gearSpeeds[2][1] = h3;
    this.gearSpeeds[3][0] = l4;
    this.gearSpeeds[3][1] = h4;
    this.gearSpeeds[4][0] = l5;
    this.gearSpeeds[4][1] = h5;

    this.validateRanges();

    this.speed = 0;
    this.gear = 1;
    this.status = "OK: everything is OK.";
  }

  /**
   * Gets the current status of the vehicle without any additional parameters.
   *
   * @return the current status
   */
  @Override
  public String getStatus() {
    return this.status;
  }

  /**
   * Gets the current speed of the vehicle as a whole number, ranging between {@param l1} and
   * {@param h2}.
   *
   * @return the current speed
   */
  @Override
  public int getSpeed() {
    return this.speed;
  }

  /**
   * Gets the current gear of the vehicle as a whole number, ranging between 1 and 5.
   *
   * @return the current gear
   */
  @Override
  public int getGear() {
    return this.gear;
  }

  /**
   * Increases the speed of the vehicle by a unit of 1.
   * Increasing the speed is not possible if the vehicle has reached maximum speed or if the gear
   * needs to be increased first.
   *
   * @return a new {@code ManualTransmission}
   */
  @Override
  public ManualTransmission increaseSpeed() {
    if (this.speed == this.gearSpeeds[4][1]) {
      this.status = "Cannot increase speed. Reached maximum speed.";
      return this;
    }
    if (this.speed + 1 > this.gearSpeeds[this.gear - 1][1]) {
      this.status = "Cannot increase speed, increase gear first.";
      return this;
    }
    this.speed++;
    if (this.gear < 5 && this.speed >= this.gearSpeeds[this.gear][0]) {
      this.status = "OK: you may increase the gear.";
    } else {
      this.status = "OK: everything is OK.";
    }
    return this;
  }

  /**
   * Decreases the speed of the vehicle by a unit of 1.
   * Decreasing the speed is not possible if the vehicle has reached minimum speed of if the gear
   * needs to be decreased first.
   *
   * @return a new {@code ManualTransmission}
   */
  @Override
  public ManualTransmission decreaseSpeed() {
    if (this.speed == 0) {
      this.status = "Cannot decrease speed. Reached minimum speed.";
      return this;
    }
    if (this.speed - 1 < this.gearSpeeds[this.gear - 1][0]) {
      this.status = "Cannot decrease speed, decrease gear first.";
      return this;
    }
    this.speed--;
    if (this.gear > 1 && this.speed <= this.gearSpeeds[this.gear - 2][1]) {
      this.status = "OK: you may decrease the gear.";
    } else {
      this.status = "OK: everything is OK.";
    }
    return this;
  }

  /**
   * Increases the gear of the vehicle by a unit of 1.
   * Increasing the gear is not possible if the vehicle has reached maximum gear or if the speed
   * needs to be increased first.
   *
   * @return a new {@code ManualTransmission}
   */
  @Override
  public ManualTransmission increaseGear() {
    if (this.gear == 5) {
      this.status = "Cannot increase gear. Reached maximum gear.";
      return this;
    }
    if (this.speed < this.gearSpeeds[this.gear][0]) {
      this.status = "Cannot increase gear, increase speed first.";
      return this;
    }
    this.gear++;
    this.status = "OK: everything is OK.";
    return this;
  }

  /**
   * Decreases the gear of the vehicle by a unit of 1.
   * Decreasing the gear is not possible if the vehicle has reached minimum gear or if the speed
   * needs to be decreased first.
   *
   * @return a new {@code ManualTransmission}
   */
  @Override
  public ManualTransmission decreaseGear() {
    if (this.gear == 1) {
      this.status = "Cannot decrease gear. Reached minimum gear.";
      return this;
    }
    if (this.speed > this.gearSpeeds[this.gear - 2][1]) {
      this.status = "Cannot decrease gear, decrease speed first.";
      return this;
    }
    this.gear--;
    this.status = "OK: everything is OK.";
    return this;
  }

  // Validates the gear ranges and throws an exception if it does not meet the conditions
  private void validateRanges() throws IllegalArgumentException {
    for (int i = 0; i < 5; i++) {
      int lowSpeed = this.gearSpeeds[i][0];
      int highSpeed = this.gearSpeeds[i][1];
      if (lowSpeed > highSpeed) {
        throw new IllegalArgumentException(
                "The low speed is greater than the high speed for gear " + (i + 1)
        );
      }
      if (i > 0) {
        int previousGearLowSpeed = this.gearSpeeds[i - 1][0];
        if (lowSpeed <= previousGearLowSpeed) {
          throw new IllegalArgumentException(
                  "The low speed of gear "
                          + (i + 1)
                          + " is less than the low speed of gear "
                          + i
          );
        }
        int previousGearHighSpeed = this.gearSpeeds[i - 1][1];
        if (lowSpeed > previousGearHighSpeed) {
          throw new IllegalArgumentException(
                  "The low speed of gear "
                          + i
                          + " is greater than the high speed of gear"
                          + (i + 1)
          );
        }
      }
    }
    if (this.gearSpeeds[0][0] != 0) {
      throw new IllegalArgumentException("The low speed of the first gear must be 0");
    }
  }
}
