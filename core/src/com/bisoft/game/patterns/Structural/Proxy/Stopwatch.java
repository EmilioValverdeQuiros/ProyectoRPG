package com.bisoft.game.patterns.Structural.Proxy;



import com.bisoft.game.patterns.Structural.Proxy.IStopwatch.IStopwatch;

import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch {
    static int interval;
    static Timer timer;

    public static void main(String[] args) {
        IStopwatch stopwatch = new ProxyStopwatch();

        try
        {

            String secs = "800";
            int delay = 1000;
            int period = 1000;
            timer = new Timer();
            interval = Integer.parseInt(secs);
//            System.out.println("Total time " + secs + " !!!!!!");
//            System.out.println(secs);
            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {
                    System.out.println(setInterval());

                }
            }, delay, period);
            stopwatch.tiempo(secs);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static final int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }
}