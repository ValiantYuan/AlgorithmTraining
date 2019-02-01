package geektimepractice.linkedlist;

public interface  LRU  <K , V>{
	/**
	 * 在缓存中访问节点，如果存在，则返回该节点，如果不存在，则通过模拟数据库获取值，插入到节点中
	 * @param node
	 * @return
	 */
	public default Object Visitor(K key, DataBase dataBase) {
		V result = gerValue(key);
		if (result == null) {
			result = (V)dataBase.get();
			K number = getKey();
			add(number ,result);
		}
		return result; 
	}
	/*
	 * 数据是否在缓存中,在则返回该对象，不在则返回null
	 */
	public  V gerValue(K key);
	/**
	 * 将对象加入到LRU中去
	 * @param object
	 */
	public void add(K key, V value);
	
	public K getKey();
	
}
