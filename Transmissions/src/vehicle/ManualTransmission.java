package vehicle;

/**
 * Specifies operations for simulating a manual transmission vehicle.
 */
public interface ManualTransmission {

  /**
   * Gets the current status of the vehicle.
   *
   * @return the current status
   */
  String getStatus();

  /**
   * Gets the current speed of the vehicle.
   *
   * @return the current speed
   */
  int getSpeed();

  /**
   * Gets the current gear of the vehicle.
   *
   * @return the current gear
   */
  int getGear();

  /**
   * Increases the speed of the vehicle by a certain fixed amount.
   * If the speed cannot be increased, it returns an object with the same speed.
   *
   * @return a new {@code ManualTransmission}
   */
  ManualTransmission increaseSpeed();

  /**
   * Decreases the speed of the vehicle by a certain fixed amount.
   * If the speed cannot be decreased, it returns an object with the same speed.
   *
   * @return a new {@code ManualTransmission}
   */
  ManualTransmission decreaseSpeed();

  /**
   * Increases the gear of the vehicle by one.
   * If the gear cannot be increased, it returns an object with the same gear.
   *
   * @return a new {@code ManualTransmission}
   */
  ManualTransmission increaseGear();

  /**
   * Decreases the gear of the vehicle by one.
   * If the gear cannot be decreased, it returns an object with the same gear.
   *
   * @return a new {@code ManualTransmission}
   */
  ManualTransmission decreaseGear();
}
