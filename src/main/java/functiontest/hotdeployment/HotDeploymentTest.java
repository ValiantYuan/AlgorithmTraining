package functiontest.hotdeployment;

import java.net.URL;
import java.net.URLClassLoader;

public class HotDeploymentTest {
	public static void main(String[] args) throws Exception {
		URL classUrl = new URL("file:/Users/chenlianda/eclipse-workspace/Markdown/src/");
		while (true) {
			URLClassLoader classLoader = new URLClassLoader(new URL[] {classUrl});
			/**
			 *这里要注意，包名也是类名的一部分，在执行时，应该把类的包名带上
			 *同样的，在命令行中执行java程序时，也需要带上包名 
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
