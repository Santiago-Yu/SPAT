class n13420786 {
	public static void unzip(File zipInFile, File outputDir) throws Exception {
		ZipFile zipFile = new ZipFile(zipInFile);
		Enumeration<? extends ZipEntry> entries;
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipInFile));
		File curOutDir = outputDir;
		ZipEntry entry = (ZipEntry) zipInputStream.getNextEntry();
		while (entry != null) {
			if (entry.isDirectory()) {
				curOutDir = new File(curOutDir, entry.getName());
				curOutDir.mkdirs();
				continue;
			}
			File outFile = new File(curOutDir, entry.getName());
			File tempDir = outFile.getParentFile();
			if (!tempDir.exists())
				tempDir.mkdirs();
			outFile.createNewFile();
			int n;
			BufferedOutputStream outstream = new BufferedOutputStream(new FileOutputStream(outFile));
			byte[] buf = new byte[1024];
			while ((n = zipInputStream.read(buf, 0, 1024)) > -1)
				outstream.write(buf, 0, n);
			outstream.flush();
			outstream.close();
			zipInputStream.closeEntry();
			entry = zipInputStream.getNextEntry();
		}
		zipInputStream.close();
		zipFile.close();
	}

}