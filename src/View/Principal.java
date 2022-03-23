package View;
import java.util.concurrent.Semaphore;
import Controller.*;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo1 = new Semaphore(1);
		Semaphore semaforo2 = new Semaphore(1);		
		for (int threadId = 1; threadId< 13 ; threadId++) {
			Thread thread = new Processos(threadId, semaforo1, semaforo2);
			thread.start();
		}
	}
}