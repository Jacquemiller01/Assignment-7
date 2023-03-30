import java.util.Random;

public class MergeSort {
  public static void main(String[] args) {

    Random rand = new Random();
    int[] numbers = new int[10];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(100);
    }

    System.out.println("Before:");
    printArray(numbers);

    mergeSort(numbers); 

    System.out.println("\nAfter:");
    printArray(numbers);
  }


  private static void mergeSort(int[] inputArray) {
    int inputLength = inputArray.length;
    
    if (inputLength < 2) {
      return;
    }
    
    int midIndex = inputLength / 2;
    int[] leftPiece = new int[midIndex];
    int[] rightPiece = new int[inputLength - midIndex];
    
    for (int i = 0; i < midIndex; i++) {
      leftPiece[i] = inputArray[i];
    }
    for (int i = midIndex; i < inputLength; i++) {
      rightPiece[i - midIndex] = inputArray[i];
    }
    
    mergeSort(leftPiece);
    mergeSort(rightPiece);

    merge(inputArray, leftPiece, rightPiece);
  }

  private static void merge (int[] inputArray, int[] leftPiece, int[] rightPiece) {
    int leftSize = leftPiece.length;
    int rightSize = rightPiece.length;
    
    int i = 0, j = 0, k = 0;
    
    while (i < leftSize && j < rightSize) {
      if (leftPiece[i] <= rightPiece[j]) {
        inputArray[k] = leftPiece[i];
        i++;
      }
      else {
        inputArray[k] = rightPiece[j];
        j++;
      }
      k++;
    }
    
    while (i < leftSize) {
      inputArray[k] = leftPiece[i];
      i++;
      k++;
    }
    
    while (j < rightSize) {
      inputArray[k] = rightPiece[j];
      j++;
      k++;
    }
    
  }

  private static void printArray(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
  }
}