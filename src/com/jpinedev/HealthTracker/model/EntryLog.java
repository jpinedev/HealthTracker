package com.jpinedev.HealthTracker.model;

import java.util.ArrayList;

public class EntryLog extends ArrayList<Entry> {

  public EntryLog() {
    super();
  }

  @Override
  public String toString() {
    String result = "";
    for (int i = 0; i < this.size(); i++) {
      result += this.get(i);
      if (i + 1 < this.size()) {
        result += "\n";
      }
    }
    return result;
  }

}
