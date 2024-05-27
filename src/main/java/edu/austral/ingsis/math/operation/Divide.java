package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.operand.Number;
import edu.austral.ingsis.math.operand.Variable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Divide implements Function {

  private final Function x;
  private final Function y;

  public Divide(Function x, Function y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public Double apply() {
    return x.apply() / y.apply();
  }

  @Override
  public List<String> listVariables() {
    return listVariables(x.listVariables(), y.listVariables());
  }

  @Override
  public String toString() {
    String outX = this.x.toString();
    String outY = this.y.toString();
    if (x.getClass() != Number.class && x.getClass() != Variable.class) {
      outX = "(" + outX + ")";
    }
    if (y.getClass() != Number.class && y.getClass() != Variable.class) {
      outY = "(" + outY + ")";
    }
    return outX + " / " + outY;
  }

  private List<String> listVariables(List<String> x, List<String> y) {
    Set<String> outputSet = new HashSet<>(x);
    for (String variable : y) {
      outputSet.add(variable);
    }
    return new ArrayList<>(outputSet);
  }
}
