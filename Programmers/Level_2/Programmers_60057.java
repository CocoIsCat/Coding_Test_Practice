class Solution {
    public int solution(String s) {
        int unit = 1;
        int answer = s.length();
        while (unit <= s.length() / 2) {
            StringBuffer sb = new StringBuffer();
            int start = unit;
            int end = start + unit;
            int count = 1;
            String prev = s.substring(0, unit);

            while (start < s.length()) {
                String temp = s.substring(start, end);

                if (prev.equals(temp)) {
                    count++;
                } else {
                    if (count == 1) {
                        sb.append(prev);
                    } else {
                        sb.append(Integer.toString(count) + prev);
                        count = 1;
                    }
                }

                start = end;
                end += unit;
                prev = temp;
                if (end > s.length()) {
                    end = s.length();
                    temp = s.substring(start, end);
                    if (prev.equals(temp)) {
                        count++;
                    }
                    if (count == 1) {
                        sb.append(prev);
                        sb.append(temp);
                        break;
                    } else {
                        sb.append(Integer.toString(count) + prev);
                        sb.append(temp);
                        break;
                    }
                }
            }
            answer = Math.min(answer, sb.length());
            unit++;
        }
        return answer;
    }
}