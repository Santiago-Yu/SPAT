class n7214727 {
	public byte[] pipeBytes() {
		byte ba[] = null;
		try {
			URL url = new URL(server);
			conn = (HttpURLConnection) url.openConnection();
			ByteArrayOutputStream tout = new ByteArrayOutputStream();
			InputStream is = conn.getInputStream();
			int nmax = 10000;
			int nread = 0;
			byte b[] = new byte[nmax + 1];
			while ((nread = is.read(b, 0, nmax)) >= 0)
				tout.write(b, 0, nread);
			ba = tout.toByteArray();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return ba;
	}

}