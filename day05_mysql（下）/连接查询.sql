-- 笛卡尔积
SELECT * FROM student,score;

SELECT * 
FROM student,score
WHERE student.stuid = score.stuid;
-- 根据主外键关系

-- 1.
SELECT s.stuid, stuname, score, courseid
FROM student s, score r
WHERE s.stuid = r.stuid;deptdept


SELECT * FROM emp;
SELECT * 
FROM emp e, dept d
WHERE e.deptno = d.deptno; 



