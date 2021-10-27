class n2867246 {
	public static void copyFile(File inputFile, File outputFile) throws IOException {
		BufferedOutputStream fw = new BufferedOutputStream(new FileOutputStream(outputFile));
		BufferedInputStream fr = new BufferedInputStream(new FileInputStream(inputFile));
		int n;
		byte[] buf = new byte[8192];
		while ((n = fr.read(buf)) >= 0)
			fw.write(buf, 0, n);
		fr.close();
		fw.close();
	}

}