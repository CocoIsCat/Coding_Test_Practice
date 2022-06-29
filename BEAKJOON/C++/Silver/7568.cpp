/* 백준 7568 : 덩치
 * 자료구조
 * int num : 입력 수
 * int body[][0] : 체중 body[][1] : 신장
 * int rank[] : 순위
 *
 * 알고리즘
 * i번째와 i+1번째의 신체 조건 비교
 * i가 i+1보다 덩치가 작으면 rank + 1
 * 점수를 출력
 */

#include <iostream>
using namespace std;
int main() {

    int num = 0;
    int body[50][2] = {0};
    int rank[50] = {0};
    cin >> num;

    //입력
    for (int i = 0; i < num; i++) {
        cin >> body[i][0] >> body[i][1];
        rank[i] = 1;
    }

    for (int i = 0; i < num; i++) {
        for (int j = 0; j < num; j++) {
            if (body[i][0] < body[j][0] && body[i][1] < body[j][1]) {
                rank[i]++;
            }
        }
    }

    for (int i = 0; i < num; i++) {
        cout << rank[i] << " ";
    }
    return 0;
}