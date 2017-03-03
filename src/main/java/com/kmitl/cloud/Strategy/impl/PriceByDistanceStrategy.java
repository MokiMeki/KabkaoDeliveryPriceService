package com.kmitl.cloud.Strategy.impl;

import com.kmitl.cloud.Strategy.IPriceByDistanceStrategy;
import org.springframework.stereotype.Component;

/**
 * Created by snow_ on 04-Mar-17.
 */

@Component
public class PriceByDistanceStrategy implements IPriceByDistanceStrategy {

    @Override
    public long priceByDistance(long metres) {
        long deliveryFee = 40;
        long distanceFee = (metres/1000)*2; //1000 metres = 2 Baht
        long price = deliveryFee + distanceFee;

        return price;
    }
}
