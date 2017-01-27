package testiraj.dretve;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;


public class DretveSBlockingQueue {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
		Thread t = new Thread(() -> {
			System.out.println("Uso u dretvu za dohvat el iz queue");
			try{
				String s = queue.take();
				System.out.println(s);
				s = queue.take();
				System.out.println(s);
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		});
		t.start();
		try {
			Thread.sleep(1000);
			queue.put("jurij");
			Thread.sleep(5000);
			queue.put("kos");
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		
		try{
			System.out.println("jurij");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
