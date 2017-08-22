package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {

        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());

    }


    public static void main(String[] args) {

        threads.get(4).start();

    }

    public static class Thread1 extends Thread {

        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class Thread2 extends Thread {

        @Override
        public void run() {

            try {
                while (!isInterrupted()) {

                }

                throw new InterruptedException();

            } catch (InterruptedException e) {

                System.out.println("InterruptedException");

            }

        }

    }

    public static class Thread3 extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    sleep(500);
                }
            } catch (InterruptedException e) {

            }
        }

    }

    public static class Thread4 extends Thread implements Message {
        @Override
        public void showWarning() {
            interrupt();
        }

        @Override
        public void run() {
            while (!isInterrupted()){

            }
        }
    }

    public static class Thread5 extends Thread {

        @Override
        public void run()
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;

            try{

                while (!isInterrupted())
                {
                    String s = reader.readLine();

                    if (s.equals("N")) this.interrupt();

                    else
                    {
                        int integer = Integer.parseInt(s);

                        sum += integer;
                    }
                }

                throw new InterruptedException();

            }catch (IOException e)
            {

            }catch (InterruptedException e)
            {
                System.out.println(sum);
            }


        }

    }
}