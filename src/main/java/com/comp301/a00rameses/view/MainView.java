package com.comp301.a00rameses.view;

import com.comp301.a00rameses.controller.ClassicMvcController;
import com.comp301.a00rameses.model.Model;
import com.comp301.a00rameses.model.ModelObserver;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MainView implements FXComponent, ModelObserver {
  // main view to bring together other views
  private final FXComponent ramesesview;
  private final FXComponent buttonview;
  private final Scene scene;

  public MainView(Model model, ClassicMvcController controller) {
    this.ramesesview = new RamesesView(model, controller);
    this.buttonview = new ButtonView(model, controller);
    // render our initial scene
    this.scene = new Scene(render());
    // add our stylesheet
    this.scene.getStylesheets().add("main.css");
    // this is an observer to our model!
    model.addObserver(this);
  }

  public Scene getScene() {
    return scene;
  }

  @Override
  public Parent render() {
    // pane to house our other views
    BorderPane pane = new BorderPane();
    pane.setTop(ramesesview.render());
    pane.setBottom(buttonview.render());
    return pane;
  }

  // Everytime our update method is called (when ask button is pressed) our view will render!
  @Override
  public void update(Model model) {
    scene.setRoot(render());
  }
}
