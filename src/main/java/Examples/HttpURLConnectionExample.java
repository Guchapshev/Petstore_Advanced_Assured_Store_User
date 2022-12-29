package Examples;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLConnectionExample {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://google.ru");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        System.out.println(connection.getRequestMethod());

        System.out.println(connection.getResponseCode());

        System.out.println(connection.getResponseMessage());

        Map<String, List<String>> headersMap = connection.getHeaderFields();

        Set<String> headerFields = headersMap.keySet();

        for (String str: headerFields) {
            System.out.println("Ключ: " + str + "  Значение: " + headersMap.get(str));
        }

    }

}
