package person.liuxx.learn.code.io.netty.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author
 * 
 * @version 1.0.0<br>
 *          创建时间：2022年3月9日 下午5:53:11
 * 
 * @since 1.0.0
 */
public class TimeServerHandler implements Runnable {
    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(this.socket
                .getInputStream()));
                PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true)) {
            String currentTime = null;
            String body = null;
            while (true) {
                body = in.readLine();
                if (Objects.isNull(body)) {
                    break;
                }
                System.out.println("The time server receive order : " + body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? LocalDateTime.now()
                        .toString() : "BAD ORDER";
                out.println(currentTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
