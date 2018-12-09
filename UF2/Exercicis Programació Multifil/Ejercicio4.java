public class Ejercicio4 {
    static Ejercicio4 container = new Ejercicio4();

	public class Lector extends Thread {
        Escritor escritor;

        Lector(Escritor escritor) {
            this.escritor = escritor;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Lector: " + escritor.getValue());
                try {
                    sleep(1000);
                } catch (Exception e) {
                    System.out.println("Ha ocurrido un error");
                }
            }
        }
    }
	
    public class Escritor extends Thread {
        StringBuffer buffer = new StringBuffer();
        String valores = "ABCDEFGHIJ";
        String[] valoresArray = valores.split("");
        
        public void run() {
            for (String str: valoresArray) {
            	// Limpiamos el buffer
            	buffer.delete(0, buffer.length());
                System.out.println("Escriptor: " + str);
                // Insertamos en la posición incicial el String para pasar 
                buffer.insert(0, str);
                try {
                    sleep(1000);
                } catch (Exception e) {
                    System.out.println("Ha ocurrido un error");
                }
            }
        }

        public String getValue() {
            return buffer.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        Thread escritor = container.new Escritor();
        Thread lector = container.new Lector((Escritor) escritor);
        escritor.start();
        Thread.sleep(250);
        lector.start();
    }
}