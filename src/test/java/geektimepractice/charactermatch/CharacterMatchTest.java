package geektimepractice.charactermatch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CharacterMatchTest {

	@Test
	public void test() {
//		String s1 = "abbabaaaabbbaabaabaabbbaaabaaaaaabbbabbaabbabaabbabaaaaababbabbaaaaabbbbaaabbaaabbbbabbbbaaabbaaaaababbaababbabaaabaabbbbbbbaabaabaabbbbababbbababbaaababbbabaabbaaabbbba";
//		String s2 = "bbbbbbaa";
		for (int i = 0; i < 10000; i++) {
			
			String s1 = "bbababaaaababbaabbbabbbaaabbbaaababbabaabbaaaaabbaaabbbbaaabaabbaababbbaabaaababbaaabbbbbbaabbbbbaaabbababaaaaabaabbbababbaababaabbaa";
			String s2 = "bbabba";
			try {
				Thread.sleep(100);
				System.out.println(i + "th waiting");
			} catch (Exception e) {
				// TODO: handle exception
			}
			CharacterMatch characterMatch = new CharacterMatch();
			assertEquals(-1, characterMatch.kmp(s1.toCharArray(), s1.length(), s2.toCharArray(), s2.length()));
		}
	}

}
