package org.example.glava2;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        Random random = new Random();

        // Ввод размерности матрицы
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();

        // Создание и заполнение матрицы случайными числами от -n до n
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n; // Генерация числа от -n до n
            }
        }

        // Вывод исходной матрицы
        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        // 1. Упорядочить строки матрицы по k-му столбцу
        System.out.print("Введите номер столбца для сортировки (0-" + (n - 1) + "): ");
        int k = scanner.nextInt();
        sortRowsByColumn(matrix, k);
        System.out.println("Матрица после сортировки строк по столбцу " + k + ":");
        printMatrix(matrix);

        // 2. Циклический сдвиг вправо на k позиций
        shiftMatrix(matrix, k);
        System.out.println("Матрица после циклического сдвига вправо на " + k + " позиций:");
        printMatrix(matrix);

        // 3. Найти наибольшее число возрастающих/убывающих элементов
        int maxIncreasing = findMaxConsecutiveIncreasing(matrix);
        int maxDecreasing = findMaxConsecutiveDecreasing(matrix);
        System.out.println("Наибольшее число возрастающих элементов: " + maxIncreasing);
        System.out.println("Наибольшее число убывающих элементов: " + maxDecreasing);

        // 4. Сумма элементов между первым и вторым положительными элементами в каждой строке
        int sumBetweenPositives = sumBetweenFirstTwoPositives(matrix);
        System.out.println("Сумма элементов между первым и вторым положительными элементами: " + sumBetweenPositives);

        // 5. Вывод чисел от 1 до k в виде матрицы N x N
        printNumbersInMatrix(n, k);

        // 6. Округление всех элементов матрицы
        roundMatrix(matrix);
        System.out.println("Матрица после округления:");
        printMatrix(matrix);

        // 7. Поворот матрицы на 90 градусов против часовой стрелки
        rotateMatrix(matrix, 90);
        System.out.println("Матрица после поворота на 90 градусов:");
        printMatrix(matrix);

        // 8. Вычисление определителя матрицы
        double determinant = calculateDeterminant(matrix);
        System.out.println("Определитель матрицы: " + determinant);

        // 9. Вычитание среднего арифметического из каждой строки
        subtractRowMean(matrix);
        System.out.println("Матрица после вычитания среднего арифметического из каждой строки:");
        printMatrix(matrix);

        // 10. Удаление строк и столбцов, содержащих максимальный элемент
        removeMaxElementRowsAndColumns(matrix);
        System.out.println("Матрица после удаления строк и столбцов с максимальным элементом:");
        printMatrix(matrix);

        // 11. Уплотнение матрицы (удаление строк и столбцов, заполненных нулями)
        compactMatrix(matrix);
        System.out.println("Уплотненная матрица:");
        printMatrix(matrix);

        // 12. Перемещение минимального элемента на заданное место
        moveMinElement(matrix);
        System.out.println("Матрица после перемещения минимального элемента:");
        printMatrix(matrix);

        // 13. Перестановка нулей в конце каждой строки
        rearrangeZeros(matrix);
        System.out.println("Матрица после перестановки нулей в конце каждой строки:");
        printMatrix(matrix);

        // 14. Поиск седловых точек
        int saddlePoints = countSaddlePoints(matrix);
        System.out.println("Количество седловых точек: " + saddlePoints);

        // 15. Перестановка строк, чтобы сумма элементов возрастала
        reorderRowsBySum(matrix);
        System.out.println("Матрица после перестановки строк по возрастанию суммы элементов:");
        printMatrix(matrix);

        // 16. Поиск локальных минимумов
        int localMinCount = countLocalMinima(matrix);
        System.out.println("Количество локальных минимумов: " + localMinCount);

        // 17. Наименьший среди локальных максимумов
        int smallestLocalMax = findSmallestLocalMaximum(matrix);
        System.out.println("Наименьший среди локальных максимумов: " + smallestLocalMax);

        // 18. Перестановка столбцов по убыванию суммы модулей элементов
        reorderColumnsBySum(matrix);
        System.out.println("Матрица после перестановки столбцов по убыванию суммы модулей:");
        printMatrix(matrix);

        // 19. Перестановка элементов для заполнения главной диагонали
        rearrangeForDiagonal(matrix);
        System.out.println("Матрица после перестановки для заполнения главной диагонали:");
        printMatrix(matrix);
        System.out.println("Разработчик: Дансаранов");
        System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

        LocalDateTime endDateTime = LocalDateTime.now();
        System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
    }

    // Метод для вывода матрицы
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    // Метод для сортировки строк по заданному столбцу
    public static void sortRowsByColumn(int[][] matrix, int k) {
        Arrays.sort(matrix, (a, b) -> Integer.compare(a[k], b[k]));
    }

    // Метод для циклического сдвига матрицы
    public static void shiftMatrix(int[][] matrix, int k) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                temp[(j + k) % n] = matrix[i][j];
            }
            matrix[i] = temp;
        }
    }

    // Метод для нахождения максимального числа возрастающих элементов
    public static int findMaxConsecutiveIncreasing(int[][] matrix) {
        int maxCount = 0;
        for (int[] row : matrix) {
            int count = 1;
            for (int j = 1; j < row.length; j++) {
                if (row[j] > row[j - 1]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    // Метод для нахождения максимального числа убывающих элементов
    public static int findMaxConsecutiveDecreasing(int[][] matrix) {
        int maxCount = 0;
        for (int[] row : matrix) {
            int count = 1;
            for (int j = 1; j < row.length; j++) {
                if (row[j] < row[j - 1]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    // Метод для суммы элементов между первым и вторым положительными элементами
    public static int sumBetweenFirstTwoPositives(int[][] matrix) {
        int totalSum = 0;
        for (int[] row : matrix) {
            int firstPositiveIndex = -1;
            int secondPositiveIndex = -1;
            for (int j = 0; j < row.length; j++) {
                if (row[j] > 0) {
                    if (firstPositiveIndex == -1) {
                        firstPositiveIndex = j;
                    } else if (secondPositiveIndex == -1) {
                        secondPositiveIndex = j;
                        break;
                    }
                }
            }
            if (firstPositiveIndex != -1 && secondPositiveIndex != -1) {
                for (int j = firstPositiveIndex + 1; j < secondPositiveIndex; j++) {
                    totalSum += row[j];
                }
            }
        }
        return totalSum;
    }

    // Метод для вывода чисел от 1 до k в виде матрицы N x N
    public static void printNumbersInMatrix(int n, int k) {
        int[][] numbersMatrix = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (num <= k) {
                    numbersMatrix[i][j] = num++;
                } else {
                    numbersMatrix[i][j] = 0; // Заполняем оставшиеся элементы нулями
                }
            }
        }
        System.out.println("Числа от 1 до " + k + " в виде матрицы:");
        printMatrix(numbersMatrix);
    }

    // Метод для округления всех элементов матрицы
    public static void roundMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) Math.round(matrix[i][j]);
            }
        }
    }

    // Метод для поворота матрицы на заданный угол
    public static void rotateMatrix(int[][] matrix, int angle) {
        int n = matrix.length;
        if (angle == 90) {
            int[][] rotated = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rotated[j][n - 1 - i] = matrix[i][j];
                }
            }
            System.arraycopy(rotated, 0, matrix, 0, n);
        } else if (angle == 180) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = matrix[n - 1 - i][n - 1 - j];
                }
            }
        } else if (angle == 270) {
            int[][] rotated = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rotated[n - 1 - j][i] = matrix[i][j];
                }
            }
            System.arraycopy(rotated, 0, matrix, 0, n);
        }
    }

    // Метод для вычисления определителя матрицы
    public static double calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double determinant = 0;
        for (int j = 0; j < n; j++) {
            determinant += Math.pow(-1, j) * matrix[0][j] * calculateDeterminant(minor(matrix, 0, j));
        }
        return determinant;
    }

    // Метод для получения минора матрицы
    public static int[][] minor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != row && j != col) {
                    minor[i < row ? i : i - 1][j < col ? j : j - 1] = matrix[i][j];
                }
            }
        }
        return minor;
    }

    // Метод для вычитания среднего арифметического из каждой строки
    public static void subtractRowMean(int[][] matrix) {
        for (int[] row : matrix) {
            double mean = Arrays.stream(row).average().orElse(0);
            for (int j = 0; j < row.length; j++) {
                row[j] -= mean;
            }
        }
    }

    // Метод для удаления строк и столбцов, содержащих максимальный элемент
    public static void removeMaxElementRowsAndColumns(int[][] matrix) {
        int maxElement = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int value : row) {
                maxElement = Math.max(maxElement, value);
            }
        }

        boolean[] rowsToRemove = new boolean[matrix.length];
        boolean[] colsToRemove = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == maxElement) {
                    rowsToRemove[i] = true;
                    colsToRemove[j] = true;
                }
            }
        }

        int[][] finalMatrix = matrix;
        matrix = Arrays.stream(matrix)
                .filter(row -> !rowsToRemove[Arrays.asList(finalMatrix).indexOf(row)])
                .toArray(int[][]::new);

        for (int j = 0; j < matrix.length; j++) {
            if (colsToRemove[j]) {
                matrix[j] = Arrays.stream(matrix[j])
                        .filter(value -> !Arrays.asList(colsToRemove).contains(value))
                        .toArray();
            }
        }
    }

    // Метод для уплотнения матрицы (удаление строк и столбцов, заполненных нулями)
    public static void compactMatrix(int[][] matrix) {
        // Удаление строк, заполненных нулями
        matrix = Arrays.stream(matrix)
                .filter(row -> Arrays.stream(row).anyMatch(value -> value != 0))
                .toArray(int[][]::new);

        // Удаление столбцов, заполненных нулями
        for (int j = 0; j < matrix[0].length; j++) {
            final int colIndex = j;
            if (Arrays.stream(matrix).allMatch(row -> row[colIndex] == 0)) {
                for (int i = 0; i < matrix.length; i++) {
                    int[][] finalMatrix = matrix;
                    int finalI = i;
                    matrix[i] = Arrays.stream(matrix[i])
                            .filter(value -> value != finalMatrix[finalI][colIndex])
                            .toArray();
                }
            }
        }
    }

    // Метод для перемещения минимального элемента на заданное место
    public static void moveMinElement(int[][] matrix) {
        int minElement = Integer.MAX_VALUE;
        int minRow = -1, minCol = -1;

        // Поиск минимального элемента
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }

        // Перемещение минимального элемента на заданное место
        if (minRow != -1 && minCol != -1) {
            matrix[minRow][minCol] = matrix[0][0]; // Заменяем минимальный элемент
            matrix[0][0] = minElement; // Ставим минимальный элемент на место (0,0)
        }
    }

    // Метод для перестановки нулей в конце каждой строки
    public static void rearrangeZeros(int[][] matrix) {
        for (int[] row : matrix) {
            int count = 0;
            for (int value : row) {
                if (value != 0) count++;
            }
            int[] newRow = new int[row.length];
            for (int i = 0; i < count; i++) {
                newRow[i] = row[i];
            }
            for (int i = count; i < newRow.length; i++) {
                newRow[i] = 0;
            }
            System.arraycopy(newRow, 0, row, 0, row.length);
        }
    }

    // Метод для подсчета седловых точек
    public static int countSaddlePoints(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean isSaddlePoint = true;
                // Проверяем, является ли элемент минимальным в строке
                for (int k = 0; k < matrix[i].length; k++) {
                    if (matrix[i][k] < matrix[i][j]) {
                        isSaddlePoint = false;
                        break;
                    }
                }
                // Проверяем, является ли элемент максимальным в столбце
                if (isSaddlePoint) {
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[k][j] > matrix[i][j]) {
                            isSaddlePoint = false;
                            break;
                        }
                    }
                }
                if (isSaddlePoint) {
                    count++;
                }
            }
        }
        return count;
    }

    // Метод для перестановки строк по возрастанию суммы элементов
    public static void reorderRowsBySum(int[][] matrix) {
        Arrays.sort(matrix, (a, b) -> Integer.compare(Arrays.stream(a).sum(), Arrays.stream(b).sum()));
    }

    // Метод для подсчета локальных минимумов
    public static int countLocalMinima(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean isLocalMin = true;
                for (int x = Math.max(0, i - 1); x <= Math.min(matrix.length - 1, i + 1); x++) {
                    for (int y = Math.max(0, j - 1); y <= Math.min(matrix[i].length - 1, j + 1); y++) {
                        if (x == i && y == j) continue;
                        if (matrix[x][y] <= matrix[i][j]) {
                            isLocalMin = false;
                            break;
                        }
                    }
                }
                if (isLocalMin) {
                    count++;
                }
            }
        }
        return count;
    }

    // Метод для нахождения наименьшего среди локальных максимумов
    public static int findSmallestLocalMaximum(int[][] matrix) {
        int smallestLocalMax = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean isLocalMax = true;
                for (int x = Math.max(0, i - 1); x <= Math.min(matrix.length - 1, i + 1); x++) {
                    for (int y = Math.max(0, j - 1); y <= Math.min(matrix[i].length - 1, j + 1); y++) {
                        if (x == i && y == j) continue;
                        if (matrix[x][y] >= matrix[i][j]) {
                            isLocalMax = false;
                            break;
                        }
                    }
                }
                if (isLocalMax) {
                    found = true;
                    smallestLocalMax = Math.min(smallestLocalMax, matrix[i][j]);
                }
            }
        }
        return found ? smallestLocalMax : Integer.MIN_VALUE;
    }

    // Метод для перестановки столбцов по убыванию суммы модулей элементов
    public static void reorderColumnsBySum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Integer[] columnIndices = new Integer[m];
        for (int i = 0; i < m; i++) {
            columnIndices[i] = i;
        }

        Arrays.sort(columnIndices, (a, b) -> Integer.compare(
                Arrays.stream(matrix).mapToInt(row -> Math.abs(row[a])).sum(),
                Arrays.stream(matrix).mapToInt(row -> Math.abs(row[b])).sum()
        ));

        int[][] sortedMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sortedMatrix[i][j] = matrix[i][columnIndices[j]];
            }
        }
        System.arraycopy(sortedMatrix, 0, matrix, 0, n);
    }

    // Метод для перестановки элементов для заполнения главной диагонали
    public static void rearrangeForDiagonal(int[][] matrix) {
        int n = matrix.length;
        int[] sortedElements = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .sorted((a, b) -> b - a) // Сортируем по убыванию
                .mapToInt(i -> i)
                .toArray();

        for (int i = 0; i < n; i++) {
            matrix[i][i] = sortedElements[i]; // Заполняем главную диагональ
        }
    }
}
