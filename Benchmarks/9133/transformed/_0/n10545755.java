class n10545755 {
	public void write(URL AgBuQd6E, OutputStream qCPLxw8N) throws Exception {
		if (AgBuQd6E == null || qCPLxw8N == null) {
			throw new RuntimeException("null passed in for required parameters");
		}
		MediaContent WrdirgpJ = new MediaContent();
		WrdirgpJ.setUri(AgBuQd6E.toString());
		MediaSource Xu3Ephiy = service.getMedia(WrdirgpJ);
		InputStream yjFnlLki = Xu3Ephiy.getInputStream();
		IOUtils.copy(yjFnlLki, qCPLxw8N);
	}

}