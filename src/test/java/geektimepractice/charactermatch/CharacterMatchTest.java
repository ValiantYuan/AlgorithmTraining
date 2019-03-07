package geektimepractice.charactermatch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CharacterMatchTest {

	@Test
	public void test() {
//		String s1 = "abbabaaaabbbaabaabaabbbaaabaaaaaabbbabbaabbabaabbabaaaaababbabbaaaaabbbbaaabbaaabbbbabbbbaaabbaaaaababbaababbabaaabaabbbbbbbaabaabaabbbbababbbababbaaababbbabaabbaaabbbba";
//		String s2 = "bbbbbbaa";
		String s1 = "bbababaaaababbaabbbabbbaaabbbaaababbabaabbaaaaabbaaabbbbaaabaabbaababbbaabaaababbaaabbbbbbaabbbbbaaabbababaaaaabaabbbababbaababaabbaa";
		String s2 = "bbabba";
		CharacterMatch characterMatch = new CharacterMatch();
		assertEquals(-1, characterMatch.kmp(s1.toCharArray(), s1.length(), s2.toCharArray(), s2.length()));
	}

}
