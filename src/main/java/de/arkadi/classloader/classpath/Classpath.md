Classpath.md

- hotdeploying Java code 
	- update application while it still running 
	- with Classloaders
	- you need it if you  want to deploy new service 
- you can define a Classpath to needed libs, or you can place libs in the ext(extensions) directory of the jre.
	- there are libs which are needed but not part of th e JRE 
	- you need to  compile it with `javac -sourcepath src src/com/arkdai/main.java`
	- wit `java -cp classes -Djava.ext.dirs=c\lib com.arkadi.Main` we set explicitly the extensions directory.

### Classpath
 - can be a directory or a jar file 

## Classloaders 
- from child to parent 
- you want to load the String Class
- every time a Classloader i try to load class it check if the class was previously loaded this one and return the class from the cash.
- a class type in the memory is a singleton. 

### Application Classloader
- Load your classes and classes on the local(machine) class path 
- delegate to the Extension Classloader / ask to load String class
- if Extension Classloader  fail this Classloader will try to load class in its' name-space
- written in Java
 
### Extension Classloader
- Load from Extension directory 
- delegate to the Bootstrap Classloader / ask to load String class
- if Bootstrap Classloader fail, searches for the class in it's name-space for classes
- if it find it it will load else delegate back to the Application Classloader.  
- written in Java

### Bootstrap Classloader 
- He load the bootstrap classes, main classes make up Java runtime form rt.jar 
- with `-x` you can modify the Classloader to append, replace or prepends classes
- load classes like String and delegate down the delegation 
- if no class is found it fail and delegate back extension Classloader
- written in C 



## Classloader Delegation
- print out Classloader hierarchy with Classloader content

```Java
public class Delegation {
	public static void main(String[] args) {
		URLClassloader Classloader = (URLClassloader) Classloader.getSystemClassloader();
		do {
			System.out.println(Classloader);		
            for (URL url : Classloader.getURLs()) {
                System.out.printf("\t %s\n", url.getPath());
            }
        } while ((Classloader = (URLClassloader) Classloader.getParent()) != null);
        System.out.println("Bootstrap Classloader");
	}
}
```

## Own Classloader 

- a Classloader which load a class and print the hash

```Java
public class Main {
	public static void main(String[] args) {
        URL url;
        try {
            url = new URL("file:///c:/demos/lib/quoter.jar");
            URLClassloader ucl = new URLClassloader(new URL[]{url});
            Class clazz = ucl.loadClass("com.mantiso.Quote");
            Object o = clazz.newInstance();
            System.out.println(o.toString());
        } catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
    }
}
```

- a Classloader which can cast loaded class to a type. 
- the interface _IQuote_ and the _Main_ class are inside one jar and the implementation _Quote_ class is load from another Classloader from an other jar. 
- `java -cp client/:interface.jar: com.arkadi.Main` this will put the main class and the interface on the Classpath and run it, but without implementation.
- the implementation is loaded from a specific location by a different Classloader _impl_.


```Java
public class Main {
    public static void main(String[] args) {
        try {
            URL impl = new URL("file:///C:/demos/ClassloadingWithItf/out/artifacts/Implementations_jar/Implementations.jar");
			//URL url = new URL("http://localhost:8080/Implementations.jar");
            URLClassloader ucl = new URLClassloader(new URL[]{impl});
            Class clazz = ucl.loadClass("com.pluralsight.Quote");
            IQuote quote = (IQuote) clazz.newInstance();
            System.out.println(quote.getQuote());
		 } catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
    }
```

- own Classloader can not call method on loaded classes like the classes loaded by the application Classloader.
- we can reference an object but we can not use  methods of the object.
- consequently we can not reference implementation classes.
- to avoid this problem we have to split our code into interfaces and implementations.
- Interface goes into the Classpath and the implementation by our Classloader.
- you can also specify a remote location `URL url = new URL("http://localhost:8080/Implementations.jar");`

## Side by Side Deployment 
- if you work with extensions and need same type with different implementation on the Classpath
- different extension require different version of a class
- so Classloader provide isolation within an application
- two Classloader delegation can provide a class in two flavors/versions
- this classes can be loaded from different directories
- `Class.forName("com.arkadi.Quote",true, urlCls)` loads a class with the urlCls  and want it initialized (static fields are set)
- you can cast every class with same name from different Classloadres  on same interface  
- same classes loaded by different Classloaders are different 

```Java
public class Main {
    public static void main(String[] args) {
        try {
            URL url1 = new URL("file:///C:/demos/ClassloadingWithItf/out/artifacts/Implementations_jar/Implementations.jar");
            URLClassloader ucl1 = new URLClassloader(new URL[]{url1});
            Class clazz1 = Class.forName("com.pluralsight.Quote", true, ucl1);
            IQuote quote1 = (IQuote) clazz1.newInstance();

            URL url2 = new URL("file:///C:/demos/ClassloadingWithItf/out/artifacts/Implementations_jar/Implementations.jar");
            URLClassloader ucl2 = new URLClassloader(new URL[]{url2});
            Class clazz2 = Class.forName("com.pluralsight.Quote", true, ucl2);
            IQuote quote2 = (IQuote) clazz2.newInstance();

            System.out.printf("clazz1 == clazz2? %b\n", clazz1 == clazz2);
            System.out.printf("quote1.class == quote2.class? %b\n", quote1.getClass() == quote2.getClass());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
```


## Hot Deployment 
- for example tomcat do no need to restart if a file is added or updated.

```Java
public class Client {
    static Classloader cl;
    static ServerItf server;

    public static void reloadSerer() throws Exception {
        URL[] urls = new URL[]{new URL("file:./serverclass/")};
        cl = new URLClassloader(urls);
        server  = (ServerItf) cl.loadClass("com.pluralsight.ServerImpl").newInstance();
    }

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        reloadSerer();
        while (true) {
            System.out.print("Enter QUOTE, RELOAD, or QUIT: ");
            String cmdRead = br.readLine();
            String cmd = cmdRead.toUpperCase();
            if (cmd.equals("QUIT")) {
                return;
            } else if (cmd.equals("QUOTE")) {
                System.out.println( server.getQuote());
            } else if (cmd.equals("RELOAD")) {
                reloadSerer();
            }
        }
    }
}

```

## Reflection
- uses meta-data in runtime to get type information about types we using 
- can access methods fields modifiers of a type(class)
- can create instances by calling correct constructor 
- this is reflection, creating an object using its type at runtime rather than discovering its time at runtime.
- this works only with no argument constructor.
```Java
public class Main {

    public static void main(String[] args) throws Exception {
        // reflation
		Class cls = Car.class;
        cls.newInstance();
		// get public methods of type
		Method[] methods=cls.getMethods();
		for(methods method: methods){
			int count = method.getParameterCount();
			System.out.printf("%s %d\n", method.getName() ,count);
		}
	}
```

- show object hierarchy 
```Java
private static void superClasses(Class cls) {
    Class superClass = cls.getSuperclass();
    while(superClass != null){
        System.out.println(superClass.getName());
        superClass = superClass.getSuperclass();
    }
```

- show methods 
```Java
   private static void methodParameters(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        for (Method method: methods){
            System.out.printf("%s", method.getName());
            int count = method.getParameterCount();
            System.out.printf(" (%d) ", count);
            Parameter[] parameters = method.getParameters();
            for (Parameter p : parameters){
                System.out.printf("%s, %s ", p.getName(), p.getType());
            }
            System.out.println();
        }
    }


```

## Inversion of Control
<!-- eventuell übergangn zu java ee (damals gabs noch nicht war zu neu und jetzt ist es da) -->
- With inversion of control you can instantiate objects like you could do with the _new_ operator.
- this code create an object by invoking the constructor and in addition using objects methods.
```java
private static void invokingMethods(Class cls) throws InstantiationException, 
                                                        IllegalAccessException, 
                                                        InvocationTargetException, 
                                                        NoSuchMethodException {
    Constructor[] ctors = cls.getDeclaredConstructors();
    Car car = (Car) ctors[1].newInstance(4);
    //  methods can be overloaded, you have to set parameter types for the given method "drive" 
    Method method = cls.getDeclaredMethod("drive", char.class, int.class);
    // to invoke the method you need to pass the object and the parameters.
    method.invoke(car, 'D', 6);

    method = cls.getDeclaredMethod("print");
    // for static methods you pass null as object,
    method.invoke(null);
    // invoking private methods by setting them as accessible
    method = cls.getDeclaredMethod("accelerate");
    method.setAccessible(true);
    method.invoke(car);
    }
```
- you can also get and set field values of a class 

```java
private static void Fields(Class cls, Car car) throws NoSuchFieldException, IllegalAccessException {
    // set class and create an instance with reflection
    Class cls = Car.class;
    Car car= (Car)cls.newInstance();

    // get field of a class 
    Field f = cls.getDeclaredField("speed");


    // get value of the field
    Object obj = f.get(car);
    System.out.println(obj);


    // set  normally the field
    car.drive('D', 33);
    // observe changes 
    obj = f.get(car);
    System.out.println(obj);


    // set field with reflection
    f.set(car, 44);
    obj = f.get(car);
    System.out.println(obj);


    // get people array
    Field field = cls.getDeclaredField("people");
    // use static array method to set in given array on a special index an object
    Array.set(field.get(car), 1, "Kevin");
    // get the the object of the array people on index 1 and print it. it is the java.reflect.array class 
    Object obj = Array.get(field.get(car), 1);
    System.out.println(obj);

    // get array for strings type, very weired syntax
    Class clazz = String[].class;
    clazz = Class.forName("[Ljava.lang.String;");
    System.out.println(clazz.getName());
}
```




