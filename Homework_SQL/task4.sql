SELECT last_name, COUNT(last_name) as last_name_count
FROM person
GROUP BY last_name
ORDER BY last_name