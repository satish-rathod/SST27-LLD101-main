
package com.example.render;

public class Glyph {
    private final char ch; // extrinsic
    private final TextStyle style; // intrinsic (shared)

    public Glyph(char ch, TextStyle style) {
        this.ch = ch;
        this.style = style;
    }

    public int drawCost() {
        return style.getSize() + (style.isBold() ? 10 : 0);
    }

    public char getCh() { return ch; }
    public TextStyle getStyle() { return style; }
}
