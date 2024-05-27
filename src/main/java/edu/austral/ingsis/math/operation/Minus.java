package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Minus implements Function {

  private final Function x;
  private final Function y;

  public Minus(Function x, Function y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public Double apply() {
    return x.apply() - y.apply();
  }

  @Override
  public List<String> listVariables() {
    return listVariables(x.listVariables(), y.listVariables());
  }

  @Override
  public String toString() {
    return x.toString() + " - " + y.toString();
  }

  private List<String> listVariables(List<String> x, List<String> y) {
    Set<String> outputSet = new HashSet<>(x);
    for (String variable : y) {
      outputSet.add(variable);
    }
    return new ArrayList<>(outputSet);
  }
}
