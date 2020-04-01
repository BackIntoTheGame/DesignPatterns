package CreationalPatterns;

import java.util.HashMap;

public class Exercise {
    public static void main(String[] args) {
        CodeBuilder1 cb = new CodeBuilder1("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }

}

class CodeBuilder1
{
    public String className;
    public HashMap<String, String> fields = new HashMap<>();
    public CodeBuilder1(String className)
    {
        // todo
        this.className = className;
    }

    public CodeBuilder1 addField(String name, String type)
    {
        // todo
        fields.put(name, type);
        return this;
    }

    @Override
    public String toString()
    {
        // todo
        StringBuilder sb = new StringBuilder();
        sb.append("public class " + className).append("\n{");
        fields.forEach((k,v) -> {
            sb.append("\n   public ").append(v).append(" ").append(k).append(";");});
        sb.append("\n{\n");

        return sb.toString();
    }
}