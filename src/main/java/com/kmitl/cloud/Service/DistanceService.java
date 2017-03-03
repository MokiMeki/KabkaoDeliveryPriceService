package com.kmitl.cloud.Service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElementStatus;
import com.kmitl.cloud.Constant;
import com.kmitl.cloud.Credential;
import com.kmitl.cloud.Exception.RouteNotFound;
import com.kmitl.cloud.Model.Coordinate;
import org.springframework.stereotype.Service;

/**
 * Created by snow_ on 02-Mar-17.
 */

@Service
public class DistanceService {

    GeoApiContext context = new GeoApiContext().setApiKey(Credential.API_KEY);

    public String getDistanceReadable(String address){
        try{
            DistanceMatrix distanceMatrices = DistanceMatrixApi.getDistanceMatrix(context, new String[]{Constant.STORE_LAT+","+Constant.STORE_LONG},new String[]{address}).await();

            return distanceMatrices.rows[0].elements[0].distance.humanReadable;

        }catch (Exception e){}

        return "Is your address belongs to another world?";
    }

    public long getDistance(String address){
        try{
            DistanceMatrix distanceMatrices = DistanceMatrixApi.getDistanceMatrix(context, new String[]{Constant.STORE_LAT+","+Constant.STORE_LONG},new String[]{address}).await();
            if(distanceMatrices.rows[0].elements[0].status == DistanceMatrixElementStatus.OK){
                return distanceMatrices.rows[0].elements[0].distance.inMeters;
            }

        }catch (Exception e){}

        throw new RouteNotFound();
    }

    public long getDistance(Coordinate coordinate){
        try{
            DistanceMatrix distanceMatrices = DistanceMatrixApi.getDistanceMatrix(context, new String[]{Constant.STORE_LAT+","+Constant.STORE_LONG},new String[]{coordinate.getLatitude()+","+coordinate.getLongitude()}).await();
            if(distanceMatrices.rows[0].elements[0].status == DistanceMatrixElementStatus.OK){
                return distanceMatrices.rows[0].elements[0].distance.inMeters;
            }

        }catch (Exception e){}

        throw new RouteNotFound();
    }
}
