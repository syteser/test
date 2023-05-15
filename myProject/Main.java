package myProject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

public class Main implements Serializable {
    private static final int RANDOM_HEIGHT = 25;
    private static final int SLEEP_THREAD = 100;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("start....");

        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 22);
        map.put(3, 0);
        map.put(4, -12);
        map.put(5, 22);
        map.put(6, 12);

        System.out.println(MapMath.getMin(map));
        System.out.println(MapMath.getMax(map));
        int i = MapMath.getMin(map);

        System.out.println(map);

        myTheard mt = new myTheard(10, SLEEP_THREAD*5);
        myTheard mt2 = new myTheard(2, SLEEP_THREAD);

        String filePath = "./myProject/ser.ser";

        Animal animal = new Animal(27, "Oleg", 90);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(animal);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        Object object = ois.readObject();

        Animal animal2 = (Animal) object;

        oos.close();
        ois.close();

        System.out.printf("Name - %s, age - %s, weight - %s\n", animal.getName(), animal.getAge(), animal.getWeight());
        System.out.printf("Name - %s, age - %s, weight - %s\n", animal2.getName(), animal2.getAge(), animal2.getWeight());
        System.out.println(animal2.equals(animal));

        System.out.println("............");
        mt.start();
        mt2.start();
    }

    static class myTheard extends Thread {
        private int i = 0;
        private int sleepTimer = 1000;

        public myTheard(int i, int sleepTimer) {
            this.i = i;
            this.sleepTimer = sleepTimer;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    int randomI = (int) (Math.random() * RANDOM_HEIGHT);
                    System.out.println(randomI);
                    if (randomI == 5) {
                        interrupt();
                    }
                    Thread.sleep(sleepTimer);
                }
            } catch (InterruptedException e) {
                System.out.println("exit....");
            }
        }
    }
}
