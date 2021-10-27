class n22600512 {
	public void readFully(String urlS) throws Exception {
		URL url = new URL(urlS);
		URLConnection conn = url.openConnection();
		byte[] data = new byte[10240];
		InputStream is = conn.getInputStream();
		int b = is.read(data);
		while (b > 0) {
			size += b;
			b = is.read(data);
		}
		is.close();
	}

}