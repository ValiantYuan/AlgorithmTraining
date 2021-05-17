package leetcode.problem.medium.array;

/**
 * @author : yuanqi
 * @since : 2021/2/18
 * https://leetcode-cn.com/problems/gas-station/
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int i = 0;
        int n = gas.length;;
        while (i < n) {
            int gasSum = 0;
            int costSum = 0;
            int step = 0;
            while (step < n) {
                int index = (i + step) % n;
                gasSum += gas[index];
                costSum += cost[index];
                if (gasSum < costSum) {
                    break;
                }
                step++;
            }
            if (step == n) {
                return i;
            } else {
                i += step + 1;
            }
        }
        return -1;
    }
}
