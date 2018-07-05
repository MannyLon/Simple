import com.JPTest.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class IndexTest {

    private CalculatorIndex calculatorIndex;

    @Mock
    TradeRecorder tradeRecorder;

    @Before
    public void setup(){
        calculatorIndex = new IndexCalculator(new WeightedCalculator());
    }

    @Test
    public void meanForEmpty(){
        List<Trade> trades = new ArrayList<>();
        Mockito.doReturn(trades).when(tradeRecorder).trades(StockName.TEA.toString());
        assertThat(calculatorIndex.calc(StockName.values(), tradeRecorder), is(0.0));
    }

    @Test
    public void meanForTeaPOP(){
        // 15 weighted
        Trade tradeA = new Trade(LocalDateTime.now(ZoneOffset.UTC), 20, true, 22, StockName.TEA.toString());
        Trade tradeB = new Trade(LocalDateTime.now(ZoneOffset.UTC), 10, true, 2, StockName.TEA.toString());
        List<Trade> tradesTea = new ArrayList<>();
        tradesTea.add(tradeA);
        tradesTea.add(tradeB);
        Mockito.doReturn(tradesTea).when(tradeRecorder).trades(StockName.TEA.toString());

        // 1210 / 110 = 11 weighted
        Trade tradeC = new Trade(LocalDateTime.now(ZoneOffset.UTC), 100, true, 12, StockName.POP.toString());// 1200
        Trade tradeD = new Trade(LocalDateTime.now(ZoneOffset.UTC), 10, true, 1, StockName.POP.toString());// 10
        List<Trade> tradesPop = new ArrayList<>();
        tradesPop.add(tradeC);
        tradesPop.add(tradeD);
        Mockito.doReturn(tradesPop).when(tradeRecorder).trades(StockName.POP.toString());

        // 11 * 15 root 5 = 13
        assertThat(calculatorIndex.calc(StockName.values(), tradeRecorder), is(3.0));

    }

}
