package javachat;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.io.*;
import java.util.*;

public class JavaChatUI implements ActionListener
{
    private JFrame frame;
    private boolean buttonPressed;
    private JTextField userInput;
    private JTextArea textArea;
    
    public JavaChatUI()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),
                BoxLayout.PAGE_AXIS));
        
        textArea = new JTextArea(40, 40);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);
        
        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        userInput = new JTextField(40);
        userInput.addActionListener(this);
        frame.getContentPane().add(userInput);
        
        frame.pack();
        userInput.requestFocusInWindow();
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        buttonPressed = true;
    }
    
    public String getInput()
    {
        buttonPressed = false;
        while(!buttonPressed)
        {
            try
            {
                Thread.sleep(1);
            }
            catch(InterruptedException e)
            {
            }
        }
        String input = userInput.getText();
        userInput.setText("");
        return input;
    }
    
    public void setText(String text)
    {
        textArea.setText(text);
    }
    
    public void addText(String text)
    {
        textArea.append(text + "\n");
    }
    
    public void setTitle(String title)
    {
        frame.setTitle(title);
    }
    
    public void getText()
    {
        textArea.getText();
    }
}
