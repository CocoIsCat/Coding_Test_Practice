import java.util.*;

class File {
    public int id;
    public int imp;

    File(int id, int imp) {
        this.id = id;
        this.imp = imp;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();


        while(t-- > 0) {
            Queue<File> q = new LinkedList<>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] important = new int[10];
            int count = 0;

            for(int i = 0; i < n; i++) {
                int imp = sc.nextInt();
                q.offer(new File(i, imp));
                important[imp]++;
            }

            while(true) {
                File f = q.poll();
                boolean cp = true;
                for(int i = f.imp + 1; i < 10; i++) {
                    if(important[i] > 0) {
                        cp = false;
                        break;
                    }

                }
                if(cp) {
                    count++;
                    important[f.imp]--;

                    if(f.id == m) {
                        System.out.println(count);
                        break;
                    }
                }
                else {
                    q.offer(f);
                }
            }
        }
    }
}