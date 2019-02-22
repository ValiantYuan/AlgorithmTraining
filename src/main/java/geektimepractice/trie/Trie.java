package geektimepractice.trie;

import java.util.ArrayList;

/**
 * 
 * @author valiant
 * 假设对于字母进行trie结构建立
 * 创建Trie树的时间复杂度是O(n)，n是插入单词的总字符数
 * 匹配时间复杂度O(k),k是需要匹配字符串的长度
 */

public class Trie {
	//以无意义的字符作为根节点
	TrieNode root = new TrieNode('/');
	//查询返回的结果集
	ArrayList<String> results = new ArrayList<String>();
	
	
	//往trie中插入单词
	public void insertWord(char[] text) {
		TrieNode curNode = root;
		/**
		 * 逐个字符遍历，如果当前字符的节点已存在则跳转到该字符的节点，继续遍历，如果不存在，则新建节点
		 */
		for (int i = 0; i < text.length; i++) {
			int index = text[i] - 'a';
			if (curNode.children[index] == null) {
				curNode.children[index] = new TrieNode(text[i]);
			}
			curNode = curNode.children[index];
		}
		curNode.isEndingChar = true;
	}
	
	/**
	 * 查找一个单词，可以从根节点根据单词的字符进行遍历
	 * @param text
	 */
	public void find(char[] text) {
		results.clear();
		TrieNode curNode = root;
		for (int i = 0; i < text.length; i++) {
			int index = text[i] - 'a';
			if (curNode.children[index] == null) {
				return;
			}
			curNode = curNode.children[index];
		}
		String preword = new String(text);
		//如果当前节点时一个单词，加入到结果集中
		if (curNode.isEndingChar) {
			results.add(preword);
		}
		//查询模式text结束后，要从当前节点输出所有的以text作为前缀的结果集，深度优先遍历trie
		dfs(curNode, preword);
	}
	
	public void dfs(TrieNode root, final String preword) {
		//当前节点的所有子节点
		TrieNode[] children = root.children;
		//是否到达了当前分支的末尾，当子为空时，即为分支末尾
		TrieNode curNode = null;
		for (int i = 0; i < children.length; i++) {
			curNode = children[i];
			if (curNode == null) {
				continue;
			}
			//一旦当前子节点有数据，则不是分支末尾
			//组成当前的字符串
			String word = preword + curNode.data;
			if (curNode.isEndingChar) {
				results.add(word);
			}
			dfs(curNode, word);
		}
		//到达当前分支的末尾，深度优先返回
		return;
	}
	
}
