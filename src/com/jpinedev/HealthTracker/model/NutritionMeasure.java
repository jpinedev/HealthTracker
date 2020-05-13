package com.jpinedev.HealthTracker.model;

/**
 * A class to represent a nutritional intake measurement.
 */
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
