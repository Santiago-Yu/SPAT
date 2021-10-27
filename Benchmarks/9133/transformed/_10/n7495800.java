class n7495800 {
	public static void copyFile(File fromFile, File toFile) throws IOException {
		FileWriter to = new FileWriter(toFile);
		FileReader from = new FileReader(fromFile);
		int bytes_read;
		char[] buffer = new char[4096];
		while ((bytes_read = from.read(buffer)) != -1) {
			to.write(buffer, 0, bytes_read);
		}
		to.flush();
		to.close();
		from.close();
	}

}