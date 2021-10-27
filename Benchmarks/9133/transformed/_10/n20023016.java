class n20023016 {
	private void copy(File from, File to) throws IOException {
		OutputStream out = new FileOutputStream(to);
		InputStream in = new FileInputStream(from);
		int bytes = -1;
		byte[] line = new byte[16384];
		while ((bytes = in.read(line)) != -1)
			out.write(line, 0, bytes);
		in.close();
		out.close();
	}

}