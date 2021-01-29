SELECT last_name, COUNT(last_name)
FROM person
GROUP BY last_name
ORDER BY last_name