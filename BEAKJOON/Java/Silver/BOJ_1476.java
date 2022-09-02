import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 1;
        int earthYear = sc.nextInt();
        int sunYear = sc.nextInt();
        int moonYear = sc.nextInt();

        while(true) {
            int earth = result % 15;
            if(earth == 0)
                earth = 15;
            int sun = result % 28;
            if(sun == 0)
                sun = 28;
            int moon = result % 19;
            if(moon == 0)
                moon = 19;

            if(earth == earthYear && sun == sunYear && moon == moonYear) {
                System.out.println(result);
                break;
            }
            else {
                result++;
            }
        }
    }
}