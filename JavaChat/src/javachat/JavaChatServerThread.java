package javachat;
import java.io.*;
import java.net.*;

public class JavaChatServerThread extends Thread
{
    private Socket socket = null;
    
    public JavaChatServerThread(Socket socket)
    {
        super("JavaChatServerThread");
        this.socket = socket;
    }
    
    public void run()
    {
        try
        {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            String s;
            while(!(s = in.readLine()).equals("/quit"))
            {
                out.println("SERVER MESSAGE:" + s);
            }
            
            System.err.println("Closing connection");
            out.close();
            in.close();
            socket.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
