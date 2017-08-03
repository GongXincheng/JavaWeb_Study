-- 查询表中的所有数据 
SELECT * FROM emp;

-- 向emp表中添加数据
INSERT INTO emp(id,NAME,gender,birthday,salary,entry_date,RESUME)
VALUES(1,'tom','m','2015-09-24',10000,'2015-09-25','good boy');

INSERT INTO emp(id,NAME,gender,birthday,salary,entry_date,RESUME)
VALUES(2,'jerry','f','2015-09-24',10000,'2015-09-25','good girl');

INSERT INTO emp(id,NAME,gender,birthday,salary,entry_date,RESUME)
VALUES(2,'菜10','f','2015-09-24',10000,'2015-09-25','good girl');

INSERT INTO emp VALUES(2,'周杰杰','f','2015-09-24',10000,'2015-09-25','good girl');

-- 将所有员工薪水修改为5000元。
UPDATE emp SET salary=5000;
-- 将姓名为’tom’的员工薪水修改为3000元。if(name=='tom')
UPDATE emp SET salary=3000 WHERE NAME='tom';

-- 将姓名为’jerry’的员工薪水修改为4000元,job改为ccc。
UPDATE emp SET salary=4000,gender='m' WHERE NAME='jerry';
			
-- 将wu的薪水在原有基础上增加1000元。
UPDATE emp SET salary=salary+1000 WHERE NAME='菜10';
	
-- Delete语句
-- 删除表中名称为’tom’的记录。
DELETE FROM emp WHERE NAME='tom';

-- 删除表中所有记录。
DELETE FROM emp;
-- 使用truncate删除表中记录。
TRUNCATE TABLE emp;

SELECT NAME,gender FROM emp;

-- 查询练习- ----------- 

CREATE TABLE stu (
	sid	CHAR(6),
	sname		VARCHAR(50),
	age		INT,
	gender	VARCHAR(50)
);

INSERT INTO stu VALUES('S_1001', 'liuYi', 35, 'male');
INSERT INTO stu VALUES('S_1002', 'chenEr', 15, 'female');
INSERT INTO stu VALUES('S_1003', 'zhangSan', 95, 'male');
INSERT INTO stu VALUES('S_1004', 'liSi', 65, 'female');
INSERT INTO stu VALUES('S_1005', 'wangWu', 55, 'male');
INSERT INTO stu VALUES('S_1006', 'zhaoLiu', 75, 'female');
INSERT INTO stu VALUES('S_1007', 'sunQi', 25, 'male');
INSERT INTO stu VALUES('S_1008', 'zhouBa', 45, 'female');
INSERT INTO stu VALUES('S_1009', 'wuJiu', 85, 'male');
INSERT INTO stu VALUES('S_1010', 'zhengShi', 5, 'female');
INSERT INTO stu VALUES('S_1011', 'xxx', NULL, NULL);


CREATE TABLE emp(
	empno		INT,
	ename		VARCHAR(50),
	job		VARCHAR(50),
	mgr		INT,
	hiredate	DATE,
	sal		DECIMAL(7,2),
	comm		DECIMAL(7,2),
	deptno		INT
) ;

INSERT INTO emp VALUES(7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
INSERT INTO emp VALUES(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO emp VALUES(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,500,30);
INSERT INTO emp VALUES(7566,'JONES','MANAGER',7839,'1981-04-02',2975,NULL,20);
INSERT INTO emp VALUES(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,1400,30);
INSERT INTO emp VALUES(7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,NULL,30);
INSERT INTO emp VALUES(7782,'CLARK','MANAGER',7839,'1981-06-09',2450,NULL,10);
INSERT INTO emp VALUES(7788,'SCOTT','ANALYST',7566,'1987-04-19',3000,NULL,20);
INSERT INTO emp VALUES(7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO emp VALUES(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO emp VALUES(7876,'ADAMS','CLERK',7788,'1987-05-23',1100,NULL,20);
INSERT INTO emp VALUES(7900,'JAMES','CLERK',7698,'1981-12-03',950,NULL,30);
INSERT INTO emp VALUES(7902,'FORD','ANALYST',7566,'1981-12-03',3000,NULL,20);
INSERT INTO emp VALUES(7934,'MILLER','CLERK',7782,'1982-01-23',1300,NULL,10);

CREATE TABLE dept(
	deptno		INT,
	dname		VARCHAR(14),
	loc		VARCHAR(13)
);
INSERT INTO dept VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO dept VALUES(20, 'RESEARCH', 'DALLAS');
INSERT INTO dept VALUES(30, 'SALES', 'CHICAGO');
INSERT INTO dept VALUES(40, 'OPERATIONS', 'BOSTON');
SELECT * FROM dept;
SELECT * FROM emp;
SELECT * FROM stu;

DROP TABLE emp;

--  DQL练习
-- 1.2　查询指定列
SELECT sid,sname,age FROM stu;

-- 2.2　查询性别为女，并且年龄大于等于50的记录
SELECT * FROM stu WHERE gender='female' AND age>=50;

-- 2.3　查询学号为S_1001，或者姓名为liSi的记录
SELECT * FROM stu WHERE sid='S_1001' OR sname='lisi';

-- 2.4　查询学号为S_1001，S_1002，S_1003的记录
SELECT * FROM stu WHERE sid='S_1001' OR sid='S_1002' OR sid='S_1003';

SELECT * FROM stu WHERE sid IN('S_1001','S_1002','S_1003');

-- 2.5　查询学号不是S_1001，S_1002，S_1003的记录

SELECT * FROM stu WHERE sid NOT IN('S_1001','S_1002','S_1003');

-- 2.6　查询年龄为null的记录
SELECT * FROM stu WHERE age IS NULL;

SELECT * FROM stu WHERE age IS NOT NULL;

-- 2.7　查询年龄在20到40之间的学生记录
SELECT * FROM stu WHERE age>=20 AND age<=40;

SELECT * FROM stu WHERE age BETWEEN 20 AND 40;

-- 2.8　查询性别非男的学生记录
SELECT * FROM stu WHERE gender='female';

SELECT * FROM stu WHERE gender!='male';

SELECT * FROM stu WHERE gender<>'male';

-- 2.9　查询姓名不为null的学生记录
SELECT * FROM stu WHERE sname IS NOT NULL;

-- 3.1　查询姓名由5个字母构成的学生记录
SELECT * FROM stu WHERE sname LIKE '_____';

-- 3.2　查询姓名由5个字母构成，并且第5个字母为“i”的学生记录
SELECT * FROM stu WHERE sname LIKE '____i';

-- 3.3　查询姓名以“z”开头的学生记录
SELECT * FROM stu WHERE sname LIKE 'z%';

-- 3.4　查询姓名中第2个字母为“i”的学生记录
SELECT * FROM stu WHERE sname LIKE '_i%';

-- 3.5　查询姓名中包含“a”字母的学生记录
SELECT * FROM stu WHERE sname LIKE '%a%';


SELECT DISTINCT deptno FROM emp;

-- 4.2　查看雇员的月薪与佣金之和
SELECT * FROM emp;
SELECT sal+IFNULL(comm,0) FROM emp;

SELECT IFNULL(comm,0) FROM emp;

-- 给列起别名
SELECT *,sal+IFNULL(comm,0) AS total FROM emp;

SELECT sname AS 姓名, gender 性别 FROM stu;

SELECT sname,sname FROM stu;

-- 5.1　查询所有学生记录，按年龄升序排序
SELECT * FROM stu ORDER BY age ASC;
SELECT * FROM stu ORDER BY age;

-- 5.2　查询所有学生记录，按年龄降序排序
SELECT * FROM stu ORDER BY age DESC;

-- 5.3　查询所有雇员，按月薪降序排序，如果月薪相同时，按编号升序排序
SELECT * FROM emp ORDER BY sal ,empno DESC;

-- 6　聚合函数  sum avg max min count

SELECT COUNT(*) FROM stu;
-- 查询emp表中有佣金的人数：

SELECT COUNT(comm) FROM emp;
-- 查询emp表中月薪大于2500的人数：
SELECT COUNT(*) FROM emp WHERE sal>2500;

-- 统计月薪与佣金之和大于2500元的人数：

SELECT COUNT(*) FROM emp WHERE (sal+IFNULL(comm,0))>2500;

-- 查询有佣金的人数，有领导的人数：
SELECT COUNT(comm),COUNT(mgr) FROM emp;

-- 查询有佣金的人数，以及有领导的人数：
SELECT COUNT(*) FROM emp WHERE comm IS NOT NULL AND mgr IS NOT NULL;

-- 查询所有雇员月薪和：
SELECT SUM(sal) FROM emp;

-- 查询所有雇员月薪和，以及所有雇员佣金和：
SELECT SUM(sal),SUM(comm) FROM emp;

-- 查询所有雇员月薪+佣金和：
SELECT SUM(sal+IFNULL(comm,0)) FROM emp;

SELECT SUM(sal)+SUM(comm) FROM emp;

-- 统计所有员工平均工资：
SELECT AVG(sal) FROM emp;

-- 查询最高工资和最低工资：
SELECT MAX(sal),MIN(sal) FROM emp;


SELECT COUNT(*) FROM stu WHERE gender='male' OR gender='female';

SELECT COUNT(*) FROM stu WHERE gender IS NOT NULL GROUP BY gender;

SELECT COUNT(*) FROM stu WHERE gender IS NOT NULL GROUP BY gender;


-- 查询各部门的人数
SELECT deptno,COUNT(*) FROM emp GROUP BY deptno;

-- 查询每个部门的部门编号和每个部门的工资和：
SELECT deptno,SUM(sal) FROM emp GROUP BY deptno;
-- 查询每个部门的部门编号以及每个部门的人数：
SELECT deptno,COUNT(*) FROM emp GROUP BY deptno;

-- 查询每个部门的部门编号以及每个部门工资大于1500的人数
SELECT * FROM emp WHERE sal>1500;
SELECT deptno,COUNT(*) FROM emp WHERE sal>1500 GROUP BY deptno;

-- 查询工资总和大于9000的部门编号以及工资和：
SELECT deptno,SUM(sal) FROM emp GROUP BY deptno HAVING SUM(sal)>9000;


SELECT deptno,SUM(sal) FROM emp GROUP BY deptno HAVING SUM(sal)>9000 ORDER BY SUM(sal);


-- 查询工资大于1500的,工资总和大于6000的部门编号以及工资和：
SELECT deptno,SUM(sal) FROM emp WHERE sal>1500 GROUP BY deptno  HAVING SUM(sal)>6000 ORDER BY SUM(sal); 




-- limit
SELECT * FROM emp;
INT currentPage = 3;-- 当前页
INT pageSize = 3; -- 每页显示的条数
SELECT * FROM emp LIMIT （currentPage-1）*pageSize,pageSize;     


SELECT * FROM emp LIMIT 0,3; -- 第一个参数：从第几行查询，第二个参数：查几行



CREATE DATABASE day04;

USE day04;

CREATE TABLE student(
	id INT
);

