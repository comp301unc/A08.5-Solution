package com.comp301.a00rameses.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
  // boolean to track whether on lovesme or lovesme not
  private boolean lovesme;
  // counter to track how many times button clicked
  private int count;
  // list of observers for mvc design pattern
  private final List<ModelObserver> observers;

  // constructor
  public ModelImpl() {
    // starts off with loves me
    lovesme = true;
    count = 0;
    observers = new ArrayList<>();
  }

  // getter for loves me
  public boolean getLovesme() {
    return lovesme;
  }

  // getter for counter
  public int getCount() {
    return count;
  }

  // this method is what is called when button is clicked
  @Override
  public void ask() {
    // Change loves me to loves me not or vice versa
    lovesme = !lovesme;
    // increase the times ask
    count++;
    // notify our observers
    notifyObservers();
  }

  // Practice by adding a reset button! Don't forget to notify the observers!

  // methods below are for mvc purposes
  @Override
  public void addObserver(ModelObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException("Observer cannot be null");
    }
    observers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }

  private void notifyObservers() {
    for (ModelObserver observer : observers) {
      observer.update(this);
    }
  }
}
