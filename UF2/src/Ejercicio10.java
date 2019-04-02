import java.io.BufferedReader;
import java.io.FileReader;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Ejercicio10 {
    static Ejercicio10 container = new Ejercicio10();
    
	public class Thread2 extends Thread {
        int num;

        Thread2(int num) {
            this.num = num;
        }
        
        int cont = 0;

        public void run() {
        	try {
        		FileReader file = new FileReader("file.txt");
        		BufferedReader br = new BufferedReader(file);
                String line = null;
                
                while (br.readLine() != null) {
                	cont++;
                	System.out.println("Test");
                	if (cont == this.num) {
                		System.out.println(line);
                		break;
					}
                }
			} catch (Exception e) {
				System.out.println("ERROR");
			}
        }
        
        public int getNum() {
            return cont;
        }
	}
	
	public class Thread1 extends Thread {
        Thread2 thread2;

        Thread1(Thread2 thread2) {
            this.thread2 = thread2;
        }
        
        public void run() {
        	try {
        		FileReader file = new FileReader("file.txt");
        		BufferedReader br = new BufferedReader(file);
                String line = null;
                int cont = 0;
                
                while (br.readLine() != null) {
                	cont++;
                	if (cont == thread2.getNum()) {
                		System.out.println(line);
					}
                }
			} catch (Exception e) {
				System.out.println("ERROR");
			}
        }
	}

    public static void main(String[] args) throws Exception {
        Thread thread2 = container.new Thread2(1);
        Thread thread1 = container.new Thread1((Thread2) thread2);
        thread2.start();
        Thread.sleep(250);
        thread1.start();
    }
}