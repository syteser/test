package myProject;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("start....");

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,22);
        map.put(3,0);
        map.put(4,-12);
        map.put(5,22);
        map.put(6,12);

        System.out.println(MapMath.getMin(map));
        System.out.println(MapMath.getMax(map));
        int i = MapMath.getMin(map);

    }
}
