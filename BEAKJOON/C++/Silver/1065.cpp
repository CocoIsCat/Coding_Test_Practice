/* 백준 1065 : 한수
 * 자료구조
 * int input : 입력받은 수
 * int count : 개수 카운트
 * int hunds : 백의 자리
 * int tens : 십의 자리
 * int units : 일의 자리
 *
 * 알고리즘 : 브루트포스
 *
*/

#include <iostream>
#include <cstdio>
using namespace std;
int main() {
    int input = 0;
    int count = 0;
    int hunds = 0;
    int tens = 0;
    int units = 0;

    scanf("%d", &input);

    //
    for (int i = 1; i <= input; i++) {
        hunds = i / 100;
        tens = (i - hunds * 100) / 10;
        units = i % 10;

        if(hunds == 0 && tens == 0) {  //입력이 한자리 수
            count++;
        }

        else if (hunds == 0) {  //입력이 두자리 수
            count++;
        }

        else {  //입력이 세자리 수
            if (!((hunds - tens) - (tens - units))) {
                count++;
            }
        }
    }

    printf("%d", count);  //출력

    return 0;
}