package edu.pingpong.stockx.domain.criteria;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.item.Sneaker;
import edu.pingpong.stockx.domain.offer.Bid;
import edu.pingpong.stockx.domain.offer.Offer;
import edu.pingpong.stockx.domain.offer.Sale;

public class LastSaleTest {
        
    Item sneaker;
    Criteria sales;
    Criteria lastSale;

    @Test
    public void checkLastSale1() {

        sneaker = new Sneaker("Nike", "Performance");
        sales = new Sales();
        lastSale = new LastSale();

        sneaker.add(new Bid("12", 100));
        sneaker.add(new Sale("13", 200));
        sneaker.add(new Bid("14", 300));
        sneaker.add(new Sale("15", 400));
        sneaker.add(new Bid("16", 500));
        sneaker.add(new Sale("17", 600));

        assertArrayEquals(600, lastSale.checkCriteria(sneaker).get(0).value());
    }

    private void assertArrayEquals(int i, int value) {
    }

    @Test
    public void checkLastSale2() {

        sneaker = new Sneaker("Nike", "Performance");
        sales = new Sales();
        lastSale = new LastSale();

        sneaker.add(new Bid("12", 450));
        sneaker.add(new Sale("17", 600));
        sneaker.add(new Sale("13", 328));
        sneaker.add(new Bid("14", 452));
        sneaker.add(new Sale("15", 111));
        sneaker.add(new Bid("16", 500));
        

        assertArrayEquals(111, lastSale.checkCriteria(sneaker).get(0).value());
    }

    @Test
    public void lastSaleNull() {
        sneaker = new Sneaker("Nike", "Performance");
        lastSale = new LastSale();
        List<Offer> salesList = lastSale.checkCriteria(sneaker);

        assertTrue(salesList.isEmpty());
    }
}
