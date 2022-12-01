package com.comp301.a00rameses.view;

import com.comp301.a00rameses.controller.ClassicMvcController;
import com.comp301.a00rameses.model.Model;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ButtonView implements FXComponent {
  // our view components should encapsulate a model and controller
  private final Model model;
  private final ClassicMvcController controller;
  private Button askbutton;

  public ButtonView(Model model, ClassicMvcController controller) {
    this.model = model;
    this.controller = controller;
  }

  @Override
  public Parent render() {
    // Set up Vbox to store hbox and message
    VBox pane1 = new VBox();
    pane1.getChildren().clear();
    // Set style
    pane1.getStyleClass().add("vbox");
    pane1.setAlignment(Pos.CENTER);

    // using our model to determine what is displayed!
    if (model.getLovesme()) {
      // Intialize message
      Label helovesme = new Label("He loves me!");
      helovesme.getStyleClass().add("label");
      pane1.getChildren().add(helovesme);
    } else {
      // Intialize message
      Label helovesmenot = new Label("He loves me not!");
      helovesmenot.getStyleClass().add("label");
      pane1.getChildren().add(helovesmenot);
    }

    // Set up Hbox to store the buttons and counter
    HBox pane = new HBox();
    pane.getChildren().clear();
    // Set style
    pane.getStyleClass().add("hbox");
    pane.setAlignment(Pos.CENTER);

    // Intialize button
    if (askbutton == null) {
      askbutton = new Button("Does Rameses Love Me?");
      askbutton.setOnAction(
          (ActionEvent event) -> {
            controller.askbutton();
          });
    }
    // Set style
    askbutton.getStyleClass().add("button");
    pane.getChildren().add(askbutton);

    // Intialize counter
    Label Count = new Label("Times asked:" + " " + (model.getCount()));
    // Set style
    Count.getStyleClass().add("label");
    pane.getChildren().add(Count);

    // Put the buttons into vbox under message
    pane1.getChildren().add(pane);

    return pane1;
  }
}
