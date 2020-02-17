package practice;

import java.time.LocalDateTime;

public class Test {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("地址：" + "中文测试" + "\n");
        stringBuilder.append("       " + "中文测试" + "\n");
        System.out.println(stringBuilder.toString());


    }
}
