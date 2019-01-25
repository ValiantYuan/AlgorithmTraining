package geektimepractice.linkedlist;

public interface LRU {
	/**
	 * 在缓存中访问节点，如果存在，则返回该节点，如果不存在，则通过模拟数据库获取值，插入到节点中
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
	 * 数据是否在缓存中,在则返回该对象，不在则返回null
	 */
	public Object isIn(Object object);
	
	/**
	 * 将对象加入到LRU中去
	 * @param object
	 */
	public void add(Object object);
	
}
