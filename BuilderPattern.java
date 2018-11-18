package ForGit;

public class BuilderPattern {
    public static void main(String[] args) {

        House house = House.builder().windows(4).pool(false).walls("brick").buildHouse();
        System.out.println(house);

    }

}

class House {

    String walls;
    int windows;
    boolean pool;

    House(String walls, int windows, boolean pool){
        this.walls = walls;
        this.windows = windows;
        this.pool = pool;
    }

    public static HouseBuilder builder(){
        return new HouseBuilder();
    }

    public String toString(){
        return "House - walls: " + walls + ", windows: " + windows + ", pool: " + pool;
    }
}

class HouseBuilder {
    String walls;
    int windows;
    boolean pool;

    public HouseBuilder walls(String walls){
        this.walls = walls;
        return this;
    }

    public HouseBuilder windows(int windows){
        this.windows = windows;
        return this;
    }

    public HouseBuilder pool(boolean pool){
        this.pool = pool;
        return this;
    }

    public House buildHouse(){
        return new House(walls, windows, pool);
    }

    public String toString(){
        return "HouseBuilder - walls: " + walls + ", windows: " + windows + ", pool: " + pool;
    }

}


