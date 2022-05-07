package com.craigwh10.naivebayes.Math;

import java.util.ArrayList;

/**
 * argmax(g(x))
 * -
 * <a href="https://machinelearningmastery.com/argmax-in-machine-learning/#:~:text=Argmax%20is%20an%20operation%20that,function%20is%20preferred%20in%20practice.">Definition</a>
 */
public final class MathArgMax {
    public int index;
    public double value;

    public MathArgMax (double[] values, MathUtils.DoubleFunction method) {
        calculate(values, method);
    }

    private void calculate (double[] values, MathUtils.DoubleFunction method) {
        ArrayList<Double> results = new ArrayList<Double>();

        for (int idx = 0; idx < values.length; idx++) {
            double result = method.callback(values[idx]);

            results.add(result);
        }

        double maxValue = results.stream().mapToDouble(Double::doubleValue).max().getAsDouble();

        // Cast so can interact with ArrayList.
        Double maxAsDouble = (Double) maxValue;
        int maxValueIndex = results.indexOf(maxAsDouble);

        this.index = maxValueIndex;
        this.value = maxValue;
    }
}
