package com.arrayrotation;

import com.arrayrotation.ArrayRotation;

/*
Time complexity o(n*d)
Auxiliary space complexity o(1)
 */
public class TempVariableAlgorithm implements ArrayRotation {
    @Override
    public void rotateArray(int[] arr, int length, int digitsToRotate) {
        for (int j = 1; j <= digitsToRotate; j++) {
            int temp = arr[0];
            for (int i = 1; i < length; i++) {
                arr[i - 1] = arr[i];
            }
            arr[length - 1] = temp;
        }
    }
}
