package com.jpinedev.HealthTracker.model;

import java.util.Calendar;

/**
 * A measurement for logging data.
 */
public interface Measure {

  /**
   * Add a data point to the log at the current time.
   *
   * @param data point for the measurement
   */
  void addEntry(double data);

  /**
   * Add a data point to the log at the specified time.
   *
   * @param time of the measurement
   * @param data point for the measurement
   */
  void addEntry(Calendar time, double data);

  /**
   * Remove a data point identified by its time and amount.
   *
   * @param time of the measurement
   * @param data point for the measurement
   */
  void removeEntry(Calendar time, double data);

  /**
   * Sum up of all entries on the specified day.
   *
   * @param day of the entries to be totaled
   * @return total of the entries on that day
   */
  double dailyTotal(Calendar day);

}
