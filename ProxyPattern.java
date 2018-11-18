package ForGit;

public class ProxyPattern {

    public static void main(String[] args) {
        Payment payment = new Proxy();
        payment.pay();
    }
}


interface Payment {
    void pay();
}

class Purchase implements Payment {

    @Override
    public void pay() {
        System.out.println("Paying ");
    }
}

class Proxy implements Payment {

    Purchase purchase;

    @Override
    public void pay() {
        purchase = new Purchase();
        System.out.println("Modifying security settings");
        purchase.pay();
        System.out.println("Completeing payment safely");
    }
}