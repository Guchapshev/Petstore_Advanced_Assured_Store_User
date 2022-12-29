package Examples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketExample {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("whois.internic.net", 43);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        String request = "google.com\n";
        byte buffer[] = request.getBytes(StandardCharsets.UTF_8);

        outputStream.write(buffer);

        int c;
        while ((c = inputStream.read()) != -1) {
            System.out.print((char) c);
        }

        socket.close();

    }

}
