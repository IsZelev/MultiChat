import java.io.IOException;
import java.net.Socket;

public class ClientMain
{
    public static void main(String[] args) throws Exception
    {
        Socket clientSocket;
        try
        {
            clientSocket = new Socket("127.0.0.1", 5500);
            Thread invioThread = new Thread(new ThreadInvio(clientSocket));
            invioThread.start();
            

        } catch(IOException e)
        {
            System.out.println("Impossibile connettersi al server");
        }
    }
}
