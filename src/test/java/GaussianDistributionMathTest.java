import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GaussianDistributionMathTest {

    @Test
    void shouldProduceRoundedMean () {
        assertEquals(new GaussianDistributionMath().mean(new double[]{1,2,3,4,5}), 3);
    }

    @Test
    void shouldAutoBoxCharacterInputs () {
        // e = 101
        assertEquals(new GaussianDistributionMath().mean(new double[]{1,2,3,4,'e'}), 22.2);
    }

    @Test
    void shouldCalculateAccurateSampleVariance () {
        assertEquals(
                new GaussianDistributionMath().sampleVariance(new double[]{1,2,3,4,5}), 2.5
        );
    }

    // This is not desirable but is a property of auto-boxing chars to numbers.
    @Test
    void shouldCalculateAccurateSampleVarianceWithCharacters () {
        assertEquals(
                Math.round(new GaussianDistributionMath().sampleVariance(new double[]{1,2,3,4,5,'e'})), 1603
        );
    }
    // Validated with https://www.wolframalpha.com/input?i=variance+of+%7B1%2C2%2C3%2C4%2C5%2C+101%7D

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