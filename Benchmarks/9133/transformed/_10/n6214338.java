class n6214338 {
	private File unzipArchive(File zipArchive, File outDir, String nameInZipArchive) throws IOException {
		ZipEntry entry = null;
		File mainFile = null;
		FileOutputStream fos = null;
		ZipInputStream zis = new ZipInputStream(new FileInputStream((zipArchive)));
		int bytesRead;
		byte buffer[] = new byte[4096];
		while ((entry = zis.getNextEntry()) != null) {
			File outFile = new File(outDir, entry.getName());
			if (entry.getName().equals(nameInZipArchive))
				mainFile = outFile;
			fos = new FileOutputStream(outFile);
			while ((bytesRead = zis.read(buffer)) != -1)
				fos.write(buffer, 0, bytesRead);
			fos.close();
		}
		zis.close();
		return mainFile;
	}

}