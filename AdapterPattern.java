package ForGit;

import java.util.Locale;

public class AdapterPattern {

    public static void main(String[] args) {
        ClientInterface c = new Adapter();
        System.out.println(c.getPriceInUSD());

    }
}

interface ClientInterface {

    double getPriceInUSD();
}

class Adapter implements ClientInterface {

    private BuyTickets buy = new BuyTickets();
    private double usdIndex = 1.14d;
    private double price = buy.price;

    @Override
    public double getPriceInUSD() {
        if (Locale.getDefault() == Locale.US){
            price = buy.price * usdIndex;
        }
        return price;
    }

}

class BuyTickets {

    double price = 100.0;

    public double getPriceInEUR(){
        return price;
    }


}



