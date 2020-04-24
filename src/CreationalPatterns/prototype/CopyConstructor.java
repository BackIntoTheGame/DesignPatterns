package CreationalPatterns.prototype;

public class CopyConstructor {

    public static void main(String[] args) {
        Employee john = new Employee("John", new Address2("123 London Rd", "London", "UK"));

        // Employee chris = john
        Employee chris = new Employee(john);
        chris.name = "Chris";
        System.out.println(john);
        System.out.println(chris);
    }
}
 class Address2{
    public String streetAddress, city, country;

     public Address2(String streetAddress, String city, String country) {
         this.streetAddress = streetAddress;
         this.city = city;
         this.country = country;
     }

     public Address2(Address2 other){
         this(other.streetAddress, other.city, other.country);
     }
     @Override
     public String toString() {
         return "Address2{" +
                 "streetAddress='" + streetAddress + '\'' +
                 ", city='" + city + '\'' +
                 ", country='" + country + '\'' +
                 '}';
     }
 }

 class Employee{
    public String name;
    public Address2 address2;

     public Employee(String name, Address2 address2) {
         this.name = name;
         this.address2 = address2;
     }

     public Employee(Employee other){
         name = other.name;
         address2 = new Address2(other.address2);
     }

     @Override
     public String toString() {
         return "Employee{" +
                 "name='" + name + '\'' +
                 ", address2=" + address2 +
                 '}';
     }
 }