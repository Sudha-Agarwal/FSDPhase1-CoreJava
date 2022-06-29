package files;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileCreationRunner {
	Path path;

	public void createDirectory() {

		this.path = Paths.get("./resources/UserFiles");
		try {
			Files.createDirectories(path);
			System.out.println("Directory is created!");
		} catch (IOException e) {
			System.err.println("Failed to create directory!" + e.getMessage());
		}
		//return path;

	}
	
	public Path getDirectoryPath() {
		return this.path;
	}

	public void createFile() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter User File Name you want to create");

		String fileName = sc.next();


		Path newFilePath = Paths.get(this.path + "/" + fileName);

		try {
			Files.createFile(newFilePath);
			System.out.println("File created successfully");
		}
		catch(FileAlreadyExistsException e) {
			System.out.println("File already exist!!! Enter new File name");
			this.createFile();

		}
		catch (IOException e) {
			System.err.println("Failed to create File!" + e.getMessage());
		}
	}

	public void listAllFiles() {

		String dir = this.path.toString();
		File[] listOfFiles = new File(dir).listFiles();


		for (File file : listOfFiles) {
			if (file.isDirectory()) {

				System.out.println(file.getName());
			} else if (file.isFile()) {
				System.out.println(file.getName());
			}
		}
	}

	public void deleteFile() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the file name you want to delete");
		String fileToDelete = sc.next();

		try {
			Files.delete(Paths.get(this.path + "/" + fileToDelete));
			System.out.println("File deleted successfully");
		} 
		catch(NoSuchFileException e) {
			System.out.println("No such file exist!!! Enter new File name to delete");
			this.deleteFile();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void listAllFilesAscending() {
		String dir = this.path.toString();
		File[] listOfFiles = new File(dir).listFiles();

		List<File> listFile = Arrays.asList(listOfFiles);

		Collections.sort(listFile);

		Iterator<File> it = listFile.iterator();

		while(it.hasNext()) {
			System.out.println(it.next().getName());
		}		
	}


	public void searchFile() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the file name you want to search");
		String fileToSearch = sc.next();
		
		 Path path = Paths.get(this.path + "/" + fileToSearch);

	        // check exists for file and directory
	        if (Files.exists(path)) {

	            if (Files.isRegularFile(path)) {
	                System.out.println("File exists!");
	            }
	            if (Files.isDirectory(path)) {
	                System.out.println("File exists, but it is a directory.");
	            }

	        } else {
	            System.out.println("File doesn't exist");
	        }
		

	}
}
