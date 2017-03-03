package com.kmitl.cloud.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import com.kmitl.cloud.Credential;
import org.springframework.stereotype.Service;

/**
 * Created by snow_ on 02-Mar-17.
 */
@Service
public class GeocodingService {

    GeoApiContext context = new GeoApiContext().setApiKey(Credential.API_KEY);

    public Geometry getGeocoding(String address){
        try {
            GeocodingResult[] results = GeocodingApi.geocode(context,address).await();
            return results[0].geometry;
        }catch(Exception e){}

        return null;
    }
}
