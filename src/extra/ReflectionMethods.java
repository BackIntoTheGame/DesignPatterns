package extra;

import java.lang.reflect.*;

public class ReflectionMethods {
    public double d;
    public static final int i = 37;
    String s = "testing";

    public ReflectionMethods()
    {
    }

    protected ReflectionMethods(int i, double d)
    {
    }

    public ReflectionMethods(int a, int b)
    {
        System.out.println(
                "a = " + a + " b = " + b);
    }
    public static void main(String args[])
    {
        // simple example
        System.out.println(" \n  **simple example**  \n ");

        try {
            Class c = Class.forName("extra.ReflectionMethods");
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
        }
        catch (Throwable e) {
            System.err.println(e);
        }

       // Simulating the instanceOf Operator
        try {
            Class cls = Class.forName("extra.ReflectionMethods");
            boolean b1
                    = cls.isInstance(new Integer(37));
            System.out.println(b1);
            boolean b2 = cls.isInstance(new ReflectionMethods());
            System.out.println(b2);
        }
        catch (Throwable e) {
            System.err.println(e);
        }

        // Finding Out information About Methods of a Class
        System.out.println(" \n  **Finding Out information About Methods of a Class**  \n ");

        try {
            Class cls = Class.forName("extra.ReflectionMethods");

            Method methlist[] = cls.getDeclaredMethods();

            for (int i = 0; i < methlist.length; i++) {
                Method m = methlist[i];
                System.out.println("name = " + m.getName());
                System.out.println("decl class = " + m.getDeclaringClass());

                Class pvec[] = m.getParameterTypes();
                for (int j = 0; j < pvec.length; j++)
                    System.out.println("param #" + j + " " + pvec[j]);


                Class evec[] = m.getExceptionTypes();
                for (int j = 0; j < evec.length; j++)
                    System.out.println("exc #" + j + " " + evec[j]);

                System.out.println("return type = " + m.getReturnType());
                System.out.println("-----");
            }
        }
        catch (Throwable e) {
            System.err.println(e);
        }


        // Obtaining Information About Constructors
        System.out.println(" \n  **Obtaining Information About Constructors**  \n ");

        try {
            Class cls = Class.forName("extra.ReflectionMethods");

            Constructor ctorlist[] = cls.getDeclaredConstructors();

            for (int i = 0; i < ctorlist.length; i++) {
                Constructor ct = ctorlist[i];
                System.out.println("name = " + ct.getName());
                System.out.println("decl class = " + ct.getDeclaringClass());

                Class pvec[] = ct.getParameterTypes();
                for (int j = 0; j < pvec.length; j++)
                    System.out.println("param #" + j + " " + pvec[j]);

                Class evec[] = ct.getExceptionTypes();
                for (int j = 0; j < evec.length; j++)
                    System.out.println("exc #" + j + " " + evec[j]);
                System.out.println("-----");
            }
        }
        catch (Throwable e) {
            System.err.println(e);
        }

        // Finding Out About Class Fields
        System.out.println(" \n  **Finding Out About Class Fields**  \n ");

        try {
            Class cls = Class.forName("extra.ReflectionMethods");

            Field fieldlist[] = cls.getDeclaredFields();
            for (int i = 0; i < fieldlist.length; i++) {
                Field fld = fieldlist[i];
                System.out.println("name = " + fld.getName());
                System.out.println("decl class = " + fld.getDeclaringClass());
                System.out.println("type = " + fld.getType());


                int mod = fld.getModifiers();
                System.out.println("modifiers = " + Modifier.toString(mod));
                System.out.println("-----");
            }
        }
        catch (Throwable e) {
            System.err.println(e);
        }

        // Invoking Methods by Name
        System.out.println(" \n  **Invoking Methods by Name**  \n ");
        try {
            Class cls = Class.forName("extra.ReflectionMethods");

            Class partypes[] = new Class[2];
            partypes[0] = Integer.TYPE;
            partypes[1] = Integer.TYPE;
            Method meth = cls.getMethod("add", partypes);
            ReflectionMethods methobj = new ReflectionMethods();
            Object arglist[] = new Object[2];
            arglist[0] = new Integer(37);
            arglist[1] = new Integer(47);
            Object retobj = meth.invoke(methobj, arglist);
            Integer retval = (Integer)retobj;
            System.out.println(retval.intValue());
        }
        catch (Throwable e) {
            System.err.println(e);
        }

        System.out.println(" \n  **Creating New Objects**  \n ");
        try {
            Class cls = Class.forName("extra.ReflectionMethods");
            Class partypes[] = new Class[2];
            partypes[0] = Integer.TYPE;
            partypes[1] = Integer.TYPE;
            Constructor ct = cls.getConstructor(partypes);
            Object arglist[] = new Object[2];
            arglist[0] = 37;
            arglist[1] = 47;
            Object retobj = ct.newInstance(arglist);

            System.out.println("A new object is created - " + retobj.toString());
        }
        catch (Throwable e) {
            System.err.println(e);
        }


        System.out.println(" \n  **Changing Values of Fields**  \n ");
        try {
            Class cls = Class.forName("extra.ReflectionMethods");

            Field fld = cls.getField("d");
            ReflectionMethods f2obj = new ReflectionMethods();
            System.out.println("d = " + f2obj.d);
            fld.setDouble(f2obj, 12.34);
            System.out.println("d = " + f2obj.d);
        }
        catch (Throwable e) {
            System.err.println(e);
        }

        System.out.println(" \n  **Using Arrays**  \n ");
        try {
            Class cls = Class.forName(
                    "java.lang.String");
            Object arr = Array.newInstance(cls, 10);
            Array.set(arr, 5, "this is a test");
            String s = (String)Array.get(arr, 5);
            System.out.println(s);
        }
        catch (Throwable e) {
            System.err.println(e);
        }

        int dims[] = new int[]{5, 10, 15};
        Object arr
                = Array.newInstance(Integer.TYPE, dims);

        Object arrobj = Array.get(arr, 3);
        Class cls =
                arrobj.getClass().getComponentType();
        System.out.println(cls);
        arrobj = Array.get(arrobj, 5);
        Array.setInt(arrobj, 10, 37);

        int arrcast[][][] = (int[][][])arr;
        System.out.println(arrcast[3][5][10]);


        System.out.println(" \n refer to: https://www.oracle.com/technical-resources/articles/java/javareflection.html  \n ");
    }


    private int f1(
            Object p, int x) throws NullPointerException
    {
        if (p == null)
            throw new NullPointerException();
        return x;
    }

    public int add(int a, int b)
    {
        return a + b;
    }

}