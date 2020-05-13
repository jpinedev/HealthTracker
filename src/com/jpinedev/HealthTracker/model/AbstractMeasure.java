package com.jpinedev.HealthTracker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Calendar;

public abstract class AbstractMeasure implements Measure, Comparable<AbstractMeasure> {

  private final String name;
  private final String units;
  private int precision;
  private ArrayList<Entry> log;

  public AbstractMeasure(String name, String units, int precision) {
    this.name = name;
    this.units = units;
    this.precision = precision;
    this.log = new ArrayList<Entry>();
  }

  public AbstractMeasure(String name, String units) {
    this(name, units, 1);
  }

  @Override
  public void addEntry(double data) {
    this.log.add(new Entry(data));
    Collections.sort(this.log);
  }

  @Override
  public void addEntry(Calendar time, double data) {
    this.log.add(new Entry(time, data));
    Collections.sort(this.log);
  }

  @Override
  public void removeEntry(Calendar time, double data) {
    this.log.remove(new Entry(time, data));
  }

  public double dailyTotal(Calendar day) {
    double total = 0;
    for (Entry entry : this.log) {
      if (entry.sameDay(day)) {
        total += entry.getAmt();
      }
    }
    return total;
  }

  @Override
  public int compareTo(AbstractMeasure am) {
    return this.name.compareTo(am.name);
  }

}
