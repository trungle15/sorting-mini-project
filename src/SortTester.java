import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Trung Le
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void integerTest() {
    Integer[] original = { 2, 3, 5, 7, 8, 1, 9, 4, 6 };
    Integer[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // integerTest()

  @Test
  public void reverseIntegerTest() {
    Integer[] original = { 9, 5, 8, 3, 7 };
    Integer[] expected = { 9, 8, 7, 5, 3 };
    sorter.sort(original, (x, y) -> y - x); // Reverse order
    assertArrayEquals(expected, original);
  } // reverseIntegerTest()

  @Test
  public void doubleTest() {
      Double[] original = { 2.1, 1.2, 3.3, 4.4, 5.5 };
      Double[] expected = { 1.2, 2.1, 3.3, 4.4, 5.5 };
      sorter.sort(original, (x, y) -> x.compareTo(y));
      assertArrayEquals(expected, original);
  } // doubleTest

  @Test
  public void charTest() {
    Character[] original = { 'e', 'a', 'c', 'b', 'd' };
    Character[] expected = { 'a', 'b', 'c', 'd', 'e' };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // charTest

  @Test
  public void stringLengthTest() {
    String[] original = { "banana", "apple", "pear", "grape" };
    String[] expected = { "pear", "apple", "grape", "banana" };
    sorter.sort(original, (x, y) -> Integer.compare(x.length(), y.length()));
    assertArrayEquals(expected, original);
  }

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

} // class SortTester
