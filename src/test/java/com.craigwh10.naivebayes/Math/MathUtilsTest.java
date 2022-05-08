package com.craigwh10.naivebayes.Math;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class MathUtilsTest {
    @Test
    void shouldSumADoubleArrayWithSimpleReducer () {
        assertThat(MathUtils.sumOf(new double[]{1,2,3,4,5}, (val) -> val)).isEqualTo(15);
    }

    @Test
    void shouldNegativeSumADoubleArrayWithSimpleReducer () {
        assertThat(MathUtils.sumOf(new double[]{1,2,3,4,5}, (val) -> -val)).isEqualTo(-15);
    }

    @Test
    void shouldMultiplyASeriesOfResults () {
        assertThat(MathUtils.productOf(new double[]{1,2,3,4,5}, (val) -> val)).isEqualTo(120);
    }

    @Test
    void shouldNegativeMultiplyASeriesOfEvenResults () {
        // - + > -
        assertThat(MathUtils.productOf(new double[]{1,2,3,4,5}, (val) -> -val)).isEqualTo(-120);
    }

    @Test
    void shouldNegativeMultiplyASeriesOfOddResults () {
        // - + - > +
        assertThat(MathUtils.productOf(new double[]{1,2,3,4,5,2}, (val) -> -val)).isEqualTo(240);
    }
}
