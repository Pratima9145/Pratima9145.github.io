-- Include table data insertion, updation, deletion and select scripts
-- -------------------------------------------------------------------
-- Adding Menu Items in MenuItem Table
-- -------------------------------------------------------------------
INSERT INTO menu_item
VALUES 
(1, 'Sandwich', 99.0, 'Yes', '2017-03-15','Main Course', 'Yes'),
(2, 'Burger', 129.0, 'Yes', '2017-12-23', 'MainCourse', 'No'),
(3, 'Pizza', 149.0, 'Yes','2018-08-21', 'Main Course', 'No'),
(4, 'French Fries', 57.0, 'No','2017-07-02','Starters', 'Yes'),
(5, 'Chocolate Brownie', 32.0, 'Yes', '2022-11-02','Dessert', 'Yes');

-- -------------------------------------------------------------------
-- Edit Menu Items in MenuItem Table
-- -------------------------------------------------------------------
update menu_item 
set me_name='Shawarma',me_price=130.0,me_category='Main Dish'
where me_id=1;

-- -------------------------------------------------------------------
-- Displaying Customer List in MenuItem Table
-- -------------------------------------------------------------------
select me_name,me_free_delivery,me_price,me_category
from menu_item
where me_active='Yes' and me_date_of_launch <= current_date();

-- -------------------------------------------------------------------
--  setting User Name and Id
-- -------------------------------------------------------------------
INSERT INTO user 
VALUES
(1,'Pratima'),
(2,'Pooja');

-- -------------------------------------------------------------------
--  Add to Cart Table
-- -------------------------------------------------------------------
INSERT INTO cart(ct_us_id,ct_pr_id)  
VALUES
(2,1),(2,2),(2,5),(2,1),(1,1),(1,4);

-- -------------------------------------------------------------------
--  Show Cart Items
-- -------------------------------------------------------------------
SELECT me_name,me_free_delivery,me_price 
FROM menu_item 
INNER JOIN cart 
ON ct_pr_id=me_id
WHERE ct_us_id=2;

-- -------------------------------------------------------------------
--  Total Price of Cart Items
-- -------------------------------------------------------------------
select sum(me_price) as Total from menu_item
inner join cart on ct_pr_id=me_id
where ct_us_id=2; 

-- -------------------------------------------------------------------
--  Remove Cart Items
-- -------------------------------------------------------------------
DELETE FROM cart 
WHERE ct_us_id=2
AND ct_pr_id=1
LIMIT 1;

-- -------------------------------------------------------------------
--  View Remove Cart
-- -------------------------------------------------------------------
SELECT me_name,me_free_delivery,me_price 
FROM menu_item  
INNER JOIN cart 
ON ct_pr_id=me_id
WHERE ct_us_id=2;


-- -------------------------------------------------------------------
--  Show Total of Cart Items
-- -------------------------------------------------------------------
SELECT SUM(me_price) as Total 
FROM menu_item
INNER JOIN cart
on ct_pr_id=me_id
where ct_us_id=2; 


