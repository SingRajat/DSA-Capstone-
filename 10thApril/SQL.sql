create database capstone;
use capstone;
-- Create table
CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    salary DECIMAL(10,2)
);

-- Insert 11 records
INSERT INTO employees (emp_id, name, department, salary) VALUES
(1, 'Amit Sharma', 'HR', 45000.00),
(2, 'Priya Singh', 'Finance', 55000.00),
(3, 'Rahul Verma', 'IT', 60000.00),
(4, 'Sneha Patil', 'Marketing', 48000.00),
(5, 'Vikas Gupta', 'Sales', 52000.00),
(6, 'Neha Joshi', 'IT', 62000.00),
(7, 'Arjun Mehta', 'Finance', 58000.00),
(8, 'Kavita Nair', 'HR', 47000.00),
(9, 'Rohan Das', 'Sales', 51000.00),
(10, 'Pooja Kulkarni', 'Marketing', 49000.00),
(11, 'Manish Yadav', 'IT', 63000.00);

select * from employees;

select emp_id,
name,
department,
salary,
ROW_NUMBER() OVER (PARTITION By department ORDER BY salary DESC) as row_num
from employees;

select *
FROM(
select *,
row_number() over (PARTITION BY department ORDER BY Salary desc) as rn
from employees
) t
WHERE rn = 2;

select *
FROM(
select *,
row_number() over (PARTITION BY department ORDER BY Salary desc) as rn
from employees
) t
WHERE rn = 1;

select *
FROM(
select *,
row_number() over (PARTITION BY department ORDER BY Salary desc) as rn
from employees
) t
WHERE rn = 2 or rn=1;

select
name,
salary,
LEAD(salary) OVER (ORDER BY salary) as next_salary
from employees;


-- EMPLOYEE table
CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    dept_id INT,
    manager_id INT
);

-- DEPARTMENT table
CREATE TABLE department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);

-- MANAGER table
CREATE TABLE manager (
    manager_id INT PRIMARY KEY,
    manager_name VARCHAR(50)
);

-- PRODUCT table
CREATE TABLE product (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(50),
    price DECIMAL(10,2)
);

-- ORDERS table
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    emp_id INT,
    product_id INT
);

-- DEPARTMENT
INSERT INTO department VALUES
(1, 'HR'),
(2, 'IT'),
(3, 'Sales');

-- MANAGER
INSERT INTO manager VALUES
(101, 'Mr. Rao'),
(102, 'Ms. Iyer');

-- EMPLOYEE
INSERT INTO employee VALUES
(1, 'Amit', 1, 101),
(2, 'Priya', 2, 102),
(3, 'Rahul', 3, 101);

-- PRODUCT
INSERT INTO product VALUES
(201, 'Laptop', 70000),
(202, 'Phone', 30000);

-- ORDERS
INSERT INTO orders VALUES
(301, 1, 201),
(302, 2, 202),
(303, 3, 201);

-- Employee with Department
SELECT e.emp_name, d.dept_name
FROM employee e
JOIN department d ON e.dept_id = d.dept_id;

-- Employee with Manager
SELECT e.emp_name, m.manager_name
FROM employee e
JOIN manager m ON e.manager_id = m.manager_id;

-- Orders with Employee and Product
SELECT o.order_id, e.emp_name, p.product_name
FROM orders o
JOIN employee e ON o.emp_id = e.emp_id
JOIN product p ON o.product_id = p.product_id;