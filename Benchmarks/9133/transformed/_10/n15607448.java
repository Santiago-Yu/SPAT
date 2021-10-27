class n15607448 {
	private static void unzipEntry(ZipFile zipfile, ZipEntry entry, File outputDir) throws IOException {
		if (entry.isDirectory()) {
			createDir(new File(outputDir, entry.getName()));
			return;
		}
		File outputFile = new File(outputDir, entry.getName());
		if (!outputFile.getParentFile().exists()) {
			createDir(outputFile.getParentFile());
		}
		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
		BufferedInputStream inputStream = new BufferedInputStream(zipfile.getInputStream(entry));
		try {
			IOUtils.copy(inputStream, outputStream);
		} finally {
			outputStream.close();
			inputStream.close();
		}
	}

}