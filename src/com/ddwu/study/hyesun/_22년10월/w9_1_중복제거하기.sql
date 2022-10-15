-- 동물의 이름은 몇 개인지
-- 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나
-- Oracle
SELECT count(distinct name) FROM WHERE name is not null