Select Customer_id, Customer_name from customers cust where 
1<(select count(order_no) from orders ord where cust.salesman_id = ord.salesman_id group by cust.customer_id) Union
Select salesman_id, salesman_name from salesman sales where 
1<(select count(order_no) from orders ord where sales.salesman_id = ord.salesman_id group by sales.salesman_id) Order by customer_name


Select sales.salesman_id,sales.salesman_name,ord.order_no,'highest on',ord.order_date from salesman sales inner join orders ord on sales.salesman_id = ord.salesman_id where ord.purchase_amount in
(Select Max(purchase_amount) from orders Group By order_date);
Union
Select sales.salesman_id,sales.salesman_name,ord.order_no,'lowest on',ord.order_date from salesman sales inner join orders ord on sales.salesman_id = ord.salesman_id where ord.purchase_amount in
(Select Min(purchase_amount) from orders Group By order_date);