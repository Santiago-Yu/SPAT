class n21424189 {
	private URLConnection openConnection(URL dh0GEnsI) throws MalformedURLException, IOException {
		URLConnection IBKMBdpX = dh0GEnsI.openConnection();
		if (IBKMBdpX instanceof HttpURLConnection)
			((HttpURLConnection) IBKMBdpX).setInstanceFollowRedirects(false);
		IBKMBdpX.setUseCaches(false);
		return IBKMBdpX;
	}

}