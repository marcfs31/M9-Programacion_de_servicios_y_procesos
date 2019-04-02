import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Exercici2ServidorUDP {

	public static void main(String argv[]) {

		DatagramSocket socket;
		String missatge = "";
		String missatgeServidor = "";
		byte[] missatge_bytes;
		byte[] missatgeServidor_bytes;
		DatagramPacket paquet;
		DatagramPacket paquetServidor;
		InetAddress address;
		int port = 0;

		try {
			socket = new DatagramSocket(6000);

			while (1 > 0) {
				missatge_bytes = new byte[256];
				paquet = new DatagramPacket(missatge_bytes, 256);
				socket.receive(paquet);

				missatge = new String(missatge_bytes).trim();
				address = paquet.getAddress();
				port = paquet.getPort();

				switch (missatge) {
				case "HELLO":
					missatgeServidor = "HELLO";
					break;
				case "REF":
					missatgeServidor = "Refresc 2";
					break;
				case "PAT":
					missatgeServidor = "Patates fregides 3";
					break;
				case "CRO":
					missatgeServidor = "Croissant 1";
					break;
				case "BOC":
					missatgeServidor = "Entrepà 2";
					break;
				case "ENS":
					missatgeServidor = "Ensaladilla 4";
					break;
				case "CAF":
					missatgeServidor = "Cafè 1";
					break;
				case "fi":
					missatgeServidor = "fi";
					break;
				default:
					missatgeServidor = "ERROR";
					break;
				}
				System.out.println(missatgeServidor);
				missatgeServidor_bytes = missatgeServidor.getBytes();
				paquetServidor = new DatagramPacket(missatgeServidor_bytes, missatgeServidor.length(), address, port);
				socket.send(paquetServidor);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
}
