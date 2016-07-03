package BasicSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class Server {

    public static void main(String args[]) throws IOException {
        //为了简单起见，所有的异常信息都往外抛
        int port = 8899;


        /**
         * 方法二　使用BufferdReader
         */
        while (true) {
            //定义一个ServerSocket监听在端口8899上
            ServerSocket server = new ServerSocket(port);
            //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
            Socket clientSocket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),"UTF-8"));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
            }

            in.close();
            clientSocket.close();
            server.close();
        }

    }

}
