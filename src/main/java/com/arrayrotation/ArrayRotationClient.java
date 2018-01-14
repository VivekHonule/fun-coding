package com.arrayrotation;

import java.util.Scanner;

public class ArrayRotationClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strElements = scanner.nextLine();
        int[] elements = getIntArray(strElements);
        String strDigits = scanner.nextLine();
        int digits = Integer.parseInt(strDigits);
        ArrayRotation algorithm = AlgorithmFactory.createAlgorithm(ArrayRotation.TEMP_ARRAY);
        algorithm.rotateArray(elements, elements.length, digits);
        printArr(elements);
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
