package com.jpinedev.HealthTracker.model;

import java.util.Calendar;

public class Entry implements Comparable<Entry> {

  private final Calendar time;
  private final double amt;

  public Entry(Calendar time, double amt) {
    this.time = time;
    this.amt = amt;
  }

  public Entry(double amt) {
    this(Calendar.getInstance(), amt);
  }

  public double getAmt() {
    return this.amt;
  }

  public boolean sameDay(Calendar day) {
    return this.time.get(Calendar.DAY_OF_YEAR) == day.get(Calendar.DAY_OF_YEAR)
        && this.time.get(Calendar.YEAR) == day.get(Calendar.YEAR);
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

}
