package com.company;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;

public class Main {
            public static void main(String[] args) {
                boolean clickOnButton = false;

                Timer chrono = new Timer();
                chrono.schedule(new TimerTask() {
                    int time = 0;
                    int minutes = 0;

                    @Override
                    public void run() {
                        System.out.println("time : " + minutes + " min "+ time + "s");

                        if (time == 60) {
                            time = 0;
                            minutes++;
                        }
                        time++;
                    }

                }, 1000, 1000);
            }
    }