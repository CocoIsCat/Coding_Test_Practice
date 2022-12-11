package BEAKJOON.Java.Silver;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            Map<String, Integer> map = new HashMap<>();
            int count = 1;
            for(int i = 0; i < n; i++){
                sc.next();
                String str2 = sc.next();
                if(map.containsKey(str2)) {
                    int value = map.get(str2);
                    map.replace(str2, ++value);
                }
                else {
                    map.put(str2,1);
                }
            }

            for(int value : map.values()) {
                count *= (value + 1);
            }
            System.out.println(count - 1);
        }
    }
}
