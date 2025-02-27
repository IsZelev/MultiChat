import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ThreadInvio implements Runnable
{
    private Scanner sc;
    private PrintWriter out;
    private Socket socket;

    public ThreadInvio(Socket socket) throws IOException
    {
        this.socket = socket;
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
                Chat chat = chatClient.getChat();
                JTextArea chatArea = chat.getChatArea();
                            
                Thread riceviThread;
                try
                {
                    riceviThread = new Thread(new ThreadRicevi(socket, chatArea));
                    riceviThread.start();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                
                primo = false;
            }
            message = sc.nextLine();
            out.println();
            out.flush();
        }
    }
}