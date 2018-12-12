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
	 * @param porxy��the proxy instance that the method was invoked on, 
	 * ��ͨ��getProxy()��ȡ�������Proxy���󣬼�˵���������������$Proxy0.class�������ʵ��
	 * @param method:��Ҫִ�еķ��������˷������ڵ��࣬������ʵ������
	 * @param args: method������Ҫ�Ĳ�������
	 * proxy��������ã�
	 * 1.����ʹ�÷����ȡ����������Ϣ proxy.getClass().getName()
	 * 2.���Խ�proxy������Ϊinvoke()�����ķ���ֵ�����������ĵ��á�helloProxy.say("jack").say("rose");
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/**
		 * $Proxy0.class��������д��Ŀ��target���еĽӿڷ�����
		 * ͬʱ����д��Object���е�toString(),hashCode()��equals()������
		 * ��д�߼��ǵ�����InvocationHandler��invoke()������
		 * ���������invoke()������ֱ�ӻ��߼�ӵ�����Щ�������ᵼ�µݹ����ֱ��ջ���
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
	 * ���Ա���ʱ���棬��ΪnewProxyInstance���ص���һ��Object������ǿ��ת����Ϊ��T
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T>  T getProxy() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), 
										target.getClass().getInterfaces(), this);
	}
}
