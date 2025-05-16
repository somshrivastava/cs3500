import org.junit.Test;
import org.junit.Before;

import vehicle.ManualTransmission;
import vehicle.RegularManualTransmission;

import static org.junit.Assert.assertEquals;

/**
 * Represents examples and tests for the RegularManualTransmission class.
 */
public class RegularManualTransmissionTest {
  private ManualTransmission transmission;
  private ManualTransmission testTransmission;

  /**
   * Initializes a valid construction of the RegularManualTransmission object.
   */
  @Before
  public void setUp() {
    this.transmission = new RegularManualTransmission(
            0, 1,
            1, 3,
            2, 5,
            4, 7,
            6, 9);
  }

  /**
   * Tests that the constructor throws an IllegalArgumentException when a gear's lower speed
   * is greater than its higher speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorLowGreaterThanHigh() {
    new RegularManualTransmission(
            0, 10,
            5, 3,
            15, 30,
            25, 40,
            35, 50);
  }

  /**
   * Tests that the constructor throws an IllegalArgumentException when a gear's lower speed
   * is less than the previous gear's lower speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorLowLessThanPreviousLow() {
    new RegularManualTransmission(
            0, 10,
            5, 20,
            3, 30,
            25, 40,
            35, 50);
  }

  /**
   * Tests that the constructor throws an IllegalArgumentException when a gear's lower speed
   * is greater than the previous gear's higher speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorLowGreaterThanPreviousHigh() {
    new RegularManualTransmission(
            0, 10,
            15, 3,
            15, 30,
            25, 40,
            35, 50);
  }

  /**
   * Tests the initial status of the transmission after construction.
   */
  @Test
  public void testInitialStatus() {
    assertEquals("OK: everything is OK.", this.transmission.getStatus());
  }

  /**
   * Tests the initial gear of the transmission after construction.
   */
  @Test
  public void testInitialGear() {
    assertEquals(1, this.transmission.getGear());
  }

  /**
   * Tests the initial speed of the transmission after construction.
   */
  @Test
  public void testInitialSpeed() {
    assertEquals(0, this.transmission.getSpeed());
  }

  /**
   * Tests the increaseSpeed() method with various scenarios:
   * 1. Normal speed increase within gear limits
   * 2. Speed increase at gear limit
   * 3. Speed increase beyond gear limit
   * 4. Speed increase at maximum speed
   */
  @Test
  public void testIncreaseSpeed() {
    this.testTransmission = this.transmission.increaseSpeed();
    assertEquals(1, this.testTransmission.getSpeed());
    assertEquals(1, this.testTransmission.getGear());
    assertEquals("OK: you may increase the gear.", this.testTransmission.getStatus());
    this.testTransmission = this.transmission.increaseSpeed();
    assertEquals(1, this.testTransmission.getSpeed());
    assertEquals(1, this.testTransmission.getGear());
    assertEquals("Cannot increase speed, increase gear first.",
            this.testTransmission.getStatus());
    this.testTransmission = this.transmission.increaseGear();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseGear();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseGear();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseGear();
    this.testTransmission = this.transmission.increaseSpeed();
    assertEquals(8, this.testTransmission.getSpeed());
    assertEquals(5, this.testTransmission.getGear());
    assertEquals("OK: everything is OK.", this.testTransmission.getStatus());
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    assertEquals(9, this.testTransmission.getSpeed());
    assertEquals(5, this.testTransmission.getGear());
    assertEquals("Cannot increase speed. Reached maximum speed.",
            this.testTransmission.getStatus());
  }

  /**
   * Tests the decreaseSpeed() method with various scenarios:
   * 1. Speed decrease at minimum speed
   * 2. Speed decrease when gear needs to be decreased first
   * 3. Normal speed decrease within gear limits
   * 4. Speed decrease at gear limit
   */
  @Test
  public void testDecreaseSpeed() {
    this.testTransmission = this.transmission.decreaseSpeed();
    assertEquals(0, this.testTransmission.getSpeed());
    assertEquals(1, this.testTransmission.getGear());
    assertEquals("Cannot decrease speed. Reached minimum speed.",
            this.testTransmission.getStatus());
    this.testTransmission = this.transmission.increaseGear();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseGear();
    this.testTransmission = this.transmission.decreaseSpeed();
    assertEquals(1, this.testTransmission.getSpeed());
    assertEquals(2, this.testTransmission.getGear());
    assertEquals("Cannot decrease speed, decrease gear first.",
            this.testTransmission.getStatus());
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.decreaseSpeed();
    assertEquals(2, this.testTransmission.getSpeed());
    assertEquals(2, this.testTransmission.getGear());
    assertEquals("OK: everything is OK.", this.testTransmission.getStatus());
    this.testTransmission = this.transmission.decreaseSpeed();
    assertEquals(1, this.testTransmission.getSpeed());
    assertEquals(2, this.testTransmission.getGear());
    assertEquals("OK: you may decrease the gear.", this.testTransmission.getStatus());
  }

  /**
   * Tests the increaseGear() method with various scenarios:
   * 1. Gear increase without enough speed
   * 2. Normal gear increase with enough speed
   * 3. Gear increase at maximum gear
   */
  @Test
  public void testIncreaseGear() {
    this.testTransmission = this.transmission.increaseGear();
    assertEquals(0, this.testTransmission.getSpeed());
    assertEquals(1, this.testTransmission.getGear());
    assertEquals("Cannot increase gear, increase speed first.",
            this.testTransmission.getStatus());
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseGear();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseGear();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseGear();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseGear();
    assertEquals(7, this.testTransmission.getSpeed());
    assertEquals(5, this.testTransmission.getGear());
    assertEquals("OK: everything is OK.", this.testTransmission.getStatus());
    this.testTransmission = this.transmission.increaseGear();
    assertEquals(7, this.testTransmission.getSpeed());
    assertEquals(5, this.testTransmission.getGear());
    assertEquals("Cannot increase gear. Reached maximum gear.",
            this.testTransmission.getStatus());
  }

  /**
   * Tests the decreaseGear() method with various scenarios:
   * 1. Gear decrease at minimum gear
   * 2. Gear decrease with too high speed
   * 3. Normal gear decrease with appropriate speed
   */
  @Test
  public void testDecreaseGear() {
    this.testTransmission = this.transmission.decreaseGear();
    assertEquals(0, this.testTransmission.getSpeed());
    assertEquals(1, this.testTransmission.getGear());
    assertEquals("Cannot decrease gear. Reached minimum gear.",
            this.testTransmission.getStatus());
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseGear();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.increaseSpeed();
    this.testTransmission = this.transmission.decreaseGear();
    assertEquals(3, this.testTransmission.getSpeed());
    assertEquals(2, this.testTransmission.getGear());
    assertEquals("Cannot decrease gear, decrease speed first.",
            this.testTransmission.getStatus());
    this.testTransmission = this.transmission.decreaseSpeed();
    this.testTransmission = this.transmission.decreaseSpeed();
    this.testTransmission = this.transmission.decreaseGear();
    assertEquals(1, this.testTransmission.getSpeed());
    assertEquals(1, this.testTransmission.getGear());
    assertEquals("OK: everything is OK.", this.testTransmission.getStatus());
  }
}