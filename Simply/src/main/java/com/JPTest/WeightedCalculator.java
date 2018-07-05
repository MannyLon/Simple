package com.JPTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static com.JPTest.LongVals.ZERO;

public class WeightedCalculator implements CalculatorWeighted {

    // past 5 mins, sum(trade price * quantity)
    // divided by sum(quantity)
    public long calc(String stock, TradeRecorder tradeRecorder){
        List<Trade> trades = tradeRecorder.trades(stock);
        LocalDateTime now  = LocalDateTime.now(ZoneOffset.UTC);
        Duration between = null;
        long priceQuantity = ZERO;
        long quantity = ZERO;

        for (Trade t:trades)
        {
            between = Duration.between(t.getTimeStamp(), now);
            if( Math.abs(between.getSeconds() ) <= (60 * 5) ){
                priceQuantity += t.getPrice() * t.getQuantity();
                quantity += t.getQuantity();
            }
        }

        if(priceQuantity > ZERO && quantity > ZERO){
            return priceQuantity / quantity;
        }
        return ZERO;
    }

}
