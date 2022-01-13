#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// arr_len은 배열 arr의 길이입니다.
int solution (int arr[], size_t arr_len) {
    int answer = 1;
    int count = 0; //j가 어떤 수의 약수인지 아닌지
    int j = 2;//약수 찾기
    int arr_multi=1; // 배열안의 모든 수를 곱하기
   while(1){
       arr_multi = 1;
        for(int i=0; i<arr_len; i++){
            if(arr[i]%j==0){//배열에서 j를 약수로 가지는 수가 있다면
                arr[i]=arr[i]/j;//그 수를 j로 나눈 값으로 바꾸고
                count++;//j가 약수라고 입력
            }
            arr_multi = arr_multi*arr[i];
        }
            if(count!=0){//j를 약수로 가지는 수가 있다면 바뀐 배열에서의 약수를 찾으러 가야함
                answer = answer*j;//answer에 j를 곱함
                count=0;
                //j=2; //처음 문제 풀때는 j를 다시 2로 바꿔서 다시 찾았는데 블로그를 작성하던 중 그럴 필요가 없다는 것을 알게됨.
            }else{
                j++;//아니면 다음수가 약수인지 아닌지 판단
            }
        if(arr_multi==1){//배열안의 모든 수가 1로 바뀌면 최소공배수 찾기 완료
            break;
        }
    }
    return answer;
}

