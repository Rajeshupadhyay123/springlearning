USE `employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--This SQL query creates a table named "authorities" with two columns: "username" and "authority". 
--The "username" column is of type varchar(50) and cannot be null. The "authority" column is also of type varchar(50) and cannot be null. 
--The query also creates a unique key on the combination of the "username" and "authority" columns². 
--
--The UNIQUE KEY `authorities_idx_1` (`username`,`authority`) creates an index on the combination of the "username" and "authority" columns². 
--
--The CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) specifies
-- that the "username" column in the "authorities" table is a foreign key that references the "username" column in the "users" table². 
--
--The ENGINE=InnoDB DEFAULT CHARSET=latin1 specifies that the table uses the InnoDB storage engine and the latin1 character set².
--
--I hope this helps! Let me know if you have any more questions.
--
--Source: Conversation with Bing, 6/19/2023
--(1) java - How to write Entity for two tables having foreign key and .... https://stackoverflow.com/questions/44963846/how-to-write-entity-for-two-tables-having-foreign-key-and-combination-key.
--(2) Spring boot jpa not generating spring security tables "users" and .... https://stackoverflow.com/questions/65051836/spring-boot-jpa-not-generating-spring-security-tables-users-and-authorities.
--(3) oauth2/db_data.sql at master · nareshbafna/oauth2 · GitHub. https://github.com/nareshbafna/oauth2/blob/master/db_data.sql.

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');





