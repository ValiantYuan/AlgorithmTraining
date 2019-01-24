package geektimepractice.linkedlist;

public interface DataBase {
	/**
	 * 模拟数据库返回数据
	 * @return
	 */
	public default Object get() {
		return new Object();
	}
}
