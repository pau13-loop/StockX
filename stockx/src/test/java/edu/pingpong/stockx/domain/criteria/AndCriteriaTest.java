package edu.pingpong.stockx.domain.criteria;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.item.Sneaker;
import edu.pingpong.stockx.domain.offer.Offer;
import edu.pingpong.stockx.domain.offer.Sale;

public class AndCriteriaTest {

    private Item sneaker;
    private Criteria size;
    private Criteria sales;
    private Criteria andCriteria;
    
    @Before
    public void setupAndCriteria() {

        sneaker = new Sneaker("Nike", "Performance");
        size = new Size("9.5");
        sales = new Sales();
        andCriteria = new AndCriteria(size, sales);

        sneaker.add(new Sale("9.5", 750));
        sneaker.add(new Sale("10", 100));
        sneaker.add(new Sale("9.5", 200));
        sneaker.add(new Sale("8", 300));
        sneaker.add(new Sale("9.5", 400));
        sneaker.add(new Sale("9.5", 500));
    }

    @Test
    public void andCriteriaLengthTest() {
        assertEquals(4, andCriteria.checkCriteria(sneaker).size());
    }

    @Test
    public void andCriteriaFirstElementTest() {
        assertEquals(750, andCriteria.checkCriteria(sneaker).get(0).value());
    }

    @Test
    public void andCriteriaLastElementTest() {
        assertEquals(500, andCriteria.checkCriteria(sneaker).get(andCriteria.checkCriteria(sneaker).size()-1).value());
    }
}
