package operacijski_sustavi.vjezba4.prvi;

import java.util.LinkedList;
import java.util.Queue;

public class Simulacija {
	public static int [][]nove = new int[][] {
			/* trenutak dolaska, id, p, prio, rasp (prio i rasp se koriste ovisno o rasporedivacu) */
			{1,  3, 5}, /* rasp = 0 => PRIO+FIFO; 1 => PRIO+RR */
			{3,  5, 6},
			{7,  2, 3},
			{12, 1, 5},
			{20, 6, 3},
			{20, 4, 4},
	};
	public static int prosloVremena = 0;
	public static Queue<Dretva> redDretvi;
	public static Dretva aktivnaDretva;
	private static Dretva[] dretvas;
	private static int gotovo = 0;
	public static void main(String[] args) {
		System.out.println("Pocetak programa");
		dretvas = new Dretva[6];
		redDretvi = new LinkedList<>();
		initDretve(dretvas);
		System.out.println("  t    AKT     PR1     PR2     PR3     PR4");
		while (true){
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (gotovo == 0) {
				rasporediDretve();
			}
			else
				break;
		}
		System.out.println("Program je zavrsio s rasporedivanjem dretvi.");
	}
	
	private static void initDretve(Dretva[] dretvas) {
		dretvas[0] = new Dretva(nove[0][0], nove[0][1], nove[0][2]);
		dretvas[1] = new Dretva(nove[1][0], nove[1][1], nove[1][2]);
		dretvas[2] = new Dretva(nove[2][0], nove[2][1], nove[2][2]);
		dretvas[3] = new Dretva(nove[3][0], nove[3][1], nove[3][2]);
		dretvas[4] = new Dretva(nove[4][0], nove[4][1], nove[4][2]);
		dretvas[5] = new Dretva(nove[5][0], nove[5][1], nove[5][2]);
	 
	}
	
	private static void ispisStanja() {
		if (aktivnaDretva != null) {
			System.out.format(" %2d       %d          %d\n", prosloVremena, aktivnaDretva.idDretve,
					aktivnaDretva.prestaloVrijeme);
		}
		else {
			System.out.format(" %2d       -          - \n", prosloVremena);
		}
	}
	private static void ispisStanja2() {
		if (aktivnaDretva != null) {
			System.out.format(" %2d   %d/%d    ", prosloVremena, aktivnaDretva.idDretve,
					aktivnaDretva.prestaloVrijeme);
			for (Dretva dretva : redDretvi) {
				System.out.format(" %d/%d   ",dretva.idDretve, dretva.prestaloVrijeme );
			}
			System.out.format("%n");
		}
		else {
			System.out.format(" %2d   -/- \n", prosloVremena);
		}
	}
	private static void rasporediDretve() {
		for (Dretva dretva : dretvas) {
			if (dretva.trenutakDolaska == prosloVremena) {
				redDretvi.add(dretva);
				System.out.format(" %2d-- nova dretva id=%d, trajanje=%d %n",prosloVremena, 
						dretva.idDretve, dretva.prestaloVrijeme);
			}
			
		}
		if(aktivnaDretva != null || !redDretvi.isEmpty()){
			if (!redDretvi.isEmpty()){
				Dretva pomocna;
				pomocna = aktivnaDretva;
				aktivnaDretva = null;
				aktivnaDretva = redDretvi.poll();
				if (pomocna != null){
					pomocna.prestaloVrijeme--;
					if (pomocna.prestaloVrijeme > 0)
						redDretvi.add(pomocna);
					else {
						System.out.println("Dretva " + pomocna.idDretve + "zavsila." );
					}
				}
			}
			else {
				aktivnaDretva.prestaloVrijeme--;
				if (aktivnaDretva.prestaloVrijeme == 0) {
					gotovo = 1;
					System.out.println("Dretva " + aktivnaDretva.idDretve + "zavsila." );
					return;
				}
			}
		}
		//ispisStanja();
		ispisStanja2();
		prosloVremena++;
		
	}
	
	
	private static class Dretva {
		int trenutakDolaska;
		int idDretve; //1,2,3...
		int prestaloVrijeme; //preostalo vrijeme rada
		//int prio; //prioritet
		//int rasp; // nacin rasporedivanja
		public Dretva(int trenutakDolaska, int idDretve, int preostaloVrijeme) {
			this.trenutakDolaska = trenutakDolaska;
			this.idDretve = idDretve;
			this.prestaloVrijeme = preostaloVrijeme;
			//this.prio = prio;
			//this.rasp = rasp;
		}
	}
}
