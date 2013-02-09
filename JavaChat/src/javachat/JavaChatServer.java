package javachat;
import java.net.*;
import java.io.*;

public class JavaChatServer
{
    private ServerSocket server;
    
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
    }
    
    /*
     * Echoes input
     */
    public void serve()
    {
        System.out.println("Starting JavaChatServer");
        try
        {
            while(true)
            {
                Socket client = server.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(
                        client.getOutputStream(), true);
                System.out.println("New connection opened.");
                out.println("Type '/quit' to close.");
                String s;
                while((s = in.readLine()) != null) 
                {
                    System.err.println(s);
                    out.println(s);
                }
                out.close();
                in.close();
                server.close();
            }
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
