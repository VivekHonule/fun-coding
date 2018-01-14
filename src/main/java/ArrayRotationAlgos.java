import java.util.Scanner;

public class ArrayRotationAlgos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strElements = scanner.nextLine();
        int[] elements = getIntArray(strElements);
        String strDigits = scanner.nextLine();
        int digits = Integer.parseInt(strDigits);
        String strategy = scanner.nextLine();
        decideStrategy(elements, digits, strategy);
        printArr(elements);
    }

    private static void decideStrategy(int[] elements, int digits, String strategy) {
        if (strategy.equals("o(n*d)")) {
            rotateArrayOneByOne(elements, elements.length,digits);
        } else if (strategy.equals("o(n+d)")) {
            rotateArray(elements, elements.length, digits);
        } else {
            throw new IllegalStateException("this option is not supported");
        }
    }

    private static void printArr(int[] elements) {
        for (int element : elements) {
            System.out.println(element);
        }
    }

    /*
    Time complexity o(n*d)
    Auxiliary space complexity o(1)
     */
    private static void rotateArrayOneByOne(int[] elements, int length, int digit) {
        for (int j = 1; j <= digit; j++) {
            int temp = elements[0];
            for (int i = 1; i < length; i++) {
                elements[i - 1] = elements[i];
            }
            elements[length - 1] = temp;
        }
    }

    /*
    Time complexity o(n+d)
    Auxiliary space complexity o(d)
     */
    private static void rotateArray(int[] elements, int length, int digits) {
        int[] auxiliaryArr = new int[digits];
        for (int i = 0; i < length; i++) {
            if (i < digits) {
                auxiliaryArr[i] = elements[i];
                continue;
            }
            elements[i - digits] = elements[i];
        }
        int idx = length - digits;
        for (int i = 0; i < digits; i++) {
            elements[idx++] = auxiliaryArr[i];
        }
    }

    private static int[] getIntArray(String strElements) {
        String[] strArray = strElements.split(" ");
        int[] intArr = new int[strArray.length];
        int count = 0;
        for (String str : strArray) {
            int anInt = Integer.parseInt(str);
            intArr[count++] = anInt;
        }
        return intArr;
    }
}
