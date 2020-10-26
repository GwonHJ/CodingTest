#include <string>
#include <algorithm>
#include <iostream>

using namespace std;

int main(){
	int a, b;	scanf("%d %d",&a,&b);
	int b1 = b%10;
	int b2 = (b%100 -b1)/10;
	int b3 = b/100;
	printf("%d\n",a*b1);
	printf("%d\n",a*b2);
	printf("%d\n",a*b3);
	printf("%d\n",a*b);
	return 0;
}
