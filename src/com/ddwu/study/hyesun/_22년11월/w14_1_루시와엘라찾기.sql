-- https://school.programmers.co.kr/learn/courses/30/lessons/59046
-- 이름이 Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 동물의
--아이디와 이름, 성별 및 중성화 여부를 조회

SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
-- (1) OR 연산자 (❌ ||)
WHERE (name='Lucy' or name='Ella' or name='Pickle'or name='Rogan'or name='Sabrina' or name='Mitty')

-- (2) IN 연산자
WHERE name IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY ANIMAL_ID