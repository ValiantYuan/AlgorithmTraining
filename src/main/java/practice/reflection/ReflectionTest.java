package practice.reflection;

/**
 * @ClassName ReflectionTest
 * @Description: TODO
 * @Author: YuanQi
 * @Date: 2020/1/9
 */
public class ReflectionTest {

    public static void main(String[] args) {
        new ReflectionTest().getReflectionClass(new CommonImpl());
    }

    public void getReflectionClass(Common common) {
        System.out.println(common.getClass());
    }


}
