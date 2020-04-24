package CreationalPatterns.prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class CopyThrSerialization {
    public static void main(String[] args) {
        Foo life = new Foo(42, "life");
        Foo duh = SerializationUtils.roundtrip(life);

        duh.stuff = 321;
        duh.whatever = "okay";

        System.out.println(life);
        System.out.println(duh);
    }
}

class Foo implements Serializable{
    public int stuff;
    public String whatever;

    public Foo(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "stuff=" + stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}