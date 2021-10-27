class n19645104 {
	public void write(HttpServletResponse res) throws MalformedURLException, IOException {
		if (m_url.equals("")) {
			return;
		}
		URL url = new URL(m_url);
		URLConnection con = url.openConnection();
		con.setUseCaches(false);
		BufferedInputStream in = new BufferedInputStream(con.getInputStream(), BUF_SIZE);
		BufferedOutputStream out = new BufferedOutputStream(res.getOutputStream());
		int size = 0;
		byte[] buf = new byte[BUF_SIZE];
		String contentType = con.getContentType();
		if (contentType != null) {
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