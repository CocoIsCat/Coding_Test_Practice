/* 백준 2292 : 벌집
 * 자료구조
 * int input : 입력
 * int layer : 벌집의 단 수
 * int start : 시작 숫자
 * int finish : 끝 숫자
 *
 * 알고리즘 : 수학
 *
*/
#include <iostream>
using namespace std;

int main() {
    int input = 0;  //입력
    int layer = 1;  //단 수
    int start = 1;  //시작 숫자
    int finish = 1;  //종료 숫자

    cin >> input;

    while(!((input >= start) && (input <= finish))) {  //입력 값이 특정 단의 범위 안에 들어올 때까지
        start = finish + 1;  //start 값 변경

        if(layer == 1){  //1단에서 2단 갈 때는 예외 처리
            finish = start + 5;
        }
        else {
            finish = start + (6 * layer) - 1;  //finish 값 변경
        }
        layer++;  //layer 값 변경
    }
    cout << layer << "\n";
    return 0;
}