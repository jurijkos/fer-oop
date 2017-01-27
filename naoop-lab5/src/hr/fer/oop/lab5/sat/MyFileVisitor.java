package hr.fer.oop.lab5.sat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;





public class MyFileVisitor implements FileVisitor<Path> {
	private Collection<Racun> kolekcijaRacuni;
	

	public MyFileVisitor() {
		kolekcijaRacuni = new HashSet<>();

	}
	
	
	
	public void ispisiNajveceRacune() {
		//Collection<Racun> kolekcijaRacuni2 = new TreeSet<>(kolekcijaRacuni);
		List<Racun> kolekcijaRacuni2 = new ArrayList<>(kolekcijaRacuni);
		/*Collections.sort(kolekcijaRacuni2, new Comparator<Racun>() {

			@Override
			public int compare(Racun o1, Racun o2) {
				// TODO Auto-generated method stub
				 
				return (int)(100 * (o2.ukupniIznos() - o1.ukupniIznos()));
			}
		});*/
		Collections.sort(kolekcijaRacuni2, (Racun o1, Racun o2) -> 
			(int)(100 * (o2.ukupniIznos() - o1.ukupniIznos())));
		int kraj = 0;
		for (Racun racun : kolekcijaRacuni2) {
			kraj++;
			System.out.println(racun.toString());
			if (kraj == 10)
				break;
		}
	}
	
	
	
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}
	/**
	 * Functions awaken when file is visited. Reads line by line from file.
	 * If line represents Artikl creates object Artikl and adds it to the
	 * collection. 
	 */
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		String line;
		int brRacuna = 0;
		Racun racun = new Racun(brRacuna);
		if (attrs.isRegularFile() && file.toFile().toString().endsWith(".txt")){
			try (BufferedReader bReader = new BufferedReader(new InputStreamReader(
					new FileInputStream(file.toFile()),"UTF-8"));) {
				while(true){
					line = bReader.readLine();
					if (line.equals(""))
						continue;
					else if (line.substring(0, 5).equals("Kupac"))
						continue;
					else if (line.substring(0, 6).equals("UKUPNO")) 
						break;
					else if(line.substring(0, 5).equals("Račun")) {
						brRacuna = Integer.parseInt(line.substring(9,16).trim());
						racun.setBrRacuna(brRacuna);
						continue;
					}
					else if(line.substring(0, 3).equals("---") 
							|| line.substring(0, 8).equals("Proizvod") 
							|| line.substring(0, 3).equals("   "))
						continue;
					Stavka stvaka = new Stavka(line.substring(0, 80), 
							Double.parseDouble(line.substring(80,90)), 
							Integer.parseInt(line.substring(90, 95).trim()));
					racun.kolekcijaStavki.add(stvaka);
					
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		kolekcijaRacuni.add(racun);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}

}
