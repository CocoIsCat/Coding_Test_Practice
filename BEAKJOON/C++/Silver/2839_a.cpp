/* 백준 2839 : 설탕 배달
 * 자료구조
 * int sugar[5001] : DP 테이블
 * int input : 입력 값
 *
 * 알고리즘 : 다이나믹 프로그래밍
 * 재귀 사용한 탑다운 방식 사용
 */

#include <iostream>
#include <algorithm>
using namespace std;
int sugar[5001] = {0};

int DP(int input) {

    // 중복 계산을 막기 위함
    if(sugar[input] != 0) {
        return sugar[input];
    }

    // input이 3 또는 5일 경우 0 반환
    if(input == 0){
        return 0;
    }

    // input이 음수일 경우 의미 없는 큰 수 반환
    else if (input < 0) {
        return 9999;
    }

    // input이 1, 2, 4일 경우 의미 없는 큰 수 반환
    else if (input == 1 || input == 2 || input == 4) {
        return 9999;
    }


    else {
        /* 점화식 참고*/
        sugar[input] = min(DP(input - 5), DP(input - 3)) + 1;
        return sugar[input];
    }
}

int main() {
    int input = 0;

    cin >> input;
    DP(input); //DP 함수 호출

    //sugar[input]이 0과 10000이라는 것은 해당 입력 값을 나타낼 수 없다는 의미 이므로 -1로 출력
    cout << ((sugar[input] == 0 || sugar[input] == 10000) ? -1 : sugar[input]) ;

    return 0;
}