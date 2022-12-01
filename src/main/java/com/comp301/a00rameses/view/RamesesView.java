package com.comp301.a00rameses.view;

import com.comp301.a00rameses.controller.ClassicMvcController;
import com.comp301.a00rameses.model.Model;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

// Purpose of this class is to display appropriate rameses photo
public class RamesesView implements FXComponent {
  private final Model model;
  private final ClassicMvcController controller;

  public RamesesView(Model model, ClassicMvcController controller) {
    this.model = model;
    this.controller = controller;
  }

  @Override
  public Parent render() {
    // Create vbox to store
    VBox pane = new VBox();
    // Clear children
    pane.getChildren().clear();
    // Make a rameses
    ImageView rameses = makeimage();
    // Add to pane
    pane.getChildren().add(rameses);
    return pane;
  }

  private ImageView makeimage() {
    // creating the image object
    Image image;
    if (model.getLovesme()) {
      image = new Image("rameses2.jpg");
    } else {
      image = new Image("rameses_sadd.jpg");
    }
    // Creating the image view
    ImageView imageView = new ImageView();
    // Setting image to the image view
    imageView.setImage(image);
    // Setting the image view parameters
    imageView.setX(10);
    imageView.setY(10);
    imageView.setFitWidth(575);
    imageView.setPreserveRatio(true);
    // return
    return imageView;
  }
}
