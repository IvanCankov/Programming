package graphics;

import Test.src.*;

import java.lang.Math;
import javax.swing.*;
import java.awt.*;

import static Test.src.Parameters.SCENT_DISPLAY_MULTIPLIER;


public class PixelPanel extends JPanel {
    private final int scale; // pixel scale

    private final DrawData drawData; // contains the data needed for drawing

    public PixelPanel(int scale, DrawData drawData) {
        this.drawData = drawData;
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
        Color resetColor = new Color(11, 22, 33); // should not be used elsewhere
        Color lastColor;
        // draw colors
        // drawing rectangles by filling lines with same color if possible (optimisation)
        for (int y = 0; y < drawData.getDimension().height(); y++) {
            lastColor = resetColor;
            int xDelta = 0;
            for (int x = 0; x < drawData.getDimension().width(); x++) {
                Color nextColor = drawData.getColor(x, y);
                xDelta++;
                if (!nextColor.equals(lastColor)) {
                    g.setColor(lastColor);
                    g.fillRect((x-xDelta) * scale, y * scale, scale*xDelta, scale);
                    xDelta = 0;
                }
                lastColor = nextColor;
            }
            xDelta++;
            g.setColor(lastColor);
            g.fillRect((drawData.getDimension().width()-xDelta) * scale, y * scale, scale*xDelta, scale);
        }
    }
}
