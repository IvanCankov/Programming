package Test.src;

import java.util.Stack;

public class AntPath {
    private Ant ant;
    private Stack<Position> path;
    private FoodSource reachedFood;

    public AntPath(Ant ant)
    {
        this.ant = ant;
        path = new Stack<>();
        reachedFood = null;
    }

    public Ant getAnt() {
        return ant;
    }

    public Stack<Position> getPath() {
        return path;
    }

    public FoodSource getReachedFood() {
        return reachedFood;
    }

    public boolean isComplete() {
        return reachedFood != null;
    }

    public void addMovement(Position p)
    {
        path.push(p);
    }

    public void setCompleted(FoodSource food)
    {
        reachedFood = food;
    }

    public int getPathCost()
    {
        return path.size();
    }
}
