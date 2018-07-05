import com.JPTest.Calculator;
import com.JPTest.YieldCalculator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import static com.JPTest.LongVals.ZERO;

public class DividendYieldTest {
    private Calculator yieldCalc;

    @Before
    public void setUp(){
        yieldCalc = new YieldCalculator();
    }

    @Test
    public void commonLast0Price0(){
        assertThat(yieldCalc.calc(ZERO, ZERO), is(ZERO));
    }

    @Test
    public void commonLast0Price1(){
        assertThat(yieldCalc.calc(ZERO, 1), is(ZERO));
    }

    @Test
    public void commonLast1Price0(){
        assertThat(yieldCalc.calc(1, ZERO), is(ZERO));
    }

    @Test
    public void commonLastMinus20Price5(){
        assertThat(yieldCalc.calc(-20, 5), is(ZERO));
    }

    @Test
    public void commonLast20PriceMinus5(){
        assertThat(yieldCalc.calc(20, -5), is(ZERO));
    }

    @Test
    public void commonLast20Price5Dec(){
        assertThat(yieldCalc.calc(20, 5), is(4L));
    }

    @Test
    public void commonLast5Price20Dec(){
        assertThat(yieldCalc.calc(5, 20), is(0L));
    }

}
