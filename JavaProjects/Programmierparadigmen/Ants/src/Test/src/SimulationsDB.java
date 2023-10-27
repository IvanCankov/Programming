package Test.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class SimulationsDB {

    private static HashSet<AntPath> runningPaths = new HashSet<>();
    private static ArrayList<AntPath> finishedPaths = new ArrayList<>();

    public static void initDb(Field f)
    {
        for (Ant a: f.getAnts()) {
            runningPaths.add(new AntPath(a));
        }
    }

    private static AntPath getAntPathByAnt(Ant a)
    {
        for (AntPath path :
                runningPaths) {
            if (path.getAnt().equals(a))
            {
                return path;
            }
        }
        return null;
    }

    public static void addMovement(Ant a, Position p)
    {
        AntPath pathToUpdate = getAntPathByAnt(a);
        if (pathToUpdate != null && !pathToUpdate.isComplete()) {
            pathToUpdate.addMovement(p);
        }

    }

    public static void registerFoodFound(Ant a, FoodSource food)
    {
        AntPath pathToUpdate = getAntPathByAnt(a);
        if (pathToUpdate != null) {
            pathToUpdate.setCompleted(food);
            runningPaths.remove(pathToUpdate);
            finishedPaths.add(pathToUpdate);
        }
    }

    public static HashMap<AntPath, Integer> getPathsWithCost(Ant a)
    {
        HashMap<AntPath, Integer> pathsWithCost = new HashMap<>();
        for (AntPath finishedPath : finishedPaths) {
            if (finishedPath.getAnt().equals(a))
            {
                pathsWithCost.put(finishedPath, finishedPath.getPathCost());
            }
        }
        return pathsWithCost;
    }

    public static AntPath getBestPath(FoodSource food)
    {
        if (finishedPaths.size() == 0) return null;
        AntPath bestPath = finishedPaths.get(0);
        for (AntPath finishedPath : finishedPaths) {
            if (finishedPath.getReachedFood().equals(food))
            {
                if (finishedPath.getPathCost() < bestPath.getPathCost())
                {
                    bestPath = finishedPath;
                }
            }
        }
        return bestPath;
    }

}
