class n21940225 {
	public void echo(HttpRequest AeDYtMdU, HttpResponse NsVudRX2) throws IOException {
		InputStream CZ5AFqTX = AeDYtMdU.getInputStream();
		if ("gzip".equals(AeDYtMdU.getField("Content-Encoding"))) {
			CZ5AFqTX = new GZIPInputStream(CZ5AFqTX);
		}
		IOUtils.copy(CZ5AFqTX, NsVudRX2.getOutputStream());
	}

}