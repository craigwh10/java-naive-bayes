import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GaussianDistributionMathTest {

    @Test
    void shouldProduceRoundedMean () {
        assertEquals(GaussianDistributionMath.mean(new double[]{1,2,3,4,5}), 3);
    }

    @Test
    void shouldAutoBoxCharacterInputs () {
        // e = 101
        assertEquals(GaussianDistributionMath.mean(new double[]{1,2,3,4,'e'}), 22.2);
    }

    @Test
    void shouldCalculateAccurateSampleVariance () {
        assertEquals(
                GaussianDistributionMath.sampleVariance(new double[]{1,2,3,4,5}), 2.5
        );
    }

    // This is not desirable but is a property of auto-boxing chars to numbers.
    @Test
    void shouldCalculateAccurateSampleVarianceWithCharacters () {
        assertEquals(
                Math.round(GaussianDistributionMath.sampleVariance(new double[]{1,2,3,4,5,'e'})), 1603
        );
    }
    // Validated with https://www.wolframalpha.com/input?i=variance+of+%7B1%2C2%2C3%2C4%2C5%2C+101%7D

    @Test
    void shouldCalculateAccurateDeviation () {
        // x - 3
        // 1-3,2-3,3-3,4-3,5-3
        // -2,-1,0,1,2 = 0

        assertEquals(
            GaussianDistributionMath.deviation(new double[]{1,2,3,4,5}), 0
        );
    }
}

/**
 * Notes:
 *
 * double has higher precision,
 * whereas floats take up less memory and are faster.
 * In general you should use float unless you have a case where it isn't accurate enough.
 * On typical modern computers, double is just as fast as float.
 * -
 * Choice for double with it being a forecasting model, accuracy is valuable.
 */