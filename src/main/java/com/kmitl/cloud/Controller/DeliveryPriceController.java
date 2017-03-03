package com.kmitl.cloud.Controller;

import com.google.maps.model.Geometry;
import com.kmitl.cloud.Constant;
import com.kmitl.cloud.Model.Coordinate;
import com.kmitl.cloud.Model.DeliveryPrice;
import com.kmitl.cloud.Service.DistanceService;
import com.kmitl.cloud.Service.GeocodingService;
import com.kmitl.cloud.Service.PriceCalculationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by snow_ on 02-Mar-17.
 */
@RestController
public class DeliveryPriceController {

    GeocodingService geocodingService;
    DistanceService distanceService;
    PriceCalculationService priceCalculationService;

    public DeliveryPriceController(GeocodingService geocodingService, DistanceService distanceService, PriceCalculationService priceCalculationService) {
        this.geocodingService = geocodingService;
        this.distanceService = distanceService;
        this.priceCalculationService = priceCalculationService;
    }

    @GetMapping
    String deliveryPriceGet(){
        String welcomeMsg = "Welcome to KabkaoDeliveryPriceService!! \n"+
                "/storeCoordinate [Get]> to find out where we are \n"+
                "/deliveryPrice [Get]> to get delivery price example format\n"+
                "/deliveryPrice [Post]> to get delivery price ";
        return welcomeMsg;
    }

    @GetMapping(value = "/storeCoordinate")
    Coordinate storeCoordinate(){
        return new Coordinate(Constant.STORE_LAT,Constant.STORE_LONG);
    }

    @PostMapping(value="/geocode")
    Geometry geometryFromAddress(@RequestBody String address){
        return geocodingService.getGeocoding(address);
    }

    @PostMapping(value="/distanceFromStore")
    String distanceFromAddress(@RequestBody String address){
        return distanceService.getDistanceReadable(address);
    }


    @GetMapping(value="/deliveryPrice")
    Coordinate coordinateFormat(){
        return new Coordinate();
    }

    @PostMapping(value="/deliveryPrice")
    DeliveryPrice priceFromLatLong(@RequestBody Coordinate coordinate){
        DeliveryPrice deliveryPrice = priceCalculationService.deliveryPriceTo(coordinate);

        return deliveryPrice;
    }
}
