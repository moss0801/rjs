package com.moss.rjs.geolocation;

import java.util.Comparator;

public class GeoLocationComparator implements Comparator<GeoLocation> {

    @Override
    public int compare(GeoLocation o1, GeoLocation o2) {
        if (o1.getStartIp() < o2.getStartIp())
            return -1;
        if (o1.getStartIp() == o2.getStartIp())
            return 0;
        else
            return 1;
    }

}
