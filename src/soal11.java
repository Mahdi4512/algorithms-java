public class soal11 {
    public static void main(String[] args) {
        int n = 20;
        printCombinations(n, 10, 0, 0, 0);
    }
    static void printCombinations(int remaining, int coin, int c2, int c5, int c10) {
        if (remaining < 0) return;
        if (remaining == 0) {
            System.out.println("2×" + c2 + "  5×" + c5 + "  10×" + c10);
            return;
        }

        if (coin == 10) {
            printCombinations(remaining - 10, 10, c2, c5, c10 + 1);
            printCombinations(remaining, 5, c2, c5, c10);
        } else if (coin == 5) {
            printCombinations(remaining - 5, 5, c2, c5 + 1, c10);
            printCombinations(remaining, 2, c2, c5, c10);
        } else if (coin == 2) {
            printCombinations(remaining - 2, 2, c2 + 1, c5, c10);
        }
    }
}
