 package main.java.de.arkadi.classloader.classpath.hotdeplyment;


import java.net.URL;
import java.net.URLClassLoader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HotDeploymnet {
    static ClassLoader cl;
    static ServerItf server;

    public static void reloadSerer() throws Exception {
        URL[] urls = new URL[]{new URL("file:./serverclass/")};
        cl = new URLClassLoader(urls);
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
