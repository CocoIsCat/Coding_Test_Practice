/* 백준 1978 : 소수 찾기
 * 자료구조
 * int num : 입력 수
 * int input[] : 입력
 * int arr[1001] : 에라스토테네스 체에 쓸 배열
 * int count : 소수 개수 카운트
 *
 * 알고리즘 : 소수 판별
 * 에라스토테네스의 체를 활용하여 소수 판별하기
 */

#include <iostream>
#include <cmath>
using namespace std;

int main() {

    //입출력 최적화
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int num = 0;
    int input[100];
    int arr[1001] = {0};
    int count = 0;
    arr[0] = 1, arr[1] = 1;  //0이랑 1 예외처리

    cin >> num;  //입력
    for(int i = 0; i < num; i++) {
        cin >> input[i];
    }

    //에라스토테네스의 체
    for(int i = 2; i <= (int)sqrt(1000); i++) {
        if(arr[i] == 0 ) {
            for(int j = 2; j <= (int)(1000 / i); j++) {
                 arr[i*j] = 1;
            }
        }
    }

    for(int i = 0; i < num; i++) {
        if(arr[input[i]] == 0) {
            count++;
        }
    }

    cout << count << "\n";
    return 0;
}

