package com.jpinedev.HealthTracker.model;

import java.util.ArrayList;
import java.util.Collections;

public class HealthTrackerModel {

  private ArrayList<AbstractMeasure> measures;

  public HealthTrackerModel(ArrayList<AbstractMeasure> measures) {
    this.measures = measures;
  }

  public HealthTrackerModel() {
    this(new ArrayList<AbstractMeasure>());
  }

  private void addMeasure(AbstractMeasure am) {
    if (this.measures.contains(am)) {
      return;
    }
    this.measures.add(am);
    Collections.sort(this.measures);
  }

  /**
   * Adds a new measure to the list as a body measurement.
   *
   * @param name of the measure
   * @param units of the measure
   */
  public void addBodyMeasure(String name, String units) {
    this.addMeasure(new BodyMeasure(name, units));
  }

  /**
   * Adds a new measure to the list as an exercise measurement.
   *
   * @param name of the measure
   * @param units of the measure
   */
  public void addExerciseMeasure(String name, String units) {
    this.addMeasure(new ExerciseMeasure(name, units));
  }

  /**
   * Adds a new measure to the list as a nutrition measurement.
   *
   * @param name of the measure
   * @param units of the measure
   */
  public void addNutritionMeasure(String name, String units) {
    this.addMeasure(new NutritionMeasure(name, units));
  }

  /**
   * Returns the sorted names of all measures in the list as a list of strings.
   *
   * @return sorted names of measures
   */
  public ArrayList<String> asList() {
    ArrayList<String> result = new ArrayList<String>();
    for (AbstractMeasure am : this.measures) {
      result.add(am.toString());
    }
    return result;
  }

  @Override
  public String toString() {
    String result = "";
    for (int i = 0; i < this.measures.size(); i++) {
      result += this.measures.get(i).toString();
      if (i + 1 < this.measures.size()) {
        result += "\n";
      }
    }
    return result;
  }

}
