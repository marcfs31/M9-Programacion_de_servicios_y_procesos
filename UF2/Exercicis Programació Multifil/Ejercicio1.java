import java.util.ArrayList;

public class Ejercicio1 extends Thread {
	
	public void run() {
		ArrayList<Integer> listaPrimos = new ArrayList<Integer>();
		boolean primo = true;
		int i = 0;
		
		for (i = 1; i <= 100; i++) {
			for (Integer tmpNum: listaPrimos) { 
				if (tmpNum != 1 && i % tmpNum == 0) {
					primo = false;
					break;
				}
				primo = true;
			}
			if (primo) {
				listaPrimos.add(i);
				System.out.print(i + " ");
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Thread numerosPrimos = new Ejercicio1();
		numerosPrimos.start();
	}
}