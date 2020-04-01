package CreationalPatterns;
// Problem: use multiple builder to build one particular object

public class FacetedBuilderDemo {
    public static void main(String[] args) {
        PersonBuilder2 pb = new PersonBuilder2();
        Person2 person = pb
                .lives()
                    .at("123 London Road")
                    .in("London")
                    .withPostcode("SW12BC")
                .works()
                    .at("Fabrikam")
                    .asA("Engineer")
                    .earning(1230000)
                .build();
        System.out.println(person);
    }
}

class Person2{
    // address
    public String streetAddress, postcode, city;

    // employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person2{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

// ********* we want different builder for address part and employment part.

// builder facade
class PersonBuilder2{
    protected Person2 person2 = new Person2();

    public PersonAddressBuilder lives(){
        return  new PersonAddressBuilder(person2);
    }

    public PersonJobBuilder works(){
        return new PersonJobBuilder(person2);
    }

    public Person2 build(){
        return person2;
    }
}

class PersonAddressBuilder extends PersonBuilder2{
    public PersonAddressBuilder(Person2 person2){
        this.person2 = person2;
    }

    public PersonAddressBuilder at(String streetAddress){
        person2.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostcode(String postcode){
        person2.postcode = postcode;
        return  this;
    }

    public PersonAddressBuilder in(String city){
        person2.city = city;
        return  this;
    }
}

class PersonJobBuilder extends PersonBuilder2{
    public PersonJobBuilder(Person2 person2){
        this.person2 = person2;
    }

    public PersonJobBuilder at(String companyName){
        person2.companyName = companyName;
        return  this;
    }

    public PersonJobBuilder asA(String position){
        person2.position = position;
        return this;
    }

    public PersonJobBuilder earning(int annualIncome){
        person2.annualIncome = annualIncome;
        return this;
    }
}