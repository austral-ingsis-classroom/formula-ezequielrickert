package edu.austral.ingsis.math.operand;

import edu.austral.ingsis.math.Function;
import java.util.List;

public class Variable implements Function {
  private final String variable;
  private final double value;

  public Variable(String variable, double value) {
    this.value = value;
    this.variable = variable;
  }

  @Override
  public Double apply() {
    return value;
  }

  @Override
  public List<String> listVariables() {
    return List.of(variable);
  }

  @Override
  public String toString() {
    return variable;
  }

  public Function setValue(Double value) {
    return new Variable(variable, value);
  }
}
