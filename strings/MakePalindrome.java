package strings;

public class MakePalindrome {
    public static void main(String[] args) {
        String inpuString = "m?da?";
        System.out.println(makePalindrome(inpuString.toLowerCase()));
    }

    private static String makePalindrome(String inpuString) {
        char[] str = inpuString.toCharArray();
        int mirrorIndex = (str.length - 1);
        for(int i = 0; i < str.length; i++) {
            mirrorIndex = (str.length - 1) - i;
            if(str[i] == '?') {
                if(str[mirrorIndex] == '?') {
                    str[i] = 'a';
                    str[mirrorIndex] = str[i];
                }
                else {
                    str[i] = str[mirrorIndex];
                }
            }
            else if(str[i] != str[mirrorIndex] && str[mirrorIndex] != '?') {
                return "No";
            }
        }
        return new String(str);
    }
}