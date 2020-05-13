package com.jpinedev.HealthTracker.model;

import java.util.Calendar;

public interface Measure {

  void addEntry(double data);
  void addEntry(Calendar time, double data);
  void removeEntry(Calendar time, double data);

}
