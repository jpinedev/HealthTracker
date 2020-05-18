package com.jpinedev.HealthTracker.controller;

import com.jpinedev.HealthTracker.model.HealthTrackerModel;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {

  private HealthTrackerModel model = new HealthTrackerModel();
  public static boolean verbose = false;

  ObservableList<String> measuresList;

  @FXML
  private ChoiceBox measures;
  @FXML
  private Button addNewMeasure;

  private EventHandler newMeasurePopupHandler = event -> {
    try {
      newMeasurePopup();
    } catch (IOException e) {
      e.printStackTrace();
    }
  };

  private void newMeasurePopup() throws IOException {
    Stage stage = (Stage) addNewMeasure.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/newMeasurePopup.fxml"));
    Parent root = loader.load();

    NewMeasureController nmc = loader.getController();
    nmc.initNMC(this, model);

    Stage popup = new Stage();
    popup.setScene(new Scene(root));
    popup.initModality(Modality.APPLICATION_MODAL);
    popup.initOwner(stage);
    popup.showAndWait();
  }

  /**
   * Refresh the list of measures after a change in the list.
   */
  public void refreshMeasureList() {
    //TODO: add event handler for active
    String active = (String) measures.getValue();
    measuresList = FXCollections.observableArrayList(model.asList());
    measures.setItems(measuresList);
    if (active != null) {
      measures.setValue(active);
    }
  }

  @FXML
  private void initialize() {
    measuresList = FXCollections.observableArrayList(model.asList());
    measures.setItems(measuresList);
    addNewMeasure.setOnMouseClicked(newMeasurePopupHandler);
  }

}
