package ForGit;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localiz {
    public static void main(String[] args) {

        Locale rus = new Locale("ru", "RU");

        ResourceBundle bundle = ResourceBundle.getBundle("localiz",rus);

        String str = bundle.getString("country");

        System.out.println(str);

        ResourceBundle bundleUS = ResourceBundle.getBundle("localiz",Locale.US);

        System.out.println(bundleUS.getString("country"));

    }
}
