import javax.swing.JFrame;
import java.awt.*;
import java.io.PrintWriter;

public class ChatClient extends JFrame
{
    private Chat clientChat;
    public ChatClient(String username, PrintWriter out)
    {
        setSize(new Dimension(500, 300));
        setLocationRelativeTo(null);
        setEnabled(true);
        setBackground(Color.GREEN);
        clientChat = new Chat(username, out);
        getContentPane().add(clientChat);
        setVisible(true);
    }
    public Chat getChat()
    {
        return clientChat;
    }
}
