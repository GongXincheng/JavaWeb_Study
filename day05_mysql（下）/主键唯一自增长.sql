CREATE DATABASE day05;
USE day05;

-- 主键约束：primary key
	-- 方式1：
	CREATE TABLE student(
		id INT PRIMARY KEY,
		NAME VARCHAR(50)
	);
	
	-- 方式2：适合创建联合主键
	CREATE TABLE student(
		classid INT,
		id INT,
		NAME VARCHAR(50),
		PRIMARY KEY(id, classid)
	);

	-- 方式3：
	CREATE TABLE student(
		id INT,
		NAME VARCHAR(50)
	);
	ALTER TABLE student ADD CONSTRAINT pk_stu_id PRIMARY KEY(id);


-- 唯一约束：unique
	CREATE TABLE student(
		id INT PRIMARY KEY,
		NAME VARCHAR(50) UNIQUE
	);
	
-- 添加自动增长列：auto_increment
	CREATE TABLE student(
		id INT PRIMARY KEY AUTO_INCREMENT,
		NAME VARCHAR(50) UNIQUE
	);

-- 删除数据库表
DROP TABLE student;
SELECT * FROM student;