/*백준 4153 : 직각삼각형
 * 자료구조
 * int a,b,c : 삼각형의 세 변
 * int max : 세 변 중 최대
 * 알고리즘
 * 수학
 * */
#include <iostream>
using namespace std;

int main() {
    int a,b,c;
    int max;

    while(cin >> a >> b >> c) {
        if(a == 0) {
            break;
        }
        else {
            max = a > b ? (a > c ? a : c) : (b > c ? b : c);
            if(!(a*a + b*b + c*c - 2*max*max)) {
                cout << "rignt\n";
            }
            else
                cout << "wrong\n";
        }
    }
    return 0;
}
