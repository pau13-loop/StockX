package edu.pingpong.stockx.domain.offer;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class SaleTest {

    private Sale sale = null;

    @Before
    public void setupBid() {

        sale = new Sale("17", 700);
    }

    @Test
    public void sizaAndValueTest() {

        assertEquals("17", sale.size());
        assertEquals(700, sale.value());
    }

    @Test
    public void toStringTest() {

        assertEquals("\t\t17\t700\n", sale.toString());
    }
}
