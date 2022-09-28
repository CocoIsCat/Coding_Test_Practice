import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int result = 0;
        int idx = A.length - 1;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i <= idx; i++) {
            result += A[i] * B[idx - i];
        }
        return result;
    }
}