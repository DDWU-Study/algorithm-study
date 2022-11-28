-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME , SEX_UPON_INTAKE
from animal_ins
where name  IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
order by animal_id;