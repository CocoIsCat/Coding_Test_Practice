/* 백준 1463 : 1로 만들기
 * 자료구조
 * int input : 입력
 * int dp[] : dp 테이블
 *
 * 알고리즘 : 다이나믹 프로그래밍
 * 반복문 사용한  탑다운 방식
 * 점화식 : dp[i] = min(DP(i / 2), DP(i / 3), DP(i - 1)) + 1
 */

#include <iostream>
#include <algorithm>
using namespace std;
int dp[1000001] = {0};

int DP(int input) {

    //중복 계산 방지
    if(dp[input] != 0) {
        return dp[input];
    }

    else {
        if(input == 1){
            return 0;
        }
        // input이 2와 3으로 나눌 수 없으면 -1을 할 수밖에 없음
        else if(input % 2 != 0 && input % 3 != 0) {
            dp[input] = DP(input - 1) + 1;
            return dp[input];
        }
        // input이 3으로 나누어지지 않으면 2로 나누거나 -1을 한 값에서 작은 값을 선택
        else if(input % 3 != 0 ) {
            dp[input] = min(DP(input / 2), DP(input - 1)) + 1;
            return dp[input];
        }
        // input이 2로 나누어지지 않으면 3으로 나누거나 -1을 한 값에서 작은 값을 선택
        else if(input % 2 != 0) {
            dp[input] = min(DP(input / 3), DP(input - 1)) + 1;
            return dp[input];
        }
        // input이 2와 3으로 나누어지면 둘 중 작은 값 선택
       else {
            dp[input] = min(DP(input / 3), DP(input / 2)) + 1;
            return dp[input];
        }
    }
}

int main() {

    int input = 0;

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> input;
    DP(input);
    cout << dp[input];

    return 0;
}