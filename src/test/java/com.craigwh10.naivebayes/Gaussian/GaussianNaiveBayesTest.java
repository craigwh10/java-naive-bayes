package com.craigwh10.naivebayes.Gaussian;

import com.craigwh10.naivebayes.Data.Csv;
import com.craigwh10.naivebayes.Math.MathUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GaussianNaiveBayesTest {
    @Test
    void shouldGenerateClassifierForPredictor () {
        assertThat(
            new GaussianNaiveBayes(
                new DistributionMath(),
                new MathUtils()
            ).classify(
        4, new double[]{1,2,3,4})
        )
        .isEqualTo(0.75);
    }

    @Test
    void shouldHandleCsvData () {
        Csv csv = new Csv("/Users/craigwhite/IdeaProjects/NaiveBayes/src/test/resources/coin_Solana.csv");

        csv.standardiseRows(10);
        csv.saveHeaderAndRemoveFromDataset();

        double[] closingValueColumn = csv.getColumnAsDoubles(6);

        assertThat(
                new GaussianNaiveBayes(
                        new DistributionMath(),
                        new MathUtils()
                ).classify(
                        // This predictor Ck, should be used to calculate
                        // P(Ck), which should be known from our priors.
                        0.3, closingValueColumn)
        ).isEqualTo(0.75);
    }
}
