public class soal8 {
    public static void main(String[] args) {
        int n = 2;
        printTruthTable(n, 0, "");
    }
    static void printTruthTable(int n, int index, String result) {
        if (index == n) {
            System.out.println(result);
            return;
        }

        printTruthTable(n, index + 1, result + "0 ");
        printTruthTable(n, index + 1, result + "1 ");
    }
}
