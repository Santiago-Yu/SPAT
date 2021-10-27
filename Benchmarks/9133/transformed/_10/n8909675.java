class n8909675 {
	public static boolean copyFileToDir(File inputFile, File outputDir) {
		try {
			int index = 1;
			String outputFileName = inputFile.getName();
			while (existFileInDir(outputFileName, outputDir)) {
				outputFileName = index + inputFile.getName();
				index++;
			}
			String directory = getDirectoryWithSlash(outputDir.getAbsolutePath());
			FileReader in = new FileReader(inputFile);
			File outputFile = new File(directory + outputFileName);
			int c;
			FileWriter out = new FileWriter(outputFile);
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}