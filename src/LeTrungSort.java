import java.util.Comparator;

/**
 * Custom sort using insertion sort
 *
 * @author Trung Le
 */

public class LeTrungSort implements Sorter {

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
	LeTrungSort() {
	} // LeTrungSort()

	// +---------+-----------------------------------------------------
	// | Methods |
	// +---------+

	@Override
	public <T> void sort(T[] values, Comparator<? super T> order) {
		int size = values.length;

		for (int step = 0; step < size - 1; step++) {
			int min_idx = step;

			for (int i = step + 1; i < size; i++) {
				if (order.compare(values[i], values[min_idx]) < 0) {
					min_idx = i;
				}
			}

			T temp = values[step];
			values[step] = values[min_idx];
			values[min_idx] = temp;
		}
	} // sort(T[], Comparator<? super T>
} // class MergeSort
