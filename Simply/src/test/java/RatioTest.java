import com.JPTest.Calculator;
import com.JPTest.RatioCalculator;
import org.junit.Before;
import org.junit.Test;

import static com.JPTest.LongVals.ZERO;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RatioTest {

    private Calculator ratioCalc;

    @Before
    public void setUp(){
        ratioCalc = new RatioCalculator();
    }

    @Test
    public void commonLast0Price0(){
        assertThat(ratioCalc.calc(ZERO, ZERO), is(ZERO));
    }

    @Test
    public void commonLast0Price1(){
        assertThat(ratioCalc.calc(ZERO, 1), is(ZERO));
    }

    @Test
    public void commonLast1Price0(){
        assertThat(ratioCalc.calc(1, ZERO), is(ZERO));
    }

    @Test
    public void commonLastMinus20Price5(){
        assertThat(ratioCalc.calc(-20, 5), is(ZERO));
    }

    @Test
    public void commonLast20PriceMinus5(){
        assertThat(ratioCalc.calc(20, -5), is(ZERO));
    }

    @Test
    public void commonLast20Price5Dec(){
        assertThat(ratioCalc.calc(20, 5), is(ZERO));
    }

    @Test
    public void commonLast5Price20Dec(){
        assertThat(ratioCalc.calc(5, 20), is(4L));
    }

}
