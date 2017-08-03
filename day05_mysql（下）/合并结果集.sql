
--------------联合查询------------------
CREATE TABLE A(
	NAME VARCHAR(10),
	score INT
);

CREATE TABLE B(
	NAME VARCHAR(10),
	score INT
);

INSERT INTO A VALUES('a',10),('b',20),('c',30);
INSERT INTO B VALUES('a',10),('b',20),('d',40);



-- 合并结果集查询
SELECT * FROM A
UNION
SELECT * FROM B;

SELECT * FROM A
UNION ALL
SELECT * FROM B;
-- 要求：被合并的两个结果：列数、列类型必须相同。