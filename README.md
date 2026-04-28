# E-Commerce Console Application
### Mr. Cooper — Long Coding Assessment | Round 2

---

## 👤 Candidate Details

| Field | Details |
|---|---|
| **Name** | *Siva Sabari Ganesan A* |
| **College** | *Rajalakshmi Engineering College* |
| **Date** | *28/04/2026* |
| **Role** | Software Engineer Trainee |
| **Language Used** | Java |

---

## 📌 Problem Statement

Design and implement a **command-line based E-Commerce System** in Java that supports:
- User registration and role-based login (Customer / Seller)
- Product catalog management by Sellers
- Shopping cart and order placement by Customers

---




## 🧩 Classes Overview

### `Users`
| Field | Type | Description |
|---|---|---|
| username | String | Unique user identifier |
| password | String | User password |
| role | String | "Customer" or "Seller" |
| email | String | Contact email |

### `Product`
| Field | Type | Description |
|---|---|---|
| productid | int | Unique product ID |
| name | String | Product name |
| category | String | Product category |
| price | double | Product price |
| stock | int | Available quantity |
| sellerid | String | Seller's username |

### `Cart`
| Field | Type | Description |
|---|---|---|
| cartid | int | Unique cart ID |
| customerid | String | Associated customer |
| items[] | int[] | Array of product IDs |
| totalamount | double | Total cart value |

### `Order`
| Field | Type | Description |
|---|---|---|
| orderid | int | Unique order ID |
| customerid | String | Customer who placed order |
| totalamount | double | Order total |
| orderstatus | String | "Placed" / "Delivered" |

---

## ⚙️ Features Implemented

### ✅ User Management
- Register new users with role (Customer / Seller)
- Login with role-based menu routing
- View all registered users

### ✅ Customer Features
- View all available products
- Add product to cart
- Remove product from cart
- Place order from cart
- View order history

### ✅ Seller Features
- Add new products to catalog
- Update existing product details
- Delete products from catalog
- View all products

---

## 🔄 Application Flow

```
Main Menu
├── 1. Register User
├── 2. Login
│     ├── Customer Menu
│     │     ├── View Products
│     │     ├── Add to Cart
│     │     ├── Remove from Cart
│     │     ├── Place Order
│     │     └── View Orders
│     └── Seller Menu
│           ├── Add Product
│           ├── Update Product
│           ├── Delete Product
│           └── View Products
├── 3. Display All Users
└── 4. Exit
```

---


## ▶️ How to Run

### Prerequisites
- Java 8 or higher
- No external dependencies required

### Steps

```bash
# Step 1: Compile
javac Main.java

# Step 2: Run
java Ecommerce
```

---

## 🧪 Sample Test Flow

```
1. Register a Seller   → username: seller1 | role: Seller
2. Login as Seller     → Add 3 products to catalog
3. Register Customer   → username: user1 | role: Customer
4. Login as Customer   → View products
5. Add to Cart         → Add product by ID
6. Place Order         → Confirm order placement
7. View Orders         → Check order history
```

---

## 🔑 OOP Concepts Applied

| Concept | Where Used |
|---|---|
| **Encapsulation** | All model classes with fields and constructors |
| **Abstraction** | Each operation in its own method |
| **Inheritance** | (Extensible for future Admin/Seller hierarchy) |
| **Single Responsibility** | Each class handles one entity only |

---


---

*Submitted as part of Mr. Cooper Long Coding Assessment — Round 2*
