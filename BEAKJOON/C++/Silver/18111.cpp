/*백준 18111 : 마인크래프트
 * 자료구조
 * int width : 맵의 가로 칸 수
 * int vertical : 맵의 세로 칸 수
 * int block : 초기에 입력받는 블록 수
 * int rand[][] : 맵을 저장
 * int max : 맵 중에 가장 높이가 높은 수
 * int min : 맵 중에 가장 높이가 낮은 수
 * int time : 가장 빠른 시간 저장할 변수
 * int height : 시간이 time일 때 맵의 높이
 * int temp_time : 라운드 별로 시간
 * int temp_height : 라운드 별로 높이
 * int fill : 땅을 채우는 횟수
 * int dig : 땅을 파는 횟수
 *
 * 알고리즘
 * 브루트포스
 * */
#include <iostream>
#include <climits>
using namespace std;

int main() {

    int width = 0;  //맵의 가로 칸 수
    int vertical = 0;  //맵의 세로 칸 수
    int block = 0;  //가지고 있는 블록의 수
    int rand[500][500];  //맵을 저장할 배열
    int max = INT_MIN;  //맵에서 가장 높은 높이
    int min = INT_MAX;  //맵에서 가장 낮은 높이
    int time = INT_MAX;  //가장 빠른 시간을 저장할 변수
    int height = INT_MIN;  //시간이 time 일 때 맵의 높이
    int temp_time = 0;  //라운드마다 만들어지는 시간
    int temp_height = 0;  //라운드마다 만들어지는 높이
    int fill = 0;  //땅을 채우는 수
    int dig = 0;  //땅을 파는 수
    cin >> width >> vertical >> block;

    //vertical * width 만큼 2차원 배열에 땅 입력
    for(int i = 0; i < vertical; i++) {
        for(int j = 0; j < width; j++) {
            cin >>rand[i][j];

            if(rand[i][j] > max)
                max = rand[i][j];

            if(rand[i][j] < min)
                min = rand[i][j];
        }
    }

    //브루트 포스
    for(int i = max; i >= min; i--) {  //땅의 가장 높은 높이부터 낮은 위치까지 모든 높이를 가정하고 평탄화 작업
        for(int j = 0; j < vertical; j++) {
            for(int k = 0; k < width; k++) {
                if(rand[j][k] < i) {  //해당 칸의 높이가 원하는 높이보다 낮으면
                    fill += (i - rand[j][k]);  //원하는 높이까지 땅 채우기
                }
                if(rand[j][k] > i) {  //해당 칸의 높이가 원하는 높이보다 높으면
                    dig += (rand[j][k] - i);  //원하는 높이까지 땅 파기
                }
            }
        }
        if(block + dig >= fill) {  //총 블록 수(이미 가지고 있는 블록 + 땅을 파서 새로 생긴 블록)보다 채워야 하는 블록이 적으면
            temp_time = fill + (2 * dig);  //소요되는 시간 계산
            temp_height = i;  //땅의 높이는 현재 목표 높이로 입력
            fill = 0;  //변수 초기화
            dig = 0;  //변수 초기화

            if(temp_time < time) {  //time을 최소값으로 변경
                time = temp_time;
                height = temp_height;
            }
            else if (temp_time == time) {  //시간이 같으면
                if(temp_height > height)  //높이가 더 높은 경우로 변경
                    height = temp_height;
            }
        }
        else {  //변수 초기화
            fill = 0;
            dig = 0;
        }
    }

    cout << time << " " << height <<"\n";  //출력
    return 0;
}