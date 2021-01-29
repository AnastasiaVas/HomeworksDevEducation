SELECT s.name, COUNT(p.id_street) AS street_count
FROM street s INNER JOIN person p ON s.id = p.id_street
GROUP BY s.name
ORDER BY s.name