package edu.pingpong.stockx.domain.offer;

public class Bid implements Offer {

    private String size = null;
    private Integer bid = 0;

    public Bid(String size, int bid) {
        this.size = size;
        this.bid = bid;
    }

    @Override
    public String size() {
        return this.size;
    }

    @Override
    public int value() {
        return this.bid;
    }

    @Override
    public int compareTo(Offer bid) {
        return this.bid.compareTo(bid.value());
    }

    @Override
    public String toString() {
        return "\t\t" + size() + "\t" + Integer.toString(value()) + "\n";
    }
}
