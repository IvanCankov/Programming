package graphics;

import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import Test.src.Field;
import Test.src.Position;

public class PixelPanel extends JPanel {
    private final int scale; // pixel scale

    private Field field; // contains the data needed for drawing

    public PixelPanel(int scale, Field field) {
        this.field = field;
        if (scale > 0) {
            this.scale = scale;
        } else {
            this.scale = 1;
        }
    }

    // refresh/redraw panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw background: scent trail
        for (int y = 0; y < field.getDimension().height(); y++) {
            for (int x = 0; x < field.getDimension().width(); x++) {
                float scent = field.getScentTrail(new Position(x, y));
                int intensity = (int) (Math.tanh(scent)*255F);
                g.setColor(new Color(0, intensity, intensity));
                g.fillRect(x * scale, y * scale, scale, scale);
            }
        }
        // draw ants
        g.setColor(Color.BLUE);
        for (Position pixel : field.getAntPositions()) {
            int x = pixel.x();
            int y = pixel.y();
            g.fillRect(x * scale, y * scale, scale, scale);
        }
        // draw food sources
        g.setColor(Color.RED);
        for (Position pixel : field.getFoodSourcePositions()) {
            int x = pixel.x();
            int y = pixel.y();
            g.fillRect(x * scale, y * scale, scale, scale);
        }
        // draw ant hill
        g.setColor(Color.GREEN);
        {
            int x = field.getAntHillPosition().x();
            int y = field.getAntHillPosition().y();
            g.fillRect(x * scale, y * scale, scale, scale);
        }
    }
}
