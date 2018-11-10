package ForGit;

import java.rmi.NoSuchObjectException;

public class FactoryMethod {

    public static Food makeFood (String foodName)throws NoSuchObjectException{

        if (foodName.equalsIgnoreCase("cake")) return new Cake();
        else if (foodName.equalsIgnoreCase("ice cream")) return new IceCream();
        else throw new NoSuchObjectException(foodName);
    }

    public static void main(String[] args)throws NoSuchObjectException {

        Food cake = makeFood("cake");
        Food iceCream = makeFood("ice cream");
    }
}

interface Food {}
class Cake implements Food{}
class IceCream implements Food{}

