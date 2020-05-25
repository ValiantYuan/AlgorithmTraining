package leetcode.weekcompetition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName RobotAdventure
 * @Description: https://leetcode-cn.com/problems/programmable-robot/
 * LCP 3. 机器人大冒险
 * @Author: YuanQi
 * @Date: 2020/2/24
 */
public class RobotAdventure {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        if (command == null) return false;
        Coordinate curPos = new Coordinate(0, 0);
        Set<Coordinate> obsCoordinates =
            Arrays.stream(obstacles).map(ints -> new Coordinate(ints[0], ints[1]))
                .collect(Collectors.toSet());
        char[] commands = command.toCharArray();
        int index = 0;
        while(true) {
            if (commands[index] == 'R') {
                curPos.x += 1;
            }
            else if (commands[index] == 'U') {
                curPos.y += 1;
            }
            if (curPos.x == x && curPos.y == y) return true;
            if (obsCoordinates.contains(curPos)) return false;
            index++;
            if(index == commands.length) index = 0;
        }
    }

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * 注意HashMap中判断contains时，首先要判断hashCode相等，接下来才是调用equals方法
         * 类似 a.hashCode == b.hashCode && a.equals(b)
         * 所以单独重写equals方法不行，还要重写hashCode
         * @param o
         * @return
         */
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (this == o) return true;
            if (o instanceof Coordinate) {
                Coordinate cor = (Coordinate)o;
                return this.x == cor.x && this.y == cor.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return x * 100 + y * 10;
        }
    }

    public static void main(String[] args) {
        String command = "URR";
        int[][] obs = {{2, 2}};
        System.out.println(new RobotAdventure().robot(command, obs, 3, 2));
    }
}
