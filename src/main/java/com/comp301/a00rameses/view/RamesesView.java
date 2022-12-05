package com.comp301.a00rameses.view;

import com.comp301.a00rameses.controller.ClassicMvcController;
import com.comp301.a00rameses.model.Model;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
// This class is to display image
public class RamesesView implements FXComponent {
  private final Model model;
  private final ClassicMvcController controller;

  public RamesesView(Model model, ClassicMvcController controller) {
    this.model = model;
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox pane = new VBox();
    pane.getChildren().clear();
    ImageView rameses = makeimage();
    pane.getChildren().add(rameses);
    return pane;
  }

  private ImageView makeimage() {
    Image image;
    if (model.getLoves()) {
      image = new Image("rameses_love.jpg");
    } else {
      image = new Image("rameses_love_not.jpg");
    }
    ImageView imageView = new ImageView();
    imageView.setImage(image);
    imageView.setX(10);
    imageView.setY(10);
    imageView.setFitWidth(575);
    imageView.setPreserveRatio(true);
    return imageView;
  }
}
