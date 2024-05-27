package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.operand.Number;
import edu.austral.ingsis.math.operand.Variable;
import java.util.List;

public class Root implements Function {

  private final Function x;

  public Root(Function x) {
    this.x = x;
  }

  @Override
  public Double apply() {
    return Math.sqrt(x.apply());
  }

  @Override
  public List<String> listVariables() {
    return x.listVariables();
  }

  @Override
  public String toString() {
    String outX = this.x.toString();
    if (x.getClass() != Number.class && x.getClass() != Variable.class) {
      outX = "(" + outX + ")";
    }
    return outX + " ^ 0.5 ";
  }
}
