# Java Design Patterns
Java Design Pattern Learning demos and notes. This is a tutorial from the course "Design Patterns in Java" on Udemy. 

The java source code in "src" folder is java code and notes written by following the tutorial videos. The files in Resource folder is downloaded directly from the Udemy course. 

Below are some extra notes and screenshot:

SOLID Principles:

  => Single Responsibility Principle:
    --> A class should only have one reason to change. 
    --> Separation of concerns - differenct class handling different, independent tasks/problems. 
    
  => Open-closed Principles:
    --> Classes should be open for extension but closed for modification. 
    
  => Liskov Substitution Principle:
    --> You should be able to substitue a subclass for a baseclass. 
    
  => Interface Segregation Principle:
    --> Don't put too much into an interface; split into separtate interfaces. 
    --> YAGNI: You Ain't Gonna Need It. 
    
  => Dependency Inversion Principle:
    --> Hign-level modules should not depend upon low-level ones; use abstractions(interfaces/ abstract classes. )


<section>
Gamma Categorization
<ol>
  <li>Design Patterns are typicallly split into three categories, which is caaled Gamma Categorization. 
  </li>
  <li>
    Creational Patterns
    <ul>
      <li>Deal with the creation (construction) of objects.</li>
      <li>Explicit (constructor) vs. implicit (DI, reflection, etc)</li>
      <li>Wholesale (single statement) vs. piecewise (step-by-step)</li> 
    </ul>
  </li>
  <li>
    Structural Patterns
    <ul>
      <li>Concerned with the structure. (e.g., class members)</li>
      <li>Many patterns are wrappers that mimic the underlying class's interface. </li>
      <li>Stress the importance of good API design. </li> 
    </ul>
  </li>
  
  <li>
    Behavioral Patterns
    <ul>
      <li>They are all different; no central theme. </li>
    </ul>
  </li>
  </ol>
  </section>
  
  <section>
  Builder: When piecewise object construction is complicated, provide an API for doing it succinctly. 
  </section>
