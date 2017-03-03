package com.kmitl.cloud.Service;

import com.kmitl.cloud.Constant;
import com.kmitl.cloud.Model.Coordinate;
import com.kmitl.cloud.Model.DeliveryPrice;
import com.kmitl.cloud.Strategy.IPriceByDistanceStrategy;
import com.kmitl.cloud.Strategy.impl.PriceByDistanceStrategy;
import org.springframework.stereotype.Service;

/**
 * Created by snow_ on 04-Mar-17.
 */

@Service
public class PriceCalculationService {

    private final DistanceService distanceService;
    private final IPriceByDistanceStrategy priceByDistanceStrategy;

    public PriceCalculationService(DistanceService distanceService, PriceByDistanceStrategy priceByDistanceStrategy) {
        this.distanceService = distanceService;
        this.priceByDistanceStrategy = priceByDistanceStrategy;
    }

    public DeliveryPrice deliveryPriceTo(Coordinate to){
        long distance = distanceService.getDistance(to);
        long price = priceByDistanceStrategy.priceByDistance(distance);
        Coordinate from = new Coordinate(Constant.STORE_LAT,Constant.STORE_LONG);

        return new DeliveryPrice(from,to,price);
    }

}
