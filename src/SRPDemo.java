import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// SRP
// Single Responsibility Principle
class Journal{
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text){
        entries.add(""+(++count)+": "+ text);
    }

    public void removeEntry(int index){
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    // violate the SRP
    public void save(String filename) throws FileNotFoundException {
        try(PrintStream out = new PrintStream(filename)){
            out.println(toString());
        }
    }

    public void load(String filename){}
    public void load(URL url){}
}

class Persistence{
    public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
        if(overwrite || new File(filename).exists()){
            try(PrintStream out = new PrintStream(filename)){
                out.println(journal.toString());
            }
        }

    }
}

class SRPDemo{
    public static void main(String[] args) throws Exception{
        Journal j = new Journal();
        j.addEntry("I laughed so hard today.");
        j.addEntry("きょうはいい天気です。");

        System.out.println(j);

        Persistence p = new Persistence();
        String filename ="d:\\journal.txt";
        p.saveToFile(j, filename, true);

        Runtime.getRuntime().exec("notepad.exe "+filename);
    }
}