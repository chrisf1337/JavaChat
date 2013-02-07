import java.awt.event.*;

import javax.swing.*;

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
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);
        
        userInput = new JTextField(40);
        userInput.addActionListener(this);
        frame.getContentPane().add(userInput);
        
        userInput.requestFocusInWindow();
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        buttonPressed = true;
    }
}
