1️⃣ What is an Exception in Java?
An exception is an unexpected event that occurs during the execution of a program, which disrupts the normal flow of the program.
Think of it like this:
You are driving a car (normal program flow).


Suddenly, a tire bursts (exception).


You need to handle it immediately to avoid an accident (program crash).


In Java, exceptions are represented by objects that are instances of the Throwable class or its subclasses (Exception, Error).

Exception Hierarchy in Java
Throwable
├── Error           → Serious problems (like OutOfMemoryError). Usually not handled in code.
└── Exception
    ├── Checked Exceptions   → Must be handled or declared (e.g., IOException, SQLException)
    └── Unchecked Exceptions → Optional handling (e.g., ArithmeticException, NullPointerException)

Key point:
Checked exceptions → Compile-time check, must be handled.


Unchecked exceptions → Runtime exceptions, optional to handle.



2️⃣ Where are Exceptions Used?
Exceptions are used whenever something goes wrong in a program that the programmer might want to handle gracefully, instead of letting the program crash.
Common scenarios:
File Handling


Reading a file that doesn’t exist → FileNotFoundException.


Example: Reading config.txt in a program.


Database Operations


SQL query fails → SQLException.


Network Programming


Connection fails → IOException or SocketException.


Arithmetic / Math Errors


Division by zero → ArithmeticException.


User Input / Validation


Invalid PIN in ATM → custom InvalidPinException.


Custom Business Logic


Exceeding withdrawal limit, seat not available, file too large → throw custom exceptions to enforce rules.



3️⃣ Why Use Exceptions?
Graceful Handling: Instead of program crashing, you can show an error message.


Separation of Concerns: Business logic stays separate from error-handling logic.


Propagation: Exceptions can be propagated to a higher-level method that knows how to handle it.


Custom Errors: You can define your own exceptions for specific business scenarios.




4️⃣ Basic Example
public class ExceptionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;  // ArithmeticException occurs
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } finally {
            System.out.println("Execution finished.");
        }
    }
}

Output:
Error: Cannot divide by zero!
Execution finished.

✅ Here, the program did not crash, and we handled the exception properly.

So in short:
Exception = an event that disrupts normal flow of a program.
 Used = anywhere there’s a possibility of an error at runtime or a violation of business rules.


Perfect 👍 Since you’re preparing for a company exam, you’ll likely get practical, real-world style exception handling questions in Java, not just theory. Here are real-world Java exception handling questions with answers and explanations:

🔹 1. Online Banking System – Insufficient Funds
Question:
 You are designing an online banking system. If a customer tries to withdraw more money than their balance, how would you handle it using exceptions?
Answer:
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Withdrawal failed: Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        try {
            account.withdraw(1500);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

Explanation:
A custom exception is created (InsufficientFundsException).


Thrown when withdrawal exceeds balance.


This ensures business rules are enforced clearly.



🔹 2. File Handling – Missing Configuration File
Question:
 Your application reads settings from config.txt. How do you handle the case when the file is missing?
Answer:
import java.io.*;
public class ConfigReader {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("config.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Config: " + line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Configuration file not found!");
        } catch (IOException e) {
            System.out.println("Error while reading configuration: " + e.getMessage());
        }
    }
}

Explanation:
FileNotFoundException is handled separately to give a clear error message.


IOException covers other reading problems.



🔹 3. Online Shopping Cart – Invalid Product ID
Question:
 If a customer tries to buy a product with an invalid ID, how would you handle it?
Answer:
class InvalidProductException extends Exception {
    public InvalidProductException(String message) {
        super(message);
    }
}

class ShoppingCart {
    public void addProduct(int productId) throws InvalidProductException {
        if (productId <= 0) {
            throw new InvalidProductException("Invalid product ID: " + productId);
        }
        System.out.println("Product " + productId + " added successfully!");
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        try {
            cart.addProduct(-5);
        } catch (InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


🔹 4. Login System – Invalid Credentials
Question:
 In a login system, how would you throw an exception when a user enters wrong credentials?
Answer:
class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}

class LoginSystem {
    public void login(String username, String password) throws InvalidCredentialsException {
        if (!username.equals("admin") || !password.equals("1234")) {
            throw new InvalidCredentialsException("Login failed: Wrong username or password!");
        }
        System.out.println("Login successful!");
    }
}

public class Main {
    public static void main(String[] args) {
        LoginSystem system = new LoginSystem();

        try {
            system.login("user", "wrongpass");
        } catch (InvalidCredentialsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


🔹 5. Online Ticket Booking – Seats Not Available
Question:
 If a user tries to book more seats than available, how would you handle it?
Answer:
import java.util.Scanner;
class SeatsNotAvailableException extends Exception {
    public SeatsNotAvailableException(String message) {
        super(message);
    }
}
class TicketBooking {
    private int availableSeats = 5;
    public void bookTickets(int seats) throws SeatsNotAvailableException {
        if (seats > availableSeats) {
            throw new SeatsNotAvailableException("Booking failed: Only " + availableSeats + " seats left.");
        }
        availableSeats -= seats;
        System.out.println("Booking successful! Remaining seats: " + availableSeats);
    }
}
public class Main {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of seats to book: ");
        int seats = sc.nextInt();
        try {
            booking.bookTickets(seats);
        } catch (SeatsNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close(); // Close the scanner
        }
    }
}
🔹 1. ATM PIN Verification – Maximum Attempts
Question:
 Design a program where a user can enter their ATM PIN. If the PIN is incorrect more than 3 times, throw a custom exception.
Answer:
class MaxAttemptsExceededException extends Exception {
    public MaxAttemptsExceededException(String message) {
        super(message);
    }
}
class ATM {
    private final String correctPin = "1234";
    private int attempts = 0;
    public void enterPin(String pin) throws MaxAttemptsExceededException {
        if (attempts >= 3) {
            throw new MaxAttemptsExceededException("Card blocked due to too many wrong attempts!");
        }
        if (pin.equals(correctPin)) {
            System.out.println("Access Granted!");
        } else {
            attempts++;
            System.out.println("Wrong PIN. Attempts left: " + (3 - attempts));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        try {
            atm.enterPin("0000");
            atm.enterPin("1111");
            atm.enterPin("2222");
            atm.enterPin("3333");
        } catch (MaxAttemptsExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


🔹 2. Divide Marks – Handle ArithmeticException
Question:
 You are calculating student grades. If total subjects are 0, handle the exception instead of crashing.
Answer:
public class GradeCalculator {
    public static void main(String[] args) {
        int totalMarks = 450;
        int subjects = 0;

        try {
            int average = totalMarks / subjects;
            System.out.println("Average = " + average);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero. Subjects must be > 0.");
        }
    }
}


🔹 3. File Upload – Restrict File Size
Question:
 Write a program to upload a file. If file size is greater than 10 MB, throw an exception.
Answer:
class FileSizeExceededException extends Exception {
    public FileSizeExceededException(String message) {
        super(message);
    }
}

class FileUploader {
    public void uploadFile(int fileSizeInMB) throws FileSizeExceededException {
        if (fileSizeInMB > 10) {
            throw new FileSizeExceededException("Upload failed: File size exceeds 10MB limit.");
        }
        System.out.println("File uploaded successfully. Size: " + fileSizeInMB + "MB");
    }
}

public class Main {
    public static void main(String[] args) {
        FileUploader uploader = new FileUploader();

        try {
            uploader.uploadFile(15);
        } catch (FileSizeExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


🔹 4. Library Management – Book Already Issued
Question:
 In a library system, if a book is already issued, throw an exception when another student tries to borrow it.
Answer:
class BookAlreadyIssuedException extends Exception {
    public BookAlreadyIssuedException(String message) {
        super(message);
    }
}

class Library {
    private boolean isIssued = false;
    public void issueBook(String studentName) throws BookAlreadyIssuedException {
        if (isIssued) {
            throw new BookAlreadyIssuedException("Book already issued to someone else!");
        }
        isIssued = true;
        System.out.println(studentName + " successfully borrowed the book.");
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        try {
            library.issueBook("Alice");
            library.issueBook("Bob");
        } catch (BookAlreadyIssuedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


🔹 5. Online Exam – Time Expired
Question:
 In an online exam system, if the time left is 0, throw a custom exception when a student tries to answer.
Answer:
class TimeExpiredException extends Exception {
    public TimeExpiredException(String message) {
        super(message);
    }
}
class OnlineExam {
    private int timeLeftInMinutes;

    public OnlineExam(int timeLeftInMinutes) {
        this.timeLeftInMinutes = timeLeftInMinutes;
    }
    public void answerQuestion(String answer) throws TimeExpiredException {
        if (timeLeftInMinutes <= 0) {
            throw new TimeExpiredException("You cannot answer. Exam time is over!");
        }
        System.out.println("Answer submitted: " + answer);
    }
}
public class Main {
    public static void main(String[] args) {
        OnlineExam exam = new OnlineExam(0);
        try {
            exam.answerQuestion("B. Polymorphism");
        } catch (TimeExpiredException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

🔥 Hard-Level Java Exception Handling Questions with Answers

🔹 1. Banking – Multiple Exceptions (Invalid PIN + Insufficient Funds)
Question:
 Write a banking program where:
If user enters wrong PIN → throw InvalidPinException.


If withdrawal > balance → throw InsufficientFundsException.


Use multiple catch blocks to handle both.


Answer:
class InvalidPinException extends Exception {
    public InvalidPinException(String msg) { super(msg); }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) { super(msg); }
}

class Bank {
    private String pin = "1234";
    private double balance = 1000;

    public void withdraw(String enteredPin, double amount)
            throws InvalidPinException, InsufficientFundsException {
        if (!enteredPin.equals(pin)) {
            throw new InvalidPinException("Wrong PIN entered!");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance. Available: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        try {
            bank.withdraw("0000", 500); // wrong pin
        } catch (InvalidPinException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


🔹 2. File Upload System – File Type + Size Validation
Question:
 Build a file upload system where:
If file type is not .pdf, throw InvalidFileTypeException.


If file size > 10MB, throw FileSizeExceededException.


Ensure cleanup with finally.


Answer:
class InvalidFileTypeException extends Exception {
    public InvalidFileTypeException(String msg) { super(msg); }
}

class FileSizeExceededException extends Exception {
    public FileSizeExceededException(String msg) { super(msg); }
}
class FileUploader {
    public void upload(String fileName, int sizeMB)
            throws InvalidFileTypeException, FileSizeExceededException {
        if (!fileName.endsWith(".pdf")) {
            throw new InvalidFileTypeException("Only PDF files allowed.");
        }
        if (sizeMB > 10) {
            throw new FileSizeExceededException("File size exceeds 10MB limit.");
        }
        System.out.println(fileName + " uploaded successfully!");
    }
}
public class Main {
    public static void main(String[] args) {
        FileUploader uploader = new FileUploader();
        try {
            uploader.upload("resume.docx", 5);
        } catch (InvalidFileTypeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (FileSizeExceededException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Upload attempt finished (cleanup done).");
        }
    }
}


🔹 3. Online Exam – Nested Try-Catch (Network + Time Expired)
Question:
 In an online exam system:
If internet disconnects → throw NetworkFailureException.


If time expired → throw TimeExpiredException.


Use nested try-catch.


Answer:
class NetworkFailureException extends Exception {
    public NetworkFailureException(String msg) { super(msg); }
}

class TimeExpiredException extends Exception {
    public TimeExpiredException(String msg) { super(msg); }
}

class OnlineExam {
    public void submitAnswer(boolean networkOk, int timeLeft)
            throws NetworkFailureException, TimeExpiredException {
        if (!networkOk) throw new NetworkFailureException("Network disconnected!");
        if (timeLeft <= 0) throw new TimeExpiredException("Exam time is over!");
        System.out.println("Answer submitted successfully.");
    }
}

public class Main {
    public static void main(String[] args) {
        OnlineExam exam = new OnlineExam();

        try {
            try {
                exam.submitAnswer(false, 5); // network fail
            } catch (NetworkFailureException e) {
                System.out.println("Inner Catch: " + e.getMessage());
                throw e; // rethrow
            }
        } catch (Exception e) {
            System.out.println("Outer Catch: " + e.getMessage());
        }
    }
}


🔹 4. E-Commerce Order – Multiple Custom Exceptions + Recovery
Question:
 In an e-commerce system:
If product not found → throw ProductNotFoundException.


If stock < required quantity → throw OutOfStockException.


If payment fails → throw PaymentFailedException.


Handle all in one program.


Answer:
class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg) { super(msg); }
}
class OutOfStockException extends Exception {
    public OutOfStockException(String msg) { super(msg); }
}
class PaymentFailedException extends Exception {
    public PaymentFailedException(String msg) { super(msg); }
}

class ECommerce {
    public void placeOrder(String product, int qty, boolean paymentOk)
            throws ProductNotFoundException, OutOfStockException, PaymentFailedException {
        if (product == null) throw new ProductNotFoundException("Product not found!");
        if (qty > 5) throw new OutOfStockException("Only 5 items left in stock.");
        if (!paymentOk) throw new PaymentFailedException("Payment declined!");
        System.out.println("Order placed successfully for " + qty + " x " + product);
    }
}

public class Main {
    public static void main(String[] args) {
        ECommerce shop = new ECommerce();

        try {
            shop.placeOrder("Laptop", 10, true); // stock issue
        } catch (ProductNotFoundException | OutOfStockException | PaymentFailedException e) {
            System.out.println("Order Error: " + e.getMessage());
        }
    }
}


🔹 5. Flight Booking System – Chained Exceptions
Question:
 In a flight booking system:
If seat not available → throw SeatUnavailableException.


Wrap it inside a BookingFailedException using exception chaining.


Answer:
class SeatUnavailableException extends Exception {
    public SeatUnavailableException(String msg) { super(msg); }
}

class BookingFailedException extends Exception {
    public BookingFailedException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

class FlightBooking {
    public void bookTicket(int seats) throws BookingFailedException {
        try {
            if (seats > 2) throw new SeatUnavailableException("Only 2 seats available!");
            System.out.println("Flight booked successfully.");
        } catch (SeatUnavailableException e) {
            throw new BookingFailedException("Booking failed due to seat issue.", e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FlightBooking fb = new FlightBooking();
        try {
            fb.bookTicket(5);
        } catch (BookingFailedException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Caused by: " + e.getCause());
        }
    }
}


✅ These hard-level exception handling questions are the type companies love, because they test if you know:
Multiple custom exceptions


Nested try-catch


finally cleanup


Exception chaining




Encapsulation is more than just having getters and setters, though they are the most common way to implement it. Let’s break it down:

🔹 Components of Encapsulation
Private Fields (Data Hiding)


All important variables should be private.


This prevents direct access from outside the class.


Getter and Setter Methods


Getter: Returns the value of a private field.


Setter: Updates the value of a private field with optional validation or logic.


Optional Logic Inside Setters/Getters


Validation (e.g., salary > 0, GPA between 0–10)


Access control (e.g., only HR can update salary)


Computation (e.g., calculate final balance after deposit/withdraw)


Main Class / Client Code


Creates objects and accesses private data only through getters/setters.



Example: Full Encapsulation
class Employee {
    private String name;
    private double salary;

    // Getter
    public String getName() { return name; }

    // Setter with logic
    public void setSalary(double salary) {
        if(salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setSalary(50000);   // valid
        e.setSalary(-100);    // invalid
        System.out.println("Employee Salary: " + e.getSalary());
    }
}


✅ Key Takeaways
Encapsulation = Private fields + Getters/Setters (with logic)


Main class is where you create objects and use methods


You don’t always need logic, but adding validation or rules makes encapsulation useful.


It protects the object’s data and maintains integrity.



In short: Yes, getter/setter with logic + main class is correct, but the main point of encapsulation is “data hiding + controlled access”.












🔹 Real-World Problems on Encapsulation

1. Bank Account Security
Problem:
 Design a BankAccount class where balance cannot be directly accessed or modified. Users should only be able to deposit or withdraw money using methods. Ensure balance never goes negative.
Answer (Java):
class BankAccount {
    private double balance; // encapsulated

    public BankAccount(double initialBalance) {
        if (initialBalance > 0)
            this.balance = initialBalance;
    }

    // getter
    public double getBalance() {
        return balance;
    }

    // deposit with validation
    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    // withdraw with validation
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance)
            balance -= amount;
        else
            System.out.println("Insufficient funds!");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000);
        acc.deposit(500);
        acc.withdraw(200);
        acc.withdraw(2000); // not allowed
        System.out.println("Final Balance: " + acc.getBalance());
    }
}

✅ Encapsulation ensures balance is protected and only modified through methods.

2. Student Information System
Problem:
 Create a Student class where roll number, name, and GPA are private. Allow GPA updates only through a method that checks valid range (0.0 – 10.0).
Answer:
class Student {
    private String name;
    private int rollNo;
    private double gpa;

    public Student(String name, int rollNo, double gpa) {
        this.name = name;
        this.rollNo = rollNo;
        setGpa(gpa); // using setter validation
    }

    // getters
    public String getName() { return name; }
    public int getRollNo() { return rollNo; }
    public double getGpa() { return gpa; }

    // setter with validation
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 10.0)
            this.gpa = gpa;
        else
            System.out.println("Invalid GPA!");
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Rahul", 101, 8.5);
        System.out.println(s.getName() + " GPA: " + s.getGpa());
        s.setGpa(11.0); // invalid
        s.setGpa(9.0); // valid
        System.out.println("Updated GPA: " + s.getGpa());
    }
}

✅ GPA is protected, ensuring only valid data enters.

3. Employee Payroll System
Problem:
 Employees should not directly change their salary. Only the HR department (via method) can update salary.
Answer:
class Employee {
    private String empName;
    private double salary;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
    }

    // getter
    public double getSalary() {
        return salary;
    }

    // only HR can update
    public void updateSalary(double newSalary, String role) {
        if (role.equals("HR"))
            this.salary = newSalary;
        else
            System.out.println("Access Denied: Only HR can update salary.");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee("Meena", 50000);
        System.out.println("Salary: " + e.getSalary());
        e.updateSalary(60000, "Employee"); // not allowed
        e.updateSalary(60000, "HR");       // allowed
        System.out.println("Updated Salary: " + e.getSalary());
    }
}

✅ Encapsulation ensures access control.

4. Online Shopping Cart
Problem:
 Restrict direct access to product price. Apply discounts only via a method.
Answer:
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }

    // apply discount safely
    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 50)
            price = price - (price * percentage / 100);
        else
            System.out.println("Invalid discount!");
    }
}

public class Main {
    public static void main(String[] args) {
        Product p = new Product("Laptop", 50000);
        p.applyDiscount(10);
        System.out.println("After Discount: " + p.getPrice());
        p.applyDiscount(80); // invalid
    }
}

✅ Price cannot be manipulated wrongly from outside.

5. ATM PIN Security
Problem:
 User’s ATM PIN should be private and only verified through a method, not directly accessible.
Answer:
class ATM {
    private int pin = 1234;

    public boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        System.out.println(atm.verifyPin(1234) ? "Access Granted" : "Access Denied");
        System.out.println(atm.verifyPin(1111) ? "Access Granted" : "Access Denied");
    }
}

✅ Pin remains private and secure.






🔹 Medium-Level Encapsulation Questions

1. Online Exam System
Problem:
 Create a User class with username, password (private). Ensure:
Password cannot be read directly.


User can only change password using a method that validates old password.


✅ Encapsulation protects credentials
Answer:
class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void changePassword(String oldPass, String newPass) {
        if (this.password.equals(oldPass)) {
            this.password = newPass;
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Invalid old password!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        User u = new User("rahul123", "pass@123");
        u.changePassword("wrong", "newpass"); // Invalid
        u.changePassword("pass@123", "newpass"); // Valid
    }
}


2. Library Management System
Problem:
 Create a Book class where:
Book’s stock is private.


Add a method to issue books (stock decreases).


Prevent stock from going negative.


Answer:
class Book {
    private String title;
    private int stock;

    public Book(String title, int stock) {
        this.title = title;
        this.stock = stock;
    }

    public int getStock() { return stock; }

    public void issueBook() {
        if (stock > 0) {
            stock--;
            System.out.println("Book issued. Remaining: " + stock);
        } else {
            System.out.println("Out of stock!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Book b = new Book("Java Programming", 2);
        b.issueBook(); // Remaining 1
        b.issueBook(); // Remaining 0
        b.issueBook(); // Out of stock
    }
}


3. Flight Reservation System
Problem:
 Create a Flight class with private seats.
Allow booking only if seats are available.


Prevent direct modification of seat count.


Answer:
class Flight {
    private int availableSeats;

    public Flight(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() { return availableSeats; }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println("Seat booked! Remaining: " + availableSeats);
        } else {
            System.out.println("No seats available!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Flight f = new Flight(2);
        f.bookSeat();
        f.bookSeat();
        f.bookSeat(); // Not possible
    }
}


4. E-Commerce Order System
Problem:
 Create an Order class where order amount is private.
Add a method applyCoupon(code) to reduce amount if valid coupon is applied.


Answer:
class Order {
    private double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public double getAmount() { return amount; }

    public void applyCoupon(String code) {
        if (code.equals("SAVE10")) {
            amount -= amount * 0.1;
            System.out.println("Coupon applied! New amount: " + amount);
        } else {
            System.out.println("Invalid coupon!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Order o = new Order(1000);
        o.applyCoupon("SAVE10"); // valid
        o.applyCoupon("HELLO");  // invalid
    }
}


5. Hospital Patient Records
Problem:
 Create a Patient class with private fields name, disease, billAmount.
Only doctor can update disease.


Only accountant can update bill amount.


Answer:
class Patient {
    private String name;
    private String disease;
    private double billAmount;

    public Patient(String name, String disease, double billAmount) {
        this.name = name;
        this.disease = disease;
        this.billAmount = billAmount;
    }

    public void updateDisease(String newDisease, String role) {
        if (role.equals("Doctor"))
            this.disease = newDisease;
        else
            System.out.println("Access denied!");
    }

    public void updateBill(double newBill, String role) {
        if (role.equals("Accountant"))
            this.billAmount = newBill;
        else
            System.out.println("Access denied!");
    }

    public void showInfo() {
        System.out.println(name + " | " + disease + " | Bill: " + billAmount);
    }
}

public class Main {
    public static void main(String[] args) {
        Patient p = new Patient("Meena", "Fever", 2000);
        p.updateDisease("Malaria", "Doctor");   // Allowed
        p.updateBill(5000, "Accountant");       // Allowed
        p.updateBill(8000, "Nurse");            // Not allowed
        p.showInfo();
    }
}


6. Vehicle Speed Control
Problem:
 Create a Car class with private speed.
Allow increasing speed but restrict max speed to 180.


Prevent negative speed.


Answer:
class Car {
    private int speed;

    public int getSpeed() { return speed; }

    public void accelerate(int increase) {
        if (speed + increase <= 180)
            speed += increase;
        else
            System.out.println("Max speed limit reached!");
    }

    public void brake(int decrease) {
        if (speed - decrease >= 0)
            speed -= decrease;
        else
            speed = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.accelerate(100);
        System.out.println("Speed: " + c.getSpeed());
        c.accelerate(90); // exceeds limit
        c.brake(50);
        System.out.println("Speed after braking: " + c.getSpeed());
    }
}


✅ These are medium-level real-world encapsulation problems that check:
Data hiding


Validation inside setters


Access restriction based on role/logic


Preventing invalid state changes




Perfect! Let’s move up a notch ⚡ – here’s a set of 10 hard-level real-world OOP Encapsulation questions with complete Java answers. These are exactly the type Capgemini training exams or interviews can ask. They combine logic, validation, access control, and multiple rules.

🔹 Hard-Level Encapsulation Questions with Answers

1. Secure Bank Transaction
Problem:
 Create BankAccount class with balance. Only allow withdrawal if daily limit not exceeded and balance is sufficient.
Answer:
class BankAccount {
    private double balance;
    private double dailyWithdrawn;

    public BankAccount(double balance) {
        this.balance = balance;
        this.dailyWithdrawn = 0;
    }

    public double getBalance() { return balance; }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance && dailyWithdrawn + amount <= 50000) {
            balance -= amount;
            dailyWithdrawn += amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal failed! Check balance or daily limit.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(100000);
        acc.withdraw(30000); // Allowed
        acc.withdraw(25000); // Exceeds daily limit
        System.out.println("Balance: " + acc.getBalance());
    }
}


2. University Student Marks System
Problem:
 Student class: private marks array.
Provide method to update marks only if subject code exists


Calculate GPA using encapsulated data


Answer:
class Student {
    private int[] marks = new int[5]; // 5 subjects

    public void updateMarks(int subjectIndex, int mark) {
        if(subjectIndex >=0 && subjectIndex < marks.length && mark >=0 && mark <=100) {
            marks[subjectIndex] = mark;
        } else {
            System.out.println("Invalid index or mark!");
        }
    }

    public double calculateGPA() {
        int sum = 0;
        for(int m : marks) sum += m;
        return sum / (double)marks.length;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.updateMarks(0, 90);
        s.updateMarks(1, 85);
        s.updateMarks(5, 80); // Invalid
        System.out.println("GPA: " + s.calculateGPA());
    }
}


3. Library with Borrow Limit
Problem:
 LibraryUser class tracks borrowed books.
Max 3 books per user.


Borrow method should respect the limit.


Answer:
class LibraryUser {
    private int borrowedBooks = 0;

    public int getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook() {
        if(borrowedBooks < 3) {
            borrowedBooks++;
            System.out.println("Book borrowed! Total: " + borrowedBooks);
        } else {
            System.out.println("Cannot borrow more than 3 books!");
        }
    }

    public void returnBook() {
        if(borrowedBooks > 0) borrowedBooks--;
    }
}

public class Main {
    public static void main(String[] args) {
        LibraryUser u = new LibraryUser();
        u.borrowBook();
        u.borrowBook();
        u.borrowBook();
        u.borrowBook(); // Exceeds limit
        u.returnBook();
        u.borrowBook(); // Allowed
    }
}


4. E-Wallet with Transaction History
Problem:
 Wallet class: store balance and transaction history privately.
Methods for deposit/withdraw update history automatically.


Answer:
import java.util.ArrayList;

class Wallet {
    private double balance;
    private ArrayList<String> history = new ArrayList<>();

    public double getBalance() { return balance; }
    public ArrayList<String> getHistory() { return history; }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            history.add("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Withdrawn: " + amount);
        } else {
            history.add("Failed withdrawal: " + amount);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Wallet w = new Wallet();
        w.deposit(1000);
        w.withdraw(500);
        w.withdraw(600); // fails
        System.out.println("Balance: " + w.getBalance());
        System.out.println("History: " + w.getHistory());
    }
}


5. Employee Role-Based Access
Problem:
 Employee class: salary is private.
Only Manager can update salary.


All others can only read it.


Answer:
class Employee {
    private double salary;

    public Employee(double salary) { this.salary = salary; }

    public double getSalary() { return salary; }

    public void updateSalary(double newSalary, String role) {
        if(role.equals("Manager")) salary = newSalary;
        else System.out.println("Access denied!");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee(50000);
        System.out.println(e.getSalary());
        e.updateSalary(60000, "Employee"); // denied
        e.updateSalary(60000, "Manager"); // allowed
        System.out.println(e.getSalary());
    }
}


6. Flight Booking with Seat Class
Problem:
 Flight class: private availableSeats per class (Economy/Business).
Booking method should handle class type validation.


Answer:
class Flight {
    private int economySeats = 10;
    private int businessSeats = 5;

    public void bookSeat(String type) {
        if(type.equalsIgnoreCase("Economy") && economySeats>0) {
            economySeats--; System.out.println("Economy booked!");
        } else if(type.equalsIgnoreCase("Business") && businessSeats>0) {
            businessSeats--; System.out.println("Business booked!");
        } else {
            System.out.println("No seats available in " + type);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Flight f = new Flight();
        f.bookSeat("Economy");
        f.bookSeat("Business");
        f.bookSeat("First"); // invalid
    }
}


7. Secure ATM with Limited Attempts
Problem:
 ATM class: PIN is private.
User can try max 3 attempts.


Lock account after 3 failed attempts.


Answer:
class ATM {
    private int pin = 1234;
    private int attempts = 0;

    public void enterPin(int enteredPin) {
        if(attempts >= 3) {
            System.out.println("Account locked!");
            return;
        }

        if(enteredPin == pin) {
            System.out.println("Access granted");
            attempts = 0;
        } else {
            attempts++;
            System.out.println("Wrong PIN! Attempt " + attempts);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.enterPin(1111);
        atm.enterPin(2222);
        atm.enterPin(3333);
        atm.enterPin(1234); // account locked
    }
}


8. Subscription Plan with Auto-Renew
Problem:
 Subscription class: private expiry date.
Allow renewal only if current plan is active.


Track total renewals internally.


Answer:
class Subscription {
    private int daysLeft;
    private int renewals = 0;
    public Subscription(int days) { this.daysLeft = days; }
    public void renew(int additionalDays) {
        if(daysLeft > 0) {
            daysLeft += additionalDays;
            renewals++;
            System.out.println("Renewed! Days left: " + daysLeft);
        } else {
            System.out.println("Plan expired! Cannot renew.");
        }
    }

    public int getRenewals() { return renewals; }
}
public class Main {
    public static void main(String[] args) {
        Subscription s = new Subscription(10);
        s.renew(5); 
        s.renew(5); 
        System.out.println("Total renewals: " + s.getRenewals());
    }
}


9. Online Marketplace Product Rating
Problem:
 Product class: private list of ratings.
Allow adding rating 1-5 only.


Calculate average rating via getter.


Answer:
import java.util.ArrayList;
class Product {
    private ArrayList<Integer> ratings = new ArrayList<>();
    public void addRating(int rating) {
        if(rating>=1 && rating<=5) ratings.add(rating);
        else System.out.println("Invalid rating!");
    }
    public double getAverageRating() {
        if(ratings.size() == 0) return 0;
        int sum = 0;
        for(int r: ratings) sum += r;
        return sum / (double)ratings.size();
    }
}
public class Main {
    public static void main(String[] args) {
        Product p = new Product();
        p.addRating(5);
        p.addRating(4);
        p.addRating(7); // invalid
        System.out.println("Avg Rating: " + p.getAverageRating());
    }
}


10. Smart Car Fuel Management
Problem:
 Car class: private fuel level.
Allow refuel only up to tank capacity.


Drive reduces fuel, but cannot go below 0.


Answer:
class Car {
    private double fuel = 0;
    private final double capacity = 50;

    public void refuel(double amount) {
        if(amount > 0 && fuel + amount <= capacity)
            fuel += amount;
        else
            System.out.println("Cannot refuel above tank capacity!");
    }

    public void drive(double distance) {
        double fuelNeeded = distance * 0.5; // 0.5 unit per km
        if(fuelNeeded <= fuel) {
            fuel -= fuelNeeded;
            System.out.println("Car drove " + distance + " km");
        } else {
            System.out.println("Not enough fuel!");
        }
    }

    public double getFuel() { return fuel; }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.refuel(30);
        c.drive(40); // fuel needed 20
        System.out.println("Fuel left: " + c.getFuel());
        c.refuel(25); // exceeds capacity
    }
}


✅ These 10 problems are hard-level because they involve:
Multiple validations & rules


Role-based access control


Limits & thresholds


Real-world business logic




1. Definition
Encapsulation = the practice of hiding the internal data of a class and restricting direct access from outside.
Achieved by private variables + public getters/setters.


Helps control what values can be set and protects data integrity.



2. Core Components
Private data members

 private int balance;


Public getter method (to read value)

 public int getBalance() { return balance; }


Public setter method (to modify value) with logic/validation

 public void setBalance(int balance) {
    if(balance >= 0) this.balance = balance;
    else System.out.println("Invalid balance");
}



3. Common Mistakes / Missing Points
Only getters/setters without logic → Basic encapsulation, but not full control.


Not validating input in setters → Can break integrity.


Making fields public → Breaks encapsulation.


Multiple classes / inheritance scenarios → Remember protected can be used carefully.



4. Advanced / Hard-Level Tips
Encapsulation + Validation: Always validate inside setter (age, salary, stock, etc.).


Immutable Classes: If no setters, data can be read but not modified → fully encapsulated.


Encapsulation + Constructors: Initialize mandatory fields via constructor to enforce valid object state.


Encapsulation + Business Logic: You can include calculations inside getters instead of exposing raw data.



5. Real-World Example (Full Logic)
class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String holder, double initialBalance) {
        this.accountHolder = holder;
        setBalance(initialBalance); // enforce validation
    }

    // Getter
    public double getBalance() {
        return balance;
    }

    // Setter with validation
    public void setBalance(double balance) {
        if(balance >= 0) this.balance = balance;
        else System.out.println("Balance cannot be negative!");
    }

    // Business Logic
    public void deposit(double amount) {
        if(amount > 0) balance += amount;
        else System.out.println("Invalid deposit amount");
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) balance -= amount;
        else System.out.println("Invalid withdrawal or insufficient balance");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Ravi", 5000);
        acc.deposit(2000);
        acc.withdraw(8000); // invalid
        System.out.println("Current Balance: " + acc.getBalance());
    }
}

✅ What’s covered here:
Private fields → encapsulation


Constructor → initialization


Setters + validation → secure input


Business logic → control access



Summary of What You Should Know for Exams
Definition + purpose


Private variables + public getters/setters


Validation inside setters


Immutable objects (optional but advanced)


Using encapsulation with business logic


Constructor initialization to enforce valid state










Perfect 👍 That was a great abstraction example you wrote!
 Now, let’s create a real-world encapsulation question in the same style (with 5 inputs, getters/setters, and logic inside setters or extra methods).

❓ Encapsulation Question
Create a BankAccount class to store and manage customer account details.
Data members: accountNumber, holderName, balance, accountType, phoneNumber (all should be private).


Use getters and setters to protect the data.


Add validation logic inside setters:


Balance cannot be negative.


Phone number must be 10 digits.


Account type must be either Savings or Current.


Create a method deposit(double amount) that increases the balance only if amount > 0.


Create a method withdraw(double amount) that decreases the balance only if sufficient funds exist.


In the main class, create 2 BankAccount objects, set values using setters, and demonstrate deposit/withdraw.



✅ Encapsulation Answer (Code)
class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;
    private String accountType;
    private String phoneNumber;

    // Getters
    public int getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    public String getPhoneNumber() { return phoneNumber; }

    // Setters with validation
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("❌ Balance cannot be negative!");
        }
    }

    public void setAccountType(String accountType) {
        if (accountType.equalsIgnoreCase("Savings") || accountType.equalsIgnoreCase("Current")) {
            this.accountType = accountType;
        } else {
            System.out.println("❌ Invalid account type. Choose Savings or Current.");
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("❌ Phone number must be 10 digits.");
        }
    }

    // Business logic
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("❌ Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawn " + amount + ". Remaining balance: " + balance);
        } else {
            System.out.println("❌ Withdrawal failed. Check balance or amount.");
        }
    }

    public void showDetails() {
        System.out.println("Account Number: " + accountNumber +
                           ", Holder: " + holderName +
                           ", Balance: " + balance +
                           ", Type: " + accountType +
                           ", Phone: " + phoneNumber);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        b1.setAccountNumber(101);
        b1.setHolderName("Ravi");
        b1.setBalance(5000);
        b1.setAccountType("Savings");
        b1.setPhoneNumber("9876543210");

        b1.showDetails();
        b1.deposit(2000);
        b1.withdraw(3000);

        System.out.println("--------------------");

        BankAccount b2 = new BankAccount();
        b2.setAccountNumber(102);
        b2.setHolderName("Riya");
        b2.setBalance(10000);
        b2.setAccountType("Current");
        b2.setPhoneNumber("9123456789");

        b2.showDetails();
        b2.deposit(5000);
        b2.withdraw(20000); // should fail
    }
}


Definition of Abstraction
Abstraction in Java (and OOP in general) is the process of hiding unnecessary implementation details and showing only the essential features of an object.
You define what an object can do, but not how it does it.


It helps to reduce complexity and increase reusability.


In Java, abstraction is achieved using:
Abstract classes (abstract class)


Interfaces (interface)



Key Points
Abstract classes can have both abstract methods (no body) and concrete methods (with body).


Interfaces contain only abstract methods (before Java 8) or default/static methods (after Java 8).


Abstraction focuses on “what the object does”, not “how it does it”.



Real-World Example
Think of a TV remote:
You press a button (turn on, volume up/down).


You don’t need to know how the remote communicates with the TV internally.


Here, the interface (remote) provides abstraction — it exposes actions, hides implementation.



In Java Code
abstract class Vehicle {
    abstract void start();  // what the vehicle can do
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starting with key ignition"); // how it starts
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starting with kick or self-start");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start(); // Main program does not care *how* it starts
    }
}

✅ Here:
Vehicle abstracts the “start” action.


Car/Bike implement the actual logic.


The main program only interacts with what the object can do.



Where Abstraction is Used Mostly
Banking systems – hiding interest calculation and withdrawal rules.


Payment gateways – hiding internal payment processing logic.


Vehicle management systems – hiding tax calculation or engine details.


Hospital management – hiding billing/treatment logic for different patient types.


E-commerce systems – hiding discount or pricing logic per product type.



💡 Shortcut to remember:
“Abstraction = Show what, hide how.”


Exactly ✅ — that’s the correct pattern for using abstraction in Java, especially for exam or training-level problems. Let me break it down clearly:

Steps to Use Abstraction
Create an abstract class with 5 inputs (or whatever fields you need) in the constructor.


Declare abstract methods in the abstract class — these define what the class can do, but not how it does it.


Create subclasses that extend the abstract class.


Implement the abstract methods in the subclasses with the specific logic.


Use objects of the subclass to perform operations — the main program doesn’t care about the internal logic, only that the methods exist.



Template Example (5 inputs)
// Step 1: Abstract class

abstract class ExampleAbstract {
    String input1;
    int input2;
    double input3;
    String input4;
    int input5;

    public ExampleAbstract(String i1, int i2, double i3, String i4, int i5) {
        this.input1 = i1;
        this.input2 = i2;
        this.input3 = i3;
        this.input4 = i4;
        this.input5 = i5;
    }

    // Step 2: Abstract methods

    abstract void doAction1();
    abstract void doAction2();
}

// Step 3 & 4: Subclasses implementing abstract methods


class SubClass1 extends ExampleAbstract {
    public SubClass1(String i1, int i2, double i3, String i4, int i5) {
        super(i1, i2, i3, i4, i5);
    }

    void doAction1() {
        System.out.println("Logic for Action1 using inputs: " + input1 + ", " + input2);
    }

    void doAction2() {
        System.out.println("Logic for Action2 using inputs: " + input3 + ", " + input4 + ", " + input5);
    }
}

// Step 5: Use subclass objects


public class Main {
    public static void main(String[] args) {
        ExampleAbstract obj = new SubClass1("Test", 10, 20.5, "Hello", 5);
        obj.doAction1();
        obj.doAction2();
    }
}


✅ Key Points
Abstract class = holds inputs + defines what to do.


Subclasses = implement the logic (how it is done).


Main program = uses objects of the subclass and calls methods.


You cannot create an object of the abstract class directly.



 5 Real-World Abstraction Questions with Answers

Q1: Payment System
Problem:
 Design a system where users can pay using different methods (Credit Card, UPI, PayPal). Use abstraction so the user only calls pay() without worrying about implementation.
Answer:
abstract class Payment {
    abstract void pay(double amount);
}

class CreditCardPayment extends Payment {
    void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class UPIPayment extends Payment {
    void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI.");
    }
}

public class Main {
    public static void main(String[] args) {
        Payment p = new UPIPayment(); 
        p.pay(500);  // Output: Paid 500 using UPI.
    }
}


Q2: Vehicle Example
Problem:
 Create a vehicle system where different vehicles (Car, Bike, Bus) implement start() differently.
Answer:
abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts with a key.");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starts with a kick or button.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Bike();
        v.start();  // Output: Bike starts with a kick or button.
    }
}



Q3: Shape Area Calculator
Problem:
 Design a program that calculates the area of different shapes (Circle, Rectangle, Triangle) using abstraction.
Answer:
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;
    Circle(double r) { radius = r; }
    double area() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    double length, width;
    Rectangle(double l, double w) { length = l; width = w; }
    double area() { return length * width; }
}

public class Main {
    public static void main(String[] args) {
        Shape s = new Circle(5);
        System.out.println("Circle Area: " + s.area());
    }
}


Q4: Online Course Platform
Problem:
 On a learning platform, different courses (JavaCourse, PythonCourse) should have their own getCourseContent().
Answer:
abstract class Course {
    abstract void getCourseContent();
}

class JavaCourse extends Course {
    void getCourseContent() {
        System.out.println("Java Course: OOPs, Collections, Streams...");
    }
}

class PythonCourse extends Course {
    void getCourseContent() {
        System.out.println("Python Course: Basics, OOPs, Django...");
    }
}

public class Main {
    public static void main(String[] args) {
        Course c = new PythonCourse();
        c.getCourseContent();
    }
}


Q5: ATM Machine
Problem:
 Design an ATM where different banks (HDFCBank, ICICIBank) implement their own withdraw() rules.
Answer:
abstract class ATM {
    abstract void withdraw(double amount);
}

class HDFCBank extends ATM {
    void withdraw(double amount) {
        System.out.println("HDFC: Withdrawn " + amount);
    }
}

class ICICIBank extends ATM {
    void withdraw(double amount) {
        System.out.println("ICICI: Withdrawn " + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new HDFCBank();
        atm.withdraw(2000);
    }
}


✅ Key Takeaway:
Encapsulation → Data hiding with getters/setters


Abstraction → Hiding implementation, showing only essential methods via abstract classes/interfaces



Perfect 👍 Let’s do 10 medium-level Abstraction questions (like exam-style practice for interviews and training).
 Each question is based on abstract classes / interfaces, and I’ll also give the solution idea with code.

🔹 10 Medium-Level Abstraction Questions with Answers

Q1. Animal Sounds
Q: Create an Animal abstract class with sound() method. Implement in Dog, Cat, and Cow.
 A:
abstract class Animal {
    abstract void sound();
}

class Dog extends Animal {
    void sound() { System.out.println("Woof!"); }
}
class Cat extends Animal {
    void sound() { System.out.println("Meow!"); }
}
class Cow extends Animal {
    void sound() { System.out.println("Moo!"); }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.sound();
    }
}


Q2. Employee Salary
Q: Create an abstract class Employee with calculateSalary(). Implement for FullTimeEmployee and PartTimeEmployee.
 A:
abstract class Employee {
    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    double calculateSalary() { return 50000; }
}

class PartTimeEmployee extends Employee {
    double calculateSalary() { return 20000; }
}

public class Main {
    public static void main(String[] args) {
        Employee e = new PartTimeEmployee();
        System.out.println("Salary: " + e.calculateSalary());
    }
}



Q3. Bank Loan Interest
Q: Use abstraction to define a Loan class with getInterestRate(). Implement HomeLoan, CarLoan.
 A:
abstract class Loan {
    abstract double getInterestRate();
}

class HomeLoan extends Loan {
    double getInterestRate() { return 7.5; }
}

class CarLoan extends Loan {
    double getInterestRate() { return 9.0; }
}

public class Main {
    public static void main(String[] args) {
        Loan l = new CarLoan();
        System.out.println("Car Loan Interest: " + l.getInterestRate() + "%");
    }
}


Q4. Payment Gateway
Q: Create an interface Payment with pay(amount). Implement CreditCard and DebitCard.
 A:
interface Payment {
    void pay(double amount);
}

class CreditCard implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card.");
    }
}

class DebitCard implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Debit Card.");
    }
}

public class Main {
    public static void main(String[] args) {
        Payment p = new DebitCard();
        p.pay(3000);
    }
}


Q5. Online Shopping Delivery
Q: Create an abstract class Delivery with deliver(). Implement StandardDelivery and ExpressDelivery.
 A:
abstract class Delivery {
    abstract void deliver();
}

class StandardDelivery extends Delivery {
    void deliver() { System.out.println("Standard Delivery in 5 days."); }
}

class ExpressDelivery extends Delivery {
    void deliver() { System.out.println("Express Delivery in 1 day."); }
}

public class Main {
    public static void main(String[] args) {
        Delivery d = new ExpressDelivery();
        d.deliver();
    }
}


Q6. Online Exam System
Q: Create an abstract class Exam with startExam(). Implement JavaExam and PythonExam.
 A:
abstract class Exam {
    abstract void startExam();
}

class JavaExam extends Exam {
    void startExam() { System.out.println("Starting Java Exam..."); }
}

class PythonExam extends Exam {
    void startExam() { System.out.println("Starting Python Exam..."); }
}

public class Main {
    public static void main(String[] args) {
        Exam e = new PythonExam();
        e.startExam();
    }
}


Q7. File Reader System
Q: Create an abstract class FileReader with readFile(). Implement PDFReader and WordReader.
 A:
abstract class FileReader {
    abstract void readFile();
}

class PDFReader extends FileReader {
    void readFile() { System.out.println("Reading PDF File..."); }
}

class WordReader extends FileReader {
    void readFile() { System.out.println("Reading Word File..."); }
}

public class Main {
    public static void main(String[] args) {
        FileReader f = new PDFReader();
        f.readFile();
    }
}


Q8. Transport System
Q: Create an abstract class Transport with move(). Implement Bus, Train, and Flight.
 A:
abstract class Transport {
    abstract void move();
}

class Bus extends Transport {
    void move() { System.out.println("Bus moves on road."); }
}

class Train extends Transport {
    void move() { System.out.println("Train moves on tracks."); }
}

class Flight extends Transport {
    void move() { System.out.println("Flight moves in air."); }
}

public class Main {
    public static void main(String[] args) {
        Transport t = new Flight();
        t.move();
    }
}


Q9. Music Player
Q: Create an interface MusicPlayer with play(). Implement MP3Player and SpotifyPlayer.
 A:
interface MusicPlayer {
    void play();
}

class MP3Player implements MusicPlayer {
    public void play() { System.out.println("Playing MP3 music..."); }
}

class SpotifyPlayer implements MusicPlayer {
    public void play() { System.out.println("Playing Spotify music..."); }
}

public class Main {
    public static void main(String[] args) {
        MusicPlayer m = new SpotifyPlayer();
        m.play();
    }
}


Q10. Restaurant Menu
Q: Create an abstract class Food with serve(). Implement Pizza and Burger.
 A:
abstract class Food {
    abstract void serve();
}

class Pizza extends Food {
    void serve() { System.out.println("Serving Pizza with cheese."); }
}

class Burger extends Food {
    void serve() { System.out.println("Serving Burger with fries."); }
}

public class Main {
    public static void main(String[] args) {
        Food f = new Pizza();
        f.serve();
    }
}


🔹 10 Hard Abstraction Questions (with Answers)

1. Online Payment Gateway (Abstract Class)
Q: Design an abstract Payment class with abstract method processPayment(). Implement it for CreditCardPayment, PayPalPayment, and UPIPayment.
Answer:
abstract class Payment {
    abstract void processPayment(double amount);
}

class CreditCardPayment extends Payment {
    void processPayment(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

class PayPalPayment extends Payment {
    void processPayment(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
    }
}

class UPIPayment extends Payment {
    void processPayment(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}

public class Main {
    public static void main(String[] args) {
        Payment p = new PayPalPayment();
        p.processPayment(1500);
    }
}

Perfect 👍 You want answers for all 10 hard Abstraction questions. I’ll give you Java programs with explanations for each.

🔹 1. Payment Gateway (abstract class + multiple implementations)
abstract class Payment {
    abstract void processPayment(double amount);
}

class CreditCardPayment extends Payment {
    void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment of $" + amount);
    }
}

class UpiPayment extends Payment {
    void processPayment(double amount) {
        System.out.println("Processing UPI Payment of $" + amount);
    }
}

public class Main1 {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment();
        p1.processPayment(1000);

        Payment p2 = new UpiPayment();
        p2.processPayment(500);
    }
}

✅ Abstraction used: We hide payment details; only method processPayment() is exposed.

🔹 2. Vehicle Control System

abstract class Vehicle {
    abstract void start();
    abstract void stop();
}

class Car extends Vehicle {
    void start() { System.out.println("Car starting with key ignition."); }
    void stop() { System.out.println("Car stopped with brake."); }
}

class Bike extends Vehicle {
    void start() { System.out.println("Bike starting with self-start."); }
    void stop() { System.out.println("Bike stopped with disc brake."); }
}

public class Main2 {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        v1.start(); v1.stop();

        Vehicle v2 = new Bike();
        v2.start(); v2.stop();
    }
}

✅ Abstraction used: User just calls start/stop, no idea about internal mechanism.

🔹 3. Online Shopping Cart
abstract class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name; this.price = price;
    }
    abstract double getDiscountedPrice();
}

class Electronics extends Product {
    Electronics(String n, double p) { super(n, p); }
    double getDiscountedPrice() { return price * 0.9; } // 10% off
}

class Clothing extends Product {
    Clothing(String n, double p) { super(n, p); }
    double getDiscountedPrice() { return price * 0.8; } // 20% off
}

public class Main3 {
    public static void main(String[] args) {
        Product p1 = new Electronics("Laptop", 50000);
        Product p2 = new Clothing("Shirt", 2000);

        System.out.println(p1.name + " after discount: " + p1.getDiscountedPrice());
        System.out.println(p2.name + " after discount: " + p2.getDiscountedPrice());
    }
}

✅ Abstraction: Customer doesn’t know discount rules; class hides it.

🔹 4. Banking System
abstract class BankAccount {
    double balance = 0;
    abstract void deposit(double amount);
    abstract void withdraw(double amount);
}

class SavingsAccount extends BankAccount {
    void deposit(double amount) { balance += amount; }
    void withdraw(double amount) {
        if(balance - amount >= 1000) balance -= amount;
        else System.out.println("Minimum balance required!");
    }
}

class CurrentAccount extends BankAccount {
    void deposit(double amount) { balance += amount; }
    void withdraw(double amount) { balance -= amount; }
}

public class Main4 {
    public static void main(String[] args) {
        BankAccount acc = new SavingsAccount();
        acc.deposit(5000);
        acc.withdraw(4500);
        System.out.println("Remaining Balance: " + acc.balance);
    }
}

✅ Abstraction: Rules vary per account type, but user just calls deposit/withdraw.

🔹 5. Employee Payroll
abstract class Employee {
    String name;
    double baseSalary;
    Employee(String n, double s) { name = n; baseSalary = s; }
    abstract double calculatePay();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String n, double s) { super(n, s); }
    double calculatePay() { return baseSalary; }
}

class PartTimeEmployee extends Employee {
    int hours;
    PartTimeEmployee(String n, double s, int h) { super(n, s); hours = h; }
    double calculatePay() { return hours * (baseSalary / 160); } // hourly
}

public class Main5 {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("John", 40000);
        Employee e2 = new PartTimeEmployee("Alex", 40000, 80);

        System.out.println(e1.name + " Pay: " + e1.calculatePay());
        System.out.println(e2.name + " Pay: " + e2.calculatePay());
    }
}

✅ Abstraction: Payroll logic is hidden inside subclasses.

🔹 6. Hospital Management System
abstract class Staff {
    String name;
    Staff(String n) { name = n; }
    abstract void performDuty();
}

class Doctor extends Staff {
    Doctor(String n) { super(n); }
    void performDuty() { System.out.println(name + " treats patients."); }
}

class Nurse extends Staff {
    Nurse(String n) { super(n); }
    void performDuty() { System.out.println(name + " assists doctor and cares for patients."); }
}

public class Main6 {
    public static void main(String[] args) {
        Staff s1 = new Doctor("Dr. Smith");
        Staff s2 = new Nurse("Alice");
        s1.performDuty(); s2.performDuty();
    }
}

✅ Abstraction: Duties differ, but client just calls performDuty().

🔹 7. ATM System
abstract class ATM {
    abstract void withdraw(double amount);
    abstract void checkBalance();
}

class SBIATM extends ATM {
    double balance = 5000;
    void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            System.out.println("SBI ATM: Withdraw " + amount);
        } else System.out.println("Insufficient balance");
    }
    void checkBalance() { System.out.println("SBI Balance: " + balance); }
}

class HDFCATM extends ATM {
    double balance = 10000;
    void withdraw(double amount) { balance -= amount; System.out.println("HDFC ATM: Withdraw " + amount); }
    void checkBalance() { System.out.println("HDFC Balance: " + balance); }
}

public class Main7 {
    public static void main(String[] args) {
        ATM atm = new SBIATM();
        atm.withdraw(2000);
        atm.checkBalance();
    }
}

✅ Abstraction: User doesn’t care about bank-specific implementation.

🔹 8. University Management
abstract class Person {
    String name;
    Person(String n) { name = n; }
    abstract void role();
}

class Student extends Person {
    Student(String n) { super(n); }
    void role() { S ystem.out.println(name + " is a student."); }
}

class Professor extends Person {
    Professor(String n) { super(n); }
    void role() { System.out.println(name + " is a professor."); }
}

public class Main8 {
    public static void main(String[] args) {
        Person p1 = new Student("Raj");
        Person p2 = new Professor("Dr. Kumar");
        p1.role(); p2.role();
    }
}

✅ Abstraction: Everyone is a Person, but behavior differs.


🔹 9. Online Food Delivery
abstract class FoodDelivery {
    abstract void deliverFood();
}

class Swiggy extends FoodDelivery {
    void deliverFood() { System.out.println("Swiggy delivers food in 30 minutes."); }
}

class Zomato extends FoodDelivery {
    void deliverFood() { System.out.println("Zomato delivers food in 25 minutes."); }
}

public class Main9 {
    public static void main(String[] args) {
        FoodDelivery f = new Zomato();
        f.deliverFood();
    }
}

✅ Abstraction: Delivery process is hidden; user just orders.

🔹 10. Insurance Policy
abstract class InsurancePolicy {
    String holder;
    InsurancePolicy(String h) { holder = h; }
    abstract double calculatePremium();
}

class HealthInsurance extends InsurancePolicy {
    double age;
    HealthInsurance(String h, double age) { super(h); this.age = age; }
    double calculatePremium() { return age > 40 ? 5000 : 3000; }
}

class CarInsurance extends InsurancePolicy {
    int carAge;
    CarInsurance(String h, int c) { super(h); carAge = c; }
    double calculatePremium() { return carAge > 5 ? 7000 : 4000; }
}

public class Main10 {
    public static void main(String[] args) {
        InsurancePolicy p1 = new HealthInsurance("Ravi", 45);
        InsurancePolicy p2 = new CarInsurance("Arun", 3);

        System.out.println(p1.holder + " Premium: " + p1.calculatePremium());
        System.out.println(p2.holder + " Premium: " + p2.calculatePremium());
    }
}

✅ Abstraction: Different rules per policy type, but same abstract interface.


🔹 Example Hard-Level Implementation (Detailed)
Let’s fully solve Question 4 (Employee Salary System) since it’s often asked in company exams:
abstract class Employee {
    protected String name;
    protected int id;
    
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;
    
    FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    
    double calculateSalary() {
        return monthlySalary; // fixed salary
    }
}

class ContractEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;
    
    ContractEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("Arun", 101, 50000);
        Employee e2 = new ContractEmployee("Meena", 102, 120, 300);
        
        System.out.println(e1.name + " Salary: ₹" + e1.calculateSalary());
        System.out.println(e2.name + " Salary: ₹" + e2.calculateSalary());
    }
}

👉 Why abstraction here? The Main class only knows that calculateSalary() exists.
 It doesn’t care how salary is calculated (monthly vs hourly).




🔹 Question 1: Hospital Management System
Create an abstract class Hospital with 5 inputs:
 patientName, patientAge, disease, doctorName, roomNumber.
 Abstract method: treatPatient().
 Two subclasses: GeneralWard and ICU implement the treatment process differently.
✅ Answer
abstract class Hospital {
    protected String patientName;
    protected int patientAge;
    protected String disease;
    protected String doctorName;
    protected int roomNumber;

    // Constructor
    public Hospital(String patientName, int patientAge, String disease, String doctorName, int roomNumber) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.disease = disease;
        this.doctorName = doctorName;
        this.roomNumber = roomNumber;
    }

    // Abstract method
    abstract void treatPatient();

    // Common method
    public void showDetails() {
        System.out.println("Patient: " + patientName + ", Age: " + patientAge);
        System.out.println("Disease: " + disease + ", Doctor: " + doctorName + ", Room: " + roomNumber);
    }
}

class GeneralWard extends Hospital {
    public GeneralWard(String p, int a, String d, String doc, int r) {
        super(p, a, d, doc, r);
    }
    void treatPatient() {
        System.out.println("General treatment with medicines & rest.");
    }
}

class ICU extends Hospital {
    public ICU(String p, int a, String d, String doc, int r) {
        super(p, a, d, doc, r);
    }
    void treatPatient() {
        System.out.println("ICU care with continuous monitoring and ventilator support.");
    }
}

public class Main {
    public static void main(String[] args) {
        Hospital h1 = new GeneralWard("John", 45, "Flu", "Dr. Smith", 101);
        h1.showDetails();
        h1.treatPatient();

        Hospital h2 = new ICU("Alice", 70, "Heart Attack", "Dr. Brown", 202);
        h2.showDetails();
        h2.treatPatient();
    }
}


🔹 Question 2: Banking System
Create an abstract class BankAccount with 5 inputs:
 accountHolder, accountNumber, balance, branch, ifscCode.
 Abstract methods: deposit(double amount) and withdraw(double amount).
 Two subclasses: SavingsAccount and CurrentAccount.
✅ Answer
abstract class BankAccount {
    protected String accountHolder;
    protected int accountNumber;
    protected double balance;
    protected String branch;
    protected String ifscCode;

    public BankAccount(String holder, int number, double bal, String branch, String ifsc) {
        this.accountHolder = holder;
        this.accountNumber = number;
        this.balance = bal;
        this.branch = branch;
        this.ifscCode = ifsc;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    public void showDetails() {
        System.out.println(accountHolder + " | Acc#: " + accountNumber + " | Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String h, int n, double b, String br, String ifsc) {
        super(h, n, b, br, ifsc);
    }
    void deposit(double amount) {
        balance += amount;
        System.out.println("Savings Deposit: " + amount + ", New Balance: " + balance);
    }
    void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            System.out.println("Savings Withdraw: " + amount + ", Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient balance in Savings Account!");
        }
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String h, int n, double b, String br, String ifsc) {
        super(h, n, b, br, ifsc);
    }
    void deposit(double amount) {
        balance += amount;
        System.out.println("Current Deposit: " + amount + ", New Balance: " + balance);
    }
    void withdraw(double amount) {
        if(amount <= balance + 5000) {  // overdraft allowed
            balance -= amount;
            System.out.println("Current Withdraw: " + amount + ", Remaining Balance: " + balance);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}

public class MainBank {
    public static void main(String[] args) {
        BankAccount s = new SavingsAccount("Raj", 1001, 10000, "Chennai", "IFSC001");
        s.showDetails();
        s.deposit(5000);
        s.withdraw(2000);

        BankAccount c = new CurrentAccount("Priya", 2001, 5000, "Bangalore", "IFSC002");
        c.showDetails();
        c.deposit(3000);
        c.withdraw(9000);
    }
}


🔹 Question 3: E-commerce Product System
Abstract class Product with 5 inputs:
 id, name, price, category, stock.
 Abstract method: calculateDiscount().
 Subclasses: Electronics, Clothing.
✅ Answer
abstract class Product {
    protected int id;
    protected String name;
    protected double price;
    protected String category;
    protected int stock;

    public Product(int id, String name, double price, String category, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    abstract void calculateDiscount();

    public void showDetails() {
        System.out.println("Product: " + name + " | Category: " + category + " | Price: " + price + " | Stock: " + stock);
    }
}

class Electronics extends Product {
    public Electronics(int id, String n, double p, String c, int s) {
        super(id, n, p, c, s);
    }
    void calculateDiscount() {
        System.out.println("Electronics discount: " + (price * 0.10));
    }
}

class Clothing extends Product {
    public Clothing(int id, String n, double p, String c, int s) {
        super(id, n, p, c, s);
    }
    void calculateDiscount() {
        System.out.println("Clothing discount: " + (price * 0.20));
    }
}

public class MainProduct {
    public static void main(String[] args) {
        Product p1 = new Electronics(101, "Laptop", 60000, "Electronics", 10);
        p1.showDetails();
        p1.calculateDiscount();

        Product p2 = new Clothing(201, "Shirt", 2000, "Clothing", 50);
        p2.showDetails();
        p2.calculateDiscount();
    }
}



🔹 Question 4: Vehicle Registration System
Abstract class: Vehicle
 Inputs: regNumber, ownerName, model, fuelType, price
 Abstract methods: calculateTax(), displayDetails()
 Subclasses: Car, Bike
✅ Answer
abstract class Vehicle {
    protected String regNumber;
    protected String ownerName;
    protected String model;
    protected String fuelType;
    protected double price;

    public Vehicle(String regNumber, String ownerName, String model, String fuelType, double price) {
        this.regNumber = regNumber;
        this.ownerName = ownerName;
        this.model = model;
        this.fuelType = fuelType;
        this.price = price;
    }

    abstract void calculateTax();
    abstract void displayDetails();
}

class Car extends Vehicle {
    public Car(String regNumber, String ownerName, String model, String fuelType, double price) {
        super(regNumber, ownerName, model, fuelType, price);
    }

    void calculateTax() {
        double tax = fuelType.equalsIgnoreCase("Electric") ? price * 0.05 : price * 0.10;
        System.out.println("Car Tax: " + tax);
    }

    void displayDetails() {
        System.out.println("Car - Reg#: " + regNumber + ", Owner: " + ownerName + ", Model: " + model + ", Fuel: " + fuelType + ", Price: " + price);
    }
}

class Bike extends Vehicle {
    public Bike(String regNumber, String ownerName, String model, String fuelType, double price) {
        super(regNumber, ownerName, model, fuelType, price);
    }

    void calculateTax() {
        double tax = fuelType.equalsIgnoreCase("Electric") ? price * 0.03 : price * 0.08;
        System.out.println("Bike Tax: " + tax);
    }

    void displayDetails() {
        System.out.println("Bike - Reg#: " + regNumber + ", Owner: " + ownerName + ", Model: " + model + ", Fuel: " + fuelType + ", Price: " + price);
    }
}

public class MainVehicle {
    public static void main(String[] args) {
        Vehicle v1 = new Car("TN01AB1234", "Ravi", "Hyundai i20", "Petrol", 800000);
        v1.displayDetails();
        v1.calculateTax();

        Vehicle v2 = new Bike("TN02XY5678", "Priya", "Honda Activa", "Electric", 70000);
        v2.displayDetails();
        v2.calculateTax();
    }
}

✅ Abstraction: Tax calculation differs by vehicle type and fuel type, but user just calls calculateTax().

🔹 Question 5: Hospital Patient Billing System
Abstract class: Patient
 Inputs: id, name, age, disease, billAmount
 Abstract methods: treatmentCost(), applyInsurance()
 Subclasses: InPatient, OutPatient
✅ Answer
abstract class Patient {
    protected int id;
    protected String name;
    protected int age;
    protected String disease;
    protected double bill;
    
    //get input from the question
    public Patient(int id, String name, int age, String disease, double bill) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.bill = bill;
    }
    
    //create abstract method
    abstract void treatmentCost();
    abstract void applyInsurance();
    
    //show Patient details
    public void showDetails() {
        System.out.println("Patient ID: " + id + ", Name: " + name + ", Age: " + age +
                           ", Disease: " + disease + ", Bill: " + bill);
    }
}

//create InPatient details
class InPatient extends Patient {
    private int daysAdmitted;

    public InPatient(int id, String name, int age, String disease, double bill, int daysAdmitted) {
        super(id, name, age, disease, bill);
        this.daysAdmitted = daysAdmitted;
    }

    void treatmentCost() {
        bill += daysAdmitted * 2000;
        System.out.println("Total bill: " + bill);
    }

    void applyInsurance() {
        bill *= 0.8;
        System.out.println("Bill after insurance: " + bill);
    }
}

//OutPatient details
class OutPatient extends Patient {
    private int visits;

    public OutPatient(int id, String name, int age, String disease, double bill, int visits) {
        super(id, name, age, disease, bill);
        this.visits = visits;
    }

    void treatmentCost() {
        bill += visits * 500;
        System.out.println("Total bill: " + bill);
    }

    void applyInsurance() {
        bill *= 0.9;
        System.out.println("Bill after insurance: " + bill);
    }
}

//main class
public class Main {
    public static void main(String[] args) {
        Patient p1 = new InPatient(101, "Ravi", 45, "Heart", 50000, 5);
        p1.showDetails();
        p1.treatmentCost();
        p1.applyInsurance();

        Patient p2 = new OutPatient(104, "Riya", 20, "Brain", 100000, 3);
        p2.showDetails();
        p2.treatmentCost();
        p2.applyInsurance();
    }
}

✅ Abstraction: Billing rules are different for in-patient vs out-patient. The main program doesn’t care about calculation logic, just calls treatmentCost() and applyInsurance().

These last two questions are very hard level because:
Each uses 5 inputs.


Logic differs per subclass.


🔹 10 Easy Polymorphism Questions with Answers

Q1. Animal Sounds
👉 Create a program where different animals make different sounds using polymorphism.
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog(); // Runtime Polymorphism
        Animal a2 = new Cat();
        
        a1.sound();
        a2.sound();
    }
}

✅ Output:
Dog barks  
Cat meows


Q2. Shape Area Calculation
👉 Use polymorphism to calculate area of Circle and Rectangle.
class Shape {
    void area() {
        System.out.println("Find area");
    }
}

class Circle extends Shape {
    void area() {
        System.out.println("Area of Circle = πr²");
    }
}

class Rectangle extends Shape {
    void area() {
        System.out.println("Area of Rectangle = l × b");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();
        
        s1.area();
        s2.area();
    }
}

✅ Output:
Area of Circle = πr²  
Area of Rectangle = l × b


Q3. Payment System
👉 Different payment modes using polymorphism.
class Payment {
    void pay() {
        System.out.println("Paying...");
    }
}

class CreditCard extends Payment {
    void pay() {
        System.out.println("Paid using Credit Card");
    }
}

class UPI extends Payment {
    void pay() {
        System.out.println("Paid using UPI");
    }
}

public class Main {
    public static void main(String[] args) {
        Payment p1 = new CreditCard();
        Payment p2 = new UPI();
        
        p1.pay();
        p2.pay();
    }
}

✅ Output:
Paid using Credit Card  
Paid using UPI


Q4. Employee Salary
👉 Different employee types calculate salary differently.
class Employee {
    void salary() {
        System.out.println("Salary calculated");
    }
}

class FullTimeEmployee extends Employee {
    void salary() {
        System.out.println("Full Time Salary = 50000");
    }
}

class PartTimeEmployee extends Employee {
    void salary() {
        System.out.println("Part Time Salary = 20000");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee();
        Employee e2 = new PartTimeEmployee();
        
        e1.salary();
        e2.salary();
    }
}

✅ Output:
Full Time Salary = 50000  
Part Time Salary = 20000


Q5. Vehicle Example
👉 Car and Bike run differently.
class Vehicle {
    void run() {
        System.out.println("Vehicle is running");
    }
}

class Car extends Vehicle {
    void run() {
        System.out.println("Car is running at 100km/hr");
    }
}

class Bike extends Vehicle {
    void run() {
        System.out.println("Bike is running at 60km/hr");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();
        
        v1.run();
        v2.run();
    }
}

✅ Output:
Car is running at 100km/hr  
Bike is running at 60km/hr


Q6. Student Exam Results
class Exam {
    void result() {
        System.out.println("Result published");
    }
}

class MathExam extends Exam {
    void result() {
        System.out.println("Math exam result published");
    }
}

class ScienceExam extends Exam {
    void result() {
        System.out.println("Science exam result published");
    }
}

public class Main {
    public static void main(String[] args) {
        Exam e1 = new MathExam();
        Exam e2 = new ScienceExam();
        
        e1.result();
        e2.result();
    }
}

✅ Output:
Math exam result published  
Science exam result published


Q7. Printer Example
class Printer {
    void print() {
        System.out.println("Printing...");
    }
}

class InkjetPrinter extends Printer {
    void print() {
        System.out.println("Inkjet Printer printing...");
    }
}

class LaserPrinter extends Printer {
    void print() {
        System.out.println("Laser Printer printing...");
    }
}

public class Main {
    public static void main(String[] args) {
        Printer p1 = new InkjetPrinter();
        Printer p2 = new LaserPrinter();
        
        p1.print();
        p2.print();
    }
}

✅ Output:
Inkjet Printer printing...  
Laser Printer printing...


Q8. Bank Interest Calculation
class Bank {
    void interestRate() {
        System.out.println("General interest rate");
    }
}

class SBI extends Bank {
    void interestRate() {
        System.out.println("SBI Interest Rate = 6%");
    }
}

class ICICI extends Bank {
    void interestRate() {
        System.out.println("ICICI Interest Rate = 7%");
    }
}

public class Main {
    public static void main(String[] args) {
        Bank b1 = new SBI();
        Bank b2 = new ICICI();
        
        b1.interestRate();
        b2.interestRate();
    }
}

✅ Output:
SBI Interest Rate = 6%  
ICICI Interest Rate = 7%


Q9. Media Player
class MediaPlayer {
    void play() {
        System.out.println("Playing media...");
    }
}

class AudioPlayer extends MediaPlayer {
    void play() {
        System.out.println("Playing audio...");
    }
}

class VideoPlayer extends MediaPlayer {
    void play() {
        System.out.println("Playing video...");
    }
}

public class Main {
    public static void main(String[] args) {
        MediaPlayer m1 = new AudioPlayer();
        MediaPlayer m2 = new VideoPlayer();
        
        m1.play();
        m2.play();
    }
}

✅ Output:
Playing audio...  
Playing video...


Q10. Calculator (Method Overloading)
👉 Compile-time polymorphism
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("Sum of 2 numbers: " + c.add(5, 10));
        System.out.println("Sum of 3 numbers: " + c.add(5, 10, 15));
    }
}

✅ Output:
Sum of 2 numbers: 15  
Sum of 3 numbers: 30



Great 👍 Now let’s step up and move to 10 medium-level polymorphism questions (mix of method overloading + method overriding + real-world type casting + abstract classes).

🔹 10 Medium-Level Polymorphism Questions with Answers

Q1. Overloading with Different Parameters
class AreaCalculator {
    int area(int side) {  // square
        return side * side;
    }
    int area(int l, int b) { // rectangle
        return l * b;
    }
}

public class Main {
    public static void main(String[] args) {
        AreaCalculator ac = new AreaCalculator();
        System.out.println("Square area: " + ac.area(5));
        System.out.println("Rectangle area: " + ac.area(4, 6));
    }
}


Q2. Overloading with Different Data Types
class Printer {
    void print(String msg) {
        System.out.println("String: " + msg);
    }
    void print(int num) {
        System.out.println("Integer: " + num);
    }
}

public class Main {
    public static void main(String[] args) {
        Printer p = new Printer();
        p.print("Hello");
        p.print(100);
    }
}


Q3. Overriding Example
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog(); // runtime polymorphism
        a.sound();
    }
}


Q4. Overloading Constructors
class Student {
    String name;
    int age;

    Student(String n) {
        name = n;
        age = 18; // default
    }
    Student(String n, int a) {
        name = n;
        age = a;
    }

    void show() {
        System.out.println(name + " - " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Ravi");
        Student s2 = new Student("Priya", 22);
        s1.show();
        s2.show();
    }
}


Q5. Method Overriding with Superclass Reference
class Vehicle {
    void move() {
        System.out.println("Vehicle is moving");
    }
}

class Car extends Vehicle {
    void move() {
        System.out.println("Car is driving");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Car(); // runtime polymorphism
        v.move();
    }
}


Q6. Abstract Class with Polymorphism

abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square extends Shape {
    void draw() {
        System.out.println("Drawing Square");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Square();
        s1.draw();
        s2.draw();
    }
}


Q7. Method Overloading with Type Promotion

class Test {
    void show(int a, double b) {
        System.out.println("int, double");
    }
    void show(double a, int b) {
        System.out.println("double, int");
    }
}

public class Main {
    public static void main(String[] args) {
        Test t = new Test();
        t.show(10, 20.5);
        t.show(20.5, 10);
    }
}


Q8. Polymorphism in Banking Example

class Bank {
    double getRateOfInterest() {
        return 0;
    }
}

class SBI extends Bank {
    double getRateOfInterest() {
        return 7.5;
    }
}

class HDFC extends Bank {
    double getRateOfInterest() {
        return 8.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank b1 = new SBI();
        Bank b2 = new HDFC();
        System.out.println("SBI ROI: " + b1.getRateOfInterest());
        System.out.println("HDFC ROI: " + b2.getRateOfInterest());
    }
}


Q9. Method Overriding with Upcasting
class Employee {
    void role() {
        System.out.println("General Employee");
    }
}

class Developer extends Employee {
    void role() {
        System.out.println("Writes Code");
    }
}

class Tester extends Employee {
    void role() {
        System.out.println("Tests Software");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Developer();
        Employee e2 = new Tester();
        e1.role();
        e2.role();
    }
}


Q10. Polymorphism with Arrays

class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Meow");
    }
}

class Cow extends Animal {
    void sound() {
        System.out.println("Moo");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat(), new Cow()};
        for (Animal a : animals) {
            a.sound();
        }
    }
}




Got it 👍
 Let’s start simple with 10 easy inheritance questions in Java. These will help you clearly understand base (parent) and derived (child) class relationships before moving to harder problems.

🔹 10 Easy Inheritance Questions (with Answers)

Q1. Single Inheritance
Create a class Person with name and age. Inherit it in Student class and display details.
✅ Answer:
class Person {
    String name;
    int age;
}

class Student extends Person {
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Ravi";
        s.age = 20;
        s.display();
    }
}


Q2. Inheritance with Method
Create Animal class with sound() method. Inherit Dog and Cat.
✅ Answer:
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
        Cat c = new Cat();
        c.sound();
    }
}


Q3. Vehicle Example
Create Vehicle class with brand, and inherit Car with model.
✅ Answer:
class Vehicle {
    String brand = "Toyota";
}

class Car extends Vehicle {
    String model = "Fortuner";
    void show() {
        System.out.println("Brand: " + brand + ", Model: " + model);
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.show();
    }
}


Q4. Teacher & Subject
Create a base class Teacher. Inherit MathTeacher.
✅ Answer:
class Teacher {
    void teach() {
        System.out.println("Teaching...");
    }
}

class MathTeacher extends Teacher {
    void teachMath() {
        System.out.println("Teaching Mathematics");
    }
}

public class Main {
    public static void main(String[] args) {
        MathTeacher m = new MathTeacher();
        m.teach();
        m.teachMath();
    }
}


Q5. Employee Example
Create Employee class with salary. Inherit Manager and print bonus.
✅ Answer:
class Employee {
    double salary = 30000;
}

class Manager extends Employee {
    double bonus = 10000;
    void show() {
        System.out.println("Salary: " + salary + ", Bonus: " + bonus);
    }
}

public class Main {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.show();
    }
}


Q6. Multilevel Inheritance
Create classes Animal -> Mammal -> Human.
✅ Answer:
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Mammal extends Animal {
    void walk() {
        System.out.println("Mammal walks");
    }
}

class Human extends Mammal {
    void speak() {
        System.out.println("Human speaks");
    }
}

public class Main {
    public static void main(String[] args) {
        Human h = new Human();
        h.eat();
        h.walk();
        h.speak();
    }
}


Q7. Sports Example
Create Sports class and inherit Cricket.
✅ Answer:
class Sports {
    void play() {
        System.out.println("Playing a sport");
    }
}

class Cricket extends Sports {
    void playCricket() {
        System.out.println("Playing Cricket");
    }
}

public class Main {
    public static void main(String[] args) {
        Cricket c = new Cricket();
        c.play();
        c.playCricket();
    }
}


Q8. Library Example
Create Book class with title, inherit EBook with size.
✅ Answer:
class Book {
    String title = "Java Basics";
}

class EBook extends Book {
    int sizeMB = 5;
    void show() {
        System.out.println("Title: " + title + ", Size: " + sizeMB + "MB");
    }
}

public class Main {
    public static void main(String[] args) {
        EBook e = new EBook();
        e.show();
    }
}


Q9. Shop Example
Create Shop with name, inherit ClothingShop with type.
✅ Answer:
class Shop {
    String name = "ABC Store";
}

class ClothingShop extends Shop {
    String type = "Clothing";
    void show() {
        System.out.println("Shop: " + name + ", Type: " + type);
    }
}

public class Main {
    public static void main(String[] args) {
        ClothingShop cs = new ClothingShop();
        cs.show();
    }
}


Q10. Bank Account
Create Account class with balance. Inherit SavingsAccount with interest.
✅ Answer:
class Account {
    double balance = 5000;
}

class SavingsAccount extends Account {
    double interestRate = 0.05;
    void calculateInterest() {
        System.out.println("Interest: " + (balance * interestRate));
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount();
        sa.calculateInterest();
    }
}




