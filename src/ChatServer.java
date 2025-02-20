import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class ChatServer extends JFrame
{
    PrintWriter out;
    public ChatServer(String username)
    {
        setSize(new Dimension(500, 300));
        setLocationRelativeTo(null);
        setEnabled(true);
        setBackground(Color.BLUE);
        Chat serverChat = new Chat(username, out);
        getContentPane().add(serverChat);
        setVisible(true);
    }
}
