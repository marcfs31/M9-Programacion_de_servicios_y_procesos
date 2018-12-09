import java.util.Random;

public class Ejercicio5 {
    static Ejercicio5 container = new Ejercicio5();

    public class LanzarDado extends Thread {
        private int suma;
        private String nombre;
        private Random dado;

        LanzarDado(String nombre, Random dado) {
            this.nombre = nombre;
            this.dado = dado;
        }

        public synchronized void run() { // Otro subproceso no puede usar el metodo a la vez
        	// Hacemos que otros subprocesos no puedan modificar la variable dado
            //synchronized (dado) {
                suma = dado.nextInt(6) + 1;
                System.out.println(nombre + ": " + suma);
            //}
        }

        public int getSuma() {
            return suma;
        }
    }

    public static void main(String[] args) throws Exception {
        Random num = new Random();
        LanzarDado d1 = container.new LanzarDado("D1", num);
        LanzarDado d2 = container.new LanzarDado("D2", num);
        LanzarDado d3 = container.new LanzarDado("D3", num);
        d1.start();
        d2.start();
        d3.start();
        Thread.sleep(100);
        System.out.println("D1+D2+D3: "+(d1.getSuma()+d2.getSuma()+d3.getSuma()));
    }
}