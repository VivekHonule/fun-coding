package com.arrayrotation;

import com.arrayrotation.ArrayRotation;

/*
  Time complexity o(n+d)
  Auxiliary space complexity o(1)
   */
public class TempArrayAlgorithm implements ArrayRotation {
    @Override
    public void rotateArray(int[] arr, int length, int digitsToRotate) {
        int[] auxiliaryArr = new int[digitsToRotate];
        for (int i = 0; i < length; i++) {
            if (i < digitsToRotate) {
                auxiliaryArr[i] = arr[i];
                continue;
            }
            arr[i - digitsToRotate] = arr[i];
        }
        int idx = length - digitsToRotate;
        for (int i = 0; i < digitsToRotate; i++) {
            arr[idx++] = auxiliaryArr[i];
        }
    }
}
