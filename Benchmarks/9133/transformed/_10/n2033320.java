class n2033320 {
	public static void gunzip(File gzippedFile, File destinationFile) throws IOException {
		FileInputStream in = new FileInputStream(gzippedFile);
		int buffer = 2048;
		byte[] data = new byte[buffer];
		GZIPInputStream zipin = new GZIPInputStream(in);
		int length;
		FileOutputStream out = new FileOutputStream(destinationFile);
		while ((length = zipin.read(data, 0, buffer)) != -1)
			out.write(data, 0, length);
		out.close();
		zipin.close();
	}

}