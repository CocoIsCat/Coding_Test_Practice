#include <iostream>
using namespace std;

int main() {

    int input;
    int h = 0, t = 0, o = 0;
    cin >> input;

    for(int i = 1; i < input; i++) {
        if(i < 10) {
            o = i;
        }
        else {
            h = input / 100;
            o = input % 10;
            t = input / 10 - o;
        }
        if(input == i + h + o + t) {
            cout << i;
            break;
        }
    }
    cout << "0";
    return 0;
}

