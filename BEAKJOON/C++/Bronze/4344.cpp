/* 백준 4344 : 평균은 넘겠지
 * 자료구조
 * int input_num : 테스트 케이스의 수
 * int student_num : 학생 수
 * int student[] : 학생 점수를 저장할 배열
 * int count : 평균 이상인 학생들을 세기 위한 변수
 * float mean : 학급 평균
 * int sum : 학급 학생들의 점수 총합
 *
 * 알고리즘 : 단순 구현
 * 재귀 사용한 바텀업 방식 사용
 */

#include <iostream>

using namespace std;

int main() {

    int input_num = 0;
    int student_num = 0;
    int student[1001] = {0};
    int count = 0;
    int sum = 0;
    float mean = 0;

    cin >> input_num;

    for(int i = 0; i < input_num; i++) {  //테스트 케이스 수대로 반복
        cin >> student_num;
        for(int j = 0; j <student_num; j++) {  //학생 수대로 반복
            cin >> student[j];
            sum += student[j];  // 학급 점수 합계
        }
        mean = (float)sum / (float)student_num;  //학급 평균 구하기

        for(int j = 0; j < student_num; j ++) {
            if((float)student[j] > mean) {  // 평균보다 점수가 높은 학생이 있다면
                count ++;  // count 증가
            }
        }

        //출력 형식 소수점 세자리 출력 위함
        cout<<fixed;
        cout.precision(3);

        cout << (((float)count / (float)student_num) * 100) << "% \n";
        sum = 0;
        mean = 0;
        count = 0;
    }
    return 0;
}