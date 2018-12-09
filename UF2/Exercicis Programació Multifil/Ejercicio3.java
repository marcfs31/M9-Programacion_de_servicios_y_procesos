public class Ejercicio3 {
	static Ejercicio3 container = new Ejercicio3();
	
	public class Impar extends Thread{
		public void run() {
			for (int i = 1; i <= 100; i++) {
				if (i%2 != 0) {
					System.out.println("FilImparell: " + i);
				}
			}
			/*
			Thread par = container.new Par();
			par.start();
			*/
		}
	}
	
	public class Par extends Thread{
		public void run() {
			for (int i = 1; i <= 100; i++) {
				if (i%2 == 0) {
					System.out.println("FilParell: " + i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Thread impar = container.new Impar();
		impar.start();
		Thread par = container.new Par();
		par.start();
	}
}