package person.liuxx.learn.code.io.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * @author
 * 
 * @version 1.0.0<br>
 *          创建时间：2022年3月9日 下午5:33:55
 * 
 * @since 1.0.0
 */
public class TimeServer {
    /**
     * @author
     * 
     * @version 1.0.0<br>
     *          创建时间：2022年3月9日 下午5:33:56
     * 
     * @since 1.0.0
     * 
     * @param args
     */
    public static void main(String[] args) {
        int port = 8080;
        if (Objects.nonNull(args) && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(server)) {
                System.out.println("The time server close !");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server = null;
            }
        }
    }
}
