package main.java.de.arkadi.classloader.manifest;

public class Main {
    public static void main(String[] args) {
        IPrint print = new ImplPrint();
        print.print();
    }
}


// javac -d bin/classes/ -sourcepath src $(find . -name *.java)
// search needed types in src for file compilation found with java extenssion
// jar -cvfe Appication.jar Main $(find . -name *.class)
// create a jar with main class "Main"
// jar -cf lib/Print.jar -C bin/classes/ de/arkadi/ImplPrint.class && cd ../..
// jar -cfe lib/Application.jar  Main -C bin/classes $(find . -name *.class)
// 188 > java -cp lib/Print.jar:lib/Application.jar de.arkadi.Main
// jar -cf lib/Resource.war -C lib/ Print.jar
// jar -cfe lib/Test.jar  Main -C bin/classes .
// jar cvf MyJar.jar *.properties lib/*.jar -C bin .
// jar -cfe lib/Full.jar de.arkadi.Main -C src/main/java/ .
// jar -cf lib/Print.jar -C bin/classes/ de/arkadi/ImplPrint.class
// java -jar Application.jar dann brauchst du die main classe nicht angeben 
// jar -cfe ./lib/LocalApplication.jar de.arkadi.classloader.local.Main -C bin/classes/ de/arkadi/local/
// !  jar --create --file classes.jar Foo.class Bar.class == -cf
// jar --create --file foo.jar --main-class com.foo.Main
// jar cfe lib/partial/PartApplication.jar de.arkadi.classloader.local.Main -C bin/classes/ de/arkadi/local/Main.class -C bin/classes/ de/arkadi/local/IPrint.class
// java -cp bin/classes/:lib/partial/PartPrint.jar de.arkadi.classloader.local.Main
// jar -cfm lib/manifest/MaApplication.jar src/main/resources/MANIFEST.MF -C bin/classes/ de/arkadi/local/IPrint.class -C bin/classes/ de/arkadi/local/Main.class
// Manifest.txt is renamed by creating a jar into MANIFEST.MF
// javac -d bin/classes/ -sourcepath src src/main/java/remote-manifest/*
