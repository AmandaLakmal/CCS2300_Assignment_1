package module_2;

public class BubbleSort {
    public static long sortAndMeasure(int[] arr) {
        int[] data = arr.clone(); 
        long startTime = System.nanoTime();
        
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        
        long endTime = System.nanoTime();
        return endTime - startTime; 
    }
}