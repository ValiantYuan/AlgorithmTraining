package leetcode.primarytest.string;

import java.util.Iterator;
import java.util.LinkedHashMap;
/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @author valiant
 *
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < chars.length; i++) {
        	if (!map.containsKey(chars[i])) {
				map.put(chars[i], i);
			} else {
            	map.put(chars[i], -1);
            }
        }
        Iterator iterator = map.keySet().iterator();
        int index = -1;
        while(iterator.hasNext()) {
        	index = map.get(iterator.next());
        	if(index != -1) {
        		return index;
        	}
        }
        return -1;
    }
}
