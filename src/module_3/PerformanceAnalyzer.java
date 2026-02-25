package module_3;

import module_2.BubbleSort;

/**
 * Analyzes and displays the time complexity and performance of algorithms.
 * This class fulfills the Module 3 requirement to measure execution time 
 * across different input sizes (100, 500, 1000) and displays the results 
 * in a formatted comparison table.
 */
public class PerformanceAnalyzer {

    /**
     * Runs the performance test for the searching algorithm (Binary Search).
     * Measures the execution time for locating an element in datasets of varying sizes.
     * The results are printed to the console in a tabular format.
     */
    public void analyzeSearchPerformance() {
        int[] sizes = {100, 500, 1000}; 
        
        System.out.println("--------------------------------------------------");
        System.out.println("   Search Algorithm Performance (Binary Search)   ");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-15s | %-20s\n", "Input Size (N)", "Execution Time (ns)");
        System.out.println("--------------------------------------------------");

        for (int size : sizes) {
            // Generate a sorted array required for Binary Search
            int[] data = generateSortedArray(size);
            
            // Select the last element as the target to test the worst-case scenario
            int target = data[data.length - 1];

            // Record the start time
            long startTime = System.nanoTime();
            
            // Execute the binary search
            SearchUtil.binarySearch(data, target);
            
            // Record the end time
            long endTime = System.nanoTime();

            // Calculate total execution duration
            long duration = endTime - startTime;
            
            // Display the performance metrics for the current input size
            System.out.printf("%-15d | %-20d\n", size, duration);
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Runs the performance test for the sorting algorithm (Bubble Sort).
     * Integrates Member 2's sorting implementation to measure execution time 
     * on datasets of varying sizes. The results are printed in a tabular format.
     */
    public void analyzeSortPerformance() {
        int[] sizes = {100, 500, 1000}; 
        
        System.out.println("\n--------------------------------------------------");
        System.out.println("    Sort Algorithm Performance (Bubble Sort)      ");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-15s | %-20s\n", "Input Size (N)", "Execution Time (ns)");
        System.out.println("--------------------------------------------------");

        for (int size : sizes) {
            // Generate an array in reverse order to test the worst-case scenario for Bubble Sort
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = size - i; 
            }

            // Execute Member 2's sorting method, which internally measures and returns the execution time
            long duration = BubbleSort.sortAndMeasure(data);

            // Display the performance metrics for the current input size
            System.out.printf("%-15d | %-20d\n", size, duration);
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Helper method to generate a sorted integer array.
     * * @param size The required number of elements in the array.
     * @return An array containing sequential integers from 1 to the specified size.
     */
    private int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1; 
        }
        return arr;
    }
}