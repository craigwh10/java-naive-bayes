package com.craigwh10.naivebayes.Gaussian;

import com.craigwh10.naivebayes.Math.MathArgMax;
import com.craigwh10.naivebayes.Math.MathUtils;

final public class GaussianNaiveBayes {
    private final DistributionMath distributionMath;
    private final MathUtils mathUtils;

    public GaussianNaiveBayes (
            DistributionMath distributionMath,
            MathUtils mathUtils
    ) {
        this.distributionMath = distributionMath;
        this.mathUtils = mathUtils;
    }

    public double classify (double predictor, double[] priorData) {
        // P(i4 = 0 | prior) = P(i4) * PROD{ l(i0=0|prior=0)..l(i1=1|prior=0)
        // P(i4 = 1 | ..
        // P(i4 = 2
        double classifier = MathArgMax.calculate(new double[]{1/3, 1/8}, (value -> value * this.mathUtils.productOf(
                priorData, (prior) -> (
                this.distributionMath.likelihood(predictor, priorData)
        ))));

        return classifier;
    }
}
