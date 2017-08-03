-- 内连接查询

	-- 1、99查询法
		SELECT * FROM emp;
		SELECT e.empno,e.ename,e.hiredate 
		FROM emp e, dept d
		WHERE e.deptno = d.deptno; 
		
	-- 2、内连接查询：JOIN ... ON ...
		SELECT * 
		FROM student s JOIN score c
		ON s.stuid = c.stuid;



-- 外连接查询

	-- 左外连接:
		SELECT * 
		FROM student s LEFT JOIN score c
		ON s.stuid = c.stuid;
		
	-- 右外连接:	
		SELECT * 
		FROM student s RIGHT JOIN score c
		ON s.stuid = c.stuid;
	
	
-- 多表查询
	CREATE TABLE course(
		courseid INT PRIMARY KEY,
		cname VARCHAR(50)
	);	
-- 99查询法
	SELECT * 
	FROM student s, score c, course cc
	WHERE s.stuid = c.stuid
	AND c.courseid = cc.courseid; 
	
-- 
	SELECT * 
	FROM student s 
	JOIN score c ON s.stuid = c.stuid
	JOIN course cc ON c.courseid = cc.courseid;
	
	
	
-- 自然连接
	SELECT * FROM student s NATURAL JOIN score c
	SELECT * FROM student s NATURAL LEFT JOIN score c
	SELECT * FROM student s NATURAL RIGHT JOIN score c