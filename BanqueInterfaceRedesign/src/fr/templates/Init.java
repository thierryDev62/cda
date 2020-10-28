package fr.templates;

import java.awt.*;

public class Init {
    private final Font DEFAULT_FONT = new Font("Verdana", Font.BOLD, 16);
    private final Font TITRE_FONT = new Font("Verdana", Font.BOLD, 30);

    public Font getDefaultFont() {
        return DEFAULT_FONT;
    }

    public Font getTitreFont() {
        return TITRE_FONT;
    }
}
