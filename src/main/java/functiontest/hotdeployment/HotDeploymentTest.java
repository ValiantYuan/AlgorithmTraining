package functiontest.hotdeployment;

import java.net.URL;
import java.net.URLClassLoader;

public class HotDeploymentTest {
	public static void main(String[] args) throws Exception {
		URL classUrl = new URL("file:/Users/chenlianda/eclipse-workspace/Markdown/src/");
		while (true) {
			URLClassLoader classLoader = new URLClassLoader(new URL[] {classUrl});
			/**
			 *����Ҫע�⣬����Ҳ��������һ���֣���ִ��ʱ��Ӧ�ð���İ�������
			 *ͬ���ģ�����������ִ��java����ʱ��Ҳ��Ҫ���ϰ��� 
			 */
			Class<?> clazz = classLoader.loadClass("hotdeployment.Hello");
			Object instance = clazz.newInstance();
//			clazz.getMethod("hello").invoke(instance);
			System.out.println(clazz.getClassLoader() + ":" + clazz);
			System.out.println("the number is " + clazz.getMethod("getValue").invoke(instance));
			classLoader.close();
			System.gc();
			Thread.sleep(5000);
		}
	}
}
