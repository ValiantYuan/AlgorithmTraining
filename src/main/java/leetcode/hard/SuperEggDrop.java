package leetcode.hard;

/**
 * @NAME: SuperEggDrop
 * @USER: valiant
 * @DATE: 2019-10-18
 * @DESCRITION:你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        //i表示鸡蛋个数，j表示尝试次数，dp[i][j]表示i个鸡蛋尝试j次能确定的最大楼层数
        //这里必须注意外层循环是尝试次数，内层代表着i个鸡蛋在j次尝试下确定最大层数到过程
        //显然dp内的一维数组都是单调递增数组，j次尝试时肯定是K个鸡蛋能确定的最大楼层数最大，如果确定的层数没有大于N，则要多一次尝试
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= K; i++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1] + 1;
                if (dp[i][j] >= N) {
                    return j;
                }
            }
        }
        return N;
    }


    public static void main(String[] args) {
        int count = new SuperEggDrop().superEggDrop(2,100);
        System.out.println(count);
    }
}
