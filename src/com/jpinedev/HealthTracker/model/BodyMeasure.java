package com.jpinedev.HealthTracker.model;

public class BodyMeasure extends AbstractMeasure {

  public BodyMeasure(String name, String units) {
    super(MeasureType.BODY, name, units);
  }

}
