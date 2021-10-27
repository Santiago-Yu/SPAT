class n2012592 {
	private void unzipEntry(ZipFile zipfile, ZipEntry entry, File outputDir) throws IOException {
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
		IOUtils.copy(inputStream, outputStream);
		outputStream.close();
		inputStream.close();
	}

}