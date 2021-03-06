CREATE FUZZY DOMAIN fuzzyint50 AS POSSIBILITY DISTRIBUTION ON INTEGER;
CREATE TABLE test(id integer, value fuzzyint50);
INSERT INTO test VALUES(1,{f (Null, Null, 10, 20)} ); 
INSERT INTO test VALUES(2,{f (10, 20, Null, Null)} ); 
INSERT INTO test VALUES(3,{f 0.25/13, 1.0/14, 0.75/15} ); 
INSERT INTO test VALUES(4,{f (0, 11, 12, 13)} ); 
INSERT INTO test VALUES(5,{f 0.75/13, 1.0/14, 0.25/15} ); 
INSERT INTO test VALUES(6,{f (14, 15, 19, 30)} ); 
