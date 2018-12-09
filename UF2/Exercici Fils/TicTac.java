public class TicTac {
	public static void main(String[] args) throws InterruptedException {
		Thread tic = new TIC();
		Thread tac = new TAC();
		tic.start();
		Thread.sleep(100);
		tac.start();
	}
}