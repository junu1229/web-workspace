SELECT student_no, student_name, student_address, department_name, category
		FROM TB_STUDENT
		JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
        WHERE STUDENT_NO LIKE '%경기도%' 
        OR student_name LIKE '%경기도%' 
        OR student_address LIKE '%경기도%' 
        OR department_name LIKE '%경기도%' 
        OR category LIKE '%경기도%'