package leetcode.problem.medium.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindCircleNum {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (visited[j] == 0 && M[i][j] == 1) {
                visited[j] = 1;
                dfs(M, visited,j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] friends = new int[][] {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new FindCircleNum().findCircleNum(friends));
    }
}
