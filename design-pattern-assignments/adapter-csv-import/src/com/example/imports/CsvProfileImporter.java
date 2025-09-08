package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = csvReader;
        this.profileService = profileService;
    }

    @Override
    public int importFrom(Path csvFile) {
        int count = 0;
        List<String[]> rows = csvReader.read(csvFile);
        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);
            if (row.length < 2) {
                System.out.println("Row " + (i+1) + ": Skipped (missing id/email)");
                continue;
            }
            String id = row[0];
            String email = row[1];
            String displayName = row.length > 2 ? row[2] : "";
            try {
                Objects.requireNonNull(id, "id");
                Objects.requireNonNull(email, "email");
                if (!email.contains("@")) throw new IllegalArgumentException("bad email");
                profileService.createProfile(id, email, displayName);
                count++;
            } catch (Exception e) {
                System.out.println("Row " + (i+1) + ": Skipped (" + e.getMessage() + ")");
            }
        }
        return count;
    }
}
