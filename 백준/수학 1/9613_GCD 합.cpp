#include<stdio.h>
int gcd(int a, int b){
    if(b==0)    return a;
    else        return gcd(b,a%b);
}
int main(){
    int T;    scanf("%d",&T);
    for(int i = 0; i<T; i++){
        int n;    scanf("%d",&n);
        int a[100] = {0};    long long sum = 0;
        for(int j = 0; j<n; j++){
            scanf("%d",&a[j]);
        }
        for(int j = 0; j<n-1; j++){
            for(int k = j+1; k<n; k++){
                sum += gcd(a[j],a[k]);
            }
        }
        printf("%lld\n",sum);
    }
    
    return 0;
}
