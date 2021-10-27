class n2915107 {
	public static void unZip(String unZipfileName, String outputDirectory) throws IOException, FileNotFoundException {
		File file;
		FileOutputStream fileOut;
		ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(unZipfileName)), encoder);
		ZipEntry zipEntry;
		while ((zipEntry = zipIn.getNextEntry()) != null) {
			file = new File(outputDirectory + File.separator + zipEntry.getName());
			if (zipEntry.isDirectory()) {
				createDirectory(file.getPath(), "");
			} else {
				File parent = file.getParentFile();
				fileOut = new FileOutputStream(file);
				if (!parent.exists()) {
					createDirectory(parent.getPath(), "");
				}
				int readedBytes;
				while ((readedBytes = zipIn.read(buf)) > 0) {
					fileOut.write(buf, 0, readedBytes);
				}
				fileOut.close();
			}
			zipIn.closeEntry();
		}
	}

}