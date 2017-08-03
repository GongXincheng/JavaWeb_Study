-- 学生表
CREATE TABLE student(
	stuid VARCHAR(10)PRIMARY KEY,
	stuname VARCHAR(50)
);

-- 分数表
CREATE TABLE score(
	stuid VARCHAR(10),
	score INT,
	courseid INT,
				-- 添加外键约束:方式一
	CONSTRAINT fk_stu_sco  FOREIGN KEY(stuid) REFERENCES student(stuid)
);

INSERT INTO student VALUES('1001','张三峰');
INSERT INTO student VALUES('1002','张无忌');
INSERT INTO student VALUES('1003','王尼玛');
INSERT INTO student VALUES('1004','王老五');

INSERT INTO score VALUES('1001',98,1);
INSERT INTO score VALUES('1002',95,1);
INSERT INTO score VALUES('1002',67,2);
INSERT INTO score VALUES('1003',83,2);
INSERT INTO score VALUES('1003',57,3);

SELECT * FROM student;
SELECT * FROM score;
DROP TABLE score;
DROP TABLE student;


引用完整性(参照完整性)：
	
	外键约束：FOREIGN KEY
		
--  添加外键约束:方式二：
CREATE TABLE stu(
	stuid INT PRIMARY KEY,
	NAME VARCHAR(50) NOT NULL
);

CREATE TABLE score1(
	stuid INT,
	score DOUBLE
);

ALTER TABLE score1 ADD CONSTRAINT fk_stuid FOREIGN KEY (stuid) REFERENCES stu(stuid);