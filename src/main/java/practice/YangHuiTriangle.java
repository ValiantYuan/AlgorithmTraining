package practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class YangHuiTriangle {
    private final int level;
    private final String path = "/Users/valiant/IdeaProjects/Practice";

    public YangHuiTriangle(int level) {
        this.level = level;

    }

    public void print() throws Exception{
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String filePath = path + "/result.txt";
//        File file = new File(filePath);
//        file.delete();
//        file.createNewFile();

        System.out.println(level + "层杨辉三角如下：");
//        StringBuilder builder = new StringBuilder();
//        builder.append(level).append("层杨辉三角如下：");
//        writeToFile(file, builder.toString());

        for (int row = 0; row < level; row++) {
//            builder.delete(0, builder.length());
            for (int j = 0; j < level - row; j++) {
                System.out.print(" ");
//                builder.append(" ");
            }
            for (int column = 0; column < row + 1; column++) {
                System.out.print(num(row, column) + " ");
//                builder.append(num(row, column)).append( " ");
            }
            System.out.println();
//            writeToFile(file, builder.toString());
        }

    }


    public void printWithCache() throws Exception {
        System.out.println(level + "层杨辉三角如下：");
        long[][] cache = new long[level][];
        for (int row = 0; row < level; row++) {
            long[] array = new long[row + 1];
            for (int j = 0; j < level - row; j++) {
                System.out.print(" ");
            }
            for (int column = 0; column < row + 1; column++) {
                array[column] = getCachedResult(row, column, cache);
                System.out.print(array[column] + " ");
            }
            cache[row] = array;
            System.out.println();
        }
    }

    private long getCachedResult(int row, int column, long[][] cache) {
        if (column == 0 || column == row) {
            return 1;
        }
        return cache[row - 1][column - 1] + cache[row - 1][column];
    }

    private void writeToFile(File file, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(content);
        printWriter.flush();
        printWriter.close();
    }


    private long num(int row, int column) {
        //第一列都为1
        if (column == 0 || column == row) {
            return  1;
        }
        return num(row - 1, column - 1) + num(row - 1, column);
    }


    public static void main(String[] args)  {
        YangHuiTriangle yangHuiTriangle = new YangHuiTriangle(30);
        try {
            long startTime1 = System.currentTimeMillis();
            yangHuiTriangle.print();
            long endTime1 = System.currentTimeMillis();

            long startTime2 = System.currentTimeMillis();
            long endTime2 = System.currentTimeMillis();
            yangHuiTriangle.printWithCache();
            System.out.println("有缓存时执行50层计算时间为：" + (endTime2 - startTime2));
            System.out.println("没有缓存时执行50层计算时间为：" + (endTime1 - startTime1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
