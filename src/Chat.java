import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class Chat extends JPanel implements ActionListener
{
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private String username;
    private PrintWriter out;
    
    public Chat(String username, PrintWriter out) {
        this.username = username;
        this.out = out;
        
        setLayout(new BorderLayout(10, 10));
        
        // Username display
        JLabel nameLabel = new JLabel(username, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(nameLabel, BorderLayout.NORTH);
        
        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);
        
        // Input panel
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        messageField = new JTextField();
        sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        
        add(inputPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            //da mandare in out
            String message = messageField.getText().trim();
            out.println(message);
            //
            if (!message.isEmpty()) {
                
                chatArea.append(username + ": " + message + "\n");
                messageField.setText("");
            
            
            }
        }
    }
}
