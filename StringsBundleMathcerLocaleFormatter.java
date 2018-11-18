package ForGit;

import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsBundleMathcerLocaleFormatter {
    public static void main(String[] args) {

        // Formatter
        System.out.println("-----------------------Formatter----------------------------");

        NumberFormat curForm = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        String format = curForm.format(1355120);
        System.out.println(format);

        NumberFormat numForm = NumberFormat.getNumberInstance(new Locale("ru", "RU"));
        String format1 = numForm.format(1355120);
        System.out.println(format1);

        Formatter formatter = new Formatter();
        System.out.println(formatter.format(Locale.CHINA, "%s", "hi"));

        // ResourceBundle

        System.out.println("-----------------------ResourceBundle----------------------------");

        ResourceBundle bun = ResourceBundle.getBundle("localiz", new Locale("en", "IN"));
        System.out.println(bun.getString("language"));

        Enumeration<String> keys = bun.getKeys();

        while (keys.hasMoreElements()) {
            System.out.println(bun.getString(keys.nextElement()));
        }

        // RegEx
        // Pattern & Matcher
        System.out.println("-----------------------REGEX----------------------------");

        Pattern pattern = Pattern.compile("[c|b]at");
        System.out.println(pattern.pattern());

        Matcher matcher = pattern.matcher("cats");
        Matcher matcher2 = pattern.matcher("fat");
        matcher.find();
        System.out.println(matcher.group());
        System.out.println(matcher.lookingAt());
        System.out.println(matcher.matches());
        matcher.reset("bat");
        System.out.println(matcher.matches());
        System.out.println(matcher2.matches());

        boolean matches = Pattern.matches("\\d\\w*", "3a");
        System.out.println(matches);
        boolean matches1 = Pattern.matches(".*[^abc]{3}", "hi123");
        System.out.println(matches1);


        System.out.println(pattern.pattern());

        // Predicate (filter() takes predicate)
        System.out.println("-----------------------Predicate----------------------------");

        List<Integer> list = Arrays.asList(1, -5, 88, 0 , 6);
        list.stream().filter(i -> i > 0).forEach(System.out::println);




    }
}
