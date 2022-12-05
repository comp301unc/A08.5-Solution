package com.comp301.a00rameses.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
  private boolean lovesMe;
  private int count;
  private final List<ModelObserver> observers;

  public ModelImpl() {
    lovesMe = true;
    count = 0;
    observers = new ArrayList<>();
  }

  public boolean getLoves() {
    return lovesMe;
  }

  public int getCount() {
    return count;
  }

  @Override
  public void ask() {
    lovesMe = !lovesMe;
    count++;
    notifyObservers();
  }

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
