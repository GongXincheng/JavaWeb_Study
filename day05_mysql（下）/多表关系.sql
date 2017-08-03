-- 多对多关系

CREATE TABLE teacher(
	tid INT PRIMARY KEY,
	tname VARCHAR(20)
);

CREATE TABLE stu2(
	sid INT PRIMARY KEY,
	sname VARCHAR(50)
);

CREATE TABLE tea_stu_rel(
	tid INT,
	sid INT
);

-- 创建外键 （多对多）
ALTER TABLE tea_stu_rel ADD CONSTRAINT fk_tid FOREIGN KEY (tid) REFERENCES teacher(tid);
ALTER TABLE tea_stu_rel	ADD CONSTRAINT fk_sid FOREIGN KEY (sid) REFERENCES stu2(sid);



-- 一对一关系
CREATE TABLE QQ(
	qqid INT PRIMARY KEY,
	PASSWORD VARCHAR(50)
);

CREATE TABLE QQDetail(
	qqid INT PRIMARY KEY,
	NAME VARCHAR(50),
	adddess VARCHAR(200)
);

ALTER TABLE QQDetail ADD CONSTRAINT fk_QQ_QQDetail_qqid FOREIGN KEY (qqid) REFERENCES QQ(qqid);

