package Examples;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLConnectionExample {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://google.ru");
        URLConnection connection = url.openConnection();

        long date = connection.getDate();
        if (date != 0) {
            System.out.println(new Date(date));
        } else {
            System.out.println("Сведения о дате отсутствуют");
        }

        System.out.println(connection.getContentType());

        long expiration = connection.getExpiration();
        if (expiration != 0) {
            System.out.println(new Date(expiration));
        } else {
            System.out.println("сведения о сроке действия отсутствуют");
        }

        long lastModified = connection.getLastModified();
        if (lastModified != 0) {
            System.out.println(new Date(lastModified));
        } else {
            System.out.println("сведения о последнем изменении отсутствуют");
        }

        long length = connection.getContentLength();
        if (length != -1) {
            System.out.println(length);
        } else {
            System.out.println("сведения о длине содержимого недоступны");
        }

        if (length != 0) {
            int c;
            InputStream inputStream = connection.getInputStream();
            while ((c = inputStream.read()) != -1) {
                System.out.print((char) c);
            }
            inputStream.close();
        }

    }

}
