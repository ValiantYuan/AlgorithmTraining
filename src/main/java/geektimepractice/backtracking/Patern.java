package geektimepractice.backtracking;

/**
 * @NAME: Patern
 * @USER: valiant
 * @DATE: 2019-08-28
 * @DESCRITION:
 **/
public class Patern {

    private char[] patern;
    private int length;
    private boolean matched;


    public Patern(char[] patern) {
        this.patern = patern;
        length = patern.length;
    }

    public boolean isMatch(char[] text, int textLength) {
        match(0, 0, text, textLength);
        return matched;
    }

    private void match(int paternPos, int textPos, char[] text, int textLength) {
        if (matched) {
            return;
        }
        //正则表达式匹配到了最后一个字符，则表示已经匹配上了，可以退出
        if (paternPos == length) {
            if (textPos == textLength) {
                matched = true;
            }
            return;
        }
        if (patern[paternPos] == '*') {
            for (int k = 0; k <= textLength - textPos; k++) {
                match(paternPos + 1, textPos + k, text, textLength);
            }
        } else if (patern[paternPos] == '?') {
            match(paternPos + 1, textPos, text, textLength);
            match(paternPos + 1, textPos + 1, text, textLength);
        } else if (textPos < length && patern[paternPos] == text[textPos]) {
            match(paternPos + 1, textPos + 1, text, textLength);
        }
    }

    public static void main(String[] args) {
        Patern patern = new Patern("about*".toCharArray());
        char[] str = "I'm go to home and will get there about five hours later".toCharArray();
        char[] str1 = "nothing abou you can make me down".toCharArray();
        char[] str2 = "about 1 point 5 millions year ago, humans came into appearance in earth".toCharArray();
        System.out.println(patern.isMatch(str, str.length ));
        System.out.println(patern.isMatch(str1, str1.length));
        System.out.println(patern.isMatch(str2, str2.length));
    }

}





































