import java.io.* ;
import java.net.* ;
import java.util.* ;

public final class WebServerPartA {
    public static void main(String argv[]) throws Exception {
		int port = 6789;
	
		// Establish the listen socket.
		ServerSocket serverSocket = new ServerSocket(port);
	
		// Process HTTP service requests in an infinite loop.
		while (true) {
	    	// Listen for a TCP connection request.
			Socket connection = serverSocket.accept();
	    
	    	// Construct an object to process the HTTP request message.
	    	HttpRequestPartA request = new HttpRequestPartA(connection);
	    
	    	// Create a new thread to process the request.
	    	Thread thread = new Thread(request);
	    
	    	// Start the thread.
	   		thread.start();
		}
    }
}


 
