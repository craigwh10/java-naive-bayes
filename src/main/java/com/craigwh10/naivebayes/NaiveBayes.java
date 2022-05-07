package com.craigwh10.naivebayes;

import com.craigwh10.naivebayes.Gaussian.GaussianNaiveBayes;

/**
 Bayes Rule:
 P(c|x) =  P(x|c) * P(c)
           ------------
              p(x)

 P(c|x) = posterior probability
 Probability of c occurring given x has already
 occurred.

 P(x|c) likelihood of prior given class
 Probability of x occurring given c has already occurred.
 P(c) prior probability (class)
 P(x) prior probability (predictor)

 Naive Bayes: [Gaussian, Multinomial & Bernoulli]

 Gaussian - features with normal distribution (a feature is something that can be categorised)
 Multinomial - discrete counts, how often something will occur.
 Bernoulli - binary feature vectors, something will occur and not occur.

 - Convert dataset into frequency table
 - Create likelihood table
 -
 -

 **/

public class NaiveBayes {
    private GaussianNaiveBayes gaussianNaiveBayes;

    public NaiveBayes (GaussianNaiveBayes gaussianNaiveBayes) {
        this.gaussianNaiveBayes = gaussianNaiveBayes;
    }

    public void gaussian () {

    }
}
