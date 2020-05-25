package geektimepractice.trie;

import org.junit.Test;

public class TrieTests {

	@Test
	public void test() {
		Trie trie = new Trie();
		trie.insertWord("abcdefg".toCharArray());
		trie.insertWord("abcde".toCharArray());
		trie.insertWord("abcd".toCharArray());
		trie.find("abcde".toCharArray());
		for (String word : trie.results) {
			System.out.println(word);
		}
	}

}
