package com.moss.rjs.geolocation;

import java.util.Collections;
import java.util.List;

public class GeoLocationFinder {
    private List<GeoLocation> geoLocationList;

    public void setGeoLocationList(List<GeoLocation> geoLocationList) {
        this.geoLocationList = geoLocationList;
        Collections.sort(geoLocationList, new GeoLocationComparator());
    }
    
    public static long getLongCode(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        return 16777216*Long.parseLong(parts[0]) 
                + 65536*Long.parseLong(parts[1])
                + 256*Long.parseLong(parts[2]) 
                + Long.parseLong(parts[3]);
    }
    
    public GeoLocation getGeoLocation(String ipAddress) {
        long ipValue = getLongCode(ipAddress);
        int startIndex = 0;
        int endIndex = geoLocationList.size();
        int midIndex = (startIndex + endIndex) / 2;
        GeoLocation candidate = geoLocationList.get(midIndex); 
        while (candidate.getStartIp() > ipValue
                || candidate.getEndIp() <= ipValue) {
            if (candidate.getStartIp() > ipValue) {
                endIndex = midIndex;
                midIndex = (startIndex + endIndex) / 2;
                candidate = geoLocationList.get(midIndex);
            } else {
                startIndex = midIndex;
                midIndex = (startIndex + endIndex) / 2;
                candidate = geoLocationList.get(midIndex);
            }
        }
        return candidate;
    }
}
