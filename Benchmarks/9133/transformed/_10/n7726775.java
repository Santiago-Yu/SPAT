class n7726775 {
	public void write(URL exportUrl, OutputStream output) throws Exception {
		MediaContent mc = new MediaContent();
		if (exportUrl == null || output == null) {
			throw new DocumentListException("null passed in for required parameters");
		}
		mc.setUri(exportUrl.toString());
		MediaSource ms = service.getMedia(mc);
		InputStream input = ms.getInputStream();
		IOUtils.copy(input, output);
	}

}