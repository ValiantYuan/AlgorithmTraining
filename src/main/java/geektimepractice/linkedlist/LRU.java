package geektimepractice.linkedlist;

public interface LRU {
	/**
	 * �ڻ����з��ʽڵ㣬������ڣ��򷵻ظýڵ㣬��������ڣ���ͨ��ģ�����ݿ��ȡֵ�����뵽�ڵ���
	 * @param node
	 * @return
	 */
	public default Object Visitor(Object object, DataBase dataBase) {
		Object result = isIn(object);
		if (result == null) {
			result = dataBase.get();
			add(result);
		}
		return result; 
	}
	/*
	 * �����Ƿ��ڻ�����,���򷵻ظö��󣬲����򷵻�null
	 */
	public Object isIn(Object object);
	
	/**
	 * ��������뵽LRU��ȥ
	 * @param object
	 */
	public void add(Object object);
	
}
