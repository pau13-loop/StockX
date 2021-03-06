package edu.pingpong.stockx.domain.offer;

public class Ask implements Offer {

    private String size = null;
    private Integer ask = 0;

    public Ask(String size, int ask) {
        this.size = size;
        this.ask = ask;
    }

    @Override
    public String size() {
        return this.size;
    }

    @Override
    public int value() {
        return this.ask;
    }

    @Override
    public int compareTo(Offer ask) {
        return this.ask.compareTo(ask.value());
    }

    @Override
    public String toString() {
        return "\t\t" + size() + "\t" + Integer.toString(value()) + "\n";
    }
}
