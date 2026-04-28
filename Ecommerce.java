import java.util.ArrayList;
import java.util.List;

import java.util.*;

class Users {
    String username;
    String password;
    String role;
    String email;

    Users(String username, String password, String role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;

    }
}

class Product{
    int productid;
    String name;
    String Category;
    int price;
    int stock;
    int sellerid;
    Product(int productid,String name, String Category,int price,int stock , int sellerid){
        this.productid=productid;
        this.name=name;
        this.Category=Category;
        this.price=price;
        this.stock=stock;
        this.sellerid=sellerid;
    }
}

class Cart{
    int cartid;
    int customerid;
    int item[];
    int totalamount;
    Cart(int cartid,int customerid,int item[],int totalamount){
        this.cartid=cartid;
        this.customerid=customerid;
        this.item=item;
        this.totalamount=totalamount;
    }
}
class Order{
    int orderid;
    int customerid;
    int item[];
    String orderstatus;
    int totalamount;
    Order(int orderid,int customerid,int totalamount,String orderstatus){
        this.orderid=orderid;
        this.customerid=customerid;
        this.totalamount=totalamount;
        this.orderstatus=orderstatus;
    }
}

public class Ecommerce {
    Scanner sc= new Scanner(System.in);
    static List<Users> User=new ArrayList<>();
    static List<Product>products=new ArrayList<>();
    static List<Cart>cart=new ArrayList<>();
    static List<Order>order=new ArrayList<>();

    public static void main(String[]args){



        while(true){
            Scanner sc= new Scanner(System.in);

            System.out.println("1.Register User");
            System.out.println("2.Login User");
            System.out.println("3.Display User");
            int ch =sc.nextInt();

            switch(ch){
                case 1:
                    registeruser();
                    break;
                case 2:
                    loginuser();
                    break;
                case 3:
                    displayuser();
                    break;
            }
        }

    }

    private static void displayuser() {
        for(Users user:User){
            System.out.println("Username"+user.username);
            System.out.println(user.password);
            System.out.println("Role"+user.role);
        }

    }


    private static void loginuser() {
        Scanner sc= new Scanner(System.in);
        String username=sc.nextLine();
        String password=sc.nextLine();
        for(Users user:User){
            if(username.equals(user.username)&& password.equals(user.password)) {
                System.out.println("Login success");
                if (user.role.equalsIgnoreCase("Customer")) {
                    System.out.println("Logged in as customer");
                    customermenu();
                }
                else if(user.role.equalsIgnoreCase("Seller")){
                    System.out.println("Logged in as seller");
                    sellermenu();                    }
                else{
                    System.out.println("Invaild role");
                }
            }
            else{
                System.out.println("Login failed");

            }
        }
    }

    private static void customermenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seller's Menu");
        System.out.println("1.Add to cart  ");
        System.out.println("2. place order ");
        System.out.println("3.remove from cart");
        System.out.println("4.View Product");
        System.out.println("5.Exit");
        while (true) {
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    addtocart();
                    break;
                case 2:
                    placeorder();
                    break;
                case 3:
                    removecart();
                    break;
                case 4:
                    viewproduct();
                    break;
                case 5:
                    vieworder();
                    break;
            }
        }
    }

    private static void vieworder() {
        for(Order ord:order){
            System.out.println("Order id: "+ ord.orderid);
            System.out.println("Customer id: "+ ord.customerid);
            System.out.println("Total amount: "+ord.totalamount);
            System.out.println("Order status: "+ord.orderstatus);

        }
    }
    private static void removecart() {
        Scanner sc = new Scanner(System.in);
        int cartid=sc.nextInt();
        Cart check = findcartid(cartid);
        if(check!=null){
            cart.remove(cartid);
            System.out.println("Product removed from cart successfully");
        }
        else{
            System.out.println("Cart not found");
        }
    }
    private static Cart findcartid(int cartid) {
        for(Cart crt:cart){
            if(cartid==crt.cartid){
                return crt;
            }
        }
        return null;
    }

    private static void addtocart() {
        Scanner sc = new Scanner(System.in);
        int productid=sc.nextInt();
        Product check = findpid(productid);
        if(check!=null){
            System.out.println("Product added to cart successfully");
        }
        else{
            System.out.println("Product not found");
        }

    }
    private static void placeorder() {
        Scanner sc = new Scanner(System.in);
        int cartid=sc.nextInt();
        int customerid=sc.nextInt();
        int totalamount=sc.nextInt();
        order.add(new Order(cartid,customerid,totalamount,"Placed"));
        System.out.println("Order placed successfully");
    }


    private static void sellermenu() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Seller's Menu");
        System.out.println("1.Add product ");
        System.out.println("2.update product");
        System.out.println("3.delete product");
        System.out.println("4.View Product");
        System.out.println("5.Exit");
        while(true){
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    Addproduct();
                    break;
                case 2:
                    updateproduct();
                    break;
                case 3:
                    deleteproduct();
                    break;
                case 4:
                    viewproduct();
                    break;
                case 5:
                    break;
            }

        }


    }

    private static void viewproduct() {
        for(Product pr:products){
            System.out.println("Product id: "+ pr.productid);
            System.out.println("Product name: "+ pr.name);
            System.out.println("Product price:"+pr.price);

        }
    }

    private static void deleteproduct() {
        System.out.println("Enter the Productid: ");
        Scanner sc = new Scanner(System.in);
        int pid=sc.nextInt();
        Product check = findpid(pid);
        if(check!=null){
            products.remove(pid);
            System.out.println("Product Deleted Successfully");
        }
        else{
            System.out.println("Product not found");
        }


    }


    private static void Addproduct() {
        Scanner sc = new Scanner(System.in);
        int productid= sc.nextInt();
        String name=sc.nextLine();
        String Category=sc.next();
        int price=sc.nextInt();
        int stock=sc.nextInt();
        int sellerid= sc.nextInt();
        products.add(new Product(productid,name,Category,price,stock,sellerid));
        System.out.println("Product Added Successfully");

    }

    private static void updateproduct() {
        System.out.println("Enter the Productid: ");
        Scanner sc = new Scanner(System.in);
        int pid=sc.nextInt();
        Product checl = findpid(pid);
        if(checl!=null){
            checl.name=sc.nextLine();
            checl.Category=sc.nextLine();
            checl.price = sc.nextInt();
            System.out.println("Product updated successfully");
        }
        else{
            System.out.println("Product Not found ");
        }
    }

    private static Product findpid(int pid)
    {
        for(Product pr:products){
            if(pid==pr.productid){
                return pr;
            }
        }
        return null;
    }



    private static void registeruser() {
        Scanner sc= new Scanner(System.in);
        String username=sc.nextLine();
        String password=sc.nextLine();
        String role=sc.nextLine();
        String email=sc.nextLine();
        User.add(new Users(username,password,role,email));
        System.out.println("User created successfully");

    }


}