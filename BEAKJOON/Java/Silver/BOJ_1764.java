package BEAKJOON.Java.Silver;

import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Set<String> people = new HashSet<>();
        List<String> result = new ArrayList<>();
        while(N-- > 0) {
            people.add(sc.next());
        }
        while(M-- > 0) {
            String tmp = sc.next();
            if(people.contains(tmp)) {
                result.add(tmp);
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for(String str : result) {
            System.out.println(str);
        }
    }
}