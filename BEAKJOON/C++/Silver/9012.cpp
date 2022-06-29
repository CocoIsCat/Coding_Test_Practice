/* 백준 10828 : 괄호
 * 자료구조
 * stack[] :
 * int top :
 * int count :
 * string str : 입력 값
 * int length : 문자열 길이
 *
 *
 * 알고리즘 : 스택
 *
*/
#include <iostream>
#include <string>
using namespace std;

char stack[50];  //스택으로 사용할 배열
int top = -1;  //top 선언 및 초기화

int isEmpty() {  //배열이 비어있는지 확인
    if(top < 0) {
        return 1;
    }
    else
        return 0;
}

void push(char input) {  //push 함수
    stack[++top] = input;
}
int pop() {  //pop 함수
    if(isEmpty()){
        return 1;
    }
    else {
        stack[top--] = 0;
    }
    return 0;
}
void reset() {  //스택 초기화
    for(int i = 0; i < 50; i++) {
        stack[50] = 0;
    }
    top = -1;
}

int main() {
    int result = 0;
    int num = 0;
    int count = 0;
    int length = 0;
    string str;

    cin >> num;
    cin.ignore();  //입력 버퍼 제거

    while(count < num) {
        getline(cin, str);  //문자열 입력
        length = str.length();
        for (int i = 0; i < length; i++) {  //문자열 길이만큼 반복
            if (str[i] == '(') {  //여는 괄호는 push
                push(str[i]);
            }
            else if (str[i] == ')') {  //닫는 괄호는 pop
                if(pop()){
                    result = 1;  //입력이 비어있을 때 pop을 시도하면 result를 1로 변경
                }
            }
        }
        if (isEmpty() && result == 0) {  //VPS면
            cout << "YES" << "\n";
            count++;
        }
        else {
            cout << "NO" << "\n";
            reset();
            result = 0;
            count++;
        }
    }
    return 0;
}