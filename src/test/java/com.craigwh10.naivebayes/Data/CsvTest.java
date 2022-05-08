package com.craigwh10.naivebayes.Data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CsvTest {
    String[] headers = new String[]{
            "SNo",
            "Name",
            "Symbol",
            "Date",
            "High",
            "Low",
            "Open",
            "Close",
            "Volume",
            "Marketcap"
    };

    @Test
    void shouldReturnCoinDataWithEmptyArrayAtStart () {
        Csv csv = new Csv("/Users/craigwhite/IdeaProjects/NaiveBayes/src/test/resources/coin_Solana.csv");

        assertThat(csv.file.get(0)).isEqualTo(new String[]{""});
    }

    @Test
    void shouldReturnCoinDataWithNoEmptyArrayAtStart () {
        Csv csv = new Csv("/Users/craigwhite/IdeaProjects/NaiveBayes/src/test/resources/coin_Solana.csv");

        csv.standardiseRows(10);

        assertThat(csv.file.get(0)).isNotEqualTo(new String[]{""});
    }

    @Test
    void firstRowShouldBeColumnNamesAfterStandardising () {
        Csv csv = new Csv("/Users/craigwhite/IdeaProjects/NaiveBayes/src/test/resources/coin_Solana.csv");

        csv.standardiseRows(10);

        assertThat(csv.getFirstRow()).isEqualTo(headers);
    }

    @Test
    void shouldMakeHeaderAccessibleWhenRemoved () {
        Csv csv = new Csv("/Users/craigwhite/IdeaProjects/NaiveBayes/src/test/resources/coin_Solana.csv");

        csv.standardiseRows(10);

        assertThat(csv.headers).isEqualTo(null);

        csv.saveHeaderAndRemoveFromDataset();

        assertThat(csv.headers).isEqualTo(headers);
    }

    @Test
    void columnsShouldBeReturnable () {
        Csv csv = new Csv("/Users/craigwhite/IdeaProjects/NaiveBayes/src/test/resources/coin_Solana.csv");

        csv.standardiseRows(10);
        csv.saveHeaderAndRemoveFromDataset();

        assertThat(csv.getColumn(1)[0]).isEqualTo("Solana");
        assertThat(csv.getColumn(1)[140]).isEqualTo("Solana");
        assertThat(csv.getColumn(1)[249]).isEqualTo("Solana");
    }

    @Test
    void shouldBeAbleToReturnColumnsAsDoubles () {
        Csv csv = new Csv("/Users/craigwhite/IdeaProjects/NaiveBayes/src/test/resources/coin_Solana.csv");

        csv.standardiseRows(10);
        csv.saveHeaderAndRemoveFromDataset();

        String[] stringColumn = csv.getColumn(6);

        assertThat(stringColumn[0]).isEqualTo("0.95105395758");
        double[] numericalStringColumn = csv.getColumnAsDoubles(6);

        assertThat(numericalStringColumn[0]).isEqualTo(0.95105395758);
    }

    @Test
    void shouldThrowIfFileNotFound () {
        try {
            new Csv("invalid.txt");
        } catch (RuntimeException err) {
            assertThat(err).isNotNull();
        }
    }
}
