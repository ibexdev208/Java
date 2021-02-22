USE products_DB;
CREATE TABLE monitor (
id INT(11) NOT NULL AUTO_INCREMENT,
brand VARCHAR(45) NOT NULL,
resolution INT(4) NOT NULL,
model VARCHAR(8) NOT NULL,
price FLOAT(6) NOT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

USE products_DB;
INSERT INTO monitor VALUES (1000, 'Dell', 1080, 'SE2216H', 89.99);
INSERT INTO monitor VALUES (1001, 'Samsung', 1280, 'S2721HGF', 328.49);

mysql> desc monitor;
+------------+-------------+------+-----+---------+----------------+
| Field      | Type        | Null | Key | Default | Extra          |
+------------+-------------+------+-----+---------+----------------+
| id         | int         | NO   | PRI | NULL    | auto_increment |
| brand      | varchar(45) | NO   |     | NULL    |                |
| resolution | int         | NO   |     | NULL    |                |
| model      | varchar(8)  | NO   |     | NULL    |                |
| price      | float       | NO   |     | NULL    |                |
+------------+-------------+------+-----+---------+----------------+

mysql> SELECT * FROM monitor;
+------+---------+------------+----------+--------+
| id   | brand   | resolution | model    | price  |
+------+---------+------------+----------+--------+
| 1000 | Dell    |       1080 | SE2216H  |  89.99 |
| 1001 | Samsung |       1280 | S2721HGF | 328.49 |
+------+---------+------------+----------+--------+

