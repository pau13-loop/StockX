package edu.pingpong.stockx.domain.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void sizeLengthTest() {
        assertEquals(3, size.checkCriteria(sneaker).size());
    }

    @Test
    public void checkRightSizeTest() {
        assertTrue(size.checkCriteria(sneaker).stream().allMatch(s -> s.size().equals("9.5")));;
    }
    
    @Test
    public void nullSizeTest() {
        Item sneaker2 = new Sneaker("Nike", "Spider-Man");
        size = new Size("5");
        assertTrue(size.checkCriteria(sneaker2).isEmpty());
    }
}
