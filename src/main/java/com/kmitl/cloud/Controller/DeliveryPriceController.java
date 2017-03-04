package com.kmitl.cloud.Controller;

import com.google.maps.model.Geometry;
import com.kmitl.cloud.Constant;
import com.kmitl.cloud.Model.Coordinate;
import com.kmitl.cloud.Model.DeliveryPrice;
import com.kmitl.cloud.Service.DistanceService;
import com.kmitl.cloud.Service.GeocodingService;
import com.kmitl.cloud.Service.PriceCalculationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import static com.kmitl.cloud.Constant.ADDRESS_NOT_FOUND_MSG;
import static com.kmitl.cloud.Constant.ROUTE_NOT_FOUND_MSG;

/**
 * Created by snow_ on 02-Mar-17.
 */
@Api(description = "Api of Kabkao delivery price")
@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class DeliveryPriceController {

    GeocodingService geocodingService;
    DistanceService distanceService;
    PriceCalculationService priceCalculationService;

    public DeliveryPriceController(GeocodingService geocodingService, DistanceService distanceService, PriceCalculationService priceCalculationService) {
        this.geocodingService = geocodingService;
        this.distanceService = distanceService;
        this.priceCalculationService = priceCalculationService;
    }

    @ApiOperation(value = "Kabkao headquarter coordinate")
    @GetMapping(value = "/storeCoordinate")
    public Coordinate storeCoordinate(){
        return new Coordinate(Constant.STORE_LAT,Constant.STORE_LONG);
    }

    @ApiOperation(value = "Get coordinate by address")
    @ApiResponses(value = @ApiResponse(code = 500,message = ADDRESS_NOT_FOUND_MSG))
    @PostMapping(value="/geocode")
    public Coordinate geometryFromAddress(@RequestBody String address){
        Geometry geometry = geocodingService.getGeocoding(address);
        return new Coordinate(geometry.location.lat,geometry.location.lng);
    }

    @ApiResponses(@ApiResponse(code = 500,message = ROUTE_NOT_FOUND_MSG+" or "+ADDRESS_NOT_FOUND_MSG))
    @ApiOperation(value = "Distance to Kabkao headquarter in friendly text!!")
    @PostMapping(value="/distanceFromStore")
    public String distanceFromAddress(@RequestBody String address){
        return distanceService.getDistanceReadable(address);
    }

    @ApiOperation(value = "Calculate delivery price based on coordinate")
    @ApiResponses(value = @ApiResponse(code = 500,message = ROUTE_NOT_FOUND_MSG))
    @PostMapping(value="/deliveryPrice")
    public DeliveryPrice priceFromLatLong(@RequestBody Coordinate coordinate){
        DeliveryPrice deliveryPrice = priceCalculationService.deliveryPriceTo(coordinate);

        return deliveryPrice;
    }
}
