#include <iostream>
using namespace std;

int main() {

	int arr[10001] = {0};
	int newnum;

	for (int i = 1; i <= 10000; i++) {
		newnum = i;
		do {
			if (newnum != i && newnum <= 10000) {
				arr[newnum] = 1;
			}
			newnum = (newnum / 1000) + ((newnum / 100) % 10) + ((newnum / 10) % 10) + (newnum % 10) + newnum;
		} while (newnum <= 10000);
	}
	for (int i = 1; i <= 10000; i++) {
		if (arr[i] == 0)
			cout << i << endl;
	}

	return 0;
}