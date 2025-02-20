import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class ChatClient extends JFrame
{
    public ChatClient(String username, PrintWriter out)
    {
        setSize(new Dimension(500, 300));
        setLocationRelativeTo(null);
        setEnabled(true);
        setBackground(Color.GREEN);
        Chat clientChat = new Chat(username, out);
        getContentPane().add(clientChat);
        setVisible(true);
    }
}
