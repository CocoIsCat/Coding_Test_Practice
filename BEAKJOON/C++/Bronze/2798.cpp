/* 백준 알고리즘 2789 : 블랙잭
 * 자료구조
 * int cardnum : 카드 수
 * int card[] : 카드
 * int num : 입력
 * int sum : 카드 세개의 합
 * int max : sum의 최대
 *
 * 알고리즘
 * 브루트포스
 * */
#include <iostream>
using namespace std;

int main() {
    int cardnum = 0;  //카드 수
    int card[101];  //카드
    int M= 0;  //입력 받은 수
    int sum = 0;  //총합
    int max = 0;  //총합 중 입력과 가장 가까운 수

    cin >> cardnum >> M;
    for(int i = 1; i <= cardnum; i++){  //카드 수만큼 카드 입력
        cin >> card[i];
    }
    for(int i = 1; i <= cardnum - 2; i++ ) {
        for(int j = i + 1; j <= cardnum - 1; j++) {
            for(int k = j + 1; k <= cardnum; k++) {

                sum = card[i] + card[j] + card[k];

                if(sum > M){  //sum이 M보다 크면
                    continue;  //다음 조합 실행
                }
                else {
                    if(M - sum < M - max) {  //sum이 max보다 조건에 더 부합하면
                        max = sum;  //max 값 교체
                    }
                }
            }
        }
    }
    cout << max << "\n";
    return 0;
}
