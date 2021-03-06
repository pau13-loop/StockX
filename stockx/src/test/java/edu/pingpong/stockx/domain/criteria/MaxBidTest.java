package edu.pingpong.stockx.domain.criteria;

import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import edu.pingpong.stockx.domain.item.Item;
import edu.pingpong.stockx.domain.item.Sneaker;
import edu.pingpong.stockx.domain.offer.Bid;
import edu.pingpong.stockx.domain.offer.Offer;
import edu.pingpong.stockx.domain.offer.Sale;

public class MaxBidTest {
    
    Item sneaker = null;
    Criteria bids = null;
    Criteria maxBid = null;

    @Test
    public void checkMaxBidTest1() {
        sneaker = new Sneaker("Nike", "Performance");
        maxBid = new MaxBid();

        sneaker.add(new Bid("45", 300));
        sneaker.add(new Bid("80", 500));
        sneaker.add(new Bid("12", 78));
        sneaker.add(new Bid("74", 200));
        sneaker.add(new Bid("1", 15));

        Optional<Offer> maxBidOptional = Optional.ofNullable(maxBid.checkCriteria(sneaker).get(0));

        // By the way of my teacher David Felta Gelpi
        sneaker.setBid(maxBidOptional.isPresent()? maxBidOptional.get().value() : 0);
        assertEquals(500, sneaker.getBid());

        //By my way
        assertEquals(500, maxBidOptional.get().value());
    }

    @Test
    public void checkMaxBidTest2() {
        sneaker = new Sneaker("Nike", "Performance");
        maxBid = new MaxBid();

        sneaker.add(new Sale("12", 500));
        sneaker.add(new Sale("5", 300));
        sneaker.add(new Sale("10", 120));
        sneaker.add(new Bid("5", 100));
        sneaker.add(new Bid("8", 150));
        sneaker.add(new Bid("12", 78));
        sneaker.add(new Bid("9.5", 200));
        sneaker.add(new Bid("3", 15));

        /**
         * Another possible way when you know that the list is not going to be empty, but it's more efficient like the way shown above
         */
        assertEquals(200, maxBid.checkCriteria(sneaker).get(0).value());
    }

    @Test
    public void checkMaxBidNullTest() {
        sneaker = new Sneaker("Nike", "Performance");
        maxBid = new MaxBid();
        List<Offer> maxB = maxBid.checkCriteria(sneaker);
        sneaker.setBid(maxB.isEmpty()? 0 : maxB.get(0).value());
        assertEquals(0, sneaker.getBid());
    }
}
