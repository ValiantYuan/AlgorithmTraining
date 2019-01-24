package functiontest.dynamicproxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDynamicProxy implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before intercept");
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("after intercept");
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls) {
		return (T) Enhancer.create(cls, this); 
	}
	
}
