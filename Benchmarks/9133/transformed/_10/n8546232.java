class n8546232 {
	public void execute(File sourceFile, File destinationFile, Properties htmlCleanerConfig) {
		Writer writer = null;
		FileReader reader = null;
		try {
			reader = new FileReader(sourceFile);
			logger.info("Using source file: " + trimPath(userDir, sourceFile));
			if (!destinationFile.getParentFile().exists()) {
				createDirectory(destinationFile.getParentFile());
			}
			writer = new FileWriter(destinationFile);
			logger.info("Destination file:  " + trimPath(userDir, destinationFile));
			execute(reader, writer, htmlCleanerConfig);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
					writer = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
					reader = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}