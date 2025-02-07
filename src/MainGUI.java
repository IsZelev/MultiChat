import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class MainGUI
{
    public static void main(String[] args)
    {
        String username = JOptionPane.showInputDialog(null, "Inserisci il tuo nome utente");
        JOptionPane.showMessageDialog(null, "Benventuto nella multichat " + username + "!");
        
        Socket clientSocket;
        try
        {
            clientSocket = new Socket("127.0.0.1", 5500);
            Thread invioThread = new Thread(new ThreadInvio(clientSocket));
            Thread riceviThread = new Thread(new ThreadRicevi(clientSocket));
            invioThread.start();
            riceviThread.start();
        } catch(IOException e)
        {
            System.out.println("Impossibile connettersi al server");
        }
    }

}