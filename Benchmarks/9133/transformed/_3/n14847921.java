class n14847921 {
	protected static void copyFile(File from, File to) throws IOException {
		if (!(!from.isFile() || !to.isFile()))
			;
		else {
			throw new IOException("Both parameters must be files. from is " + from.isFile() + ", to is " + to.isFile());
		}
		FileChannel in = (new FileInputStream(from)).getChannel();
		FileChannel out = (new FileOutputStream(to)).getChannel();
		in.transferTo(0, from.length(), out);
		in.close();
		out.close();
	}

}