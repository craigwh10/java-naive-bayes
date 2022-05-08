package com.craigwh10.naivebayes.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Referenced from: <br/>
 * <a href="https://techvidvan.com/tutorials/read-csv-file-in-java/">External link</a>
 */
public class Csv {
    ArrayList<String[]> file;
    String[] headers;

    public void standardiseRows (int expectedColumns) {
        file = file.stream().filter((row) -> {
            return row.length == expectedColumns;
        }).collect(Collectors.toCollection(ArrayList::new));
    }

    public String[] getFirstRow () {
        return file.get(0);
    }

    public void removeRow (int idx) {
        file.remove(idx);
    }

    public void saveHeaderAndRemoveFromDataset () {
        headers = getFirstRow();
        removeRow(0);
    }

    public double[] getColumnAsDoubles (int idx) {
        String[] column = getColumn(idx);

        return Arrays.stream(column).mapToDouble(num -> Double.parseDouble(num)).toArray();
    }

    public String[] getColumn (int colIdx) {
        ArrayList<String> columnData = new ArrayList<String>();

        file.stream().forEach((row) -> {
            columnData.add(row[colIdx]);
        });

        return columnData.toArray(String[]::new);
    }

    public Csv (String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            ArrayList<String[]> result = new ArrayList<String[]>();
            
            String line = "";
            String splitBy = ",";

            do {
                String[] coin = line.split(splitBy);

                if (coin != null) {
                    result.add(coin);
                }
            } while ((line = br.readLine()) != null);

            file = result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
