import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientChat1 {
	final static int ServerPort = 6000;

	public static void main(String args[]) throws UnknownHostException, IOException {
		Scanner scanner = new Scanner(System.in);

		// Establecemos la conexion con el servidor
		Socket socket = new Socket("localhost", ServerPort);

		// Obtener el input y output Stream
		DataInputStream inputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

		// Thread para enviar mensajes
		Thread sendMessage = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					String mensajeEnviado = scanner.nextLine();

					try {
						// Enviar el mensaje
						outputStream.writeUTF(mensajeEnviado);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});

		// Thread para leer mensajes
		Thread readMessage = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						// Leer el mensaje recibido
						String mensajeRecibido = inputStream.readUTF();
						System.out.println(mensajeRecibido);
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
			}
		});

		sendMessage.start();
		readMessage.start();
	}
}