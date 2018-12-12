package functiontest.dynamicproxy.jdk;

import functiontest.dynamicproxy.jdk.DynamicProxy;
import functiontest.dynamicproxy.Hello;
import functiontest.dynamicproxy.HelloImpl;

public class DynamicProxyTest {
	public static void main(String[] args) {
		Hello hello = new HelloImpl();
		DynamicProxy dynamicProxy = new DynamicProxy(hello);
		Hello helloProxy = dynamicProxy.getProxy();
		/**
		 * ��һ�������Ͽ��԰Ѳ�����$Proxy0.class��������������һֱ�޷�ִ�гɹ���JDK1.8
		 */
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		helloProxy.hello();
	}
}
