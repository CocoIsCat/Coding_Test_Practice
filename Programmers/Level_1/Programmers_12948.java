package Programmers.Level_1;

public class Programmers_12948 {
    public String solution(String phone_number) {
        StringBuffer sb = new StringBuffer();
        int idx = phone_number.length() - 4;
        for(int i = 0; i < idx; i++) {
            sb.append("*");
        }
        sb.append(phone_number.substring(idx));
        return sb.toString();
    }
}
