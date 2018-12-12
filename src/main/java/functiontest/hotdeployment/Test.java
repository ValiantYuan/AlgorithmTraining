package functiontest.hotdeployment;

import functiontest.hotdeployment.A;

public class Test {
	public static void main(String[] args) throws Exception {
		//这里编译时会报错，找不到符号
//		new A();
		/**
		 * 如果A类不存在时，编译不会报错，运行时这里会报错ClassNotFoundException
		 * 
		 */
		((A) Class.forName("hotdeployment.A").newInstance()).say();
		
		/**
		 * 如果A类存在，运行前把A.class删除，则这里会报错NoClassDefFoundError
		 */
		new A().say();
	}
}
