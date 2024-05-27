package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operand.Number;
import edu.austral.ingsis.math.operand.Variable;
import edu.austral.ingsis.math.operation.*;
import edu.austral.ingsis.math.operation.Module;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Function result = new Sum(new Number(1), new Variable("x", 3));
    assertThat(result.apply(), equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Function result = new Divide(new Number(12), new Variable("div", 4));
    assertThat(result.apply(), equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double result =
        new Multiply(new Divide(new Number(9), new Variable("x", 3)), new Variable("y", 4)).apply();

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double result =
        new Power(new Divide(new Number(27), new Variable("a", 9)), new Variable("b", 3)).apply();

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double result = new Root(new Variable("z", 36)).apply();

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double result = new Minus(new Module(new Variable("value", 8)), new Number(8)).apply();

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Double result = new Minus(new Module(new Variable("value", 8)), new Number(8)).apply();

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double result =
        new Multiply(new Minus(new Number(5), new Variable("i", 2)), new Number(8)).apply();
    assertThat(result, equalTo(24d));
  }
}
