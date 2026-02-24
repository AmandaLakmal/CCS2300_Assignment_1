package module_2;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DataSorter {
    public void runModule(){
        Scanner scanner = new Scanner(System.in);
        boolean runnig = true;

        while(runnig){
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
            }
        }
    }
}