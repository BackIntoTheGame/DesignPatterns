package CreationalPatterns;

/*** if you want a fluent builder to propagate
 * across inheritance hierarchy, you need to
 * have recursive generic definitions.
 *
 * Answer: give them a common Builder, switch to
 * different builder by method calls, thereby maintaining
 * a fluent builder mechanism.
 */
public class FluentBuilderInheritanceDmo {
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        Person person = pb.withName("Dmitri")
                .worksAt("Developer")
                .build();
        /* * Houston! we've got a problem:
         * after calling withName method,
         * you can't call worksAt method,
         * b/c the "Type" is PersonBuilder.
         */
        System.out.println(person);
    }
}

class Person{
    public String name;
    public String position;

    @Override
    public String toString() {

        return "Person{"+
                "name = '"+name+'\''+
                ", position ='" + position +'\''
                +'}';
    }
}

// fix: step #1 added Generic class
//class  PersonBuilder{
    // to RECURSIVE GENERIC.
class PersonBuilder<SELF extends  PersonBuilder<SELF>>{
    protected Person person = new Person();

    // fix step #3 change the return type
//    public PersonBuilder withName(String name){
    public SELF withName(String name){
        person.name = name;
        return self();
    }

    //
    public Person build(){
        return person;
    }

    // FIX step #4
    protected SELF self(){
        return (SELF) this;
    }
}

// fix step #1
//class EmployeeBuilder extends PersonBuilder{
class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{
    public EmployeeBuilder worksAt(String position){
        person.position = position;
        return self();
    }

    // fix step #5

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}