# Write your MySQL query statement below
select eu.unique_id,e.name   #select  all column name 
from Employees e             #from 1st table name
left join EmployeeUNI eu     #left join  dusara table name
on e.id=eu.id                #jis bhi colum ke bases pe join karna hai 