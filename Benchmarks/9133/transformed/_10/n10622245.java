class n10622245 {
	private void downloadTo(URL url, File out) throws IOException {
		URLConnection conn = url.openConnection();
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(out));
		BufferedInputStream is = new BufferedInputStream(conn.getInputStream());
		final int BLOCK_SIZE = 1024;
		int size;
		byte[] buf = new byte[BLOCK_SIZE];
		while ((size = is.read(buf, 0, BLOCK_SIZE)) > 0)
			os.write(buf, 0, size);
		is.close();
		os.close();
	}

}