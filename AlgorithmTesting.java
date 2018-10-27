package ForGit;

import org.junit.Test;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.junit.Assert.*;

public class AlgorithmTesting {

    // №1 Сортировка пузырьком

    @Test
    public void bubbleSort() {
        int[] original = {4, 0, 88, 1563, -171};
        int[] expected = {-171, 0, 4, 88, 1563};
        original = QA.Algorithms.bubbleSort(original);
        assertArrayEquals(expected, original);
    }

    // №2 Сортировка вставками

    @Test
    public void insertionSort() {

        int[] original = {4, 0, 88, 1563, -171};
        int[] expected = {-171, 0, 4, 88, 1563};
        original = QA.Algorithms.insertionSort(original);
        assertArrayEquals(expected, original);
    }


    // №3 Сортировка выбором

    @Test
    public void selectionSort() {

        int[] original = {4, 0, 88, 1563, -171};
        int[] expected = {-171, 0, 4, 88, 1563};
        original = QA.Algorithms.selectionSort(original);
        assertArrayEquals(expected, original);
    }

    // №4 Линейный поиск

    @Test
    public void linearSearch() {

        int[] array = {5, 6, 77, -163, 1578};
        assertTrue(QA.Algorithms.linearSearch(array, 77));
        assertFalse(QA.Algorithms.linearSearch(array, -7));
    }

    // №5 Бинарный поиск

    @Test
    public void binarySearch() {

        int[] array = {5, 6, 77, -163, 1578};
        assertTrue(QA.Algorithms.binarySearch(array, 77));
        assertFalse(QA.Algorithms.binarySearch(array, -7));
    }

    // № 6 Фибоначчи: найти n-ное число
    @Test
    public void fibonacciNumber() {

        assertEquals(21, QA.Algorithms.fibonacciNumber(8));
    }

    // № 7  Фибоначчи: найти n-ное число рекурсивно
    @Test
    public void fibonacciRecursive() {

        assertEquals(21, QA.Algorithms.fibonacciRecursive(8));
    }

    // № 8  Фибоначчи: вернуть последовательность в виде массива, где n - длина
    @Test
    public void fibonacciArray() {

        int[] array = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        assertArrayEquals(array, QA.Algorithms.fibonacciArray(10));
    }

    // № 9 Факториал (возвращаемое значение - int)
    @Test
    public void factorialInt() {

        assertEquals(720, QA.Algorithms.factorialInt(6));
    }

    // № 10 Факториал рекурсивно (возвращаемое значение - int)
    @Test
    public void factorialRecursive() {

        assertEquals(720, QA.Algorithms.factorialRecursive(6));
    }

    // № 11 Факториал (возвращаемое значение - BigInteger)
    @Test
    public void factorialBigInt() {

        assertEquals(BigInteger.valueOf(720), QA.Algorithms.factorialBigInt(6));
    }

    // № 12  Перевернуть строку библиотечными методами
    @Test
    public void reverseViaMethod() {

        String original = "Hello World";
        original = QA.Algorithms.reverseViaMethod(original);
        String expected = "dlroW olleH";
        assertEquals(original, expected);
    }

    // № 13 Перевернуть строку алгоритмом
    @Test
    public void reverseViaAlgorithm() {
        String original = "Hello World";
        original = QA.Algorithms.reverseViaAlgorithm(original);
        String expected = "dlroW olleH";
        assertEquals(original, expected);
    }

    // №  14  Найти максимальное значение из трех
    @Test
    public void maxValue() {

        assertEquals(88, Algorithms.maxValue(0, 88, -9));
    }

    @Test
    public void singletonTest(){

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100 ; i++) {
            pool.submit(Singleton::getInstance);
        }
        assertEquals(1, Singleton.forTest);
    }
}



