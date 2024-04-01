SQL == Structured Query Language

-- = Comments in sql to understand

/*
bigger commands to understand
bla 
bla 
bla
*/


Select titles//s.no//age
from movies  

Movies 
s.no | titles | age
1    |tn      | 2
2    |ap      | 3
3    |kl      | 4
4    |kn      | 1

rows == records  ||  no.of.rows/records=5(include header)
column == fields ||  no of columns/fields==3

fields=s.no,titles,age


query == to access only the required data

SELECT *
FROM movies
ORDER BY year  ORDER BY == Used in Sorting

ORDER BY year = Ascending(default)
ORDER BY year ASC == Ascending Order
ORDER BY year DESC == Descending Order


offset with skip the lines
limit will print the remaining lines 
s.no | titles | age
1    |tn      | 2
2    |ap      | 3
3    |kl      | 4
4    |kn      | 1
offset 2 - skip two lines(1,2)
limit 2 - prints(3,4)


Addition,sub,mul,div can be done like this
SELECT name, price, price+delivery
FROM sales

can be stroed in temporary library
SELECT name, price, price+delivery as total
FROM sales

CONCAT - Used to add the two text inputs
first_name + Last_name as Full_name
SELECT CONCAT(first_name, last_name)
FROM employees

column player_name with set1,set2,set3 
select player_name,set_1+set_2+set_3 as total
from matches

SELECT *
FROM studio
Where name = 'Walt Disney' to find where the walt disney is present in the given database

select *
from books
where genre='Fiction'

The % special symbol is known as a wildcard and is used to create patterns. 
You can use patterns to extract email addresses that share the same domain.


A restaurant is creating a new dessert menu and wants to identify desserts with names that include the word 'chocolate'. 
You are given the following desserts table:
Write a query to select the dessert name and price from the desserts table where the dessert name contains the word 'chocolate'.

ANSWER
/*
select the dessert name and price
where the name contains 'chocolate'
*/
SELECT name,price
FROM desserts
WHERE name like '%chocolate%'


Patterns are case-sensitive. 
LOWER() and UPPER() commands are used to convert strings to lower or uppercase.
SELECT LOWER(title)
FROM movies;
SELECT UPPER(title)
FROM movies;



__ - SINGLE CHARACTER
% - MULTIPLE CHARACTER
Which product codes match the pattern 'A_B_' == A4B7 



Complete the query to extract tweets that contain the hashtag '#DigitalMarketing'
SELECT *
FROM tweets
WHERE content
LIKE'%#DigitalMarketing%'


COUNT()
MAX()
MIN()
SUM()
AVG()



