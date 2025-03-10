-- 코드를 작성해주세요
SELECT ID, IFNULL(B.CNT, 0) AS CHILD_COUNT
FROM ECOLI_DATA A LEFT JOIN (
    SELECT PARENT_ID, COUNT(PARENT_ID) AS CNT
    FROM ECOLI_DATA
    GROUP BY PARENT_ID
    ) AS B ON A.ID = B.PARENT_ID
ORDER BY ID;

-- PARENT_ID를 GROUP BY해서 그 개수를 ID의 요소로~ 
-- 없다면 0으로 