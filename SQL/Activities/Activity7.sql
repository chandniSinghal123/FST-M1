select sum(purchase_amount) as "Total_sum" from orders;

select AVG(purchase_amount) as "Average" from orders;

select Max(purchase_amount) as "Max_amount" from orders;

select Min(purchase_amount) as "Min_amount" from orders;

select count(distinct salesman_id) as "Headcount" from orders;