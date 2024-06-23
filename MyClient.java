import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient
{
	public static void main(String[] args)
	{
		try
		{							//"127.0.0.1"
			Socket ser=new Socket("192.168.43.205",1234);
			
			DataInputStream dis=new DataInputStream(ser.getInputStream());
			DataOutputStream dos=new DataOutputStream(ser.getOutputStream());
			Scanner scan=new Scanner(System.in);
			String msg="";
			
			while(!msg.equals("QUIT"))
			{
				msg=dis.readUTF();
				System.out.println("\n Msg from server : "+msg);
				
				System.out.print("\n Enter msg for server : ");
				msg=scan.nextLine();
				dos.writeUTF(msg);
			}
			
			dis.close();
			dos.close();
			ser.close();
		}
		catch(Exception e)
		{
			System.out.println("\n CLIENT ERROR : "+e.getMessage());
		}
	}
}