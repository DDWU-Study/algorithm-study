--https://school.programmers.co.kr/learn/courses/30/lessons/59409
select ANIMAL_ID,
       NAME,
       CASE WHEN SEX_UPON_INTAKE LIKE 'Intact%' THEN 'X' ELSE 'O' END AS "중성화"
from ANIMAL_INS
order by ANIMAL_ID
;