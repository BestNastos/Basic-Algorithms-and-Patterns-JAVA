package ForGit;

import java.math.BigInteger;


public class Algorithms {


    // №1 Сортировка пузырьком

    public static int[] bubbleSort(int[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    // №2 Сортировка вставками

    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;

            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
        return arr;
    }

    // №3 Сортировка выбором

    public static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }

    // №4 Линейный поиск

    public static boolean linearSearch(int[] arr, int n) {

        for (int i : arr) {
            if (i == n) return true;
        }
        return false;
    }

    // №5 Бинарный поиск

    public static boolean binarySearch(int[] arr, int n) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2; //

            if (arr[mid] < n) {
                left = mid + 1;
            } else if (n < arr[mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // № 6 Фибоначчи: найти n-ное число
    // 0 1 1 2 3 5 8 13 21 34 --> последовательность Фибоначчи
    // 0 1 2 3 4 5 6  7  8  9 --> N (индекс)

    public static int fibonacciNumber(int n) {

        if (n < 2) return n;
        
        int previous = 0;
        int current = 1;
        int next = 0;
        for (int i = 2; i <= n; i++) {
            next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    // № 7  Фибоначчи: найти n-ное число рекурсивно

    public static int fibonacciRecursive(int n) {

        if (n < 2) return n;
  
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // № 8  Фибоначчи: вернуть последовательность в виде массива, где n - длина

    public static int[] fibonacciArray(int n) {

        int[] arr = new int[n];

        if (n == 1) arr[0] = 0;
        else if (n > 1) {
            arr[0] = 0;
            arr[1] = 1;

            for (int i = 2; i < n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
        return arr;
    }

    // № 9 Факториал (возвращаемое значение - int)
    // 0  1  2  3   4   5   6 --> n!
    // 1  1  2  6  24 120 720 --> факториал n

    public static int factorialInt(int n) {

        if (n < 0) return n;

        int result = 1;

        for (int i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    // № 10 Факториал рекурсивно (возвращаемое значение - int)

    public static int factorialRecursive(int n) {

        if (n < 0) return n;
        else if (n < 2) return 1;

        return n * factorialRecursive(n - 1);
    }

    // № 11 Факториал (возвращаемое значение - BigInteger)

    public static BigInteger factorialBigInt(int n) {

        if (n < 0) return BigInteger.valueOf(n);
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // № 12  Перевернуть строку библиотечными методами

    public static String reverseViaMethod(String str) {

        return new StringBuilder(str).reverse().toString();
    }

    // № 13 Перевернуть строку алгоритмом

    public static String reverseViaAlgorithm(String str) {

        char[] original = str.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(reversed);
    }

    // №  14  Найти максимальное значение из трех

    public static int maxValue(int a, int b, int c) {

        int max = a;

        if (max < b) max = b;
        if (max < c) max = c;

        return max;
    }

    // №  15  Удалить символ из строки

    public static String deleteCharFromString(String s, char c) {
        if (s.isEmpty()) return "";
        else return s.replace(Character.toString(c), "");
    }
    
     // №  16  Является ли строка палиндромом
    
    public static boolean palindromeString(String s){

        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    
     // №  17  Является ли число палиндромом

    public static boolean palindromeInt(int i){
        
            while (i > 9){

            int lastDigit = i % 10;

            int firstDigit = i;
            int divider = 1;
                
            while (firstDigit > 9) {
                firstDigit = firstDigit / 10;
                divider = divider * 10;
            }

            if (firstDigit != lastDigit) return false;

            i = i % divider;
            if (i > 9) i = i / 10;
        }
        return true;
    }
}
