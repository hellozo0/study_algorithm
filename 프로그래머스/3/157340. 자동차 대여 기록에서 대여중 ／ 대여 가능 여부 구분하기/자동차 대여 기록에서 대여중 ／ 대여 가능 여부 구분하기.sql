-- 코드를 입력하세요
SELECT CAR_ID, MAX(
    CASE WHEN '2022-10-16' BETWEEN H.START_DATE AND H.END_DATE
    THEN '대여중'
    ELSE '대여 가능'
    END) AS AVAILABILITY 
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H 
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;

-- 가장 마지막 대여 기록에 대한 car_id 뽑아내야함
-- 그리고 나서 그 중에 조건에 맞는거 뽑아서 컬럼 만들어야함
