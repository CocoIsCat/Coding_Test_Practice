import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        while(!str.equals("0")) {
            int i = 0;
            int j = str.length() - 1;

            while(i <= j / 2) {
                if(str.charAt(i) == str.charAt(j - i)) {
                    i++;
                }
                else {
                    System.out.println("no");
                    break;
                }
            }
            if(i == j / 2 + 1) {
                System.out.println("yes");
            }
            str = sc.next();
        }
    }
}