class Solution {
    public String solution(String s) {
        char[] str = s.toCharArray();
        char before = ' ';
        for(int i = 0; i < str.length; i++) {
            str[i] = Character.toLowerCase(str[i]);
            if(before == ' ') {
                if(Character.isAlphabetic(str[i])) {
                    str[i] = Character.toUpperCase(str[i]);
                }
            }
            before = str[i];
        }
        return String.valueOf(str);
    }
}