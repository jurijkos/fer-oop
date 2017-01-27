package mi_priprema.datoteke;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class FindJavaFiles {
	public static void directoryTree(String root, int level){
		File directory = new File(root);
		if (level == 0) 
			System.out.println(root);
		else 
			print(level, directory.getName(), false);
		FilenameFilter filter = new MyFilenameFilter();
		File[] files = directory.listFiles(filter);
		for(File file : files){
			if (file.isDirectory())
				directoryTree(file.getAbsolutePath(), level + 1);
			else
				print(level+1, String.format("%s (%s bytes) ",
						file.getName(), file.length()), true);
		}
	}
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("Enter directory:");
			String dirName = sc.nextLine();
			directoryTree(dirName, 0);
			}
	}
	private static void print(int level,
		String name, boolean isFile) {
		if (level != 0)
			System.out.print("|");
			for(int i=0; i<level-1; i++)
				System.out.print(isFile? " " : "-");
			System.out.println(name);
			}
}
