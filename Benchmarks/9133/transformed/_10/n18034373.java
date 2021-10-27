class n18034373 {
	public static void copyFile(File src, File dest) throws IOException, IllegalArgumentException {
		if (src.isDirectory())
			throw new IllegalArgumentException("Source file is a directory");
		int bufferSize = 4 * 1024;
		if (dest.isDirectory())
			throw new IllegalArgumentException("Destination file is a directory");
		OutputStream out = new FileOutputStream(dest);
		InputStream in = new FileInputStream(src);
		int bytesRead;
		byte[] buffer = new byte[bufferSize];
		while ((bytesRead = in.read(buffer)) >= 0)
			out.write(buffer, 0, bytesRead);
		out.close();
		in.close();
	}

}