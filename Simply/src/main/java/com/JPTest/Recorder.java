package com.JPTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Recorder implements TradeRecorder{
    private final Map<String, List<Trade>> tradeMap;

    public Recorder(Map<String, List<Trade>> map){
        tradeMap = map;
    }

    @Override
    // returns bool to indicate whether trade recorded
    public boolean record(Trade trade) {
        if(trade != null){
            List<Trade> trArr = tradeMap.get(trade.getStockSymbol());
            if(trArr != null){
                trArr.add(trade);
            }
            else{
                trArr = new ArrayList<>();
                trArr.add(trade);
                tradeMap.put(trade.getStockSymbol(), trArr);
            }
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    // returns a list of stocks
    public List<Trade> trades(String stock){
        if(stock != null){
            List<Trade> trArr = tradeMap.get(stock);
            return trArr;
        }
        return new ArrayList<Trade>();
    }

}
