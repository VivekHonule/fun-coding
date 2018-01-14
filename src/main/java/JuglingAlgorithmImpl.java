import java.util.Scanner;

/**
 * Created by vivek on 7/1/18.
 * Array Rotation using jugling algorithm
 * Time complexity O(n)
 * Auxiliary space complexity O(1)
 * above complexity is excluding gcd function
 */
public class JuglingAlgorithmImpl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputArr = scanner.nextLine();
        int[] intArray = getIntArray(inputArr);
        int digitsToRotate = Integer.parseInt(scanner.nextLine());
        rotateArray(intArray, intArray.length, digitsToRotate);
        printArr(intArray);
    }

    private static void rotateArray(int[] intArray, int length, int digitsToRotate) {
        int gcd = gcd(length, digitsToRotate);
        for (int i = 0; i < gcd; i++) {
            int moveTo = length - digitsToRotate + i;
            int moveThis = intArray[i];
            while (moveTo >= 0) {
                int temp = intArray[moveTo];
                intArray[moveTo] = moveThis;
                moveTo = moveTo - digitsToRotate;
                moveThis = temp;
            }
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
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

    private static void printArr(int[] elements) {
        for (int element : elements) {
            System.out.println(element);
        }
    }
}
