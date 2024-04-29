-- Insert queries for UserAccount table
INSERT INTO UserAccount (UserName, UserType, UserPhone, CartId, AddrId, OrderId) 
VALUES ('John Doe', 'customer', '1234567890', 1, 1, 1),
       ('Jane Smith', 'vendor', '9876543210', 2, 2, 2);

-- Insert queries for UserAddress table
INSERT INTO UserAddress (UserId, IsAddrPrimary, AddrLine1, AddrLine2, Landmark, City, State, Country, Pincode, PhoneNumber) 
VALUES (1, true, '123 Main St', 'Apt 101', 'Near Park', 'New York', 'NY', 'USA', '10001', '1234567890'),
       (2, true, '456 Oak Ave', 'Suite 202', 'Next to Mall', 'Los Angeles', 'CA', 'USA', '90001', '9876543210');

-- Insert queries for OrderService table
INSERT INTO OrderService (OrderStatus, OrderDate, PaymentId) 
VALUES ('pending', '2022-04-12', 1),
       ('shipped', '2022-04-13', 2);

-- Insert queries for ProductService table
INSERT INTO ProductService (ProductType, ProductCategory, ProductMRP, ProductMargin, ProductStatus) 
VALUES (8, 'Solid', 50.0, 10.0, 'available'),
       (6, 'Liquid', 30.0, 5.0, 'available');

-- Insert queries for CartService table
INSERT INTO CartService (UserId) 
VALUES (1),
       (2);

-- Insert queries for PaymentService table
INSERT INTO payment_entity 
	(Payment_Mode, Payment_Status, Payment_Currency, Payment_Country, Payment_Date) 
	VALUES ('credit card', 'success', 'USD', 'USA', '2022-04-12');

INSERT INTO payment_entity 
	(Payment_Mode, Payment_Status, Payment_Currency, Payment_Country, Payment_Date) 
	VALUES ('789012', 'paypal', 'pending', 'USD', 'USA', '2022-04-13');
