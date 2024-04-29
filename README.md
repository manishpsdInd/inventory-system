# inventory-system
Playground Admin - dis-admin@altimetrik.com 

------------------------------------------------------
Relational database schema design
------------------------------------------------------

### UserService
	UserAccount
		UserId [Auto generated, Primary key]
		UserName
		UserType [customer/vendor/admin]
		UserPhone
		CartId [Foreign Key to CartService CartId]
		AddrId List [Foreign Key to UserAddress ArrdId]
		OrderId List [Foreign Key to OrderService OrderId]
	UserAddress
		AddrId [Auto generated, PrimaryKey]
		IsAddrPrimmry [boolean Type]
		AddrLine1
		AddrLine2
		LandMark
		City
		State
		Counttry
		Pincode
		PhoneNumber

### OrderService
	OrderId [Auto generated, PrimaryKey]
	OrderStatus
	OrderDate
	PaymentId [Foreign Key to PaymentService PaymentId]
	ProductList[]
	
### ProductService
	ProductId [Auto generated, PrimaryKey]
	ProductType [Scale of 1 to 10]
	ProductCategory Solid/Liquid/Gas
	ProductMRP
	ProductMargine	
	ProductStatus
	ProductImagesList[]

### CartService
	CartId [Auto generated, PrimaryKey]
	UserId
	ProductList[]
	
### PaymentService
	PaymentId [Auto generated, PrimaryKey]
	TransactionId
	PaymentMode
	PaymentStatus
	PaymentCurrency
	PaymentCountry
	PaymentDate

------------------------------------------------------
Create Query
------------------------------------------------------

### Account Table
CREATE TABLE UserAccount (
    UserId INT PRIMARY KEY AUTO_INCREMENT,
    UserName VARCHAR(255),
    UserType ENUM('customer', 'vendor', 'admin'),
    UserPhone VARCHAR(20),
    CartId INT,
    AddrId INT,
    OrderId INT,
    FOREIGN KEY (CartId) REFERENCES CartService(CartId),
    FOREIGN KEY (AddrId) REFERENCES UserAddress(AddrId),
    FOREIGN KEY (OrderId) REFERENCES OrderService(OrderId)
);

### Address Table
CREATE TABLE UserAddress (
    AddrId INT PRIMARY KEY AUTO_INCREMENT,
    UserId INT,
    IsAddrPrimary BOOLEAN,
    AddrLine1 VARCHAR(255),
    AddrLine2 VARCHAR(255),
    Landmark VARCHAR(255),
    City VARCHAR(100),
    State VARCHAR(100),
    Country VARCHAR(100),
    Pincode VARCHAR(20),
    PhoneNumber VARCHAR(20),
    FOREIGN KEY (UserId) REFERENCES UserAccount(UserId)
);

### Order Table
CREATE TABLE OrderService (
    OrderId INT PRIMARY KEY AUTO_INCREMENT,
    OrderStatus VARCHAR(50),
    OrderDate DATE,
    PaymentId INT,
    FOREIGN KEY (PaymentId) REFERENCES PaymentService(PaymentId)
);

### Product Table 
CREATE TABLE ProductService (
    ProductId INT PRIMARY KEY AUTO_INCREMENT,
    ProductType INT,
    ProductCategory ENUM('Solid', 'Liquid', 'Gas'),
    ProductMRP DECIMAL(10, 2),
    ProductMargin DECIMAL(10, 2),
    ProductStatus VARCHAR(50)
);

### Cart Table
CREATE TABLE CartService (
    CartId INT PRIMARY KEY AUTO_INCREMENT,
    UserId INT,
    FOREIGN KEY (UserId) REFERENCES UserAccount(UserId)
);


### Payment Table
CREATE TABLE PaymentService (
    PaymentId INT PRIMARY KEY AUTO_INCREMENT,
    TransactionId VARCHAR(100),
    PaymentMode VARCHAR(50),
    PaymentStatus VARCHAR(50),
    PaymentCurrency VARCHAR(10),
    PaymentCountry VARCHAR(100),
    PaymentDate DATE
);

------------------------------------------------------
Insert Query
------------------------------------------------------
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
INSERT INTO PaymentService (TransactionId, PaymentMode, PaymentStatus, PaymentCurrency, PaymentCountry, PaymentDate) 
VALUES ('TXN123456', 'credit card', 'success', 'USD', 'USA', '2022-04-12'),
       ('TXN789012', 'paypal', 'pending', 'USD', 'USA', '2022-04-13');

------------------------------------------------------
Micro Services
------------------------------------------------------
#WebClient
#UserService [com.ecom.user, SpringController, RDBMS]
	- addUser
	- editUser
	- deleteUser
	- getUserById
	- getUserByCondition
#OrderService [com.ecom.order, KafkaListener, MongoDB]
	- addOrder
	- editOrder [patch call]
	- deleteOrder
	- getOrderById
	- getUserByDateRange
#ProductService [com.ecom.product, KafkaListener, MngoDB]
	- addProduct
	- editProduct
	- deleteProduct
	- getProductById
	- getproductByCategory
#CartService [com.ecom.cart, SpringController, MongoDB]
	- addProduct
	- deleteProduct
#PaymentService [com.ecom.payment, RDBMS]
	- addPayment

------------------------------------------------------
Sample Request and Response
------------------------------------------------------


