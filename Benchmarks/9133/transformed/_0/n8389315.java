class n8389315 {
	public void copy(File pogooJhZ, File kQqvNXHI) throws IOException {
		FileChannel pS6o7p25 = (new FileInputStream(pogooJhZ)).getChannel();
		FileChannel b6usWsYc = (new FileOutputStream(kQqvNXHI)).getChannel();
		pS6o7p25.transferTo(0, pogooJhZ.length(), b6usWsYc);
		pS6o7p25.close();
		b6usWsYc.close();
	}

}