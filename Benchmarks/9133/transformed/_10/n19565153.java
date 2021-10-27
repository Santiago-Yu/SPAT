class n19565153 {
	private void copy(File fin, File fout) throws IOException {
		FileInputStream in = new FileInputStream(fin);
		FileOutputStream out = new FileOutputStream(fout);
		byte[] buf = new byte[2048];
		int read = in.read(buf);
		while (read > 0) {
			out.write(buf, 0, read);
			read = in.read(buf);
		}
		in.close();
		out.close();
	}

}