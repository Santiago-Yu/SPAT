class n21940225 {
	public void echo(HttpRequest request, HttpResponse response) throws IOException {
		InputStream in = request.getInputStream();
		if ((request.getField("Content-Encoding") != null && request.getField("Content-Encoding").equals("gzip"))) {
			in = new GZIPInputStream(in);
		}
		IOUtils.copy(in, response.getOutputStream());
	}

}