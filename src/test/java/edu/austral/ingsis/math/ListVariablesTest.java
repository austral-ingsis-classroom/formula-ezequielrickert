package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.operand.Number;
import edu.austral.ingsis.math.operand.Variable;
import edu.austral.ingsis.math.operation.*;
import edu.austral.ingsis.math.operation.Module;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final List<String> result = new Sum(new Number(1), new Number(6)).listVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final List<String> result = new Divide(new Number(12), new Variable("div", 1)).listVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final List<String> result =
        new Multiply(new Divide(new Number(9), new Variable("x", 1)), new Variable("y", 1))
            .listVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final List<String> result =
        new Power(new Divide(new Number(27), new Variable("a", 1)), new Variable("b", 1))
            .listVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final List<String> result =
        new Power(new Variable("z", 1), new Module(new Number(2))).listVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final List<String> result =
        new Minus(new Module(new Variable("value", 9)), new Number(8)).listVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final List<String> result =
        new Minus(new Module(new Variable("value", 9)), new Number(8)).listVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final List<String> result =
        new Multiply(new Minus(new Number(5), new Variable("i", 5)), new Number(8)).listVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
