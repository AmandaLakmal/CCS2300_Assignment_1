package module_2;

public class performanceUtils {
    public static void displayComparisonTable(long bubbleTime, long mergeTime, long quickTime) {
        System.out.println("\n======================================================");
        System.out.println("             PERFORMANCE COMPARISON TABLE             ");
        System.out.println("======================================================");
        System.out.printf("%-25s | %-25s%n", "Sorting Algorithm", "Execution Time (ns)");
        System.out.println("------------------------------------------------------");
        System.out.printf("%-25s | %-25d%n", "Bubble Sort", bubbleTime);
        System.out.printf("%-25s | %-25d%n", "Merge Sort", mergeTime);
        System.out.printf("%-25s | %-25d%n", "Quick Sort", quickTime);
        System.out.println("======================================================");

        // Highlight the fastest algorithm
        long minTime = Math.min(bubbleTime, Math.min(mergeTime, quickTime));
        String fastest = "";
        if (minTime == bubbleTime) fastest = "Bubble Sort";
        else if (minTime == mergeTime) fastest = "Merge Sort";
        else fastest = "Quick Sort";

        System.out.println("Fastest Algorithm is: " + fastest);
        System.out.println("======================================================\n");
    }
}
