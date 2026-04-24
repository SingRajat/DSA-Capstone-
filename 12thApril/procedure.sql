use capstone;

CREATE TABLE student (
    student_id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(10) CHECK (department IN ('CS', 'IT', 'ENTC')),
    marks INT
);

INSERT INTO student (student_id, name, department, marks) VALUES
(1, 'Amit', 'CS', 85),
(2, 'Sneha', 'IT', 78),
(3, 'Rahul', 'ENTC', 82),
(4, 'Priya', 'CS', 90),
(5, 'Karan', 'IT', 76),
(6, 'Neha', 'ENTC', 88),
(7, 'Vikas', 'CS', 91),
(8, 'Pooja', 'IT', 73),
(9, 'Arjun', 'ENTC', 80),
(10, 'Meera', 'CS', 87);

select * from student where department='cs';

DELIMITER $$

CREATE PROCEDURE GetStudentsByDepartment(IN dept VARCHAR(10))
BEGIN
    SELECT * 
    FROM student
    WHERE department = dept;
END $$

DELIMITER ;

CALL GetStudentsByDepartment('CS');

DELIMITER $$

CREATE PROCEDURE getStudent()
BEGIN
	SELECT * 
    FROM STUDENT;
END $$

DELIMITER ;


-- Find highest marks

DELIMITER $$
create procedure highestmarks()
begin
	select *
    from student
    where marks = (select max(marks) from student);
end $$
delimiter ;

call highestmarks();

DELIMITER $$
create procedure avgmarks()
begin
	select avg(marks)
    from student;
end $$
delimiter ;

call avgmarks();

-- show students bw 70 to 90 marks
DELIMITER $$
create procedure 70to90()
begin
	select * from 
    student where
    marks between 70 AND 90;
end $$
delimiter ;

call 70to90();


CREATE TABLE main (
    id INT PRIMARY KEY,
    salary INT
);

CREATE TABLE backup (
    id INT,
    salary INT
);

DELIMITER $$

CREATE TRIGGER t1
BEFORE DELETE ON main
FOR EACH ROW
BEGIN
    INSERT INTO backup (id, salary)
    VALUES (OLD.id, OLD.salary);
END $$

DELIMITER ;

INSERT INTO main VALUES (1, 50000), (2, 60000);

DELETE FROM main WHERE id = 1;

SELECT * FROM backup;