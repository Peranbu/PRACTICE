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

'''
|| instead of using , we can use ||
CONCAT Is used to merge firstname,.,lastname,@compay.com
ORDER BY email ASC used to rearrange in ascending orders
'''

ARITHMATIC OPERATIONS(EXAMPLE)

SELECT firstname, lastname, age / 2 AS discount
FROM Customers

SELECT firstname, lastname, weight/(height*height) AS bmi
FROM Customers

SELECT MAX(age) FROM Customers;
SELECT MIN(age) FROM Customers; 

# MAXIMUM REVENUE FROM COMPANIES


SELECT *
FROM Companies
WHERE Revenue=(SELECT MAX(Revenue)
FROM Companies
)

SELECT AVG(age) FROM Customers

You are working on a table that stores the game scores of multiple players.
Each player has a nickname associated with them. The table Scores has two columns, the nickname and the score.
The table can store multiple rows for each player, which correspond to scores they earned during multiple games.
You need to find the best score for each player and output the result sorted by the best score in descending order.
The output should have the nickname column, followed by the best score column called 'best'.

SELECT Nickname,max(score) as best
FROM Scores
GROUP BY Nickname
ORDER BY best DESC

