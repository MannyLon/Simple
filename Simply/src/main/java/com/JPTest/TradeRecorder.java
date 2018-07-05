package com.JPTest;

import java.util.List;

public interface TradeRecorder {
    boolean record(Trade trade);
    List<Trade> trades(String stock);
}
