package com.example.report;

import java.nio.file.Path;
import java.util.Map;

public class ReportBundleFacade {
    public static Path export(Map<String, Object> data, Path outDir, String fileName, Path zipPath) {
        JsonWriter jw = new JsonWriter();
        Zipper z = new Zipper();
        AuditLog log = new AuditLog();
        Path json = jw.write(data, outDir, fileName);
        Path zip = z.zip(json, zipPath);
        log.log("exported " + zip);
        return zip;
    }
}
