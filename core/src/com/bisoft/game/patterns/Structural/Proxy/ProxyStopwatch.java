package com.bisoft.game.patterns.Structural.Proxy;




import com.bisoft.game.patterns.Structural.Proxy.IStopwatch.IStopwatch;;

import java.util.ArrayList;
import java.util.List;

public class ProxyStopwatch implements IStopwatch {

    private IStopwatch stopwatch = new RealStopwatch();
    private static List<String> differentTimes;

    static
    {
        differentTimes = new ArrayList<String>();
        differentTimes.add("800");
        differentTimes.add("800");
        differentTimes.add("800");
        differentTimes.add("800");
    }

    @Override
    public void tiempo(String tiempo) throws Exception {
        if(differentTimes.contains(tiempo))
        {
//            throw new Exception("Access Denied");
            stopwatch.tiempo(tiempo);
        } else {
            throw new Exception("Access Denied");
        }
    }
}