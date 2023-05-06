package myProject;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args)  {
        System.out.println("start....");

        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1,2);
//        map.put(2,22);
//        map.put(3,0);
//        map.put(4,-12);
//        map.put(5,22);
//        map.put(6,12);
//
//        System.out.println(MapMath.getMin(map));
//        System.out.println(MapMath.getMax(map));
//        int i = MapMath.getMin(map);

        myTheard mt = new myTheard(10, 5000);
        myTheard mt2 = new myTheard(2,1515);
        mt.start();
        System.out.println("............");
        mt2.start();
    }

    static class myTheard extends Thread{
        private int i=0;
        private int sleepTimer=1000;

        public myTheard(int i, int sleepTimer) {
            this.i = i;
            this.sleepTimer = sleepTimer;
        }

        @Override
        public void run() {
            while(true){
                System.out.println(i);
                try {
                    sleep(sleepTimer);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
