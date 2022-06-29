/* 백준 10989 : 수 정렬하기 3
 * 자료구조
 * int num : 입력 수
 * int temp : 입력받은 수
 * int count_sort[] : 카운트 할 배열
 * int count;
 *
 * 알고리즘 : 정렬 알고리즘
 * 카운트 정렬 사용
 *
*/

#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int num = 0;
    int temp = 0;
    int count_sort[100001] = {0};

    cin >> num;
    for (int i = 0; i < num; i++) {
        scanf("%d", &temp);
        count_sort[temp]++;
    }

    for (int i = 1; i <= 10001; i++) {
        for (int j = 0; j < count_sort[i]; j++) {
            printf("%d\n", i);
        }
    }
    return 0;
}
