import java.util.*;

class carSpeed{
    String speed;
}

class carSpeedImplementation{
    public String setCarSpeed(carSpeed sp,int spd){
        try{
        if(spd<30 || spd>90){
            throw new SpeedInvalidException("Exception in speed validation");
        }else{
            sp.speed="Valid";
        }
        }
        catch(SpeedInvalidException ex){
            sp.speed=ex.getMessage();
        }
        return sp.speed;
    }
}

class SpeedInvalidException extends Exception{
    public SpeedInvalidException(String msg){
        super(msg);
    }
}


class main{
    public static void main(String[] args){
        carSpeed s=new carSpeed();
        carSpeedImplementation car=new carSpeedImplementation();
        System.out.println(car.setCarSpeed(s,78));
    }
}












import java.util.*;
import java.util.stream.Collectors;

class Model {
    String modelName;
    int carSpeed;

    public Model(String modelName, int carSpeed) {
        this.modelName = modelName;
        this.carSpeed = carSpeed;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return "Model[ModelName=" + modelName + ", CarSpeed=" + carSpeed + "]";
    }
}

class Implementation {
    public List<String> getModelName(List<Model> list) {
        return list.stream()
                   .map(Model::getModelName)
                   .collect(Collectors.toList());
    }

    public Model getModelInfo(List<Model> list, String model, int speed) {
        return list.stream()
                   .filter(m -> m.getModelName().equals(model) && m.getCarSpeed() == speed)
                   .findFirst()
                   .orElse(null); // safer than .get()
    }
}

public class Main {
    public static void main(String[] args) {
        List<Model> list = new ArrayList<>();
        list.add(new Model("SUV", 500));
        list.add(new Model("SEDAN", 800));

        Implementation impl = new Implementation();

        // Print all model names
        System.out.println("Model Names: " + impl.getModelName(list));

        // Find specific model info
        Model found = impl.getModelInfo(list, "SUV", 800);
        System.out.println("Found: " + found);
    }
}































class StringPlay {
    int convert;
    int max;

    public StringPlay() {
        // default constructor
    }
}

class StringMethods {
    public int convertToInt(StringPlay sp, String s) {
        int x = Integer.parseInt(s);
        sp.convert = x;   // assign to field
        return sp.convert; // return integer value
    }

    public int getMax(StringPlay sp, String str, char ch) {
        char[] s = str.toCharArray();
        int total = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ch) {
                total++;
            }
        }
        sp.max = total;
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        StringMethods sm = new StringMethods();
        StringPlay sp = new StringPlay();

        System.out.println(sm.getMax(sp, "fgfgfg", 'g'));   // counts 'g'
        System.out.println(sm.convertToInt(sp, "123"));     // converts string to int
    }
}


class Repo {
    static String getCountryName(String countryCode) throws InvalidException {
        int x = Integer.parseInt(countryCode);

        if (x >= 70 && x <= 99) {
            return "India";
        } else if (x == 908) {
            return "US";
        } else if (x == 1) { // 001 becomes 1 after parsing
            return "Some Where";
        } else {
            throw new InvalidException("No country");
        }
    }
}

class RepoImp {
    public static String getCountry(String countryCode) throws InvalidException {
        if (countryCode.length() > 3 || countryCode.length() < 2) {
            throw new InvalidException("Invaliacd code"); // fixed syntax
        } else {
            return Repo.getCountryName(countryCode);
        }
    }
}

class InvalidException extends Exception {
    public InvalidException(String msg) {
        super(msg);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            RepoImp obj = new RepoImp();
            System.out.println(obj.getCountry("78"));   // India
            System.out.println(obj.getCountry("908"));  // US
            System.out.println(obj.getCountry("001"));  // Some Where
            System.out.println(obj.getCountry("500"));  // throws InvalidException
        } catch (InvalidException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}











import java.util.*;

class Almanac {
    HashMap<String, ArrayList<String>> projects = new HashMap<>();

    public String assignProject(String name, String project) {
        if (!(projects.containsKey(name))) {
            ArrayList<String> list = new ArrayList<>();
            list.add(project);
            projects.put(name, list);
        } else {
            ArrayList<String> n = projects.get(name);
            n.add(project);
            projects.put(name, n);
        }
        return "Project Assigned";
    }

    public ArrayList<String> currentProject(String name) {
        if (projects.containsKey(name)) {
            ArrayList<String> list = projects.get(name);
            if (list.size() == 0) {
                return null;
            } else {
                return list;
            }
        }
        return null;
    }

    public String finishProject(String name, String project) {
        if (projects.containsKey(name)) {
            ArrayList<String> s = projects.get(name);
            s.remove(project);
            projects.put(name, s);
        } else {
            return "Not Found";
        }
        return "Project Finished";
    }
}

public class Main {
    public static void main(String[] args) {
        Almanac al = new Almanac();
        System.out.println(al.assignProject("Agent 47", "Mission 20891"));
        System.out.println(al.assignProject("Agent 13", "Mission 2881"));

        System.out.println(al.currentProject("Agent 47"));
        System.out.println(al.finishProject("Agent 47", "Mission 20891"));
        System.out.println(al.currentProject("Agent 47"));
    }
}













import java.util.ArrayList;
import java.util.List;

class Dish {
    String dishName;

    public Dish(String dishName) {
        this.dishName = dishName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public String toString() {
        return "Dish [dishName=" + dishName + "]";
    }
}

class DishTest {
    public List<Dish> addYummy(List<Dish> list) {
        List<Dish> dishList = new ArrayList<>();
        for (Dish d : list) {
            Dish dish = new Dish("Yummy: " + d.getDishName());
            dishList.add(dish);
        }
        return dishList;
    }

    public long count(List<Dish> list, String s) {
        long count = 0;
        for (Dish d : list) {
            if (d.getDishName().contains(s)) {
                count++;
            }
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        DishTest dt = new DishTest();
        List<Dish> list = new ArrayList<>();
        list.add(new Dish("Gazpacho"));
        list.add(new Dish("Tamon"));
        list.add(new Dish("Tortilla"));
        list.add(new Dish("Tamon"));

        System.out.println(dt.addYummy(list));
        System.out.println(dt.count(list, "5"));
    }
}




import java.util.List;
import java.util.Arrays;

class Employee {
    public String name;
    public String projectName;
    public int workingHrs;
    public int bonus;

    public Employee(String name, String projectName, int workingHrs) {
        this.name = name; 
        this.projectName = projectName;
        this.workingHrs = workingHrs;
    }

    public String setBonus() {
        List<String> list = Arrays.asList("web", "tech", "hack", "SD", "PD");
        if (list.contains(projectName) && workingHrs >= 30) {
            bonus = workingHrs / 10;
            return "congrats";
        } else {
            return "Work hard";
        }
    }

    public String checkName() {
        if (name.equals("doselect")) {
            return projectName + workingHrs;
        } else {
            return projectName + bonus;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("doselect", "hack", 45);
        System.out.println(employee.setBonus());
        System.out.println(employee.checkName());
    }
}





import java.util.*;

class string{
    
    public ArrayList<String> changeOccurance(ArrayList<String> a, String m, String n) {
        ArrayList<String> res = new ArrayList<>();
        for (String x : a) {
            if (x.equals(m)) {
                res.add(n);
            } else {
                res.add(x);
            }
        }
        return res;
    }
    
    public String listIndex(ArrayList<String> list) {
        return list.get(0);  // ✅ fixed: must return a String
    }
    
    public ArrayList<String> listAfter(ArrayList<String> a, String m, String n) {
        ArrayList<String> res = new ArrayList<>();
        a.add(a.indexOf(m) + 1, n);
        for (int i = 0; i < a.size(); i++) {
            res.add(a.get(i));
        }
        return res;
    }
}

public class Main{   // ✅ renamed to avoid conflict with Main
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        
        Main m = new Main();
        System.out.println(m.changeOccurance(list, "c", "s"));   // replaces "c" with "s"
        System.out.println(m.listIndex(list));                   // prints first element
        System.out.println(m.listAfter(list, "d", "f"));         // inserts "f" after "d"
    }
}





import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {   // ✅ fixed method name
        return age;
    }
    public void setAge(int age) {   // ✅ fixed method name
        this.age = age;
    }
}

class StreamImplementation {
    public int sumAge(List<Person> list) {
        return list.stream()
                   .filter(p -> p.getAge() > 50)
                   .mapToInt(Person::getAge)   // ✅ fixed mapToInt
                   .sum();
    }

    public List<String> printName(List<Person> list) {
        return list.stream()
                   .map(Person::getName)
                   .collect(Collectors.toList());
    }

    public List<Integer> printAge(List<Person> list) {
        return list.stream()
                   .map(Person::getAge)
                   .collect(Collectors.toList());
    }
}

public class Main {   // ✅ fixed class name
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person perry = new Person("Perry", 20);
        Person ferry = new Person("Ferry", 52);
        Person katty = new Person("Katty", 100);
        Person elly = new Person("Elly", 10);

        list.add(perry);
        list.add(ferry);
        list.add(katty);
        list.add(elly);

        StreamImplementation st = new StreamImplementation();
        System.out.println(st.sumAge(list));     // sum of ages > 50
        System.out.println(st.printName(list));  // list of names
        System.out.println(st.printAge(list));   // list of ages
    }
}




import java.util.*;

class Person {
    String name;
    String dob;
    String email;

    public Person(String name, String dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;   // ✅ fixed
    }
}

class Implementation {
    public String validator(Person details) throws Exception {
        String[] s = details.dob.split("-");   // ✅ fixed
        int year = Integer.parseInt(s[2]);     // ✅ parse year

        if (year >= 2000) {
            throw new InvalidDateException("year must be less than 2000");
        }

        if (!details.email.matches("^[a-zA-Z0-9+_.-]+@doSelect\\.com$")) {  // ✅ fixed regex
            throw new InvalidEmailException("only @doSelect.com domain email are accepted");
        }

        return "Valid details";   // ✅ added return
    }

    public String submitDetails(Person details) {
        try {
            validator(details);
            return "details submitted successfully";
        } catch (InvalidDateException e) {
            return "Invalid details: " + e.getMessage();
        } catch (InvalidEmailException e) {
            return "Invalid details: " + e.getMessage();
        } catch (Exception e) {
            return "Other Exception: " + e.getMessage();
        }
    }
}

class InvalidDateException extends Exception {
    public InvalidDateException(String msg) {
        super(msg);
    }
}

class InvalidEmailException extends Exception {
    public InvalidEmailException(String msg) {
        super(msg);
    }
}

public class Main {
    public static void main(String[] args) {
        Person data = new Person("Steve", "12-02-1998", "Steve12@doSelect.com");
        Implementation obj = new Implementation();

        try {
            System.out.println(obj.validator(data));   // ✅ prints "Valid details"
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        System.out.println(obj.submitDetails(data));   // ✅ prints "details submitted successfully"
    }
}








class SalaryData {
    String name;
    int daysInMonth;
    double salary;

    public SalaryData(String name, int daysInMonth, double salary) {
        this.name = name;
        this.daysInMonth = daysInMonth;
        this.salary = salary;
    }
}

class Validator {

    public String validateSalaryData(SalaryData s) throws InvalidDayException, InvalidSalaryException {
        int days = s.daysInMonth;
        double sal = s.salary;

        if (days != 28 && days != 30 && days != 31) {
            throw new InvalidDayException("Invalid Day");
        } 
        else if (sal < 0 || sal > 1000000) {
            throw new InvalidSalaryException("Invalid Salary");
        } 
        else {
            return "Valid data";
        }
    }

    public double getTotalSalary(SalaryData s) {
        double tot = 0;
        try {
            validateSalaryData(s);
            tot = s.daysInMonth * s.salary;
        } catch (InvalidDayException | InvalidSalaryException e) {
            tot = 0.0;
        }catch(Exception e){
            tot=0.0;
        }
        return tot;
    }
}

// ✅ Custom Exceptions MUST extend Exception
class InvalidDayException extends Exception {
    public InvalidDayException(String msg) {
        super(msg);
    }
}

class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String msg) {
        super(msg);
    }
}

public class Main {
    public static void main(String[] args) {
        SalaryData s = new SalaryData("Steve", 30, 10000);
        Validator val = new Validator();

        try {
            String ans = val.validateSalaryData(s);
            double sal = val.getTotalSalary(s);
            System.out.println(ans);
            System.out.println(sal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}





class Rating {
    int imdb;
    int nominee;

    public Rating(int imdd, int nominee) {
        this.imdb = imdd;      // ✅ fixed
        this.nominee = nominee;
    }
}

class vali {
    public String canBe(Rating rating) throws Exception {
        if (rating.imdb < 7) {
            throw new MovieRateException("movie not eligible");
        } else if (rating.nominee < 4) {
            throw new MovieRateException("minimum 4 required");
        }
        return "Eligible";   // ✅ added return
    }

    public String sendInvite(Rating rating) throws Exception {
        try {
            canBe(rating);
            return "Invited";
        } catch (MovieRateException e) {
            return "Not valid";
        } catch (Exception e) {
            return "Other Exception";
        }
    }
}

class MovieRateException extends Exception {
    public MovieRateException(String msg) {
        super(msg);
    }
}

public class Main {
    public static void main(String[] args) {
        Rating rating = new Rating(9, 7);
        vali v = new vali();

        try {
            String s = v.canBe(rating);
            System.out.println(s.toLowerCase());
        } catch (Exception e) {
            System.out.println(e.getMessage().toLowerCase());
        }

        try {
            String t = v.sendInvite(rating);
            System.out.println(t.toLowerCase());
        } catch (Exception e) {
            System.out.println(e.getMessage().toLowerCase());
        }
    }
}




import java.util.*;

class Student {
    String studentName;
    int studentId;
    int score;
    String scoName;

    public Student(String studentName, int studentId, int score) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.score = score;

        if (score < 90) {
            this.scoName = "no scheme";
        } else if (score >= 90 && score < 95) {
            this.scoName = "scheme b";
        } else {
            this.scoName = "scheme A";
        }
    }

    @Override
    public String toString() {
        return "Student [Name=" + studentName + ", Id=" + studentId + ", Score=" + score + ", Scheme=" + scoName + "]";
    }
}

class Scolar {
    static HashMap<Integer, Student> hm = new HashMap<>();

    static {
        hm.put(111, new Student("alan", 111, 99));
        hm.put(222, new Student("b", 222, 100));
        hm.put(333, new Student("c", 333, 89));
        hm.put(444, new Student("d", 444, 93));
        hm.put(555, new Student("e", 555, 95));
    }

    public void addStudent(Student s) {
        hm.put(s.studentId, s);
    }

    public ArrayList<Student> getStu(String scoName) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student s : hm.values()) {
            if (s.scoName.equals(scoName)) {   // ✅ fixed string comparison
                list.add(s);
            }
        }
        return list;
    }

    public boolean delete(int id) {
        Student s = hm.remove(id);
        return s != null;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Mary", 666, 93);
        Scolar imp = new Scolar();

        imp.addStudent(s);

        System.out.println(imp.getStu("scheme b"));   // prints students in scheme b
        System.out.println(imp.delete(909));          // false (id not found)
    }
}



import java.util.*;

class Book {
    private String bookName;
    private int bookCount;

    public Book(String bookName, int bookCount) {
        this.bookName = bookName;
        this.bookCount = bookCount;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }
}

class BookImple {

    public String getNameOfBooks(List<Book> books) {
        StringBuilder sb = new StringBuilder();
        for (Book b : books) {
            sb.append(b.getBookName())
              .append(" ")
              .append(b.getBookCount())
              .append(", ");
        }
        return sb.toString();
    }

    public int sumCost(List<Book> books) {
        int res = 0;
        for (Book b : books) {
            res += b.getBookCount();
        }
        return res;
    }

    public int getMax(List<Book> books) {
        int max = Integer.MIN_VALUE;
        for (Book b : books) {
            if (b.getBookCount() > max) {
                max = b.getBookCount();
            }
        }
        return max;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Sapiens", 550));
        books.add(new Book("Indies", 400));
        books.add(new Book("Danxer", 100));
        books.add(new Book("Abraham", 250));

        BookImple obj = new BookImple();

        System.out.println(obj.getNameOfBooks(books));
        System.out.println(obj.sumCost(books));
        System.out.println(obj.getMax(books));
    }
}






class Candidate {
    private String name;
    private int totalRating;
    private int totalContest;

    public Candidate(String name, int totalContest, int totalRating) {
        this.name = name;
        this.totalContest = totalContest;
        this.totalRating = totalRating;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public int getTotalContest() {
        return totalContest;
    }
}

class Validator {

    public String eligible(Candidate details) throws CriteriaException {
        if (details.getTotalRating() < 1000) {
            throw new CriteriaException("Minimum rating 1000 required");
        } else if (details.getTotalContest() < 10) {
            throw new CriteriaException("Minimum 10 contests required");
        } else {
            return "Eligible Candidate";
        }
    }

    public String sendInvite(Candidate details) {
        try {
            eligible(details);
            return "Invite sent";
        } catch (CriteriaException e) {
            return "Candidate is not eligible: ";
        }
    }
}

class CriteriaException extends Exception {
    public CriteriaException(String msg) {
        super(msg);
    }
}

public class Main {
    public static void main(String[] args) {

        // Correct order: (name, totalContest, totalRating)
        Candidate data = new Candidate("Steve", 20, 1020);

        Validator check = new Validator();

        try {
            System.out.println(check.eligible(data));
        } catch (CriteriaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(check.sendInvite(data));
    }
}




import java.util.*;
public class Main{
    public int sum(ArrayList<Integer> numbers){
        int sum=0;
        for(Integer i:numbers){
            sum+=i;
        }
        return sum;
    }
    
    public ArrayList<Integer> splitAndReverse(ArrayList<Integer> list){
        ArrayList<Integer> res=new ArrayList<>();
        int pivot;
        if(list.size()/2!=0){
            pivot=list.size()/2+1;
        }else{
            pivot=list.size()/2;
        }
        for(int i=pivot-1;i>=0;i--){
            res.add(list.get(i));
        }
        for(int i=list.size()-1;i>=pivot;i--){
            res.add(list.get(i));
        }
        return res;
    }
    
    public Integer getItemIndex(ArrayList<Integer> list,int index){
        if(index<0 || index>=list.size()){
            return null;
        }
        return list.get(index);
    }
    
    public static void main(String[] args){
        ArrayList<Integer> numbers=new ArrayList<>();
        numbers.add(73);
        numbers.add(24);
        numbers.add(10);
        numbers.add(15);
        numbers.add(5);
        
        Main obj=new Main();
        
        System.out.println(obj.sum(numbers));
        System.out.println(obj.splitAndReverse(numbers));
        System.out.println(obj.getItemIndex(numbers,2));
    }
}




class Product {
    String name;
    double price;
    String coupon;

    public Product(String name, double price, String coupon) {
        this.name = name;
        this.price = price;
        this.coupon = coupon;
    }
}

class Validator {

    public void validateCoupon(Product p) throws InvalidCouponException {

        String[] data = p.coupon.split("-");
        String productName = data[0];
        int discount = Integer.parseInt(data[1]);

        if (!productName.equals(p.name)) {
            throw new InvalidCouponException("Coupon product mismatch");
        }

        if (discount < 10 || discount > 25) {
            throw new InvalidCouponException("Discount must be between 10 and 25");
        }
    }

    public double netPrice(Product p) {
        try {
            validateCoupon(p);

            int discount = Integer.parseInt(p.coupon.split("-")[1]);
            return p.price - (p.price * discount / 100);

        } catch (InvalidCouponException e) {
            return p.price; // no discount
        }
    }
}

class InvalidCouponException extends Exception {
    public InvalidCouponException(String msg) {
        super(msg);
    }
}

public class Main {
    public static void main(String[] args) {

        Product obj = new Product("Iphone", 25000, "Iphone-10");
        Validator val = new Validator();

        try {
            val.validateCoupon(obj);
            System.out.println("Valid coupon");
        } catch (InvalidCouponException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(val.netPrice(obj));
    }
}






import java.util.*;
import java.util.stream.Collectors;

class Vehicle {
    private String name;
    private double price;

    public Vehicle(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Correct getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Correct setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class VehicleImpl {

    // Sum of all vehicle prices
    public Double sumOfPrices(List<Vehicle> list) {
        return list.stream()
                   .mapToDouble(Vehicle::getPrice)
                   .sum();
    }

    // Get vehicle names with price > 25000
    public List<String> getVehicleList(List<Vehicle> list) {
        return list.stream()
                   .filter(v -> v.getPrice() > 25000)
                   .map(Vehicle::getName)
                   .collect(Collectors.toList());
    }

    // Maximum vehicle price
    public double maxPrice(List<Vehicle> list){
        List<Double> prices=list.stream().map(i->i.getPrice()).collect(Collectors.toList());
        double max=0;
        for(Double v:prices){
            if(v>max){
                max=v;
            }
        }
        return max;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Bike", 90000));
        vehicles.add(new Vehicle("Scooter", 45000));
        vehicles.add(new Vehicle("Cycle", 12000));
        vehicles.add(new Vehicle("Car", 800000));

        VehicleImpl impl = new VehicleImpl();

        System.out.println("Sum of prices: " + impl.sumOfPrices(vehicles));
        System.out.println("Vehicles above 25000: " + impl.getVehicleList(vehicles));
        System.out.println("Max price: " + impl.maxPrice(vehicles));
    }
}

import java.util.*;
class main{
    HashMap<String,Integer> empList=new HashMap<>();
    
    public int totalSalary(){
        int total=0;
        for(Integer i:empList.values()){
            total+=i;
        }
        return total;
    }
    
    public String getSalary(String designation){
        if(empList.containsKey(designation)){
            return "Salary is"+empList.get(designation);
        }else{
            return "No designated Salary";
        }
    }
    
    public void updateSalary(String designation,int newSalary){
        empList.put(designation,newSalary);
    }
    
}

public class main{
    public static void main(String[] args) throws Exception{
        Salary obj=new Salary();
        obj.empList.put("CEO",20000);
        obj.empList.put("Developer",10000);
        System.out.println(obj.totalSalary());
        
        obj.updateSalary("Developer",6000);
        System.out.println(obj.getSalary("Developer"));
    }
}





//count of missing alphabets

class Pangram {
    public int minimumAlpha(String str) {

        boolean[] check = new boolean[26];
        int res = 0;
        int ascii = 'a';

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));

            // ensure only alphabets are processed
            if (ch >= 'a' && ch <= 'z') {
                check[ch - ascii] = true;
            }
        }

        // count missing alphabets
        for (int i = 0; i < 26; i++) {
            if (!check[i]) {
                res++;
            }
        }

        return res;
    }
}

public class Main{
    public static void main(String[] args){
        Pangram p=new Pangram();
        System.out.println(p.minimumAlpha("abcdefghijklmnpqrtuvwxyz"));
    }
}
}
