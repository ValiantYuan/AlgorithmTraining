package functiontest.hotdeployment;

import functiontest.hotdeployment.A;

public class Test {
	public static void main(String[] args) throws Exception {
		//�������ʱ�ᱨ���Ҳ�������
//		new A();
		/**
		 * ���A�಻����ʱ�����벻�ᱨ������ʱ����ᱨ��ClassNotFoundException
		 * 
		 */
		((A) Class.forName("hotdeployment.A").newInstance()).say();
		
		/**
		 * ���A����ڣ�����ǰ��A.classɾ����������ᱨ��NoClassDefFoundError
		 */
		new A().say();
	}
}
