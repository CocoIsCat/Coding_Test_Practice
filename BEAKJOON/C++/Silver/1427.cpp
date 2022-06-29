/*백준 1427번: 소트인사이드
 * 자료구조 : string or char형 배열
 * 입력을 숫자 10억이라 보지 말고 10글자 짜리 문자열로 봐야함

 * 알고리즘 : 정렬 알고리즘
 * n이 10이라 버블 정렬로 간단하게 해도 될듯
 */

#include <iostream>
#include <string>
using namespace std;


int main() {
    string string1;  //문자열 변수 선언
    getline(cin,string1);  //string1에 입력 받기
    char temp; //정렬에 사용할 임시 변수

    //버블 정렬
    for(int i = 0; i < string1.length() - 1; i++) {
        for(int j = 0; j < string1.length()- 1 - i; j++) {
            if(string1[j] < string1[j+1]) {
                temp = string1[j];
                string1[j] = string1[j + 1];
                string1[j + 1] = temp;
            }
        }
    }
    cout << string1 << endl;
    return 0;
}