package edu.pingpong.stockx.domain.offer;

public class Sale implements Offer {

    private String size = null;
    private Integer price = 0;

    public Sale(String size, int price) {
        this.size = size;
        this.price = price;
    }

    @Override
    public String size() {
        return this.size;
    }

    @Override
    public int value() {
        return this.price;
    }

    @Override
    public int compareTo(Offer sale) {
        return this.price.compareTo(sale.value());
    }

    @Override
    public String toString() {
        return "\t\t" + size() + "\t" + Integer.toString(value()) + "\n";
    }
}
