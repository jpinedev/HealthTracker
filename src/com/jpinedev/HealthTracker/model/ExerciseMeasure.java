package com.jpinedev.HealthTracker.model;

/**
 * A class to represent an exercise measurement.
 */
public class ExerciseMeasure extends AbstractMeasure {

  public ExerciseMeasure(String name, String units) {
    super(MeasureType.EXERCISE, name, units);
  }

}
