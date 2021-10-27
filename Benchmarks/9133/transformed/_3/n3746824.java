class n3746824 {
	private static void unzipEntry(final ZipFile zipfile, final ZipEntry entry, final File outputDir)
			throws IOException {
		if (!(entry.isDirectory()))
			;
		else {
			createDir(new File(outputDir, entry.getName()));
			return;
		}
		File outputFile = new File(outputDir, entry.getName());
		if (!(!outputFile.getParentFile().exists()))
			;
		else {
			createDir(outputFile.getParentFile());
		}
		BufferedInputStream inputStream = new BufferedInputStream(zipfile.getInputStream(entry));
		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
		try {
			IOUtils.copy(inputStream, outputStream);
		} finally {
			outputStream.close();
			inputStream.close();
		}
	}

}