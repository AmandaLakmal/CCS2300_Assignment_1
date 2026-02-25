package module_3;

/**
 * Analyzes and displays the time complexity and performance of algorithms.
 * Fulfills the Module 3 requirement to measure execution time across different input sizes.
 */
public class PerformanceAnalyzer {

    /**
     * Runs the performance test for the searching algorithm across different dataset sizes.
     * Displays the results in a tabular format.
     */
    public void analyzeSearchPerformance() {
        // The required input sizes for testing
        int[] sizes = {100, 500, 1000}; 
        
        System.out.println("--------------------------------------------------");
        System.out.println("   Search Algorithm Performance (Binary Search)   ");
        System.out.println("--------------------------------------------------");
        // Set up the table headers
        System.out.printf("%-15s | %-20s\n", "Input Size (N)", "Execution Time (ns)");
        System.out.println("--------------------------------------------------");

        // Loop through each size: 100, then 500, then 1000
        for (int size : sizes) {
            // 1. Generate a sorted array (Binary Search requires sorted data)
            int[] data = generateSortedArray(size);
            
            // We search for the very last item to test the "worst-case" scenario
            int target = data[data.length - 1];

            // 2. Start the timer!
            long startTime = System.nanoTime();
            
            // 3. Run the search
            SearchUtil.binarySearch(data, target);
            
            // 4. Stop the timer!
            long endTime = System.nanoTime();

            // Calculate how long it took
            long duration = endTime - startTime;

            // 5. Print the results as a row in our table
            System.out.printf("%-15d | %-20d\n", size, duration);
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Helper method to generate a sorted array of a specific size.
     * @param size The number of elements in the array.
     * @return A sorted integer array.
     */
    private int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1; // Fills array with 1, 2, 3... up to the size
        }
        return arr;
    }
}
