package com.comp301.a00rameses.model;

public interface Model {
  /** Returns boolean representing loves me or not */
  boolean getLovesme();

  /** Returns count of times asked */
  int getCount();

  /** Changes bool representing loves me or loves me not... when you 'ask' do you love me */
  void ask();

  /** Adds an observer to the model */
  void addObserver(ModelObserver observer);

  /**
   * Removes an observer from the model... won't be using this for this project but good to
   * implement it as practice!
   */
  void removeObserver(ModelObserver observer);
}
