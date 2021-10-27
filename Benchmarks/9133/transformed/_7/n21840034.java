class n21840034 {
	public FileOutputStream transfer(File from, File to, long mark) throws IOException, InterruptedException {
		if (out != null) {
			close();
		}
		FileChannel fch = new FileInputStream(from).getChannel();
		FileChannel rollch = new FileOutputStream(to).getChannel();
		long size = mark;
		int count = 0;
		try {
			while ((count = count + (rollch.transferFrom(fch, count, size - count))) < size) {
			}
		} finally {
			fch.close();
			rollch.close();
		}
		out = create(to);
		return out;
	}

}