package exemplos;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket {

	public static void main(String[] args) throws IOException {
		Scanner ler = new Scanner(System.in);
		
		String texto = "";
		
		Socket cliente = null;
		
		PrintStream saida = null;
		
		try{
			cliente = new Socket("192.168.1.6", 7000);
			
			saida = new PrintStream(cliente.getOutputStream());
			do{
				texto = ler.nextLine();
				ler.close();
				saida.println(texto);
			}while (!"sair".equals(texto));
			
		} catch (IOException e ){
			System.out.println("Algo errado aconteceu");
		} finally {
			cliente.close();
			
		}
	}

}
