-- 子查询

-- 1.查询于scott同一个部门的员工
	SELECT * FROM emp WHERE deptno = (
		SELECT deptno FROM emp WHERE ename='scott'
	);
	
-- 2.查询工资高于JONES的员工
	SELECT * FROM emp WHERE sal > (
		SELECT sal FROM emp WHERE ename = 'JONES'
	);
	
-- 3.工资高于30号部门所有人的员工信息
	SELECT * FROM emp WHERE sal > (
		SELECT MAX(sal) FROM emp WHERE deptno = 30
	);
	
	SELECT * FROM emp WHERE sal > ALL (		-- 大于所有
		SELECT sal FROM emp WHERE deptno = 30
	);
	
-- 4.查询工作和工资于 MARTIN 完全相同的员工信息		单行多列用in
	SELECT * FROM emp WHERE (job,sal) IN (
		SELECT job,sal FROM emp WHERE ename = 'MARTIN'
	);

-- 5.有两个以上直接下属的员工信息
	SELECT * FROM emp WHERE empno IN(
		SELECT mgr FROM emp GROUP BY mgr HAVING COUNT(mgr)>=2
	);
	
-- 6. 查询员工编号为7788的员工名称，员工工资，部门名称，部门地址
	SELECT e.ename, sal, dname, loc
	FROM emp e , dept d
	WHERE e.deptno = d.deptno
	AND e.empno = 7788;

-- 7. 自连接：自己连接自己，起别名
-- 求7369员工编号，姓名，经理编号，和经理名称
	SELECT e1.empno, e1.ename, e1.mgr, e2.ename 
	FROM emp e1, emp e2 
	WHERE e1.mgr = e2.empno 
	AND e1.empno = 7369;
	
	
	
	