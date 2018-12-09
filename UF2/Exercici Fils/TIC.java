public class TIC extends Thread{
	public void run() {
		// Bucle infinito
		for (;;) {
			System.out.print("TIC ");
			try {
				sleep(200); //Duerme 200 milisegundos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}