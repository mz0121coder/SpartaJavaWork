--2.1 List all Customers in either Paris or London. Include Customer ID, Company Name and address fields

SELECT customer_id as "CustomerID", company_name as "Company Name", address as "Address",
city as "City", postal_code as "PostalCode", country as "Country"
FROM customers 
WHERE city IN ('Paris', 'London')

-- 2.2 List all products stored in bottles.

SELECT product_name as "Product Name", quantity_per_unit as "QuantityPerUnit" FROM products
WHERE quantity_per_unit LIKE '%bottle%'

-- 2.3 Repeat question above, but add in the Supplier Name and Country.

SELECT product_name, quantity_per_unit, company_name, country FROM products JOIN suppliers
ON products.supplier_id = suppliers.supplier_id
WHERE quantity_per_unit LIKE '%bottle%'

-- 2.4 Write an SQL Statement that shows how many products there are in each category. Include Category Name in
-- result set and list the highest number first.

SELECT category_name AS "Category Name", count(product_id) AS "No of products"
FROM categories join products
ON categories.category_id = products.category_id
GROUP BY category_name
ORDER BY count(product_id) DESC

-- 2.5 List all UK employees using concatenation to join their title of courtesy, first name and last name together. Also
-- include their city of residence.

SELECT title_of_courtesy || ' ' || first_name || ' ' || last_name as "Employee",
city as "City"
from employees
where country = 'UK'

-- 2.6 Count how many Orders have a Freight amount greater than 100.00 and either USA or UK as Ship Country.

select count(order_id) as "No of Orders >100 from US or UK"
from orders
where orders.freight > 100.00
and orders.ship_country in ('UK', 'USA')

-- 2.7 Write a SQL statement to find the order line with the highest discount applied. Display the order number of the
-- order that contains this order line, as well as the discount applied. The information can be obtained from the [Order
-- Details] table

SELECT order_id as "Order ID", discount as "Total Discount"
FROM order_details
ORDER BY discount DESC
LIMIT 1;

-- 2.8 Create a view which lists all Employees from the Employees table and who they report to. Query the view.

select first_name || ' ' || last_name as "Employee Name",
reports_to as "Reports to"
from employees

-- 2.9 Create a stored procedure called “CustomerTotalOrderAmount” that takes the Customer ID as a parameter and
-- returns the Total Order Amount for that Customer (HINT: this information is in the Orders table). Execute the stored
-- procedure where the Customer ID is ‘ALFKI’. Note: Stored procedures can be found my opening up the Northwind
-- database and navigating to “Programmability > Stored Procedures”
