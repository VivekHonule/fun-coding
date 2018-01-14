package com.arrayrotation;

import com.arrayrotation.ArrayRotation;

/**
 * Created by vivek on 7/1/18.
 * Array Rotation using jugling algorithm
 * Time complexity O(n)
 * Auxiliary space complexity O(1)
 * above complexity is excluding gcd function
 */
public class JuglingAlgorithm implements ArrayRotation {

    @Override
    public void rotateArray(int[] arr, int length, int digitsToRotate) {
        int gcd = gcd(length, digitsToRotate);
        for (int i = 0; i < gcd; i++) {
            int moveTo = length - digitsToRotate + i;
            int moveThis = arr[i];
            while (moveTo >= 0) {
                int temp = arr[moveTo];
                arr[moveTo] = moveThis;
                moveTo = moveTo - digitsToRotate;
                moveThis = temp;
            }
        }
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
