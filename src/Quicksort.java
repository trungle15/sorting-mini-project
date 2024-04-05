import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Your Name Here
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quickSort(values, 0, values.length - 1, order);
  } // sort(T[], Comparator<? super T>

  public <T> void quickSort(T[] arr, int lo, int hi, Comparator<? super T> order) {
    if (lo < hi) {
      int pivotIndex = partition(arr, lo, hi, order);

      quickSort(arr, lo, pivotIndex - 1, order);
      quickSort(arr, pivotIndex + 1, hi, order);
    }
  }

  public <T> int partition(T[] arr, int lo, int hi, Comparator<? super T> order) {
    T pivot = arr[hi];
    int i = (lo - 1);

    for (int j = lo; j < hi; j++) {
      if (order.compare(arr[j], pivot) <= 0) {
        i++;

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    T temp = arr[i + 1];
    arr[i + 1] = arr[hi];
    arr[hi] = temp;

    return i + 1;
  }

} // class Quicksort
