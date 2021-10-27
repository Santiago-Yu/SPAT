class n16347457 {
	public void start(OutputStream bytes, Target target) throws IOException {
		URLConnection conn = url.openConnection();
		byte[] buf = new byte[4096];
		InputStream fis = conn.getInputStream();
		while (true) {
			int bytesRead = fis.read(buf);
			if (bytesRead < 1)
				break;
			bytes.write(buf, 0, bytesRead);
		}
		fis.close();
	}

}