package com.craigwh10.naivebayes.Math;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class MathArgMaxTest {

    @Test
    void shouldGetMaxArgAndIndexForFunctionWithArrayOfInputs () {
        assertThat(MathArgMax.calculate(new double[]{1,2,3,4,5}, (val) -> val * 2)).isEqualTo(5);
    }
}
