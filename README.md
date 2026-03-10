# Hibernate CRUD Operations - Retail Inventory System

A complete implementation of CRUD operations using Hibernate ORM with JPA annotations for managing a retail inventory system.

## Project Overview

This project demonstrates:
- **Entity Mapping**: Product entity with JPA annotations
- **CRUD Operations**: Create, Read, Update, Delete operations
- **Hibernate Configuration**: XML-based configuration with MySQL database
- **ID Generation Strategy**: IDENTITY strategy for auto-incrementing primary keys

## Features

### 1. Product Entity
- **Fields**: id (primary key), name, description, price, quantity
- **ID Generation**: IDENTITY strategy (auto-increment)
- **Annotations**: @Entity, @Table, @Column, @GeneratedValue

### 2. CRUD Operations

#### Create (Insert)
- Add new products to the inventory
- Automatic ID generation using IDENTITY strategy

#### Read (Retrieve)
- Fetch product details by product ID
- Returns Product object with all details

#### Update
- Modify product price and quantity
- Transaction-based updates with rollback support

#### Delete
- Remove discontinued products from inventory
- Safe deletion with existence check

## Project Structure

```
fullstackexp2/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/inventory/
│   │   │       ├── entity/
│   │   │       │   └── Product.java
│   │   │       ├── dao/
│   │   │       │   └── ProductDAO.java
│   │   │       ├── util/
│   │   │       │   └── HibernateUtil.java
│   │   │       └── InventoryApp.java
│   │   └── resources/
│   │       └── hibernate.cfg.xml
├── pom.xml
├── .gitignore
└── README.md
```

## Prerequisites

- Java 11 or higher
- MySQL Server
- Maven 3.6+

## Setup Instructions

### 1. Database Setup

Create the database and table:

```sql
CREATE DATABASE inventory_db;
USE inventory_db;

CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    price DOUBLE NOT NULL,
    quantity INT NOT NULL
);
```

### 2. Configure Database Connection

Update `src/main/resources/hibernate.cfg.xml`:

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/inventory_db</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">your_password</property>
```

### 3. Build and Run

```bash
# Build the project
mvn clean install

# Run the application
mvn exec:java -Dexec.mainClass="com.inventory.InventoryApp"
```

## ID Generation Strategy

The project uses **IDENTITY** strategy:

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

This strategy:
- Uses database auto-increment feature
- Generates unique IDs automatically
- Suitable for MySQL and similar databases

## Usage Example

```java
ProductDAO productDAO = new ProductDAO();

// Create
Product product = new Product("Laptop", "High-performance", 75000, 10);
productDAO.addProduct(product);

// Read
Product retrieved = productDAO.getProductById(1);

// Update
productDAO.updateProduct(1, 80000, 8);

// Delete
productDAO.deleteProduct(1);
```

## Dependencies

- Hibernate ORM 5.6.14
- JPA API 2.2
- MySQL Connector 8.0.33
- SLF4J 1.7.36

## Author

2400032184

## License

MIT
