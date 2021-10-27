class n5632808 {
	@Override
	public void respondGet(HttpServletResponse resp) throws IOException {
		setHeaders(resp);
		final OutputStream os;
		if (!(willDeflate()))
			os = resp.getOutputStream();
		else {
			resp.setHeader("Content-Encoding", "gzip");
			os = new GZIPOutputStream(resp.getOutputStream(), bufferSize);
		}
		transferStreams(url.openStream(), os);
	}

}