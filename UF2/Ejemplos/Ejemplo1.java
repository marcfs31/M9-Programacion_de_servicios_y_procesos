public class Ejemplo1 extends Thread{
	private int c; // Contar de cada hilo
	private int hilo; 
	
	public Ejemplo1(int hilo) {
		this.hilo = hilo;
		System.out.println("Creando el hilo: "+hilo);
	}
	
	public void run() {
		c = 0;
		
		while (c <= 5) {
			System.out.println("Hilo: "+hilo+" c = "+c);
			c++;
		}
	}
	
	public static void main(String[] args) {
		Ejemplo1 hilo2 = null;
		
		for (int i = 0; i < 3; i++) {
			hilo2 = new Ejemplo1(i+1); // Crear hilo
			hilo2.start();
		}
		System.out.println("3 hilos creados");
	}
}
