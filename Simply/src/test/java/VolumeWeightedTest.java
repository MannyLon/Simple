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

import static com.JPTest.LongVals.ZERO;

@RunWith(MockitoJUnitRunner.class)
public class VolumeWeightedTest {

    private CalculatorWeighted calculator;

    @Mock
    TradeRecorder tradeRecorder;

    @Before
    public void setup(){
        calculator = new WeightedCalculator();
    }

    @Test
    public void volTeaTwo(){
        Trade tradeA = new Trade(LocalDateTime.now(ZoneOffset.UTC), 20, true, 22, StockName.TEA.toString());
        Trade tradeB = new Trade(LocalDateTime.now(ZoneOffset.UTC), 10, true, 2, StockName.TEA.toString());
        List<Trade> trades = new ArrayList<>();
        trades.add(tradeA);
        trades.add(tradeB);
        Mockito.doReturn(trades).when(tradeRecorder).trades(StockName.TEA.toString());

        // (440 + 20) / 30
        assertThat(calculator.calc(StockName.TEA.toString(), tradeRecorder), is(15L));
    }

    @Test
    public void volTeaNoTrades(){
        List<Trade> trades = new ArrayList<>();
        Mockito.doReturn(trades).when(tradeRecorder).trades(StockName.TEA.toString());

        assertThat(calculator.calc(StockName.TEA.toString(), tradeRecorder), is(ZERO));
    }

    @Test
    public void volTeaTwoOne(){
        Trade tradeA = new Trade(LocalDateTime.now(ZoneOffset.UTC), 20, true, 22, StockName.TEA.toString());
        Trade tradeB = new Trade(LocalDateTime.now(ZoneOffset.UTC).plusMinutes(20), 10, true, 2, StockName.TEA.toString());
        List<Trade> trades = new ArrayList<>();
        trades.add(tradeA);
        trades.add(tradeB);
        Mockito.doReturn(trades).when(tradeRecorder).trades(StockName.TEA.toString());

        // 440 / 20
        assertThat(calculator.calc(StockName.TEA.toString(), tradeRecorder), is(22L));
    }

    @Test
    public void volTeaOneZero(){
        Trade tradeA = new Trade(LocalDateTime.now(ZoneOffset.UTC), 0, true, 22, StockName.TEA.toString());
        List<Trade> trades = new ArrayList<>();
        trades.add(tradeA);
        Mockito.doReturn(trades).when(tradeRecorder).trades(StockName.TEA.toString());

        // (440 + 20) / 30
        assertThat(calculator.calc(StockName.TEA.toString(), tradeRecorder), is(ZERO));
    }



}
