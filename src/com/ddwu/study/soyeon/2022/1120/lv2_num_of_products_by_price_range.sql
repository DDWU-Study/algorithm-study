SELECT (PRICE div 10000) * 10000 as PRICE_GROUP, COUNT(PRODUCT_ID) as PRODUCTS
FROM PRODUCT
GROUP BY PRICE div 10000
ORDER BY PRICE_GROUP ASC;