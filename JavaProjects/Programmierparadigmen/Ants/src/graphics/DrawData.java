package graphics;

import static Test.src.Parameters.SCENT_DISPLAY_MULTIPLIER;

import Test.src.Ant;
import Test.src.AntHill;
import Test.src.Field;
import Test.src.Position;
import Test.src.Dimension;
import java.awt.*;
public class DrawData {
    private final Color[][] colors;
    private final Field field;

    public DrawData(Field field) {
        this.field = field;
        int xDim = this.field.getDimension().width();
        int yDim = this.field.getDimension().height();
        colors = new Color[yDim][xDim];
    }

    public Dimension getDimension() {
        return field.getDimension();
    }

    public Color getColor(int x, int y) {
        return colors[y][x];
    }

    private void setColor(int x, int y, Color color) {
        this.colors[y][x] = color;
    }

    public void update() {
        AntHill antHill = field.getAntHill();
        // background: scent trail
        for (int y = 0; y < field.getDimension().height(); y++) {
            for (int x = 0; x < field.getDimension().width(); x++) {
                float scent = field.getScentTrail(new Position(x, y), antHill);
                int intensity = (int) (Math.tanh(scent*SCENT_DISPLAY_MULTIPLIER)*255F);
                setColor(x, y, new Color(0, intensity, intensity));
            }
        }
        // color of ants
        for (Ant ant: field.getAnts()) {
            int x = ant.getPosition().x();
            int y = ant.getPosition().y();
            switch (ant.getState()) {
                case ERKUNDUNG -> setColor(x, y, Color.ORANGE);
                case SUCHE     -> setColor(x, y, Color.BLUE);
                case BRINGT    -> setColor(x, y, Color.MAGENTA);
                case RETURNS    -> setColor(x, y, Color.WHITE);
            }
        }
        // color food sources
        for (Position pixel : field.getFoodSourcePositions()) {
            int x = pixel.x();
            int y = pixel.y();
            setColor(x, y, Color.RED);
        }
        // color ant hill
        {
            int x = field.getAntHillPosition().x();
            int y = field.getAntHillPosition().y();
            setColor(x, y, Color.GREEN);
        }
    }
}
