import java.io.*;
import java.util.*;
import java.net.*;

public class ServidorChat {
	static List<Cliente> clientes = new ArrayList<Cliente>();
	public static void main(String[] args) throws IOException {
		// Crear el socket para el servidor escuchando en el puerto 6000
		ServerSocket serverSocket = new ServerSocket(6000);
		
		int contadorClientes = 0;
		
		while (true) {
			// Aceptar la peticion del cliente
			Socket clientSocket = serverSocket.accept();

			// Obtener el input y output Stream
			DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

			// Creamos un objeto con los datos del nuevo cliente
			Cliente cliente = new Cliente(clientSocket, "Client"+contadorClientes, inputStream, outputStream);

			// Creamos un Thread con y le pasamos el cliente.
			Thread thread = new Thread(cliente);

			clientes.add(cliente);

			thread.start();

			contadorClientes++;

		}
	}
}

// Clase para manejar los clientes
class Cliente implements Runnable {
	Scanner scanner = new Scanner(System.in);
	private String nombreCliente;
	final DataInputStream inputStream;
	final DataOutputStream outputStream;
	Socket socket;
	boolean logeado;

	// Constructor
	public Cliente(Socket socket, String nombreCliente, DataInputStream inputStream,
			DataOutputStream outputStream) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
		this.nombreCliente = nombreCliente;
		this.socket = socket;
		this.logeado = true;
	}

	@Override
	public void run() {
		String mensajeRecibido;
		while (true) {
			try {
				// Recojemos el mensaje recibido
				mensajeRecibido = inputStream.readUTF();

				System.out.println(mensajeRecibido);

				if (mensajeRecibido.equals("/salir")) {
					this.logeado = false;
					this.socket.close();
					break;
				}
				
				for (Cliente c : ServidorChat.clientes) {
					if (c.logeado == true) {
						c.outputStream.writeUTF(this.nombreCliente + " : " + mensajeRecibido);
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			// Cerrar el input y output Stream
			this.inputStream.close();
			this.outputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}