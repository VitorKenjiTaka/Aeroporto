package Controller;
import java.util.concurrent.Semaphore;

public class Processos extends Thread{
	private int threadId;
	private Semaphore semaforo1;
	private Semaphore semaforo2;
	
	public Processos(int threadId, Semaphore semaforo1, Semaphore semaforo2) {
		this.threadId = threadId;
		this.semaforo1 = semaforo1;
		this.semaforo2 = semaforo2;
	}
	
	public void run() {
		decolagem();
	}
	
	private void decolagem() {
		if (threadId % 2 == 0) {
			try {
				semaforo1.acquire();
				System.out.println("Avião #" + threadId +" está manobrando.");
				sleep((int) ((Math.random()* 5000)+ 3000));
				System.out.println("Avião #" + threadId +" está taxiando.");
				sleep((int) ((Math.random()* 6000)+ 5000));
				System.out.println("Avião #" + threadId +" está deslocando.");
				sleep((int) ((Math.random()* 5000)+ 1000));
				System.out.println("Avião #" + threadId +" está se afastando da área.");
				sleep((int) ((Math.random()* 6000)+ 3000));
				System.out.println("Avião #"+ threadId +" ja decolou.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaforo1.release();
			}
		}else {
			
			try {
				semaforo2.acquire();
				System.out.println("Avião #" + threadId +" está manobrando.");
				sleep((int) ((Math.random()* 5000)+ 3000));
				System.out.println("Avião #" + threadId +" está taxiando.");
				sleep((int) ((Math.random()* 6000)+ 5000));
				System.out.println("Avião #" + threadId +" está deslocando.");
				sleep((int) ((Math.random()* 5000)+ 1000));
				System.out.println("Avião #" + threadId +" está se afastando da área.");
				sleep((int) ((Math.random()* 6000)+ 3000));
				System.out.println("Avião #"+ threadId +" ja decolou.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaforo2.release();
			}
		}
	}
}