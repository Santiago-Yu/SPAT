package step2;

import java.io.OutputStream;
import java.net.Socket;

public class Client {
	private Socket socket;
	private OutputStream socketOutputStream;
	public void start() {
		try {
			socket = new Socket("localhost",6000);
			/********** Begin *********/
            socketOutputStream = socket.getOutputStream();
            socketOutputStream.write("I am Client!".getBytes());


			/********** End *********/
			socket.shutdownOutput();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void stop() {
		try{
			socket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
