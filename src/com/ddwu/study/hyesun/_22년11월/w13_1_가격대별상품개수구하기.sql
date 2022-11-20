-- https://school.programmers.co.kr/learn/courses/30/lessons/131530
-- 만원 단위의 가격대 별로 상품 개수를 출력 (문자열계산)
SELECT concat(substr(PRICE, 0, 1), '0000')  * 10000 as PRICE_GROUP,
       count(*) as PRODUCTS FROM PRODUCT
GROUP BY concat(substr(PRICE, 0, 1), '0000')
ORDER BY BY concat(substr(PRICE, 0, 1), '0000')
;


-- 숫자 계산 floor()
SELECT FLOOR(PRICE / 10000) * 10000 AS PRICE_GORUP, COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY FLOOR(PRICE / 10000) * 10000
ORDER BY FLOOR(PRICE / 10000) * 10000