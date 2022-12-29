package Examples;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        address = InetAddress.getByName("www.vk.com");
        System.out.println(address);
        System.out.println(address.getHostName());

        /*InetAddress addresses[] = InetAddress.getAllByName("www.google.com");
        for (int i = 0; i < addresses.length; i++) {
            System.out.println(addresses[i]);;
        }*/

    }

}
