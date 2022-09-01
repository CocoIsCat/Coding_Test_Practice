import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] trol = new int[9];

        for(int i = 0; i < 9; i++) {
            trol[i] = sc.nextInt();
            sum += trol[i];
        }
        int diff = sum - 100;
        Arrays.sort(trol);
        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(trol[i] + trol[j] == diff) {
                    for(int k = 0; k < 9 ; k++) {
                        if(k == i) {}
                        else if(k == j){}
                        else {
                            System.out.println(trol[k]);
                        }
                    }
                    System.exit(0);
                }
            }
        }
    }
}