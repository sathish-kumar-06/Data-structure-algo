package stackandqueue;

public class FIndCelebrity {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0},
                {0, 1, 0},
                {0, 1, 1}};
        System.out.println(celebrity(mat));
    }

    public static int celebrity(int[][] mat) {
        int n = mat.length;
        if (n == 0) return -1;
        int top = 0;
        int down = n - 1;

        while (top < down) {
            if (mat[top][down] == 1) {
                top++;
            } else if (mat[down][top] == 1) {
                down--;
            } else {
                top++;
                down--;
            }
        }

        int cand = top;

        for (int j = 0; j < n; j++) {
            if (j == cand) continue;
            if (mat[cand][j] == 1) {
                return -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == cand) continue;
            if (mat[i][cand] == 0) {
                return -1;
            }
        }

        return cand;

    }
}
