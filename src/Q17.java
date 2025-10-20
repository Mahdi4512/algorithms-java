public class Q17 {
    public static void main(String[] args) {
        String s = "x*x+x+x-x*x";
        int k = 2;
        System.out.println(eval(s, k, 0)[0]);
    }

    static int[] eval(String s, int k, int i) {
        if (i >= s.length()) return new int[]{0, i};

        int cur = 0;
        char op = '+';

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == 'x') {
                int val = k;
                if (op == '+') cur += val;
                else if (op == '-') cur -= val;
                else if (op == '*') cur *= val;
                i++;
            } else if (ch == '+' || ch == '-' || ch == '*') {
                op = ch;
                i++;
            } else {
                i++;
            }
        }

        return new int[]{cur, i};
    }
}
