/* 백준 2839 : 설탕 배달
 * 자료구조
 * int sugar[5001] : DP 테이블
 * int input : 입력 값
 *
 * 알고리즘 : 다이나믹 프로그래밍
 * 재귀 사용한 바텀업 방식 사용
 */

#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int sugar[5001] = {0};
    int input = 0;
    cin >> input;

    // 초기 테이블 세팅
    sugar[3] = sugar[5] = 1;
    sugar[1] = sugar[2] = sugar[4] = 9999;

    for(int i = 6; i <= input; i++) {
        sugar[i] = min(sugar[i - 3], sugar[i - 5]) + 1;
    }
    cout << ((sugar[input] == 0 || sugar[input] >= 9999) ? -1 : sugar[input]) ;

    return 0;

}