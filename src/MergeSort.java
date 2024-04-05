import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Trung Le
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  @SuppressWarnings("unchecked")
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // Allocate the helper array once and reuse it for merging.
    T[] helper = (T[]) new Object[values.length];
    mergeSort(values, helper, 0, values.length - 1, order);
  }

  private <T> void mergeSort(T[] values, T[] helper, int low, int high, Comparator<? super T> order) {
    if (low < high) {
      int mid = (low + high) / 2;
      mergeSort(values, helper, low, mid, order);
      mergeSort(values, helper, mid + 1, high, order);
      merge(values, helper, low, mid, high, order);
    }
  }

  private <T> void merge(T[] values, T[] helper, int low, int mid, int high, Comparator<? super T> order) {
    // Copy both halves into the helper array
    for (int i = low; i <= high; i++) {
      helper[i] = values[i];
    }

    int helperLeft = low;
    int helperRight = mid + 1;
    int current = low;

    // Iterate through helper array and copy the smaller element from either left or
    // right side back into the original array
    while (helperLeft <= mid && helperRight <= high) {
      if (order.compare(helper[helperLeft], helper[helperRight]) <= 0) {
        values[current] = helper[helperLeft];
        helperLeft++;
      } else {
        values[current] = helper[helperRight];
        helperRight++;
      }
      current++;
    }

    // Copy the rest of the left side of the array into the target array
    int remaining = mid - helperLeft;
    for (int i = 0; i <= remaining; i++) {
      values[current + i] = helper[helperLeft + i];
    }
    // Note: No need to copy the right side because it's already in place.
  }
} // class MergeSort
