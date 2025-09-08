package com.example.report;
import java.nio.file.*; import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<String,Object> data = Map.of("name", "Quarterly");
        Path zip = ReportBundleFacade.export(
            data,
            Path.of("out"),
            "report",
            Path.of("out", "report.zip")
        );
        System.out.println("DONE " + zip);
    }
}
