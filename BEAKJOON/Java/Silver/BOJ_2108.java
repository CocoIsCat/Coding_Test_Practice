import java.util.*;
import java.lang.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        double sum = 0.0;
        boolean sch = false;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += (double)arr[i];
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            }
            else {
                int value = map.get(arr[i]);
                map.replace(arr[i], ++value);
            }
        }

        Arrays.sort(arr);
        int frequency = -1;
        ArrayList<Integer> al = new ArrayList<>();
        for(int key : map.keySet()) {

            if(map.get(key) > frequency) {
                ArrayList<Integer> tmp = new ArrayList<>();
                frequency = map.get(key);
                tmp.add(key);
                al = tmp;
                sch = false;
            }
            else if(map.get(key) == frequency) {
                al.add(key);
                sch = true;
            }
        }
        Collections.sort(al);

        System.out.println(Math.round(sum/n));
        System.out.println(arr[(n - 1)/2]);
        if(sch) {
            System.out.println(al.get(1));
        }
        else {
            System.out.println(al.get(0));
        }
        System.out.println(Math.abs(arr[n - 1] - arr[0]));
    }
}