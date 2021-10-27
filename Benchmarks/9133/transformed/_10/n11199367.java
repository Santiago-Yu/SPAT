class n11199367 {
	private void copy(FileInfo inputFile, FileInfo outputFile) {
		try {
			FileReader in = new FileReader(inputFile.file);
			int c;
			FileWriter out = new FileWriter(outputFile.file);
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
			outputFile.file.setLastModified(inputFile.lastModified);
		} catch (IOException e) {
		}
	}

}