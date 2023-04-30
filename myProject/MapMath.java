package myProject;

import java.util.*;

public class MapMath {
    /**
     *
     * @param map
     * @return максимальное значение (value) коллекции map
     */
    public static int getMax(Map map) {
        int max = Integer.MIN_VALUE;
        int mapValue;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            mapValue = (int) it.next();
            if (mapValue > max) max = mapValue;
        }
        return max;
    }

    /**
     *
     * @param map
     * @return минимальное значение (value) коллекции map
     */
    public static int getMin(Map map) {
        int min = Integer.MAX_VALUE;
        int mapValue;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            mapValue = (int) it.next();
            if (mapValue < min) min = mapValue;
        }
        return min;
    }



}
