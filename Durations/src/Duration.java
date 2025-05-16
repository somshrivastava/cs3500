/**
 * This interface represents all the operations to be supported by a duration in time
 */
public interface Duration extends Comparable<Duration> {

  /**
   * Return the value of this duration in terms of seconds.
   *
   * @return the value in an integral number of seconds
   */
  long inSeconds();

  String asHms();

  Duration add(Duration other);

  /**
   * Compares two durations for someness. Two durations are the same if they have the same duration span.
   *
   * @param other the other object to be compared to this
   * @return true if the two objects are the same according to the above definition, false otherwise
   */
  boolean equals(Object other);

  /**
   * Compares two durations for ordering. Two durations are compared to each other based on their
   * duration span (i.e. duration in seconds)
   * @param other the object to be compared.
   * @return -ve number if this &lt; other,0 if this==other and +ve this &gt; other
   * */

  /**
   * @return
   */
  int hashCode();
}

