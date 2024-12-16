import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        // 1. Ввод массива
        out.print("Введите размер массива N: ");
        int n = in.nextInt();
        int[] array = new int[n];
        out.println("Введите " + n + " целых чисел, не превышающих 20 :");
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (num > 20) {
                out.println("Число не должно превышать 20! Пожалуйста, введите другое.");
                i--;
            } else {
                array[i] = num;
            }
        }
        // 2. Сортировка массива (квадраты -> по возрастанию, остальные -> по убыванию)
        int[] squares = new int[n];
        int[] others = new int[n];
        int squaresCount = 0;
        int othersCount = 0;

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num) {
                squares[squaresCount++] = num;
            } else {
                others[othersCount++] = num;
            }
        }

        // Сортировка квадратов по возрастанию
        for (int i = 0; i < squaresCount - 1; i++) { //i отслеживает кол-во завершенных проходов по массиву
            for (int j = 0; j < squaresCount - 1 - i; j++) { //j отслеживает индекс текущего элемента в массиве для сравнения
                if (squares[j] > squares[j + 1]) {
                    // Обмен значений
                    int z = squares[j];
                    squares[j] = squares[j + 1];
                    squares[j + 1] = z;
                }
            }
        }
        // Сортировка остальных чисел по убыванию
        for (int i = 0; i < othersCount - 1; i++) {
            for (int j = 0; j < othersCount - 1 - i; j++) {
                if (others[j] < others[j + 1]) {
                    // Обмен значений
                    int z = others[j];
                    others[j] = others[j + 1];
                    others[j + 1] = z;
                }
            }
        }
        // Объединение отсортированных массивов
        int[] sortedArray = new int[squaresCount + othersCount];
        int index = 0;
        // Добавляем отсортированные квадраты
        for (int i = 0; i < squaresCount; i++) {
            sortedArray[index++] = squares[i];
        }
        // Добавляем остальные числа
        for (int i = 0; i < othersCount; i++) {
            sortedArray[index++] = others[i];
        }
        // Вывод объединенного массива
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < sortedArray.length; i++) {
            out.print(sortedArray[i] + " ");
        }
        out.println();

        // 3. Подсчет чисел, являющихся кубами целых чисел
        int cubeCount = 0;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int cbrt = (int) Math.cbrt(num);
            if (cbrt * cbrt * cbrt == num) {
                cubeCount += 1;
            }
        }
        out.println("Количество чисел, являющихся кубами целых чисел: " + cubeCount);

        // 4. Замена квадратов на их квадратные корни и вывод массива
        out.println("Массив после замены квадратов на их квадратные корни:");
        for (int i = 0; i < n; i++) {
            int sqrt = (int) Math.sqrt(array[i]);
            if (sqrt * sqrt == array[i]) {
                out.print(sqrt + " ");
            } else {
                out.print(array[i] + " ");
            }
        }
        out.println();

        // 5. Замена каждого числа на его факториал и вывод массива
        out.println("Массив после замены чисел на их факториалы:");
        for (int i = 0; i < n; i++) {
            int num = array[i];
            if (num < 0) {
                out.print(num + " ");
            } else {
                long fact = 1;
                for (int j = 1; j <= num; j++) {
                    fact *= j;
                }
                out.print(fact + " ");
            }
        }
        out.println();
        in.close();
    }
}
