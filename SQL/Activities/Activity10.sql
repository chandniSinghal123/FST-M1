Select * from orders where salesman_id = (Select distinct salesman_id from orders where customer_id=3007)

Select * from orders where salesman_id = (Select salesman_id from salesman where salesman_city='New York')

Select grade, count(customer_id) from customers Group By grade having grade > (Select AVG(grade) from customers where city='New York');

Select * from orders where salesman_id in (Select salesman_id from salesman where commission=(Select MAX(commission) from salesman));