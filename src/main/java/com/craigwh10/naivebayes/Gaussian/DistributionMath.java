package com.craigwh10.naivebayes.Gaussian;

import com.craigwh10.naivebayes.Math.MathUtils;

// Final to prevent inheritance.
public final class DistributionMath {
    static public double mean (double[] data) {
        if (!(data instanceof double[])) {
            throw new IllegalArgumentException(
                    "Entries must be double values only."
            );
        }

        double acc = MathUtils.sumOf(
                data,
                (val) -> val
        );

        // Casting length to double.
        return acc / (double) data.length;
    }

    static public double sampleVariance (double[] data) {
        double mean = mean(data);

        double standardDeviation = MathUtils.sumOf(data, (value) -> {
            double deviation = value - mean;
            return Math.pow(deviation, 2);
        });

        return standardDeviation / (data.length - 1);
    }

    static public double deviation (double[] data) {
        double mean = mean(data);

        return MathUtils.sumOf(data, (value) -> value - mean);
    }

    /**
     * P(x_i | C_k)
     * P(predictor | prior_val) = 1/sqrt(2pi*variance_prior)*exp(-{deviation_of_prior_to_posterior_mean}^2/(2*posterior_var)
     * @param predictor - value to predict likelihood of
     * @param priorData - data to use for likelihood estimate
     * @return likelihood of predictor occurring given dataset.
     */
    static public double likelihood (double predictor, double[] priorData) {
        double priorVariance = sampleVariance(priorData);
        double priorDevianceToPredictor = -Math.pow((predictor - mean(priorData)), 2);

        double coefficient = Math.pow(Math.sqrt(2*Math.PI*priorVariance), -1);
        double exponent = Math.exp(priorDevianceToPredictor/(2*priorVariance));
        return coefficient * exponent;
    }
}
