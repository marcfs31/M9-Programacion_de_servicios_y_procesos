import java.util.ArrayList;

public class Ejercicio2 extends Thread {
	ArrayList<Integer> listaPrimos = new ArrayList<Integer>();
	static Ejercicio2 container = new Ejercicio2();
	
	public class Thread0 extends Thread {
		public void run() {
			boolean primo = true;
			int i = 0;
			
			for (i = 1; i <= 50; i++) {
				for (Integer tmpNum: listaPrimos) { 
					if (tmpNum != 1 && i % tmpNum == 0) {
						primo = false;
						break;
					}
					primo = true;
				}
				if (primo) {
					listaPrimos.add(i);
					System.out.println("Thread-0:" + i);
				}
			}
			// Llamamos al segundo hilo para que continue calculando
			Thread thread1 = container.new Thread1();
			thread1.start();
		}
	}
	
	public class Thread1 extends Thread {
		public void run() {
			boolean primo = true;
			int i = 0;
			
			for (i = 51; i <= 100; i++) {
				for (Integer tmpNum: listaPrimos) { 
					if (tmpNum != 1 && i % tmpNum == 0) {
						primo = false;
						break;
					}
					primo = true;
				}
				if (primo) {
					listaPrimos.add(i);
					System.out.println("Thread-1:" + i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// Llamo al primer hilo que al acabar llamará al segundo
		Thread thread0 = container.new Thread0();
		thread0.start();
		}
}