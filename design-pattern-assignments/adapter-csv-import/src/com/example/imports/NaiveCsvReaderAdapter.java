package com.example.imports;

import java.util.ArrayList;
import java.util.List;

// Adapter class to allow NaiveCsvReader to be used where CsvReader is expected
public class NaiveCsvReaderAdapter implements CsvReader {
    private NaiveCsvReader naiveCsvReader = new NaiveCsvReader();

    @Override
    public List<String[]> read(String filePath) {
        List<List<String>> raw = naiveCsvReader.readCsv(filePath);
        List<String[]> result = new ArrayList<>();
        for (List<String> row : raw) {
            result.add(row.toArray(new String[0]));
        }
        return result;
    }
}
