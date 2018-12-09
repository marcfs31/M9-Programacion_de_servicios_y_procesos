public class Ejercicio6 {
	static Ejercicio6 container = new Ejercicio6();
	
    public class CarreraHobbit extends Thread {
        private String nombre;
        private int hechizo;

        CarreraHobbit(String nombre, int hechizo) {
            this.nombre = nombre;
            this.hechizo = hechizo;
        }

        public void run() {
            for (int i = 0; i < 30; i++) {
                try {
                	// Dependiendo del hechizo de cada uno acabará antes o después
                    sleep(100 + hechizo);
                } catch (InterruptedException e) {
                    System.out.println("Ha ocurrido un error");
                }
                System.out.print(nombre);
            }
            System.out.println();
            System.out.println("Arriba " + nombre);
        }
    }

    public static void main(String[] args) throws Exception {
        CarreraHobbit sam = container.new CarreraHobbit("S", 10);
        CarreraHobbit frodo = container.new CarreraHobbit("F", 50);
        CarreraHobbit pippin = container.new CarreraHobbit("P", 60);
        sam.start();
        frodo.start();
        pippin.start();
    }
}