-- 域完整性：
-- 	数据类型
-- 	非空约束(not null)
-- 	默认值约束(default)
-- 	check约束(mysql不支持)：检查约束

CREATE TABLE student(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(50) UNIQUE NOT NULL,
	address VARCHAR(100) DEFAULT '北京'	
);

INSERT INTO student VALUE('zzzy','日本');   -- 报错
INSERT INTO student(NAME,address) VALUE('zzzy',DEFAULT);

DROP TABLE student;