-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID # GROUP BY 에 2개를 넣어야함 원리를 잘 알아야할듯 ㅠ
HAVING COUNT(*) > 1 # 같은 USER_ID가 PRODUCT_ID 2번 이상 구매 
ORDER BY USER_ID, PRODUCT_ID DESC;


# -- 코드를 입력하세요
# SELECT USER_ID, PRODUCT_ID
# FROM ONLINE_SALE
# GROUP BY USER_ID 
# HAVING COUNT( PRODUCT_ID) > 1 # 같은 USER_ID가 PRODUCT_ID 2번 이상 구매 
# ORDER BY USER_ID, PRODUCT_ID DESC;