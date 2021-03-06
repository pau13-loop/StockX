package edu.pingpong.stockx.domain.offer;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class AskTest {
    
    private Ask ask = null;

    @Before
    public void setupBid() {
        ask = new Ask("14", 400);
    }

    @Test
    public void sizaAndValueTest() {
        assertEquals("14", ask.size());
        assertEquals(400, ask.value());
    }

    @Test
    public void toStringTest() {
        assertEquals("\t\t14\t400\n", ask.toString());
    }
}
