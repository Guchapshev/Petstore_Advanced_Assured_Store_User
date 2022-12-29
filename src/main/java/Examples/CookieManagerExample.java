package Examples;

import java.net.CookieManager;
import java.net.HttpCookie;

public class CookieManagerExample {

    public static void main(String[] args) {

        CookieManager manager = new CookieManager();
        HttpCookie cookie = new HttpCookie("newCookie", "value");

    }

}
