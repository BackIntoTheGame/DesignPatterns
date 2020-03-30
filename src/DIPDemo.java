import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

/** DIP: Dependency Inversion Principle
 * Definition :
 *  A. High-level modules should not depend on low-level module.
 *  Both should depend on abstractions.
 *
 *  ???? what is high-level or low-level? Line #29
 *
 *  B. Abstractions should not depend on details.
 *  Details should depend on abstractions.
 *
 *  Abstractions are either abstract Class or interface.
 *
 */
public class DIPDemo {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent,child1);
        relationships.addParentAndChild(parent,child2);

        new Research(relationships);
        /** Problem:
         * Relationships class is a low-level module.
         * b/c it's related to data-storage, and gives us access to it.
         *
         * Research class is a high-level module
         * b/c it allows us to perform some actions on the low-level constructs.
         * The problem is Research constructor takes a low-level module
         * Relationship as a dependency, violating the DIP!!!!
         */
    }
}

enum Relationship{
    PARENT,
    CHILD,
    SIBLING
}

class Person
{
    public String name;
    // dob, nationality


    public Person(String name) {
        this.name = name;
    }
}

class Relationships implements RelationshipBrowser{
    private List<Triplet<Person, Relationship,Person>>
    relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child){
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    // FIX Step2 ===================================
    @Override
    public List<Person> findAllChildrenOf(String name) {
       // find all the children of parents who named "John"
        return         relations.stream().filter(x -> Objects.equals(x.getValue0().name, name)
                       && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}

class Research{
 /*   public Research(Relationships relationships){
        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();

        // find all the children of parents who named "John"
        relations.stream().filter(x -> x.getValue0().name.equals("John")
        && x.getValue1() == Relationship.PARENT)
                .forEach(ch -> System.out.println(
                        "John has a child called " + ch.getValue2().name
                ));
    }
*/
    // Fix Step 3 =========================
    // Now if you have anything to change in low-level module saying Relationships class
    // the How level module won't need to change anything.
    public Research(RelationshipBrowser browser){
        List<Person> children = browser.findAllChildrenOf("John");
        for(Person child : children){
            System.out.println("John has a child called: " + child.name);
        }
    }
}

// Fix Step 1 ================================\
interface RelationshipBrowser{
    List<Person> findAllChildrenOf(String name);
}