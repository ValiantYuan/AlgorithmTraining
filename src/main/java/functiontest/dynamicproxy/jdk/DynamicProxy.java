package functiontest.dynamicproxy.jdk;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class DynamicProxy implements InvocationHandler{
	private Object target;
	public DynamicProxy(Object target) {
		super();
		this.target = target;
	}
	/**
	 * @param porxy：the proxy instance that the method was invoked on, 
	 * 即通过getProxy()获取到的这个Proxy对象，简单说就是虚拟机产生的$Proxy0.class代理类的实例
	 * @param method:想要执行的方法，绑定了方法所在的类，而不是实例对象
	 * @param args: method方法需要的参数数组
	 * proxy对象的作用：
	 * 1.可以使用反射获取代理对象的信息 proxy.getClass().getName()
	 * 2.可以将proxy对象作为invoke()方法的返回值，进行连续的调用。helloProxy.say("jack").say("rose");
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/**
		 * $Proxy0.class代理类重写了目标target具有的接口方法，
		 * 同时还重写了Object类中的toString(),hashCode()和equals()方法，
		 * 重写逻辑是调用了InvocationHandler的invoke()方法，
		 * 所以如果在invoke()方法中直接或者间接调用这些方法，会导致递归调用直到栈溢出
		 */
		//System.out.println(proxy.toString());
		before();
		Object result = method.invoke(target, args);
		after();
		return result;
	}
	public void before() {
		System.out.println("before say hello");
	}
	public void after() {
		System.out.println("after say hello");
	}
	/**
	 * 忽略编译时警告，因为newProxyInstance返回的是一个Object，这里强制转换成为了T
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T>  T getProxy() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), 
										target.getClass().getInterfaces(), this);
	}
}
