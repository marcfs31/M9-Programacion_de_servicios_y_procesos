import java.io.BufferedReader;
import java.io.FileReader;

public class Ejercicio10 {
    static Ejercicio10 container = new Ejercicio10();
    
	public class Thread1 extends Thread {
        String file;
        int cont;

        Thread1(String file, int cont) {
            this.file = file;
            this.cont = cont;
        }
        
        public void run() {
        	try {
        		FileReader file = new FileReader(this.file);
        		BufferedReader br = new BufferedReader(file);
                String line;
                int num = cont+1;
                
                while (this.cont < num) {
                	this.cont++;
                	line = br.readLine();
                	System.out.println(line);
                }
			} catch (Exception e) {
				System.out.println("ERROR");
			}
        }
	}
	
	public class Thread2 extends Thread {
		String file;
        int cont;

        Thread2(String file, int cont) {
            this.file = file;
            this.cont = cont;
        }
        
        public void run() {
        	try {
        		FileReader file = new FileReader(this.file);
        		BufferedReader br = new BufferedReader(file);
                String line;
                int num = cont+1;
                
                while (this.cont < num+1) {
                	this.cont++;
                	line = br.readLine();
                	System.out.println(line);
                }
			} catch (Exception e) {
				System.out.println("ERROR");
			}
        }
	}

    public static void main(String[] args) throws Exception {
        Thread thread1 = container.new Thread1("file.txt",0);
        Thread thread2 = container.new Thread2("file.txt",1);
        thread1.start();
        thread2.start();
    }
}