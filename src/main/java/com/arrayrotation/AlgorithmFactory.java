package com.arrayrotation;

public class AlgorithmFactory {

    public static ArrayRotation createAlgorithm(int strategy) {
        if (strategy == ArrayRotation.JUGLING_ALGORITHM) {
            return new JuglingAlgorithm();
        } else if (strategy == ArrayRotation.TEMP_ARRAY) {
            return new TempArrayAlgorithm();
        } else if (strategy == ArrayRotation.TEMP_VARIABLE) {
            return new TempVariableAlgorithm();
        } else {
            throw new IllegalArgumentException("Invalid strategy");
        }
    }
}
