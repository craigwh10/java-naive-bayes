package com.craigwh10.naivebayes.Gaussian;

import com.craigwh10.naivebayes.Math.MathUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GaussianNaiveBayesTest {
    @Test
    void shouldGenerateClassifierForPredictor () {
        /**
         * Given two
         */
        assertThat(
            new GaussianNaiveBayes(
                new DistributionMath(),
                new MathUtils()
            ).classify(
        4, new double[]{1,2,3,4})
        )
        .isEqualTo(0.75);
    }
}
