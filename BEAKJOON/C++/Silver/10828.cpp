/* 백준 10828 : 스택
 * 자료구조
 * int stack[] : 스택을 구현하기 위한 배열
 * int top;
 * int data; : 입력 값
 * int count;
 *
 * 알고리즘 : 스택
 *
*/
#include <iostream>
#include <string>
using namespace std;
#define STACK_SIZE 10000

int stack[STACK_SIZE];  //STACK_SIZE 만큼의 int형 배열
int top = -1;  //top 선언 및 초기화

int isEmpty() {  //스택이 비어있는지 확인
    if(top < 0) {
        return 1;
    }
    else {
        return 0;
    }
}

int isFull() {  //스택이 꽉 차있는지 확인
    if (top == STACK_SIZE - 1) {
        return 1;
    }
    else {
        return 0;
    }
}

void Push(int input) {  //스택에 데이터를 삽입하는 함수
    if(!isFull()) {  //스택이 꽉 차있는지 확인
        top++;  //top을 증가
        stack[top] = input;  //데이터 삽입
    }
    else {
        cout << "Stack is Full\n";
    }
}

int Pop() {  //스택에서 데이터를 삭제하는 함수
    int data;
    if(isEmpty()) {  //스택이 비어있는지 확인
        data = -1;
    }
    else {
        data = stack[top];
        stack[top] = 0;  //스택의 가장 끝 데이터를 0으로 초기화
        top--;  //top 감소
    }
    return data;
}

int printtop() {  //top을 출력
    int data = 0;
    if(isEmpty()) {
        return -1;
    }
    else {
        data = stack[top];
    }
    return data;
}

int main() {

    string command;
    int num = 0;
    int input = 0;
    int count = 0;

    cin >> num;

    while(count < num) {

        cin >> command;
        if(!command.compare("push")) {
            cin >> input;
            Push(input);
            count++;
        }

        else if(!command.compare("pop")) {
            cout << Pop() << "\n";
            count++;
        }

        else if(!command.compare("top")) {
            cout << printtop() << "\n";
            count++;
        }

        else if(!command.compare("size")) {
            cout << top + 1<< "\n";
            count++;
        }

        else if (!command.compare("empty")) {
            cout << isEmpty() << "\n";
            count++;
        }
    }
    return 0;
}
