package ForGit;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        Subscriber one = new Customer();
        Subscriber two = new Customer();
        Subscriber three = new Customer();

        AppleStore store = new AppleStore();
        System.out.println(store.IPhoneWaitList);

        one.subscribe(store.IPhoneWaitList);
        two.subscribe(store.IPhoneWaitList);
        three.subscribe(store.IPhoneWaitList);
        System.out.println(store.IPhoneWaitList);

        store.notifyAboutIPhone();

        one.unsubscribe(store.IPhoneWaitList);
        two.unsubscribe(store.IPhoneWaitList);
        three.unsubscribe(store.IPhoneWaitList);
        System.out.println(store.IPhoneWaitList);

    }
}

interface Subscriber{
    void update();
    void subscribe(List<Subscriber> IPhoneWaitList);
    void unsubscribe(List<Subscriber> IPhoneWaitList);
}

class Customer implements Subscriber {

    private boolean notifiedAboutIPhone = false;

    @Override
    public void update() {
        if (!notifiedAboutIPhone) notifiedAboutIPhone = true;
        System.out.println("subscriber # " + this.hashCode() + " is notified");
    }

    @Override
    public void subscribe(List <Subscriber> IPhoneWaitList) {
        IPhoneWaitList.add(this);
    }

    @Override
    public void unsubscribe(List <Subscriber> IPhoneWaitList) {
        IPhoneWaitList.remove(this);
    }
}

class AppleStore {

     List<Subscriber> IPhoneWaitList = new ArrayList<>();

    public boolean hasNewIPhone = false;

    public void notifyAboutIPhone(){
        for (Subscriber subscriber : IPhoneWaitList) {
            subscriber.update();
        }
    }
}
