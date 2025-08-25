public class Frame {
    byte[] data;
    public Frame(byte[] d) {
        this.data = d;
    }
    public int getSize() {
        return data != null ? data.length : 0;
    }
}
