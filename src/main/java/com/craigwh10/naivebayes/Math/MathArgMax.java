package com.craigwh10.naivebayes.Math;

import java.util.ArrayList;

/**
 * <b>argmax(<g(x))</b>
 * <br/>
 * Gets the passed parameter x that maximises g(x).
 * -
 * <a href="https://machinelearningmastery.com/argmax-in-machine-learning/#:~:text=Argmax%20is%20an%20operation%20that,function%20is%20preferred%20in%20practice.">Definition</a>
 */
public final class MathArgMax {
    static public double calculate (double[] values, MathUtils.DoubleFunction method) {
        double maxValue = 0;
        double maximisingParameter = 0;

        for (int idx = 0; idx < values.length; idx++) {
            double result = method.callback(values[idx]);

            if (result > maxValue) {
                maxValue = result;
                maximisingParameter = values[idx];
            }

        }

        return maximisingParameter;
    }
}
