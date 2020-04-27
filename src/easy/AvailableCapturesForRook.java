/**
 * Created by xwx_ on 2020/3/26
 */

/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。
 *
 * 大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
 *
 * 另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 *
 * 提示：
 *
 *     1.board.length == board[i].length == 8
 *     2.board[i][j] 可以是 'R'，'.'，'B' 或 'p'
 *     3.只有一个格子上存在 board[i][j] == 'R'
 *
 */


public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};    //定义方向上下左右
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {   //找出白色车rook
                    int res = 0;
                    for (int[] direction : directions) {
                        if (rampage(board, i, j, direction)) {  //从车的位置开始向四个方向遍历
                            res++;
                        }
                    }
                    return res;
                }
            }
        }
        return 0;
    }

    private boolean rampage(char[][] board, int x, int y, int[] direction) {
        int i = x;
        int j = y;
        while (inArea(i, j)) {
            if (board[i][j] == 'B') {   //遇到友军Bishop撤回
                break;
            }

            if (board[i][j] == 'p') {   //遇到敌军pawn击杀
                return true;
            }
            i += direction[0];
            j += direction[1];
        }
        return false;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    public static void main(String[] args) {
        char[][] board =
                        {{'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'}};

        AvailableCapturesForRook solution = new AvailableCapturesForRook();
        int res = solution.numRookCaptures(board);
        System.out.println(res);

    }

}
