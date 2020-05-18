package com.jpinedev.HealthTracker.controller;

import com.jpinedev.HealthTracker.model.HealthTrackerModel;
import com.jpinedev.HealthTracker.model.MeasureType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewMeasureController {

  private Controller ctrl;
  private HealthTrackerModel model;

  ObservableList<MeasureType> typeOptions =
      FXCollections.observableArrayList(
          MeasureType.BODY,
          MeasureType.EXERCISE,
          MeasureType.NUTRITION
      );

  @FXML
  private ChoiceBox typeBox;
  @FXML
  private TextField nameText;
  @FXML
  private TextField unitText;
  @FXML
  private Button addMeasure;

  EventHandler addMeasureEvent = event -> {
    if (nameText.getText().isEmpty() || unitText.getText().isEmpty()
        || typeBox.getValue() == null) {
      return;
    }
    if (!(typeBox.getValue() instanceof MeasureType)) {
      throw new IllegalStateException("Type ComboBox must only be MeasureTypes");
    }
    MeasureType type = (MeasureType) typeBox.getValue();
    switch (type) {
      case BODY:
        model.addBodyMeasure(nameText.getText(), unitText.getText());
        break;
      case EXERCISE:
        model.addExerciseMeasure(nameText.getText(), unitText.getText());
        break;
      case NUTRITION:
        model.addNutritionMeasure(nameText.getText(), unitText.getText());
        break;
      default:
        throw new IllegalStateException("Unhandled MeasureType: " + type.toString());
    }
    nameText.clear();
    unitText.clear();
    if (ctrl.verbose) {
      System.out.println(model.toString());
    }
    ctrl.refreshMeasureList();
    Stage stage = (Stage) addMeasure.getScene().getWindow();
    stage.close();
  };

  /**
   * Pass the main controller's instance of the model to this controller.
   *
   * @param ctrl the main controller
   * @param model from the main controller
   */
  public void initNMC(Controller ctrl, HealthTrackerModel model) {
    this.ctrl = ctrl;
    this.model = model;
  }

  @FXML
  private void initialize() {
    typeBox.setItems(typeOptions);
    addMeasure.setOnMouseClicked(addMeasureEvent);
  }

}
