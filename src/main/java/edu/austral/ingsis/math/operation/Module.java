package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;
import java.util.List;

public class Module implements Function {

  private final Function x;

  public Module(Function x) {
    this.x = x;
  }

  @Override
  public Double apply() {
    return Math.abs(x.apply());
  }

  @Override
  public List<String> listVariables() {
    return x.listVariables();
  }

  @Override
  public String toString() {
    String outX = this.x.toString();
    return "|" + outX + "|";
  }
}
