package com.arrayrotation;

public interface ArrayRotation {
    int JUGLING_ALGORITHM = 1;
    int TEMP_ARRAY = 2;
    int TEMP_VARIABLE = 3;

    void rotateArray(int[] arr, int length, int digitsToRotate);
}
