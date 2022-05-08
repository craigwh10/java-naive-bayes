package com.craigwh10.naivebayes.Math;

final public class MathUtils {
    public interface DoubleFunction {
        double callback(double value);
    }

    static public double sumOf(double[] data, DoubleFunction method) {
        int dataLength = data.length;
        double sumOf = 0;

        for (int idx = 0; idx < dataLength; idx++) {
            sumOf += method.callback(data[idx]);
        };

        return sumOf;
    }

    static public double productOf(double[] data, DoubleFunction method) {
        int dataLength = data.length;
        double productOf = 0;

        for (int idx = 0; idx < dataLength; idx++) {
            if (idx == 0) {
                productOf = method.callback(data[idx]);
            } else {
                productOf *= method.callback(data[idx]);
            }
        };

        return productOf;
    }
}
