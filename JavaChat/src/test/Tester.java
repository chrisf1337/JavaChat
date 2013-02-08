package test;
import javachat.JavaChatClient;

public class Tester
{
    public static void main(String[] args)
    {
        JavaChatClient client = new JavaChatClient();
        String input = "";
        while(!input.equals("quit"))
        {
            input = client.getInput();
            client.setText(input);
            client.sendMessage(input);
        }
        System.exit(0);
    }
}
