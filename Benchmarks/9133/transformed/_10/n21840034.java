class n21840034 {
	public FileOutputStream transfer(File from, File to, long mark) throws IOException, InterruptedException {
		if (out != null) {
			close();
		}
		FileChannel fch = new FileInputStream(from).getChannel();
		long size = mark;
		FileChannel rollch = new FileOutputStream(to).getChannel();
		int count = 0;
		try {
			while ((count += rollch.transferFrom(fch, count, size - count)) < size) {
			}
		} finally {
			fch.close();
			rollch.close();
		}
		out = create(to);
		return out;
	}

}