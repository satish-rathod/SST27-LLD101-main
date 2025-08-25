public class Player {
    private Frame last;
    private final Decoder decoder;
    private final PlayerUI ui;

    public Player(Decoder decoder, PlayerUI ui) {
        this.decoder = decoder;
        this.ui = ui;
    }

    public void play(byte[] fileBytes) {
        Frame f = decoder.decode(fileBytes);
        last = f;
        ui.showPlaying(f);
        ui.showCacheStatus(last != null);
    }
}

interface Decoder {
    Frame decode(byte[] fileBytes);
}

class SimpleDecoder implements Decoder {
    public Frame decode(byte[] fileBytes) {
        return new Frame(fileBytes); // pretend decoding
    }
}

interface PlayerUI {
    void showPlaying(Frame f);
    void showCacheStatus(boolean cached);
}

class ConsolePlayerUI implements PlayerUI {
    public void showPlaying(Frame f) {
        System.out.println("\u25B6 Playing " + (f != null ? f.getSize() : 0) + " bytes");
    }
    public void showCacheStatus(boolean cached) {
        System.out.println("Cached last frame? " + cached);
    }
}