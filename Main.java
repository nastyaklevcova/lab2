import java.util.*;
import java.math.BigInteger;

public class Main {

    // Функция для вычисления факториала
    public static BigInteger factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Факториал не определён для отрицательных чисел.");
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // Функция для проверки, является ли число квадратом целого числа
    public static boolean isPerfectSquare(int n) {
        if (n < 0) return false;
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    // Функция для проверки, является ли число кубом целого числа
    public static boolean isPerfectCube(int n) {
        int absN = Math.abs(n);
        int cubeRoot = (int) Math.cbrt(absN);
        return cubeRoot * cubeRoot * cubeRoot == absN;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вводим размер массива
        System.out.print("Введите размер массива: ");
        int N = scanner.nextInt();
        long[] originalArr = new long[N];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < N; i++) {
            originalArr[i] = scanner.nextLong();
        }

        // Замена на факториалы для исходного массива
        System.out.println("Массив после замены на факториалы:");
        for (long num : originalArr) {
            if (num >= 0 && num <= 100) { // Ограничение для факториала
                BigInteger fact = factorial((int) num);
                System.out.print(fact + " ");
            } else {
                System.out.print(num + " "); // Если число вне диапазона, оставляем его без изменений
            }
        }
        System.out.println();

        // Создаем массивы для квадратов и остальных чисел
        int squaresCount = 0;
        int othersCount = 0;

        // Подсчитываем количество квадратов и других чисел
        for (long num : originalArr) {
            if (isPerfectSquare((int) num)) {
                squaresCount++;
            } else {
                othersCount++;
            }
        }

        // Массивы для квадратов и остальных чисел
        long[] squares = new long[squaresCount];
        long[] others = new long[othersCount];

        // Заполняем массивы
        int squareIndex = 0, otherIndex = 0;
        for (long num : originalArr) {
            if (isPerfectSquare((int) num)) {
                squares[squareIndex++] = num;  // Заполняем массив квадратов
            } else {
                others[otherIndex++] = num;  // Заполняем массив остальных чисел
            }
        }

        // Объединяем квадраты и остальные числа
        long[] mergedArray = new long[squaresCount + othersCount];
        System.arraycopy(squares, 0, mergedArray, 0, squaresCount);
        System.arraycopy(others, 0, mergedArray, squaresCount, othersCount);

        System.out.println("Объединённый массив:");
        for (long num : mergedArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Подсчитываем количество кубов
        int cubeCount = 0;
        for (long num : mergedArray) {
            if (isPerfectCube((int) num)) {
                cubeCount++;
            }
        }
        System.out.println("Количество кубов: " + cubeCount);

        // Замена квадратов на корни
        System.out.println("Массив после замены квадратов на корни:");
        for (int i = 0; i < N; i++) {
            if (isPerfectSquare((int) originalArr[i])) {
                originalArr[i] = (long) Math.sqrt(originalArr[i]);
            }
            System.out.print(originalArr[i] + " ");
        }
        System.out.println();
    }
}
