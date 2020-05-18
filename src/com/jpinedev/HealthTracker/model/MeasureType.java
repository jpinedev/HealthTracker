package com.jpinedev.HealthTracker.model;

public enum MeasureType {
  BODY("Body"), EXERCISE("Exercise"), NUTRITION("Nutrition");
  private String type;

  MeasureType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type;
  }
}
