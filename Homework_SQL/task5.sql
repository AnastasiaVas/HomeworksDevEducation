SELECT last_name
FROM person
WHERE SUBSTRING (last_name, 2, LENGTH(last_name) - 2) LIKE '%b%';