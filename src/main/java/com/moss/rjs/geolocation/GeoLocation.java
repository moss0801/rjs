package com.moss.rjs.geolocation;

import lombok.Data;

@Data
public class GeoLocation implements Comparable<GeoLocation> {
    long startIp;
    long endIp;
    String country;
    
    public GeoLocation() {
        
    }
    
    public GeoLocation(String startIp, String endIp, String country) {
        this.startIp = GeoLocationFinder.getLongCode(startIp.substring(1, startIp.length()-1));
        this.endIp = GeoLocationFinder.getLongCode(endIp.substring(1, endIp.length()-1)); 
        this.country = country;
    }

    @Override
    public int compareTo(GeoLocation o) {
        if (this.getStartIp() < o.getStartIp())
            return -1;
        if (this.getStartIp() == o.getStartIp())
            return 0;
        else
            return 1;
    }
}
