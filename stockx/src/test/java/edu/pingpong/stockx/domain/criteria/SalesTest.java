package edu.pingpong.stockx.domain.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.item.Sneaker;
import edu.pingpong.stockx.domain.offer.Ask;
import edu.pingpong.stockx.domain.offer.Bid;
import edu.pingpong.stockx.domain.offer.Offer;
import edu.pingpong.stockx.domain.offer.Sale;

public class SalesTest {

    private Item sneaker = null;
    private Criteria sales = new Sales();

    @Before
    public void setupSales() {

        sneaker = new Sneaker("Nike", "Performance");

        sneaker.add(new Ask("9.5", 100));
        sneaker.add(new Ask("9.5", 200));
        sneaker.add(new Ask("4", 300));
        sneaker.add(new Sale("3", 400));
        sneaker.add(new Sale("9.5", 500));
        sneaker.add(new Bid("13", 600));
        sneaker.add(new Bid("9.5", 700));
    }

    @Test
    public void salesLengthTest() {
        assertEquals(2, sales.checkCriteria(sneaker).size());
    }

    @Test
    public void allMatchSalesTest() {
        assertTrue(sales.checkCriteria(sneaker).stream().allMatch(a -> a instanceof Sale));
    }

    @Test
    public void getBiggerSales() {
        sneaker.setSale(sales.checkCriteria(sneaker).get(0).value());
        assertEquals(500, sneaker.getSale());
    }

    @Test
    public void nullSalesTest() {
        Item sneaker2 = new Sneaker("Nike", "Spider-Man");
        List<Offer> minimumSale = sales.checkCriteria(sneaker2);
        sneaker2.setSale(minimumSale.isEmpty()? 0 : minimumSale.get(0).value());
        assertEquals(0, sneaker.getSale());
    }
}
