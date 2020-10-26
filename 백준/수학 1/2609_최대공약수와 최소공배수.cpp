#include <stdio.h>
int gcd(int a, int b){
    if (b==0){
        return a;
    } else{
        return gcd(b,a%b);
    }
}
int main(){
    int a, b;
    scanf("%d %d",&a,&b);
    int G = gcd(a,b);
    int L = G*(a/G)*(b/G);
    printf("%d\n%d",G,L);

    return 0;
}
