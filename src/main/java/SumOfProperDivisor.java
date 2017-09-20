import java.util.Scanner;


public class SumOfProperDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();
        for (int i = 1; i <= noOfTestCases; i++) {
            int noOfElements = scanner.nextInt();
            scanner.nextLine();
            String elementsStr = scanner.nextLine();
            String[] elementsStrArr = elementsStr.split("\\s");
            int[] elements = convertToIntArray(elementsStrArr, noOfElements);
            int[] sumOfProperDivisors = calculateSumOfProperDivisors(elements, noOfElements);
            for (int sumOfProperDivisor : sumOfProperDivisors) {
                System.out.println(sumOfProperDivisor);
            }
        }
    }

    //comment
    private static int[] calculateSumOfProperDivisors(int[] elements, int noOfElements) {
        int[] sumOfProperDivisors = new int[noOfElements];
        for (int i = 0; i < noOfElements; i++) {
            int element = elements[i];
            int sumOfElement = calculateSumOfProperDivisors(element);
            sumOfProperDivisors[i] = sumOfElement;
        }
        return sumOfProperDivisors;
    }

    private static int calculateSumOfProperDivisors(int element) {
        int sum = 1;
        if (element == 0) {
            return 0;
        }
        for (int i = 2; i < element; i++) {
            sum = sum + (element % i == 0 ? i : 0);
        }
        return sum;
    }

    private static int[] convertToIntArray(String[] elementsStrArr, int noOfElements) {
        int[] elementsArr = new int[noOfElements];
        for (int i = 0; i < noOfElements; i++) {
            int element = Integer.parseInt(elementsStrArr[i]);
            elementsArr[i] = element;
        }
        return elementsArr;
    }
}
