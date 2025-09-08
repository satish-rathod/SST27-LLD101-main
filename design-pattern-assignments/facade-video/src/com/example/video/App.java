package com.example.video;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        VideoProcessorFacade facade = new VideoProcessorFacade();
        Path out = facade.process(Path.of("in.mp4"), Path.of("out.mp4"), 5);
        System.out.println("Wrote " + out);
    }
}
