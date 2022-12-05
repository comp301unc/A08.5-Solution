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
  private final Model model;
  private final ClassicMvcController controller;
  private Button askbutton;

  public ButtonView(Model model, ClassicMvcController controller) {
    this.model = model;
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox pane1 = new VBox();
    pane1.getChildren().clear();
    pane1.getStyleClass().add("vbox");
    pane1.setAlignment(Pos.CENTER);

    if (model.getLoves()) {
      Label helovesme = new Label("He loves me!");
      helovesme.getStyleClass().add("label");
      pane1.getChildren().add(helovesme);
    } else {
      Label helovesmenot = new Label("He loves me not!");
      helovesmenot.getStyleClass().add("label");
      pane1.getChildren().add(helovesmenot);
    }

    HBox pane = new HBox();
    pane.getChildren().clear();
    pane.getStyleClass().add("hbox");
    pane.setAlignment(Pos.CENTER);

    if (askbutton == null) {
      askbutton = new Button("Does Rameses Love Me?");
      askbutton.setOnAction(
          (ActionEvent event) -> controller.askButton());
    }

    askbutton.getStyleClass().add("button");
    pane.getChildren().add(askbutton);

    Label Count = new Label("Times asked:" + " " + (model.getCount()));
    Count.getStyleClass().add("label");
    pane.getChildren().add(Count);
    pane1.getChildren().add(pane);

    return pane1;
  }
}
