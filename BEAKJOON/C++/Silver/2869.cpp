/*백준 2869 : 달팽이는 올라가고 싶다
 * 자료구조
 * int up : 낮 동안 올라가는 높이
 * int down : 밤 동안 내려가는 높이
 * int day : 올라가는 데 걸리는 시간
 * int height : 막대의 높이
 * */
#include <iostream>
using namespace std;

int main() {
    int up = 0;  //낮 동안 올라가는 높이
    int down = 0;  //밤 동안 내려가는 높이
    int day = 1;  //올라가는 데 걸리는 시간
    int height = 0;  // 막대의 높이

    cin >> up >> down >> height;

    if(up >= height)  //낮 동안 올라가는 높이가 막대보다 길면
        cout << day << "\n";  //하루만에 올라갈 수 있음 day = 1

    else {  //하루 만에 올라갈 수 없으면

        //설명 참고
        height -= up;
        day = height / (up - down);
        if((up - down) * day < height) {
            day++;
        }

        cout << ++day << "\n";

    }
    return 0;
}