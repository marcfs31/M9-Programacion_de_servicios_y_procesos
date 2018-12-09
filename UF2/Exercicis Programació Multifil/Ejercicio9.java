public class Ejercicio9 {
	static Ejercicio9 container = new Ejercicio9();
	
    public class Productor extends Thread {
        public void run() {
            for (;;) {
                System.out.print("OLE ");
                try {
                    sleep(500);
                } catch (Exception e) {
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
                    sleep(750);
                } catch (Exception e) {
                	System.out.println("Ha ocurrido un error");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread productor = container.new Productor();
        Thread consumidor = container.new Consumidor();
        productor.start();
        Thread.sleep(250);
        consumidor.start();
    }
}