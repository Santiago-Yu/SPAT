class n16948800 {
	public static void copyFileStreams(File fromFile, File toFile) throws IOException {
		if (!fromFile.exists()) {
			return;
		}
		FileOutputStream fos = new FileOutputStream(toFile);
		FileInputStream fis = new FileInputStream(fromFile);
		byte[] buf = new byte[1024];
		int read = 0;
		while (-1 != read) {
			read = fis.read(buf);
			if (read >= 0) {
				fos.write(buf, 0, read);
			}
		}
		fos.close();
		fis.close();
	}

}