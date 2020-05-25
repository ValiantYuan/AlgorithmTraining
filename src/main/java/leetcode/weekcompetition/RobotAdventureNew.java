package leetcode.weekcompetition;


import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName RobotAdventureNew
 * @Description:
 * @Author: YuanQi
 * @Date: 2020/3/3
 */
public class RobotAdventureNew {

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        Set<Long> obstaclesSet = new HashSet<>();
        // 把障碍的坐标转换为Long型
        for (int[] obstacle: obstacles) {
            obstaclesSet.add(((long)obstacle[0] << 32) + obstacle[1]);
        }
        char[] commands = command.toCharArray();
        int index = 0;
        int startX = 0;
        int startY = 0;
        while(true) {
            if (commands[index] == 'R') {
                startX += 1;
            }
            else if (commands[index] == 'U') {
                startY += 1;
            }
            if (startX == x && startY == y) return true;
            if (obstaclesSet.contains(((long)x << 32) + y)) return false;
            index++;
            // 循环执行
            if(index == commands.length) index = 0;
        }

    }


}
