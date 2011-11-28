package ca.uqam.mgl7460.a2011.hospitalizer.util;

import java.util.*;
import java.io.*;

public class DirectoryReader {
	public Collection<File> getAllFilesInDirectory(String directoryName) {
		Collection<File> filesCollection = new ArrayList<File>();
		File directory = new File(directoryName);
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isFile())
				filesCollection.add(file);
		}
		return filesCollection;
	}
}
