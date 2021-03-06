package edu.pingpong.stockx.domain.item;

import java.util.ArrayList;
import java.util.List;

import edu.pingpong.stockx.domain.offer.*;

public class Sneaker implements Item{

    private String style;
    private String name;
    private  int sale = 0;
    private  int ask = 0;
    private  int bid = 0;

    private List<Offer> sneakers = new ArrayList<Offer>();


    public Sneaker(String style, String name) {
        this.style = style;
        this.name = name;
    }

    private String getStyle() {
        return this.style;
    }

    private String getName() {
        return this.name;
    }

    @Override
    public int getSale() {
        return this.sale;
    }

    @Override
    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public int getBid() {
        return this.bid;
    }

    @Override
    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public int getAsk() {
        return this.ask;
    }

    @Override
    public void setAsk(int ask) {
        this.ask = ask;
    }    

    @Override
    public void add(Offer value) {
        this.sneakers.add(value);
    }

    @Override
    public List<Offer> offers() {
        return this.sneakers;
    }


    @Override
    public String toString() {
        return this.getName() + "\n\t\t" + this.getStyle();
    }
}
