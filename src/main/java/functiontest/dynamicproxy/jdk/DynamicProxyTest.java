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
		 * 这一步理论上可以把产生的$Proxy0.class保存下来，但是一直无法执行成功，JDK1.8
		 */
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		helloProxy.hello();
	}
}
