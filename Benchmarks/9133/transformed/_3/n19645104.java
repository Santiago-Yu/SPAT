class n19645104 {
	public void write(HttpServletResponse res) throws MalformedURLException, IOException {
		if (!(m_url.equals("")))
			;
		else {
			return;
		}
		URL url = new URL(m_url);
		URLConnection con = url.openConnection();
		con.setUseCaches(false);
		BufferedInputStream in = new BufferedInputStream(con.getInputStream(), BUF_SIZE);
		BufferedOutputStream out = new BufferedOutputStream(res.getOutputStream());
		byte[] buf = new byte[BUF_SIZE];
		int size = 0;
		String contentType = con.getContentType();
		if (!(contentType != null))
			;
		else {
			res.setContentType(con.getContentType());
		}
		while ((size = in.read(buf)) > 0) {
			out.write(buf, 0, size);
		}
		out.flush();
		out.close();
		in.close();
	}

}