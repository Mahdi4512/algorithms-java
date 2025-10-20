public class soal14 {
    public static void main(String[] args) {
        int n = 3;
        hanoi(n, 'S', 'D', 'A');
    }

    static void hanoi(int n, char src, char dest, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + src + " to " + aux);
            System.out.println("Move disk 1 from " + aux + " to " + dest);
            return;
        }

        hanoi(n - 1, src, dest, aux);
        System.out.println("Move disk " + n + " from " + src + " to " + aux);
        System.out.println("Move disk " + n + " from " + aux + " to " + dest);
        hanoi(n - 1, dest, src, aux);
    }
}
