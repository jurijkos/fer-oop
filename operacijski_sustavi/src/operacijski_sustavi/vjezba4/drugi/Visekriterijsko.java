package operacijski_sustavi.vjezba4.drugi;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;






public class Visekriterijsko {
	public static int [][]nove = new int[][] {
		/* trenutak dolaska, id, p, prio, rasp (prio i rasp se koriste ovisno o rasporedivacu) */
		{1,  3, 5, 3, 1}, /* rasp = 0 => PRIO+FIFO; 1 => PRIO+RR */
		{3,  5, 6, 5, 1},
		{7,  2, 3, 5, 0},
		{12, 1, 5, 3, 0},
		{20, 6, 3, 6, 1},
		{20, 4, 4, 7, 1},
	};
	public static int prosloVremena = 0;
	public static Queue<Dretva> redDretvi;
	public static List<Dretva> dodajURedDretvi;
	public static Dretva aktivnaDretva;
	private static Dretva[] dretvas;
	private static int gotovo = 0;
	public static void main(String[] args) {
		System.out.println("Pocetak programa");
		dretvas = new Dretva[6];
		redDretvi = new LinkedList<>();
		dodajURedDretvi = (List<Dretva>)redDretvi;
		initDretve(dretvas);
		//System.out.println("  t ID_aktivne   preostalo  prioritet");
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
		dretvas[0] = new Dretva(nove[0][0], nove[0][1], nove[0][2], nove[0][3], nove[0][4]);
		dretvas[1] = new Dretva(nove[1][0], nove[1][1], nove[1][2], nove[1][3], nove[1][4]);
		dretvas[2] = new Dretva(nove[2][0], nove[2][1], nove[2][2], nove[2][3], nove[2][4]);
		dretvas[3] = new Dretva(nove[3][0], nove[3][1], nove[3][2], nove[3][3], nove[3][4]);
		dretvas[4] = new Dretva(nove[4][0], nove[4][1], nove[4][2], nove[4][3], nove[4][4]);
		dretvas[5] = new Dretva(nove[5][0], nove[5][1], nove[5][2], nove[5][3], nove[5][4]);
	}


	
	private static void ispisStanja() {
		if (aktivnaDretva != null) {
		System.out.format(" %2d       %d          %d        %d%n", prosloVremena, aktivnaDretva.idDretve,
				aktivnaDretva.prestaloVrijeme, aktivnaDretva.prioritet);
		}
		else {
			System.out.format(" %2d       -          - %n", prosloVremena);
		}
	}
	
	private static void ispisStanja2() {
		if (aktivnaDretva != null) {
			System.out.format(" %2d  %d/%d/%d", prosloVremena, aktivnaDretva.idDretve,
					aktivnaDretva.prestaloVrijeme,aktivnaDretva.prioritet);
			for (Dretva dretva : redDretvi) {
				System.out.format("   %d/%d/%d ",dretva.idDretve, dretva.prestaloVrijeme, dretva.prioritet);
			}
			System.out.format("%n");
		}
		else {
			System.out.format(" %2d -/-/- \n", prosloVremena);
		}
	}

	private static void rasporediDretve() {
		for (Dretva dretva : dretvas) {
			if (dretva.trenutakDolaska == prosloVremena) {
				dodajURed(dretva);
				System.out.format(" %2d-- nova dretva id=%d, trajanje=%d prioritet=%d%n",prosloVremena, 
					dretva.idDretve, dretva.prestaloVrijeme, dretva.prioritet);
			}
		}

		if(aktivnaDretva == null && !redDretvi.isEmpty()){
			
			aktivnaDretva = redDretvi.poll();
		}
		else if (aktivnaDretva != null && !redDretvi.isEmpty()) {
			if (aktivnaDretva.rasporedivac == 1) {
				if (redDretvi.element().prioritet >= aktivnaDretva.prioritet) {
					Dretva pomocna;
					pomocna = aktivnaDretva;
					aktivnaDretva = null;
					aktivnaDretva = redDretvi.poll();
					pomocna.prestaloVrijeme--;
					if (pomocna.prestaloVrijeme > 0)
						dodajURed(pomocna);
					else {
						System.out.println("Dretva " + pomocna.idDretve + "zavsila." );
					}
				}
				else {
					aktivnaDretva.prestaloVrijeme--;
					if (aktivnaDretva.prestaloVrijeme == 0) {
						System.out.println("Dretva " + aktivnaDretva.idDretve + "zavsila." );
						aktivnaDretva = redDretvi.poll();
					}
				}
			}
			else if(aktivnaDretva.rasporedivac == 0) {
				aktivnaDretva.prestaloVrijeme--;
				if (aktivnaDretva.prestaloVrijeme == 0) {
					System.out.println("Dretva " + aktivnaDretva.idDretve + "zavsila." );
					aktivnaDretva = redDretvi.poll();
				}
				else if (redDretvi.element().prioritet > aktivnaDretva.prioritet){
					dodajURed(aktivnaDretva);
					aktivnaDretva = redDretvi.poll();
				}

			}
			
		}
		else if (aktivnaDretva != null) {
			aktivnaDretva.prestaloVrijeme--;
			if (aktivnaDretva.prestaloVrijeme == 0) {
				gotovo = 1;
				return;
			}
		}
		//ispisStanja();
		ispisStanja2();
		prosloVremena++;
	}
	public static void dodajURed(Dretva dretva){
		for (int i = 0; i <dodajURedDretvi.size(); i++) {
			if (dretva.prioritet > dodajURedDretvi.get(i).prioritet ) {
				dodajURedDretvi.add(i, dretva);
				return;
			}
		}
		dodajURedDretvi.add(dretva);
	}


	private static class Dretva {
		int trenutakDolaska;
		int idDretve; //1,2,3...
		int prestaloVrijeme; //preostalo vrijeme rada
		int prioritet; //prioritet
		int rasporedivac; //0-prio+fifo 1-prio+rasp 
		public Dretva(int trenutakDolaska, int idDretve, int preostaloVrijeme,
				int prirotet, int rasporedivac) {
			this.trenutakDolaska = trenutakDolaska;
			this.idDretve = idDretve;
			this.prestaloVrijeme = preostaloVrijeme;
			this.prioritet = prirotet;
			this.rasporedivac = rasporedivac;
		}
	}
}
