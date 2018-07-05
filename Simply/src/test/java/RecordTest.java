import com.JPTest.Recorder;
import com.JPTest.StockName;
import com.JPTest.Trade;
import com.JPTest.TradeRecorder;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class RecordTest {
    TradeRecorder tradeRecorder;

    @Before
    public void setUp(){
        Map<String, List<Trade>> map = new ConcurrentHashMap<>();
        tradeRecorder = new Recorder(map);
    }

    @Test
    public void recordNullEntry(){
        assertThat(tradeRecorder.record(null), is(false));
    }

    @Test
    public void aleAdded(){
        Trade tr = new Trade(LocalDateTime.now(), 20, true, 22, StockName.ALE.toString());
        tradeRecorder.record(tr);
        List<Trade> trades = tradeRecorder.trades(StockName.ALE.toString());
        assertThat(trades, hasItem(tr));
    }
}
