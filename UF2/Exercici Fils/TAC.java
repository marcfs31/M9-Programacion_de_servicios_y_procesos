public class TAC extends Thread{
	public void run() {
		// Bucle infinito
		for (;;) {
			System.out.print("TAC ");
			try {
				sleep(200); //Duerme 200 milisegundos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}