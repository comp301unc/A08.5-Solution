package com.comp301.a00rameses.model;

public interface ModelObserver {
  /** When a model value is changed, the model calls update() on all active ModelObserver objects */
  void update(Model model);
}
