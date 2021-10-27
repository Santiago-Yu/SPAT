class n11594590 {
	public <T extends FetionResponse> T executeAction(FetionAction<T> fetionAction) throws IOException {
		URL url = new URL(
				fetionAction.getProtocol().name().toLowerCase() + "://" + fetionUrl + fetionAction.getRequestData());
		URLConnection connection = url.openConnection();
		byte[] buffer = new byte[10240];
		InputStream in = connection.getInputStream();
		int read = 0;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		while ((read = in.read(buffer)) > 0) {
			bout.write(buffer, 0, read);
		}
		return fetionAction.processResponse(parseRawResponse(bout.toByteArray()));
	}

}