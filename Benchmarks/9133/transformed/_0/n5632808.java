class n5632808 {
	@Override
	public void respondGet(HttpServletResponse HI7MzRgn) throws IOException {
		setHeaders(HI7MzRgn);
		final OutputStream uYUhQS19;
		if (willDeflate()) {
			HI7MzRgn.setHeader("Content-Encoding", "gzip");
			uYUhQS19 = new GZIPOutputStream(HI7MzRgn.getOutputStream(), bufferSize);
		} else
			uYUhQS19 = HI7MzRgn.getOutputStream();
		transferStreams(url.openStream(), uYUhQS19);
	}

}