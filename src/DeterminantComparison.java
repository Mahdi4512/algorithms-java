import java.util.Random;
import java.util.Scanner;

public class DeterminantComparison {

    // 🔹 ساخت ماتریس تصادفی
    static double[][] generateMatrix(int n) {
        Random rand = new Random();
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(10); // عدد تصادفی بین 0 تا 9
            }
        }
        return matrix;
    }

    // 🔹 چاپ ماتریس
    static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%6.2f ", val);
            }
            System.out.println();
        }
    }

    // 🔹 دترمینان به روش بازگشتی (Laplace expansion)
    static double determinantRecursive(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double det = 0;
        for (int j = 0; j < n; j++) {
            det += Math.pow(-1, j) * matrix[0][j] * determinantRecursive(minor(matrix, 0, j));
        }
        return det;
    }

    // 🔹 ساخت زیرماتریس برای روش بازگشتی
    static double[][] minor(double[][] matrix, int row, int col) {
        int n = matrix.length;
        double[][] result = new double[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                result[r][c++] = matrix[i][j];
            }
            r++;
        }
        return result;
    }

    // 🔹 دترمینان با روش گوس (Gaussian Elimination)
    static double determinantGaussian(double[][] matrix) {
        int n = matrix.length;
        double[][] mat = new double[n][n];
        for (int i = 0; i < n; i++)
            mat[i] = matrix[i].clone();

        double det = 1;
        for (int i = 0; i < n; i++) {
            int pivot = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(mat[j][i]) > Math.abs(mat[pivot][i])) pivot = j;
            }

            if (i != pivot) {
                double[] temp = mat[i];
                mat[i] = mat[pivot];
                mat[pivot] = temp;
                det *= -1;
            }

            if (mat[i][i] == 0) return 0;

            det *= mat[i][i];
            for (int j = i + 1; j < n; j++) {
                double factor = mat[j][i] / mat[i][i];
                for (int k = i; k < n; k++) {
                    mat[j][k] -= factor * mat[i][k];
                }
            }
        }
        return det;
    }

    // 🔹 تابع اصلی (Main)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix size n: ");
        int n = sc.nextInt();

        double[][] matrix = generateMatrix(n);

        System.out.println("\nGenerated Matrix:");
        printMatrix(matrix);

        // --- روش بازگشتی ---
        long start1 = System.nanoTime();
        double detRec = determinantRecursive(matrix);
        long end1 = System.nanoTime();

        // --- روش گاوس ---
        long start2 = System.nanoTime();
        double detGauss = determinantGaussian(matrix);
        long end2 = System.nanoTime();

        // --- نمایش نتایج ---
        System.out.printf("\nDeterminant (Recursive): %.2f", detRec);
        System.out.printf("\nDeterminant (Gaussian): %.2f", detGauss);

        System.out.printf("\n\nTime Recursive: %.3f ms", (end1 - start1) / 1e6);
        System.out.printf("\nTime Gaussian: %.3f ms\n", (end2 - start2) / 1e6);

        // --- مقایسه‌ی پیچیدگی ---
        System.out.println("\nComplexity Analysis:");
        System.out.println("  Recursive Method : O(n!)");
        System.out.println("  Gaussian Method  : O(n^3)");

        if (n > 6)
            System.out.println("  ✅ Gaussian elimination is MUCH faster for large n.");
        else
            System.out.println("  ⚠️ For small n, both methods work fine.");

        sc.close();
    }
}
