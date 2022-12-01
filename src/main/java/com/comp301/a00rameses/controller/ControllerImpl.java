package com.comp301.a00rameses.controller;

import com.comp301.a00rameses.model.Model;

public class ControllerImpl implements ClassicMvcController {
  // our controller should encapsulate a model
  private final Model model;

  public ControllerImpl(Model model) {
    if (model == null) {
      throw new IllegalArgumentException("Cannot instantiate ControllerImpl with null Model");
    }
    this.model = model;
  }

  // we want to make sure we can 'control' our desired model methods
  @Override
  public void askbutton() {
    model.ask();
  }
}
