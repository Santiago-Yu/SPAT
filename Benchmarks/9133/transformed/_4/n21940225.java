class n21940225 {
	public void echo(HttpRequest request, HttpResponse response) throws IOException {
		InputStream in = request.getInputStream();
		in = ("gzip".equals(request.getField("Content-Encoding"))) ? new GZIPInputStream(in) : in;
		IOUtils.copy(in, response.getOutputStream());
	}

}