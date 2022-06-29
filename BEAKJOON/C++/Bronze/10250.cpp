/* 백준 10250 : ACM 호텔
 * 자료구조
 * int H : 문제에서 H
 * int W : 문제에서 W
 * int N : 문제에서 N
 * int num : 테스트케이스 수
 * int floor : 층수
 * int room : 호수
 *
 * 알고리즘
 * 수학
 * */

#include <iostream>
using namespace std;
int main() {
    int H = 0;
    int W = 0;
    int N = 0;
    int num = 0;
    int floor = 0;
    int room = 0;
    cin >> num;
    for(int i = 0; i < num; i++) {
        cin >> H >> W >> N;
        room = (N / H) + 1;
        floor = N % H;
        if(H >= N){
            floor = N;
            room = 1;
        }
        if(floor == 0) {
            floor = H;
            room = N / H;
        }
        if (room < 10) {
            cout << floor << "0" << room << "\n";
        }
        else {
            cout << floor << room << "\n";
        }
    }
    return 0;
}