package Examples;

import java.net.MalformedURLException;
import java.net.URL;

public class URLExample {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://google.com");
        System.out.println(url.getProtocol());
        System.out.println(url.getPort());
        System.out.println(url.getHost());
    }

}
