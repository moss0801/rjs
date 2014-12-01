package com.moss.rjs;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.moss.rjs.message.MessageMapSource;

/**
 * RootConext 설정 파일
 * @author moss
 *
 */
@EnableTransactionManagement
@ComponentScan(
		basePackages="com.moss",
		useDefaultFilters=false,
		includeFilters=@ComponentScan.Filter({Service.class, Repository.class}))
@Configuration
public class RootContextConfig {
    private Locale[] localeList = new Locale[] {
            Locale.KOREAN,
            Locale.KOREA,
            Locale.US
    };
    
    @Bean
    public MessageMapSource messageMapSource() {
        MessageMapSource messageMapSource = new MessageMapSource();
        messageMapSource.setBasenameList(new String[] {"message/app" });
        messageMapSource.setLocaleList(localeList);
        return messageMapSource;
    }
    
    /*@Bean
    public GeoLocationFinder geoLocationFinder() throws IOException, GeoIp2Exception {
        GeoLocationFinder finder = new GeoLocationFinder();
        
        String csvFile = "/geolocation/dbip-country.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        List<GeoLocation> geoLocationList = new ArrayList<GeoLocation>();
          
        try {
            InputStream is = getClass().getResourceAsStream(csvFile);
            Reader reader = new InputStreamReader(is);
            //new InputStreamReader(is);
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            //br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
     
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                
                GeoLocation geoLocation = new GeoLocation(country[0], country[1], country[2]);
                geoLocationList.add(geoLocation);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        finder.setGeoLocationList(geoLocationList);
        
        GeoLocation result = finder.getGeoLocation("112.170.59.43");
        log.debug("{}", result);
        return finder;
    }*/
   
}
