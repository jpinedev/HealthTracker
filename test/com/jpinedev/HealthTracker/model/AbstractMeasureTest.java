package com.jpinedev.HealthTracker.model;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import org.junit.Test;

public class AbstractMeasureTest {

  AbstractMeasure weight;

  public void initializeMeasures() {
    Calendar yesterday = Calendar.getInstance();
    yesterday.set(Calendar.DAY_OF_YEAR, yesterday.get(Calendar.DAY_OF_YEAR) - 1);

    weight = new BodyMeasure("Weight", "lbs");
    weight.addEntry(yesterday, 138);
    weight.addEntry(Calendar.getInstance(), 142);
  }

  @Test
  public void testDailyAverage() {
    initializeMeasures();
    assertEquals(140, weight.dailyAverage(), 0.001);
  }

}