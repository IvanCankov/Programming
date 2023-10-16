package graphics;

import Test.src.Field;
import javax.swing.*;

public class Display
{
    private JFrame mainFrame;
    private PixelPanel pixelPanel;

    private Field field;

    public Display(int scale, Field field)
    {
        this.field = field;
        mainFrame = new JFrame("My First GUI");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(field.getDimension().width()*scale, field.getDimension().height()*scale);
        pixelPanel = new PixelPanel(scale, this.field);
        mainFrame.add(pixelPanel);
    }

    public void showFrame()
    {
        mainFrame.setVisible(true);
    }

    public void refresh() {
        //pixelPanel.spawnAnt(field.getAntHill().getPosition().x(), field.getAntHill().getPosition().y());
        pixelPanel.repaint();
    }
}