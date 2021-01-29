SELECT p.first_name, p.last_name
	FROM person p INNER JOIN street s ON p.id_street = s.id
	WHERE lower(s.name) = lower('Pravdy avenue') and p.age < 18
	ORDER BY first_name