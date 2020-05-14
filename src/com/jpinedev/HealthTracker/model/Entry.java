package com.jpinedev.HealthTracker.model;

import java.util.Calendar;

/**
 * A class to represent a data point for a measurement. Sortable by time of the entry.
 */
public class Entry implements Comparable<Entry> {

  private final Calendar time;
  private final double amt;
  private final String units;
  private final int precision;

  public Entry(String units, int precision, Calendar time, double amt) {
    this.units = units;
    this.precision = precision;
    this.time = time;
    this.amt = amt;
  }

  public Entry(String units, int precision, double amt) {
    this(units, precision, Calendar.getInstance(), amt);
  }

  /**
   * Getter for the amount of the entry.
   *
   * @return the amount of the entry.
   */
  public double getAmt() {
    return this.amt;
  }

  /**
   * Determines if the entry is on the specified day.
   *
   * @param day to be checked against
   * @return if the entry is on the specified day
   */
  public boolean sameDay(Calendar day) {
    return this.time.get(Calendar.DAY_OF_YEAR) == day.get(Calendar.DAY_OF_YEAR)
        && this.time.get(Calendar.YEAR) == day.get(Calendar.YEAR);
  }

  /**
   * Determines if the entry is on the specified week.
   *
   * @param dayInWeek to be checked against
   * @return if the entry is in the specified week
   */
  public boolean sameWeek(Calendar dayInWeek) {
    return this.time.get(Calendar.WEEK_OF_YEAR) == dayInWeek.get(Calendar.WEEK_OF_YEAR)
        && this.time.get(Calendar.YEAR) == dayInWeek.get(Calendar.YEAR);
  }

  public double daysSince(Entry e) {
    return this.time.get(Calendar.DAY_OF_YEAR) - e.time.get(Calendar.DAY_OF_YEAR)
        + (this.time.get(Calendar.YEAR) - e.time.get(Calendar.YEAR)) * 364.25;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Entry)) {
      return false;
    }
    Entry e = (Entry) o;
    return this.amt == e.amt && this.time.equals(e.time);
  }

  @Override
  public int hashCode() {
    return this.time.hashCode() * 100 + Double.hashCode(this.amt / 100);
  }

  @Override
  public int compareTo(Entry o) {
    return this.time.compareTo(o.time);
  }

  @Override
  public String toString() {
    return String.format("%d/%d/%d : %."+precision+"f"+units,
        this.time.get(Calendar.MONTH) + 1,
        this.time.get(Calendar.DAY_OF_MONTH),
        this.time.get(Calendar.YEAR),
        this.amt);
  }

}
