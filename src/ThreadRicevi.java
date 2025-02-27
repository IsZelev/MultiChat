import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

public class ThreadRicevi implements Runnable
{
    private Socket socket;
    private JTextArea chatArea;
    BufferedReader in;
    public ThreadRicevi(Socket socket, JTextArea chatArea) throws IOException
    {
        this.chatArea = chatArea;
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    public void run()
    {
        String messaggio;
        try
        {
            messaggio = in.readLine();

            while(messaggio!=null)
            {
                System.out.println(messaggio);
                chatArea.append(messaggio + "\n");
                messaggio = in.readLine();
            }
            System.out.println("Server chiuso");
            socket.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
