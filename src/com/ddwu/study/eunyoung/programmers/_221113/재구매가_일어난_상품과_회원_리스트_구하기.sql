
    SELECT user_id,product_id
    from ONLINE_SALE
    group by user_id,product_id
    having count(*)>1
    ORDER BY USER_ID, PRODUCT_ID DESC