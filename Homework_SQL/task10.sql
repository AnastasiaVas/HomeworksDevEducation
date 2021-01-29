SELECT s.name, COUNT(p.id_street) AS tenants_count
FROM street s INNER JOIN person p ON s.id = p.id_street
GROUP BY s.name
HAVING COUNT(p.id_street) < 3
ORDER BY s.name