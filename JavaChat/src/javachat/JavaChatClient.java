package javachat;
import java.net.*;
import java.io.*;

public class JavaChatClient
{
    public static final String DEFAULT_ADDRESS = "127.0.0.1";
    public static final int DEFAULT_PORT_NUMBER = 4444;

    private JavaChatUI ui;
    private PrintWriter out;
    private BufferedReader in;
    private Socket socket;
    
    public JavaChatClient()
    {
        this(DEFAULT_ADDRESS, DEFAULT_PORT_NUMBER);
    }

    public JavaChatClient(String address, int port)
    {
        ui = new JavaChatUI();
        ui.setTitle("JavaChat");
        
        openConnection(address, port);
        chat();
    }
    
    public String getInput()
    {
        return ui.getInput();
    }
    
    public void chat()
    {
        String input = "";
        while(!input.equals("/quit"))
        {
            input = getInput();
            addText("<username> " + input);
            sendMessage(input);
        }
        System.exit(0);
    }
    
    public void setText(String text)
    {
        ui.setText(text);
    }
    
    public void addText(String text)
    {
        ui.addText(text);
    }
    
    public void sendMessage(String message)
    {
        out.println(message);
    }
    
    public void openConnection(String address, int port)
    {
        try
        {
            socket = new Socket(address, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        }
        catch(UnknownHostException e)
        {
            System.err.println("Unknown host");
            e.printStackTrace();
            System.exit(1);
        }
        catch(IOException e)
        {
            System.err.println("Unable to get I/O");
            e.printStackTrace();
            System.exit(1);
        }
        
        Thread t = new Thread() 
        {
            public void run()
            {
                try
                {
                    String s;
                    while((s = in.readLine()) != null) 
                    {
                        addText("<%server> " + s);
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        };
        t.start();
    }
    
    public void closeConnection()
    {
        try
        { 
            socket.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}