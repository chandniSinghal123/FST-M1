Select a.customer_name, b.salesman_name from customers a Inner Join salesman b on a.salesman_id=b.salesman_id

select a.customer_name,a.grade,b.salesman_name from customers a Left Outer Join salesman b on a.salesman_id=b.salesman_id where a.grade<300 order by a.customer_id;

select a.customer_id, a.customer_name, b.salesman_name, b.commission from customers a Inner Join salesman b on a.salesman_id=b.salesman_id where b.commission>12

select ord.order_no, order_date, ord.purchase_amount,b.customer_name,c.salesman_name,c.commission from customers b Inner join salesman c on b.salesman_id = c.salesman_id
Inner join orders ord on ord.customer_id  = b.customer_id 