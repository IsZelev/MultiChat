import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ThreadInvio implements Runnable
{
    private Scanner sc;
    private PrintWriter out;

    public ThreadInvio(Socket socket) throws IOException
    {
        sc = new Scanner(System.in);
        out = new PrintWriter(socket.getOutputStream());
    }
    public void run()
    {
        String message;
        boolean primo = true;
        while(!Thread.interrupted())
        {
            if(primo)
            {
                String username = JOptionPane.showInputDialog(null, "Inserisci il tuo nome utente");
                ChatClient chatClient = new ChatClient(username, out);
                
                primo = false;
            }
            out.println();
            out.flush();
        }
    }
}