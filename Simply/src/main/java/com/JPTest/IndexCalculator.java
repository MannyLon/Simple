package com.JPTest;

import java.util.List;

import static com.JPTest.LongVals.ZERO;

public class IndexCalculator implements CalculatorIndex{
    private CalculatorWeighted calculatorWeighted;

    public IndexCalculator(CalculatorWeighted c){
        calculatorWeighted = c;
    }

    @Override
    public double calc(StockName[] stockNames, TradeRecorder tradeRecorder) {
        List<Trade> trades = null;
        Long weighted = 1L;
        long calcRes = ZERO;
        boolean calculated = false;

        // go through the stocks and get the weighted stock price
        for (StockName s:stockNames) {
             trades = tradeRecorder.trades(s.toString());
             calcRes = calculatorWeighted.calc(s.toString(), tradeRecorder);
             if (calcRes > 0){
                 weighted *= calcRes;
                 calculated = true;
             }
        }

        if (!calculated){
            return 0.0;
        }

        double res = Math.pow(weighted, 1.0 / stockNames.length);
        return Math.round(res);
    }
}
