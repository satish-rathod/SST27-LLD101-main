package com.example.video;
import java.nio.file.Path;

/** Facade for video processing pipeline. */
public class VideoProcessorFacade {
    private Decoder decoder = new Decoder();
    private FilterEngine filterEngine = new FilterEngine();
    private Encoder encoder = new Encoder();
    private LegacySharpen legacySharpen = new LegacySharpen();

    /**
     * Decodes, applies grayscale, scales, sharpens, and encodes video.
     * @param input input video file
     * @param output output video file
     * @param sharpenStrength strength for legacy sharpen
     * @return output file path
     */
    public Path process(Path input, Path output, int sharpenStrength) {
        Frame[] frames = decoder.decode(input);
        frames = filterEngine.grayscale(frames);
        frames = filterEngine.scale(frames, 0.5);
        // Simulate legacy API: convert frames to handle, apply, then back
        String handle = framesToHandle(frames);
        handle = legacySharpen.applySharpen(handle, sharpenStrength);
        frames = handleToFrames(handle, frames.length);
        return encoder.encode(frames, output);
    }

    // Simulate conversion for legacy API
    private String framesToHandle(Frame[] frames) {
        return "HANDLE:" + frames.length;
    }
    private Frame[] handleToFrames(String handle, int n) {
        // Just return n dummy frames for demo
        Frame[] frames = new Frame[n];
        for (int i = 0; i < n; i++) frames[i] = new Frame(1920, 1080);
        return frames;
    }
}
