package geektimepractice.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用LinkedHashMap实现的LRU需要重写方法
 * @author valiant
 *
 */
public class LRUWithLinkedHashMap {
	private static final int SIZE = 100;
	LinkedHashMap keyMap = new LinkedHashMap<Object, Object>(SIZE, (float) 0.75, true) {
		protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
			boolean tooBig = size() >= SIZE;
			return tooBig;
		}
	};
	
}
