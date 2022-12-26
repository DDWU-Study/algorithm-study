--https://school.programmers.co.kr/learn/courses/30/lessons/59040
SELECT ANIMAL_TYPE, count(*)
from ANIMAL_INS
where ANIMAL_TYPE in('Cat', 'Dog')
group by ANIMAL_TYPE
order by ANIMAL_TYPE