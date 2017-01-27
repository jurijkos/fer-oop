package testiraj.dretve;

public class DretvaDemon {
	public static void main(String[] args) {
		Thread t =new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try{
					Thread.sleep(2000);
					System.out.println("Javljanje iz pom threada broj: " + i);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println("Thread gotova");
		});
		t.setDaemon(true);
		t.start();
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("glavni thread br: " + i);
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
			
		}
		System.out.println("gotov glavni program");
	}
}
