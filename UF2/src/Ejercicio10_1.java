import java.io.BufferedReader;
import java.io.FileReader;

public class Ejercicio10_1 {
    static Ejercicio10_1 container = new Ejercicio10_1();

	public class Lector extends Thread {
        Escritor escritor;

        Lector(Escritor escritor) {
            this.escritor = escritor;
        }

        public void run() {
        	try {
        		FileReader file = new FileReader("file.txt");
        		BufferedReader br = new BufferedReader(file);
                String line = null;
                
                while ((line = br.readLine()) != null) {
                	System.out.println("Test");
                	if (line.equals(this.escritor)) {
                		System.out.println(br.readLine());
                		break;
    				}
                }
			} catch (Exception e) {
				// TODO: handle exception
			}
        }
    }
	
    public class Escritor extends Thread {
        StringBuffer buffer = new StringBuffer();
        
        public void run() {
        	try {
        		FileReader file = new FileReader("file.txt");
        		BufferedReader br = new BufferedReader(file);
                String line = null;
                
                while ((line = br.readLine()) != null) {
                    buffer.insert(0, line);
                    System.out.println(buffer);
                	if (line.equals(buffer)) {
                		System.out.println(br.readLine());
                    	buffer.delete(0, buffer.length());
                		break;
    				}
                }
			} catch (Exception e) {
				// TODO: handle exception
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