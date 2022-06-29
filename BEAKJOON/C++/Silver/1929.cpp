/*백준 1929 : 소수 구하기
 * 자료구조
 * int start : 시작
 * int finish : 끝
 *
 * 알고리즘
 * 에라스토테네스의 채
 */

#include <iostream>
#include <cmath>
using namespace std;
int main() {
    int start = 0;  //시작하는 수
    int finish = 0;  //끝나는 수
    int arr[1000001];  //에라스토테네스 채를 위한 배열
    arr[0] = 1, arr[1] = 1;  //0과 1일 때 예외 처리

    cin >> start >> finish;

    //에라스토테네스의 채
    for(int i = 0; i <= (int)sqrt(finish); i++) {
        if(arr[i] == 0) {
            for(int j = 2; j <= (int)(finish / i); j++) {
                arr[i * j] = 1;
            }
        }
    }
    for(int i = start; i <= finish; i++) {
        if(arr[i] == 0){
            cout << i << "\n";
        }
    }
    return 0;
}