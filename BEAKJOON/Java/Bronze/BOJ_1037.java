import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int arr[] = new int[k];
        int count = 0;

        while(sc.hasNext()) {
            arr[count++] = sc.nextInt();
        }
        Arrays.sort(arr);	//약수 정렬
        System.out.println(arr[0] * arr[k - 1]);	//가장 큰 값과 작은 값 곱해서 출력
    }
}