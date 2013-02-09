package javachat;
import java.net.*;
import java.io.*;

public class JavaChatServer
{
    private ServerSocket server;
    private boolean listening;
    
    public JavaChatServer(int port)
    {
        try
        {
            server = new ServerSocket(port);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        listening = true;
    }
    
    /*
     * Echoes input
     */
    public void serve()
    {
        System.out.println("Starting JavaChatServer");
        try
        {
            while(listening)
                new JavaChatServerThread(server.accept()).start();
            server.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException 
    {
        JavaChatServer server = new JavaChatServer(4444);
        server.serve();
    }
}
