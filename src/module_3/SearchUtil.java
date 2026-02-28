package module_3;

/**
 * Utility class for searching algorithms.
 * Contains the implementation for Binary Search to be used in the Performance Analyzer.
 */
public class SearchUtil {

    /**
     * Performs a Binary Search on a sorted array of numbers.
     * * @param array  The sorted array of integers to search through.
     * @param target The number we are trying to find.
     * @return The index of the target if found, or -1 if not found.
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            // Find the middle element
            int mid = left + (right - left) / 2;

            // Check if the target is exactly in the middle
            if (array[mid] == target) {
                return mid; // Target found! Return its position.
            }

            // If target is greater than mid, it must be in the right half
            if (array[mid] < target) {
                left = mid + 1;
            } 
            // If target is smaller than mid, it must be in the left half
            else {
                right = mid - 1;
            }
        }

        // If the loop finishes and we haven't returned, the target isn't in the array
        return -1;
    }
}
