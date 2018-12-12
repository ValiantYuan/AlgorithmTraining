package functiontest.reflection;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws Exception {
		
		TestA a = new TestA(1);
		TestB b = new TestB();
		TestA c = new TestA(2);
		Method method = a.getClass().getMethod("say");
		try {
			method.invoke(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		method.invoke(c);
	}
}
