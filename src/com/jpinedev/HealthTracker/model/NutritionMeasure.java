package com.jpinedev.HealthTracker.model;

/**
 * A class to represent a nutritional intake measurement.
 */
public class NutritionMeasure extends AbstractMeasure {

  public NutritionMeasure(String name, String units) {
    super(MeasureType.NUTRITION, name, units);
  }

}
