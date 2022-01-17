from itertools import permutations
def sosu(n):
    if n <= 1:
        return False
    for i in range(2,n):
        if n%i == 0 :
            return False
    return True

def solution(numbers):
    answer = []
    per = []
    for i in range(1,len(numbers)+1) :
        per = permutations(numbers,i)
        for i in list(per) :
            num = int("".join(list(i)))
            if sosu(num) :
                answer.append(num)
            answer = list(set(answer))
    return len(answer)
