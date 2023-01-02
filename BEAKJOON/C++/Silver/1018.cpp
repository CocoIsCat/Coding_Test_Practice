#include <iostream>
#include <string>
using namespace std;
int B_check(char chess[8][8]) {
	int count = 0;
	if (chess[0][0] != 'B') {
		count++;
		chess[0][0] = 'B';
	}
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 7; j++) {
			if (i == 0) {
				if (chess[i][j] == chess[i][j + 1]) {
					count++;
					if (chess[i][j] == 'W')
						chess[i][j + 1] = 'B';
					else
						chess[i][j + 1] = 'W';
				}
			}
			else {
				if (chess[i][j] == chess[i - 1][j]) {
					count++;
					if (chess[i-1][j] == 'W')
						chess[i][j] = 'B';
					else
						chess[i][j] = 'W';
				}
				if (chess[i][j] == chess[i][j + 1]) {
					count++;
					if (chess[i][j] == 'W')
						chess[i][j + 1] = 'B';
					else
						chess[i][j + 1] = 'W';
				}
			}
		}
	}
	return count;
}
int W_check(char chess[8][8]) {
	int count = 0;
	if (chess[0][0] != 'W') {
		count++;
		chess[0][0] = 'W';
	}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				if (i == 0) {
					if (chess[i][j] == chess[i][j + 1]) {
						count++;
						if (chess[i][j] == 'W')
							chess[i][j + 1] = 'B';
						else
							chess[i][j + 1] = 'W';
					}
				}
				else {
					if (chess[i][j] == chess[i - 1][j]) {
						count++;
						if (chess[i - 1][j] == 'W')
							chess[i][j] = 'B';
						else
							chess[i][j] = 'W';
					}
					if (chess[i][j] == chess[i][j + 1]) {
						count++;
						if (chess[i][j] == 'W')
							chess[i][j + 1] = 'B';
						else
							chess[i][j + 1] = 'W';
					}
				}
			}
		}
	return count;
}

int main() {
	int M, N;
	int i = 0, j = 0, k = 0, l = 0;
	cin >> M >> N;
	string* board = new string[M];
	char B_send[8][8] = { 0 };
	char W_send[8][8] = { 0 };
	int WC = 0,BC = 0,count = 0;
	int min = 64;
	while (getchar() != '\n');
	for (int m = 0; m < M; m++) {
		getline(cin, board[m]);
	}
	for (i = 0; i < M - 7; i++) {
		j = 0;
		for (j; j < N - 7; j++) {
			for (k = i; k <= 7 + i; k++) {
				for (l = j; l <= 7 + j; l++) {
					W_send[k - i][l - j] = board[k][l];
					B_send[k-i][l-j] = board[k][l];
				}
			}
			WC = W_check(W_send);
			BC = B_check(B_send);
			if (WC < BC)
				count = WC;
			else
				count = BC;
			if (min < count);
			else
				min = count;
		}
	}
	cout << min << "\n";
	return 0;
}