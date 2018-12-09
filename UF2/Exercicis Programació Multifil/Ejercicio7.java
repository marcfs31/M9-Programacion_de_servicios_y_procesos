public class Ejercicio7 {
	static Ejercicio8 container = new Ejercicio8();
	
    public class Productor extends Thread {
        public void run() {
            for (;;) {
                System.out.print("OLE ");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                	System.out.println("Ha ocurrido un error");
                }
            }
        }
    }

    public class Consumidor extends Thread {
        public void run() {
            for (;;) {
                System.out.print("TU ");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                	System.out.println("Ha ocurrido un error");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread productor = container.new Productor();
        Thread consumidor = container.new Consumidor();
        productor.start();
        Thread.sleep(500);
        consumidor.start();
    }
}