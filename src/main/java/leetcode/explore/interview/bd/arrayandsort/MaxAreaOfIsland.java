package leetcode.explore.interview.bd.arrayandsort;

/**
 * @NAME: MaxAreaOfIsland
 * @USER: valiant
 * @DATE: 2019-09-29
 * @DESCRITION: 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 **/
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        //遍历每一个节点，计算最大值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int area = deepFirstSearch(grid, i, j);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     *
     * @param grid
     * @param i
     * @param j
     * @return
     */
    public int deepFirstSearch(int[][] grid, int i, int j) {
        //边界条件判断
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            //将访问过的点标记为0
            grid[i][j] = 0;
            //计算本点的面积1，同时向四个方向遍历
            return 1 + deepFirstSearch(grid, i - 1, j) + deepFirstSearch(grid, i + 1, j)
                    + deepFirstSearch(grid, i, j - 1) + deepFirstSearch(grid, i, j + 1);
        } else {
            return 0;
        }
    }
}
