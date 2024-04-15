Build a query that selects the 3rd to 5th rows from the Employees table, ordered by the salary column in descending order.

SELECT *
FROM Employees
ORDER BY Salary DESC
LIMIT 3 OFFSET 2             ----- starting from 3 and next 2 rows

You are given an Employees table, with the following columns: firstname, lastname, salary, department.
Select the data in all columns for the top 3 earners in the table. 

SELECT *
FROM Employees
ORDER BY Salary Desc   ----Using salary column to arrange
LIMIT 3     --- Gives the first 3 rows


SELECT CONCAT(firstname, ' ', lastname) AS name    CONCAT IS USED TO JOIN
FROM Customers

UPPER() AND LOWER() To convert the input

SELECT SUBSTRING(firstname, 1, 3)  ---> substring used to extract the elements in thw word
FROM Customers    ---> Starting from 1 and the next 2 rows including 1
(Firstname,1,3) -- from 1-starting row and 3 indicates total of 3 rows

SELECT firstname, lastname, 
REPLACE(city, 'New York', 'NY')  ---> Used to replace
FROM Customers

sql code to replace all '!' characters with a dot '.' in the description column of the Books table. Order the result by the year column.
SELECT REPLACE(Desceiption,'!','.')
FROM Books
ORDER BY Year


Email Generator 
You need to generate emails for the Employees.
The email format is firstname.lastname@company.com
So, for example, for John Smith the email would be: john.smith@company.com
Note, that the email should be in lowercase.
Write a query to create the email addresses for all employees in the table and output the result in a new column called "email".
Sort the result by the email column in ascending order. 


SELECT CONCAT(LOWER(Firstname)||'.'||LOWER(Lastname)||'@company.com') AS email
FROM employees
ORDER BY email ASC
