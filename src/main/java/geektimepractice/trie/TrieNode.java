package geektimepractice.trie;

public class TrieNode {
	char data;
	TrieNode[] children = new TrieNode[26];
	boolean isEndingChar = false;
	public TrieNode(char data) {
		super();
		this.data = data;
	}
	
	
}
