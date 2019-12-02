package leetcode.explore.interview.primarytest.string;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * @author valiant
 * 使用kmp算法
 */
public class StrStr {
	public int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0){
			return 0;
		} else if (haystack == null || haystack.length() == 0) {
			return -1;
		} 
        int[] next = new int[needle.length()];
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        getNext(next, needleArray);
        int j = 0;
        for (int i = 0; i < haystackArray.length; i++) {
        	while (j > 0 && haystackArray[i] != needleArray[j]) {
				j = next[j - 1] + 1;
			}
        	if (haystackArray[i] == needleArray[j]) {
        		if (j == needleArray.length - 1) {
        			return i - j;
        		}
				j++;
			}
		}
        return -1;
    }
	
	public void getNext(int[] next, char[] needleArray) {
		next[0] = -1;
		int k = -1;
		for (int i = 1; i < needleArray.length; i++) {
			while (k >= 0 && needleArray[i] != needleArray[k + 1]) {
				k = next[k];
			}
			if (needleArray[k + 1] == needleArray[i]) {
				++k;
			}
			next[i] = k;
		}
	}
}
