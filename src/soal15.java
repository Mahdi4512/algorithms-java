public class soal15 {
    static int N = 8;
    static int[] pos = new int[N];

    public static void main(String[] args) {
        dfs(0);
    }

    static void dfs(int r) {
        if (r == N) {
            print();
            return;
        }
        for (int c = 0; c < N; c++) {
            if (safe(r, c)) {
                pos[r] = c;
                dfs(r + 1);
            }
        }
    }

    static boolean safe(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (pos[i] == c || Math.abs(pos[i] - c) == Math.abs(i - r))
                return false;
        }
        return true;
    }
    static void print() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(pos[r] == c ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println("---");
    }
}
