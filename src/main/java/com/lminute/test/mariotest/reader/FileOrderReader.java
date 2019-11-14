package com.lminute.test.mariotest.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.lminute.test.mariotest.exceptions.FileReadException;

public class FileOrderReader {
	private List<String> ordersFiles;
	
	public FileOrderReader(String dir) throws FileReadException {
		try {
			Stream<Path> list = Files.walk(Paths.get(dir));
			
			ordersFiles = list.filter(Files::isRegularFile).map(f -> f.toString()).collect(Collectors.toList());
			
			list.close();
			
		}catch (IOException e) {
			throw new FileReadException("Couldnt read file " + e.getMessage());
		}
	}
	
	public List<String> getOrdersFiles() {
		return ordersFiles;
	}
	
	public static List<String> getFileProducts(String file) throws IOException{
		return Files.lines(Paths.get(file)).collect(Collectors.toList());
	}
}
