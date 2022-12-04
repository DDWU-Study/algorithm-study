-- 코드를 입력하세요
SELECT hour(datetime) HOUR,count(ANIMAL_ID) COUNT
from animal_outs
where hour(datetime) >= 9
group by hour(datetime)
-- 이거 안됨having hour(datetime) >= 9
-- having hour >= 9
order by hour(datetime);