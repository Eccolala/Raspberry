package BasicSocket;

import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String args[]) throws Exception {
        //为了简单起见，所有的异常都直接往外抛
        String hostName = "localhost";  //要连接的服务端IP地址
        int portNumber = 8899;   //要连接的服务端对应的监听端口
        //与服务端建立连接
        Socket client = new Socket(hostName, portNumber);
        //建立连接后就可以往服务端写数据了
        PrintWriter writer = new PrintWriter(client.getOutputStream());
        writer.write("10010001");
        writer.flush();//写完后要记得flush
        writer.close();
        client.close();
    }

}