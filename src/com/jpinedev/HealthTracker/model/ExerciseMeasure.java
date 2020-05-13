package com.jpinedev.HealthTracker.model;

public class ExerciseMeasure extends AbstractMeasure {

  public ExerciseMeasure(String name, String units) {
    super(name, units);
  }

  @Override
  public int compareTo(AbstractMeasure am) {
    if(am instanceof ExerciseMeasure) {
      return super.compareTo(am);
    }
    return -1;
  }

}
