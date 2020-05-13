package com.jpinedev.HealthTracker.model;

public class NutritionMeasure extends AbstractMeasure {

  public NutritionMeasure(String name, String units) {
    super(name, units);
  }

  @Override
  public int compareTo(AbstractMeasure am) {
    if(am instanceof NutritionMeasure) {
      return super.compareTo(am);
    }
    return 1;
  }

}
