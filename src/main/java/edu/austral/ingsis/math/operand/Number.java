package edu.austral.ingsis.math.operand;

import edu.austral.ingsis.math.Function;
import java.util.List;

public class Number implements Function {

  private final double value;

  public Number(double value) {
    this.value = value;
  }

  @Override
  public Double apply() {
    return value;
  }

  @Override
  public List<String> listVariables() {
    return List.of();
  }

  @Override
  public String toString() {
    return String.valueOf((int) value);
  }
}
