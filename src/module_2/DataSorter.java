package module_2;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DataSorter {
    public void runModule(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("\n=== Module 2: Sorting Algorithm Comparison Tool ===");
            System.out.println("1. Enter number manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Return to main menu / Exit");
            System.out.println("Choose an option : ");

            int choice = scanner.nextInt();
            int[] data = null;

            if (choice == 1) {
                System.out.println("How many numbers do you want to enter?");
                int size = scanner.nextInt();
                data = new int[size];
                System.out.println("Enter your " + size + " numbers:");
                for (int i = 0; i < size; i++) {
                    data[i] = scanner.nextInt();
                }
            } else if (choice == 2) {
                System.out.println("Enter the size of the random dataset: ");   
                int size = scanner.nextInt();
                data = new int[size];
                Random rand = new Random();
                for (int i = 0; i < size; i++) {
                    data[i] = rand.nextInt(1000); // 0-999 amoung random numbers will be generated
                }      
                System.out.println("Successfully generated " + size + " random numbers.");   
            } else if (choice == 3) {
                running = false;
                continue;
                } else {
                    System.out.println("Invalid choice. Please try again.");    
                    continue;
            }
            
            if (data != null && data.length > 0) {
                // Show a preview of the sorted output
                int[] sortedData = data.clone();
                Arrays.sort(sortedData);
                if (sortedData.length <= 20) {
                    System.out.println("\nSorted Output: " + Arrays.toString(sortedData));
                } else {
                    System.out.println("\nSorted Output: [Dataset too large to print on screen, but sorting was successful]");
                }

                // Run algorithms and collect execution times
                long bubbleTime = BubbleSort.sortAndMeasure(data);
                long mergeTime = MergeSort.sortAndMeasure(data);
                long quickTime = QuickSort.sortAndMeasure(data);

                // Draw the comparison table
                performanceUtils.displayComparisonTable(bubbleTime, mergeTime, quickTime);
            }
        }
    }
}