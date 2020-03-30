/** ISP: Interface Segregation Principle
 * desc: ISP is basically a recommendation of how to split interfaces
 * YAGNI = You Ain't Going to Need it
 */
public class ISPDemo {
}

class Document{

}

// My interface doing this
interface Machine{
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

// Client #1 wants a multi-functional printer like below
class MultiFunctionPrinter implements Machine{
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

// Another Client #2, wants a old fashioned printer
class OldFashionPrinter implements Machine{
    @Override
    public void print(Document d) {

    }

    //!!! this old fasioned printer doesn't know how to fax or scan
    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

/** to obey the ISP to split the Machine interface */
interface Printer{
    void print(Document d);
}

interface  Scanner{
    void print(Document d);
}
interface Fax{
    void fax(Document d);
}