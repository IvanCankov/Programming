package graphics;

import static Test.src.Parameters.SCENT_DISPLAY_MULTIPLIER;

import Test.src.*;
import Test.src.Dimension;

import java.awt.*;

/** stores data needed for drawing
 * Field can't be used for drawing directly as the GUI runs on a different thread
 * which causes an issue with some iterators of Field.
 * So this class stores the data needed for drawing in an intermediate, fixed size array
 * @author Mathias Engel
 */
public class DrawData {
    private final Color[][] colors;
    private final Field field;

    public DrawData(Field field) {
        this.field = field;
        int xDim = this.field.getDimension().width();
        int yDim = this.field.getDimension().height();
        colors = new Color[yDim][xDim];
        // init colors
        for (int y = 0; y < yDim; y++) {
            for (int x = 0; x < xDim; x++) {
                this.setColor(x, y, Color.BLACK);
            }
        }
    }

    public Dimension getDimension() {
        return field.getDimension();
    }

    public Color getColor(int x, int y) {
        return colors[y][x];
    }

    private void setColor(int x, int y, Color color) {
        Position pos = field.wrapPosition(new Position(x, y));
        this.colors[pos.y()][pos.x()] = color;
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

        // color obstacles
        for (Obstacle o : field.getObstacles())
        {
            for (int i = o.getObstacleTopLeft().x(); i <= o.getObstacleBotRight().x(); i++)
            {
                for (int j = o.getObstacleTopLeft().y(); j <= o.getObstacleBotRight().y(); j++)
                {
                    setColor(i, j, Color.GRAY);
                }
            }
        }
    }
}
