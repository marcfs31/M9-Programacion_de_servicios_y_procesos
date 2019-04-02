import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Exercici2ClienteUDP {

	public static void main(String argv[]) {

		if (argv.length != 1) {
			System.err.println("Us: java clientetcp servidor");
			System.exit(1);
		}

		BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));

		DatagramSocket socket;
		DatagramPacket paquet;
		DatagramPacket paquetServidor;
		InetAddress address;
		byte[] missatge_bytes = new byte[256];
		byte[] missatgeServidor_bytes = new byte[256];
		String missatge = "";
		String missatgeServidor = "";

		try {

			socket = new DatagramSocket();
			address = InetAddress.getByName(argv[0]);

			missatge = "HELLO";

			missatge_bytes = missatge.getBytes();
			paquet = new DatagramPacket(missatge_bytes, missatge.length(), address, 6000);
			socket.send(paquet);

			missatgeServidor_bytes = new byte[256];
			paquetServidor = new DatagramPacket(missatgeServidor_bytes, 256);
			socket.receive(paquetServidor);
			missatgeServidor = new String(missatgeServidor_bytes).trim();
			System.out.println(missatgeServidor);

			do {
				missatge = teclat.readLine();
				missatge_bytes = missatge.getBytes();
				paquet = new DatagramPacket(missatge_bytes, missatge.length(), address, 6000);
				socket.send(paquet);

				missatgeServidor_bytes = new byte[256];
				paquetServidor = new DatagramPacket(missatgeServidor_bytes, 256);
				socket.receive(paquetServidor);
				missatgeServidor = new String(missatgeServidor_bytes).trim();
				System.out.println(missatgeServidor);
			} while (!missatge.startsWith("fi"));

			socket.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
}