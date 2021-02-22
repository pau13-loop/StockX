package edu.pingpong.stockx.appStockx;

import edu.pingpong.stockx.domain.item.*;
import edu.pingpong.stockx.domain.offer.*;

import java.util.List;

import edu.pingpong.stockx.domain.criteria.*;


public class Stockx
{
    public static void main( String[] args )
    {
         /**
         * Crear la zapatilla 
         * y printar sus datos.
         * 
         * Lee la funcion draw() del main
         * para conocer que propiedades
         * de la zapatilla han de printarse.
         */

        Item sneaker = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
        System.out.println(Stockx.draw(sneaker));

        /**
         * Crear bids
         * y añadirlas a la zapatilla
         * en sus offers.
         */

        Bid bid = new Bid("13", 550);
        sneaker.add(bid);
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Bid("9.5", 479));
        sneaker.add(new Bid("13", 338));
        sneaker.add(new Bid("9.5", 480));

        /**
         * Crear asks
         * y añadirlas a la zapatilla
         * en sus offers.
         */

        Ask ask = new Ask("13", 288);
        sneaker.add(ask);
        sneaker.add(new Ask("6", 600));
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 340));
        sneaker.add(new Ask("13", 330));

        /**
         * Crear el filtro "Bids" que filtra
         * solo las bids de entre las 
         * offers de la zapatilla. 
         */

        Criteria bids = new Bids();
        System.out.println("\n\t\t All BIDS");
        bids.checkCriteria(sneaker).forEach(System.out::print);

        /**
         * Crea el filtro "Asks" que filtra
         * solo las asks de entre las
         * offers de la zapatilla. 
         */

        Criteria asks = new Asks();
        System.out.println("\n\t\t All ASKS");
        asks.checkCriteria(sneaker).forEach(System.out::print);

        /**
         * Muestra la bid maxima
         * de la zapatilla. 
         * 
         * Crea el filtro MaxBid que filtra
         * el maximo de las bids de la zapatilla.
         * Devuelve la bid maxima como unico
         * elemento de una lista de offers.
         * 
         * Guarda esta bid maxima en la
         * propiedad bid de sneaker.
         */

        Criteria maxBid = new MaxBid();
        List<Offer> maximum = maxBid.checkCriteria(sneaker);
        sneaker.setBid(maximum.isEmpty()? 0 : maximum.get(0).value());
        System.out.println(Stockx.draw(sneaker));

         /**
         * Muestra la ask minima
         * de la zapatilla. 
         * 
         * Crea el filtro MinAsk que filtra
         * el minimo de las asks de la zapatilla.
         * Devuelve la ask minima como unico
         * elemento de una lista de offers.
         * 
         * Guarda esta ask minima en la propiedad
         * ask de sneaker.
         */

        Criteria minAsk = new MinAsk();
        List<Offer> minimum = minAsk.checkCriteria(sneaker);
        sneaker.setAsk(minimum.isEmpty()? 0 : minimum.get(0).value());
        System.out.println(Stockx.draw(sneaker));

         /**
         * Añade ventas (sales) de 
         * una zapatilla a sus offers.
         * Las ventas se añaden segun fecha
         * en la que se producen, de mas antigua
         * a mas reciente.
         */

        Sale sale = new Sale("6", 356);
        sneaker.add(sale);
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        sneaker.add(new Sale("13", 372));

        /**
         * Crear el filtro "Sales" que filtra
         * solo las ventas /sales de entre las 
         * offers de la zapatilla.
         */

        Criteria sales = new Sales();
        System.out.println("\n\t\t All SALES");
        sales.checkCriteria(sneaker).forEach(System.out::print);

         /**
         * Crea un filtro que devuelva
         * la ULTIMA de las ventas (que 
         * es la ultima en ser incluida
         * en sneaker).
         */
        
        Criteria lastSale = new LastSale();
        
        List<Offer> actualSale = lastSale.checkCriteria(sneaker);
        sneaker.setSale(actualSale.isEmpty()? 0 : actualSale.get(0).value());
        System.out.println(Stockx.draw(sneaker));

        /**
         * Mostrar info de la zapatilla 
         * en la talla 9.5
         */

        /**
         * Muestra las sales de la talla 9.5
         * 
         * Crea un filtro Size(talla) que devuelva las
         * zapatillas de la talla indicada.
         * 
         * Crea un filtro AndCriteria() que haga
         * un AND de los filtros Size y Sales.
         */

        System.out.println("\n\t\t SALES 9.5 US");
        Criteria size = new Size("9.5");

        sales = new Sales();
        Criteria andSizeSales = new AndCriteria(size, sales);
        andSizeSales.checkCriteria(sneaker).forEach(System.out::print);

        List<Offer> sizeSales = andSizeSales.checkCriteria(sneaker);
        sneaker.setSale(sizeSales.isEmpty()? 
                            0 : 
                            sizeSales.get(sizeSales.size() -1).value());
        System.out.println("\n\t\t LAST SALE 9.5 US: " + sneaker.getSale());
    }
    

    public static String draw(Item sneaker) {
        return
        "\n\n\t\t" + sneaker.getAsk() + " Buy\t" 
        + sneaker.getBid() + " Sell \n" +  

        "\t\t" + " _    _" + "\n" +
        "\t\t" + "(_\\__/(,_" + "\n" +
        "\t\t" + "| \\ `_////-._" + "\n" +
        "\t\t" + "J_/___\"=> __/`\\" + "\n" +
        "\t\t" + "|=====;__/___./" + "\n" +
        "\t\t" + "\'-\'-\'-\"\"\"\"\"\"\"`" + "\n" +
        
        "\t" + sneaker.toString() + "\n" +
        "\t\tlast sale: " + sneaker.getSale();
    }
}
