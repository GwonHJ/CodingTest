# 코딩테스트 대비 DML정리

코딩테스트 대비용 문제 사이트

https://programmers.co.kr/learn/challenges?selected_part_id=17046

여기에 있는 사이트를 기준으로 정리

----------------------------


## 기본적인 형식

SELECT [컬럼이름] FROM [테이블이름]\
WHERE [조건]\
GROUP BY [그룹화할 컬럼]\
HAVING [그룹화한 뒤 조건]\
LIMIT [제한할 개수]
  
  ex)
  
      서랍에 있는 연필 중 길이가 10cm 이상인 연필
      SELECT 연필 FROM 서랍
      WHERE 길이 >= 10
      
      서랍에 있는 연필 중 길이가 10cm 이상이고 빨간색 연필
      SELECT 연필 FROM 서랍
      WHERE 길이 >= 10 AND 색 = '빨간색'
      
COUNT ([셀 컬럼])\
DISTINCT : 중복제거\
AS '~' : 열을 ~로 정의

  ex)
  
      COUNT(DISTINCT user_id) AS 'unigue' : 중복되지 않은 user_id의 개수를 센후 unique라고 칭하겠다

## GROUP BY
    ex)
    
    user_id           evet         event_date
      1          login_facebook    2018-03-12
      2          write_posting     2018-03-13
      1          write_comment     2018-03-12 
      3          login_facebook    2018-03-12    
      
      ---------------------------------------
      SELECT event, event_date, COUNT(DISTINCT user_id) AS 'unique'
      FROM A
      GROUP BY event, event_date
      ORDER BY event_date ASC
      
      -----[실행결과]------------------------
      
           evet         event_date    unique
      login_facebook    2018-03-12      2
      write_comment     2018-03-12      1
      write_posting     2018-03-13      1
      
      
 ## 집계함수
 
 AVG(계산할 대상) : 평균\
 MIN(계산할 대상) : 최소값\
 MAX(계산할 대상) : 최대값\
 STDEV(계산할 대상)  : 표준 편차\
 VAR_SAMP(계산할 대상) : 분산
 
 
## WHERE
   : 특정조건을 만족하는 데이터
   
   BETWEEN ~ AND/
   IN(~,~) : 괄호안을 만족하는 것이 있는것을 뽑겠다 -> OR기능\
   LIKE : 특정 문자열을 포함하는 데이터\
      - '(문자열)%' : (문자열)로 시작하는 모든 데이터\
      - '%(문자열)' : (문자열)로 끝나는 모든 데이터\
      - '%(문자열)%' : (문자열)이 포함된 모든 데이터\
      - '\_(문자열)' : (문자열)앞에 무조건 한글자가 있는 데이터\
      - '(문자열)\_' : (문자열)뒤에 무조건 한글자가 있는 데이터\
      - '\_(문자열)\_' : (문자열)앞과 뒤에 무조건 한글자가 있는 데이터\
   AND / OR/ NOT\
   IS NULL : 값이 비어있는 경우
      
      ex)
        
        키가 180cm이상 183cm이하인 사람
        SELECT name, height FROM a
        WHERE height BETWEEN 180 AND 183
        
        이름이 홍길동, 김철수, 라이언에 해당하는 사람
        WHERE name IN ('홍길동', '김철수', '라이언')        
        
        WHERE name LIKE '김%'
         => 김철수, 김밥, 김밥은맜잇어, 김
        WHERE name LIKE '_길%'
         => 홍길동, 이길에서, 저길, 요길에서보자 ...
        WHERE name LIKE '%이%'
         => 라이언, 이씨, 이름이뭐에요, 이, 이빨이빠졌어요, 아름다운이땅에...
    
        WHERE name LIKE '_길%' AND NOT NAME LIKE '%에'
         => 홍길동, 저길 ...
         
         
 ## 서브쿼리
  : 괄호를 이용해서 조건안에 조건을 넣을 수 있음
   
   ex)
      
        홍길동보다 키가 큰 사람
        SELECT name, height FROM a
        WHERE height > (SELECT height FROM a WHERE NAME = '홍길동')
        
        
## JOIN
   :관련된 두 테이블을 합치기
   
   SELECT 테이블이름.컬럼이름 FROM 테이블이름\
   LEFT JOIN 합칠테이블이름 ON 테이블이름.기준컬럼 = 합칠테이블이름.기준컬럼\
   
   JOIN 종류
   
   1. INNER JOIN
   2. OUTER JOIN
   3. CROSS JOIN
   4. FULL OUTER JOIN
   5. SELF JOIN

   ex)
        
        SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.NAME
        FROM ANIMAL_OUTS
        LEFT JOIN ANIMAL_INS ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
        WHERE ANIMAL_INS.ANIMAL_ID IS NULL
        ORDER BY ANIMAL_OUTS.ANIMAL_ID
        
        
        SELECT ANIMAL_INS.ANIMAL_ID, ANIMAL_INS.ANIMAL_TYPE, ANIMAL_INS.NAME
        FROM ANIMAL_INS
        INNER JOIN ANIMAL_OUTS ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
        WHERE ANIMAL_INS.SEX_UPON_INTAKE != ANIMAL_OUTS.SEX_UPON_OUTCOME
        ORDER BY ANIMAL_INS.ANIMAL_ID;
   
         
----------------------------------------
