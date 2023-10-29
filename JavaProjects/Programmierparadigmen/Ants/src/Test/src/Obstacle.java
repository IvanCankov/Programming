package Test.src;

// Class written by Ion Mihaescu unless otherwise noted
public class Obstacle extends FieldObj
{
    private ThreeDimension size;
    private double shapeFactor;

    /**
     * @param pos denotes center of object
     */
    public Obstacle(Position pos, ThreeDimension size, double shapeFactor) {
        this.position = pos;
        this.size = size;
        this.shapeFactor = shapeFactor;
    }

    public ThreeDimension getDimension() {
        return size;
    }

    public double getAvgScaleCost()
    {
        return (getCuboidScaleCost() * shapeFactor) + (getPyramidScaleCost() * shapeFactor);
    }

    public int getAvgPassCost()
    {
        return size.sideLength() * 2;
    }

    private int getCuboidScaleCost()
    {
        /* Obstacle is perfect cuboid:
            Distance to top = height
            Total travelling: 2 x DTT + length
        */
        return size.height() + size.sideLength() + size.height();
    }

    private double getPyramidScaleCost()
    {
        /* Obstacle is perfect pyramid:
            Distance to top = sqrt( length^2 + height^2 )
            Total travelling: 2 x DTT
        */
        double distToTop = Math.sqrt( (size.sideLength()^2) + (size.height()^2) );
        return distToTop * 2;
    }

    private int getHalfSide()
    {
        if (size.sideLength() % 2 == 0)
        {
            return (size.sideLength() / 2) - 1;
        }
        else
        {
            return size.sideLength() / 2;
        }
    }

    public Position getObstacleTopLeft()
    {
        int x = position.x() - getHalfSide();
        int y = position.y() - getHalfSide();
        return new Position(x, y);
    }

    public Position getObstacleBotRight()
    {
        int x = position.x() + getHalfSide();
        int y = position.y() + getHalfSide();
        return new Position(x, y);
    }
}
