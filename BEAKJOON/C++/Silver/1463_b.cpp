/* 백준 1463 : 1로 만들기
 * 자료구조
 * int input : 입력
 * int dp[] : dp 테이블
 *
 * 알고리즘 : 다이나믹 프로그래밍
 * 재귀 통한 바텀업 방식
 * 점화식 : dp[i] = min(DP(i / 2), DP(i / 3), DP(i - 1)) + 1
 */

#include <iostream>
#include <algorithm>
using namespace std;

int main() {

    //입출력 속도 향상
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int input = 0;
    int dp[1000001] = {0};
    dp[2] = dp[3] = 1;

    cin >> input;

    for(int i = 2; i <= input; i++) {

        if (2 * i <= input) {
            if (dp[2 * i] == 0) {
                dp[2 * i] = dp[i] + 1;
            } else {
                dp[2 * i] = min(dp[2 * i], dp[i] + 1);
            }
        }
        if(3 * i <= input) {
            if (dp[3 * i] == 0) {
                dp[3 * i] = dp[i] + 1;
            } else {
                dp[3 * i] = min(dp[3 * i], dp[i] + 1);
            }
        }
        if(dp[i + 1] == 0) {
            dp[i + 1] = dp[i] + 1;
        }
        else {
            dp[i + 1] = min(dp[i + 1], dp[i] + 1);
        }
    }

    cout << dp[input];

    return 0;
}