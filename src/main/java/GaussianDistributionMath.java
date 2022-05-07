public class GaussianDistributionMath {
    interface DoubleFunction {
        double callback(double value);
    }

    private double sumOf (double[] data, DoubleFunction method) {
        int dataLength = data.length;
        double sumOf = 0;

        for (int idx = 0; idx < dataLength; idx++) {
            sumOf += method.callback(data[idx]);
        };

        return sumOf;
    }

    public double mean (double[] data) {
        if (!(data instanceof double[])) {
            throw new IllegalArgumentException(
                    "Entries must be float values only."
            );
        }

        double acc = sumOf(
                data,
                (val) -> val
        );

        // Casting length to double.
        return acc / (double) data.length;
    }

    public double sampleVariance (double[] data) {
        double mean = mean(data);

        double standardDeviation = sumOf(data, (value) -> {
            double deviation = value - mean;
            return Math.pow(deviation, 2);
        });

        return standardDeviation / (data.length - 1);
    }
}
