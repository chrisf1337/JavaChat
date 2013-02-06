import java.io.*;

public class JavaChatHandler
{
    public JavaChatHandler()
    {
        
    }
    
    public void input()
    {
        System.out.println("Enter your name:");
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        String username = null;
        try 
        {
            username = br.readLine();
        } 
        catch(IOException e)
        {
            System.out.println("Error reading name");
            e.printStackTrace();
        }
        
        System.out.println("Your name is " + username);
    }
}
