def solution(prices):
    answer = []
    for i in range(0,len(prices)) :
        for j in range(i,len(prices)):
            if prices[i] > prices[j] :
                answer.append(j-i)
                break
            else : answer.append(len(prices)-1-i)
    return answer
