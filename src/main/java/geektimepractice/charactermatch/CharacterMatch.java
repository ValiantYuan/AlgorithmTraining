package geektimepractice.charactermatch;

import sun.nio.cs.ext.IBM037;

/**
 * 
 * @author Valiant
 *
 */
public class CharacterMatch {
	private static final int SIZE = 256;
	/**
	 * 
	 * @param origin	源字符串
	 * @param model		匹配模式串
	 * @return			匹配功能返回第一个字符在源字符串中的位置，匹配失败返回 -1
	 */
	public int bm(char[] origin, char[] model) {
		int n = origin.length;
		int m = model.length;
		if (m > n) {
			return -1;
		}
		
		//产生坏字符哈希表
		int[] bc = new int[SIZE];
		generateBC(model, bc);
		
		//计算模式串中的最大公共字串
		int[] suffix = new int[m];
		boolean[] prefix = new boolean[m];
		generateGS(model, suffix, prefix);
		
		
		int i = 0; //主串与模式串对齐的位置
		while (i <= n - m) {
			int j;
			//模式串与字串从后向前匹配,退出循环时j位坏字符在模式串中的位置
			for (j = m - 1; j >= 0; j--) {
				if (origin[i + j] != model[j]) {
					break;
				}
			}
			if (j == -1) {
				return i; //匹配成功，返回第一个字符的位置
			}
			/**
			 * 匹配不成功则要比较由坏字符规则和好后缀规则产生的移动长度，取其中较大的一个
			 */
			int x = j - bc[(int)origin[i + j]];
			int y = 0;
			//如果一个字符都没有匹配时，j = m -1,则没有好后缀，当j < m - 1,说明至少存在长度位1的好后缀
			if (j < m - 1) {
				y = move(j, m , suffix, prefix);
			}
			i += Math.max(x, y);
		}
		return -1;
	}

	/**
	 * 
	 * @param j			坏字符的位置
	 * @param m			模式的长度
	 * @param suffix	后缀数组
	 * @param prefix	前缀数组
	 * @return
	 */
	public int move(int j, int m, int[] suffix, boolean[] prefix) {
		//好后缀的长度
		int k = m - 1 - j;
		//如果suffix[k] != -1, 则说明在模式串中有前缀字串与好后缀重合，则应该后移
		if (suffix[k] != -1) {
			return j + 1 - suffix[k];
		}
		for (int r = j + 2; r <= m - 1; r++) {
			if (prefix[m - r] == true) {
				return r;
			}
		}
		return m;
	}
	
	
	/**
	 * 假设模式串和主串中仅仅出现ASCII码中的值，记录模式串每个码值出现的位置
	 * @param model	模式串
	 * @param bc	码值位置数组
	 */
	private void generateBC(char[] model, int[] bc) {
		for (int i = 0; i < bc.length; i++) {
			bc[i] = -1;
		}
		for (int i = 0; i < model.length; i++) {
			int ascii = (int)model[i];
			bc[ascii] = i;
		}
	}
	
	/**
	 * 对模式串进行分析，供bm算法好后缀规则使用
	 * @param model    	模式串
	 * @param length	模式串长度
	 * @param suffix	用来表示前缀字串长度k起始位置的数组
	 * @param prefix    用来表示长度为k的模式前缀子串是否与后缀字串匹配
	 */
	private void generateGS(char[] model, int[] suffix, boolean[] prefix) {
		int length = model.length;
		//初始化
		for (int i = 0; i < length; i++) {
			suffix[i] = -1;
			prefix[i] = false;
		}
		//倒序比较模式串中最大位置为j的前缀子串与模式串,找出最大公共子串
		for (int i = 0; i < length; i++) {
			int j = i; //前缀子串的最大位置
			int k = 0; //公共子串的长度
			while (j >= 0 && model[j] == model[length - 1 - k]) {
				j--;
				k++;
				suffix[k] = j + 1; //公共子串的在模式中的起始下标，因为j--发生过，所以此处要写j + 1
			}
			//当j = -1时，表明前缀子串与模式中的后缀子串匹配上了，因此记录prefix[k]为true，前缀子串与公共子串是两个概念，只有当没有公共子串等于好后缀时，才会考虑前缀子串与好后缀部分重合的情况
			if (j == -1) {
				prefix[k] = true;
			}
		}
	}


	/**
	 * 失效函数
	 * @param b
	 * @param m
	 * @return
	 */
	private static int[] getNexts(char[] b, int m) {
		int[] next = new int[m];
		//当子串长度为1时，不存在子串，直接赋值为-1
		int k = -1;
		next[0] = -1;
		for (int i = 1; i < m; i++) {
			//如果子串长度增加一，且增加的值与最长后缀子串匹配的前缀子串的后一位不同，则递归判断次长匹配子串是否满足条件，而次长匹配子串，可以根据最长匹配子串的next[k]数组来定位，如果最终还是无法定位，k值将会为-1，即没有可以匹配的子串
			while(k > 0 && b[i] != b[k + 1]) {
				k = next[k];
			}
			//如果子串长度增加一，且增加的值与最长后缀子串匹配的前缀子串的后一位相同，则匹配的最长后缀子串长度加一，匹配最长前缀子串的位置后移一位，即k++
			if (b[i] == b[k + 1]) {
				k++;
			}
			next[i] = k;
		}
		return next;
	}
	
	public static int kmp(char[] a, int n, char[] b, int m) {
		int[] next = getNexts(b, m);
		int j = 0;
		for (int i = 0; i < n; i++) {
			//遇到不匹配的值时，且j != 0时，根据好前缀的长度j - 1来决定，模式串中下一个开始比较的位置j = next[j - 1] + 1，当next[]为-1时，即把模式串整体移动到当前i的位置进行匹配
			while(j > 0 && a[i] != b[j]) {
				j = next[j - 1] + 1;
			}
			//当前比较相同时，模式串和主串都往后移动一位
			if (a[i] == b[j]) {
				//当长度满足子串长度时，返回子串在主串中的起始位置
				if (j == m - 1) {
					return i - m + 1;
				}
				j++;
			}

		}
		return -1;
	}
}
