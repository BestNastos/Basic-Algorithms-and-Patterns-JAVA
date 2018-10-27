package ForGit;

// П А Т Т Е Р Н Ы
// 1. Порождающие

// Синглтон с ленивой реализацией

public class Singleton {
    public static int forTest = 0;

    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                    forTest++;
                }
            }
        }
        return instance;
    }
}
