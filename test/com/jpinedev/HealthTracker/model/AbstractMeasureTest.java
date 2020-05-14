package com.jpinedev.HealthTracker.model;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import org.junit.Test;

public class AbstractMeasureTest {

  AbstractMeasure weight;
  AbstractMeasure steps;

  public void initializeMeasures() {
    Calendar yesterday = Calendar.getInstance();
    Calendar threeBack = Calendar.getInstance();
    yesterday.set(Calendar.DAY_OF_YEAR, yesterday.get(Calendar.DAY_OF_YEAR) - 1);
    threeBack.set(Calendar.DAY_OF_YEAR, threeBack.get(Calendar.DAY_OF_YEAR) - 3);

    weight = new BodyMeasure("Weight", "lbs");
    weight.addEntry(yesterday, 138);
    weight.addEntry(142);

    steps = new ExerciseMeasure("Steps", "steps");
    steps.addEntry(200);
    steps.addEntry(300);
    steps.addEntry(yesterday, 400);
    steps.addEntry(500);
    steps.addEntry(threeBack, 2000);
  }

  @Test
  public void testDailyAverage() {
    initializeMeasures();
    assertEquals(140, weight.dailyAverage(), 0.001);
    assertEquals(850, steps.dailyAverage(), 0.001);
  }

  @Test
  public void testToString() {
    initializeMeasures();
    assertEquals("5/13/2020 : 138.0lbs\n5/14/2020 : 142.0lbs", weight.toString());
    assertEquals("5/11/2020 : 2000.0steps\n"
        + "5/13/2020 : 400.0steps\n"
        + "5/14/2020 : 200.0steps\n"
        + "5/14/2020 : 300.0steps\n"
        + "5/14/2020 : 500.0steps",
        steps.toString());
  }

}