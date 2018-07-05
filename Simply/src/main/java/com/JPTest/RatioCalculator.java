package com.JPTest;

import org.apache.log4j.Logger;

import static com.JPTest.LongVals.ZERO;

public class RatioCalculator implements Calculator {
    final static Logger logger = Logger.getLogger(RatioCalculator.class);

    @Override
    public long calc(long dividend , long price){
        if ( (dividend <= ZERO) || (price <= ZERO) ){
            logger.warn("dividend: " + dividend + "price: " + price);
            return ZERO;
        }

        long res = ZERO;
        res = price / dividend;
        res = Math.round(res);
        return res;
    }
}
