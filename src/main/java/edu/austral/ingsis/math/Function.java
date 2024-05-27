package edu.austral.ingsis.math;

import java.util.List;

public interface Function {
  public Double apply();

  public String toString();

  public List<String> listVariables();
}
