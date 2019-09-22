package geektimepractice.backtracking;

/**
 * @NAME: EightQueens
 * @USER: valiant
 * @DATE: 2019-08-28
 * @DESCRITION:
 **/
public class EightQueens {
    private int[] result;
    private int count = 0;

    public EightQueens(int size) {
        result = new int[size];
    }

    /**
     *
     * @param row
     * @param column
     * @return boolean
     */
    private boolean placeable(int row, int column) {
        int left = column;
        int right = column;
        for (int i = row - 1; i >= 0; i--) {
            //当前列对应的左列和右列
            left--;
            right++;
            //如果和纵向上一行相等，则不满足条件
            if (result[i] == column) {
                return false;
            }
            //如果和左上斜对角的值（当前行上一行，当前列前一列）相等，则不满足条件
            if (left >= 0 && result[i] == left) {
                return false;
            }
            //如果和右上斜对角的值（当前行上一行，当前列后一列）相等，则不满足条件
            if (right <= result.length - 1 && result[i] == right) {
                return false;
            }
        }
        return true;
    }


    private void place(int row) {
        //找到了一种解法，打印结果
        if (row == 8) {
            printResult();
            return;
        }
        //深度优先搜索，回溯一般都是由递归实现
        for (int i = 0; i < result.length; i++) {
            if (placeable(row, i)) {
                result[row] = i;
                place(row + 1);
            }
        }
    }

    /**
     * 以棋盘的形式输出结果值
     */
    private void printResult() {
        count++;
        for(int i = 0; i < result.length; i++) {
            int pos = result[i];
            for (int j = 0; j < result.length; j++) {
                if (j == pos) {
                    System.out.print("1" + " ");
                } else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }
        System.out.println("第" + count + "种解法");
    }

    /**
     * 测试打印程序
     */
    private void printTest() {
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        printResult();
    }

    public static void main(String[] args) {
        new EightQueens(8).place(0);

    }















































}
