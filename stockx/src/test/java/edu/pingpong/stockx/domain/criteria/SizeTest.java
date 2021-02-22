package edu.pingpong.stockx.domain.criteria;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.item.Sneaker;
import edu.pingpong.stockx.domain.offer.Sale;

public class SizeTest {

    private Item sneaker = null;
    private Criteria size = null;

    @Before
    public void setupSales() {

        sneaker = new Sneaker("Nike", "Performance");
        size = new Size("9.5");
        
        sneaker.add(new Sale("10", 100));
        sneaker.add(new Sale("9.5", 200));
        sneaker.add(new Sale("8", 300));
        sneaker.add(new Sale("9.5", 400));
        sneaker.add(new Sale("9.5", 500));
    }

    @Test
    public void checkSizeConstructorTest(){
        assertEquals("9.5", size.checkCriteria(sneaker).get(0).size());
    }

    @Test
    public void checkSizeTest() {
        assertEquals(3, size.checkCriteria(sneaker).size());
    }
    
}
