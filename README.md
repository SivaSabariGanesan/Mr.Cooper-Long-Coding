# E-Commerce Console Application
### Mr. Cooper — Long Coding Assessment | Round 2

---

## 👤 Candidate Details

| Field | Details |
|---|---|
| **Name** | Siva Sabari Ganesan A |
| **College** | Rajalakshmi Engineering College |
| **Date** | 28/04/2026 |
| **Role** | Software Engineer Trainee |
| **Language Used** | Java |

---

## 📌 Problem Statement

Design and implement a **command-line based E-Commerce System** in Java that supports:
- User registration and role-based login (Customer / Seller)
- Product catalog management by Sellers (Add, Update, Delete, View)
- Shopping cart management and order placement by Customers
- All data managed in-memory using Java Collections (ArrayList)

The system must be menu-driven, support two user roles with separate menus, and demonstrate core Object-Oriented Programming principles including encapsulation, abstraction, and single responsibility.

---

## 💡 Approach & Logic

### Overall Design
The application follows a **menu-driven console architecture** with role-based access control. All entities (Users, Products, Carts, Orders) are modelled as separate Java classes and stored in static `ArrayList` collections inside the main `Ecommerce` class.

### Key Logic Decisions

**1. User Registration & Login**
- Users register with a username, password, role (`Customer` / `Seller`), and email
- During login, the system iterates through the `User` list and matches credentials using `.equals()` for safe String comparison
- On successful login, the user is routed to either `customermenu()` or `sellermenu()` based on their role

**2. Role-Based Menu Routing**
- After login, `user.role.equalsIgnoreCase("Customer")` determines which menu is shown
- Each menu runs in a `while(true)` loop so the user can perform multiple operations without re-logging in

**3. Product Management (Seller)**
- Products are stored in a static `List<Product> products`
- `findpid(int pid)` is a helper method used by update and delete to locate a product before modifying it
- Update modifies fields directly on the found object reference; delete removes the object from the list

**4. Cart & Order (Customer)**
- `addtocart()` verifies the product exists via `findpid()` before adding to cart
- `placeorder()` creates a new `Order` object and adds it to the `order` list with status `"Placed"`
- `removecart()` finds a cart by ID using `findcartid()` helper and removes it

**5. Helper Methods**
- `findpid(int pid)` — iterates products list, returns matching Product or null
- `findcartid(int cartid)` — iterates cart list, returns matching Cart or null
- Null check is always performed after calling these helpers before any operation

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
| Category | String | Product category |
| price | int | Product price |
| stock | int | Available quantity |
| sellerid | int | Seller's ID |

### `Cart`
| Field | Type | Description |
|---|---|---|
| cartid | int | Unique cart ID |
| customerid | int | Associated customer ID |
| item[] | int[] | Array of product IDs |
| totalamount | int | Total cart value |

### `Order`
| Field | Type | Description |
|---|---|---|
| orderid | int | Unique order ID |
| customerid | int | Customer who placed order |
| totalamount | int | Order total |
| orderstatus | String | "Placed" / "Delivered" |

---

## ⚙️ Features Implemented

### ✅ User Management
- Register new users with role (Customer / Seller)
- Login with role-based menu routing
- View all registered users

### ✅ Customer Features
- View all available products
- Add product to cart (by product ID)
- Remove product from cart (by cart ID)
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
│     │     ├── 1. Add to Cart
│     │     ├── 2. Place Order
│     │     ├── 3. Remove from Cart
│     │     ├── 4. View Products
│     │     └── 5. View Orders
│     └── Seller Menu
│           ├── 1. Add Product
│           ├── 2. Update Product
│           ├── 3. Delete Product
│           ├── 4. View Products
│           └── 5. Exit
├── 3. Display All Users
└── 4. Exit
```

---

## ▶️ Steps to Execute the Code

### Prerequisites
- Java 8 or higher installed
- No external libraries or dependencies required

### Step 1 — Compile the Java file
```bash
javac Ecommerce.java
```

### Step 2 — Run the application
```bash
java Ecommerce
```

### Step 3 — Follow the on-screen menu prompts

```
Main Menu shows:
  1. Register User   → Enter: username, password, role, email
  2. Login User      → Enter: username, password → routed to role menu
  3. Display Users   → Lists all registered users
```

---

## 🧪 Sample Test Flow

```
Step 1 → Select 1 (Register Seller)
         Input: seller1 → pass123 → Seller → seller@mail.com

Step 2 → Select 1 (Register Customer)
         Input: user1 → pass456 → Customer → user@mail.com

Step 3 → Select 2 (Login as Seller)
         Input: seller1 → pass123
         Seller Menu:
           → Select 1 (Add Product): 101 | Laptop | Electronics | 50000 | 10 | 1
           → Select 4 (View Products): verify Laptop is listed

Step 4 → Select 2 (Login as Customer)
         Input: user1 → pass456
         Customer Menu:
           → Select 4 (View Products): see available items
           → Select 1 (Add to Cart): enter product ID 101
           → Select 2 (Place Order): enter cartid, customerid, totalamount
           → Select 5 (View Orders): confirm order status = Placed
```

---

## 🔑 OOP Concepts Applied

| Concept | Where Applied |
|---|---|
| **Encapsulation** | All model classes (Users, Product, Cart, Order) with fields and constructors |
| **Abstraction** | Each feature isolated in its own method (addtocart, placeorder, Addproduct, etc.) |
| **Single Responsibility** | Each class manages only its own entity's data |
| **Helper Methods** | `findpid()` and `findcartid()` reused across multiple operations |

---

## 📝 Notes

- All data is stored **in-memory** using `ArrayList` — data resets when the application exits
- String comparison uses `.equals()` throughout — avoids the `==` reference comparison bug in Java
- `null` checks are performed after every `findpid()` / `findcartid()` call before any operation

---

*Submitted as part of Mr. Cooper Long Coding Assessment — Round 2*
