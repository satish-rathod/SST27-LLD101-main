package com.example.imports;

import java.util.List;

public interface CsvReader {
    List<String[]> read(String filePath);
}