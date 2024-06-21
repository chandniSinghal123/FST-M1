select max(purchase_amount), customer_id from orders Group by customer_id;

select salesman_id, max(purchase_amount), order_date from orders where order_date=To_date('2012-08-17','YYYY-MM-DD') group by salesman_id,order_date;

select customer_id, max(purchase_amount), order_date from orders group by customer_id,order_date Having max(purchase_amount) in (2030,3450,5760,6000);