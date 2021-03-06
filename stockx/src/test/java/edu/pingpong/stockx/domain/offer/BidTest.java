package edu.pingpong.stockx.domain.offer;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BidTest {

    private Bid bid = null;

    @Before
    public void setupBid() {
        bid = new Bid("13", 200);
    }

    @Test
    public void sizaAndValueTest() {
        assertEquals("13", bid.size());
        assertEquals(200, bid.value());
    }

    @Test
    public void toStringTest() {
        assertEquals("\t\t13\t200\n", bid.toString());
    }
}
