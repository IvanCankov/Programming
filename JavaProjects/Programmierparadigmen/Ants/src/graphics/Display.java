package graphics;

import Test.src.Field;

import javax.swing.*;

public class Display
{
    private final JFrame mainFrame;
    private final PixelPanel pixelPanel;

    public Display(int scale, DrawData drawData)
    {
        mainFrame = new JFrame("My First GUI");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(drawData.getDimension().width()*scale, drawData.getDimension().height()*scale);
        pixelPanel = new PixelPanel(scale, drawData);
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