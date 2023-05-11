package myProject;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
        myTheard mt2 = new myTheard(2, 1515);

        String filePath = "./myProject/ser.ser";

        Animal animal = new Animal(27, "Oleg", 90);

        FileOutputStream fileOutput = new FileOutputStream(filePath);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(animal);

        FileInputStream fiStream = new FileInputStream(filePath);
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Object object = objectStream.readObject();
        Animal animal2 = (Animal) object;

        fiStream.close();
        objectStream.close();

        System.out.printf("Name - %s, age - %s, weight - %s\n",animal2.getName(), animal2.getAge(), animal2.getWeight());
        System.out.println(animal2.equals(animal));

        mt.start();
        System.out.println("............");
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
            while (true) {
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
