package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Philosopher[] philosophersArr = new Philosopher[5];
        Fork[] forks = new Fork[philosophersArr.length];

        fillForks(forks);
        run(philosophersArr, forks);
    }
    public static void fillForks(Fork[] forks){
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork();
        }
    }
    public static void run(Philosopher[] philosophersArr, Fork[] forks){
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < philosophersArr.length; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i+1) % forks.length];

            if (i == philosophersArr.length-1){
                philosophersArr[i] = new Philosopher(rightFork, leftFork, "Философ № " + (i+1), semaphore);
            } else {
                philosophersArr[i] = new Philosopher(leftFork, rightFork, "Философ № " + (i+1), semaphore);
            }

            Thread thread = new Thread(philosophersArr[i]);
            thread.start();
        }
    }
}
