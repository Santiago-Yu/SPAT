class n4753713 {
	public ASDGrammarReader(String fileName, boolean includeCoords) throws IOException, MalformedURLException {
        includePixelCoords = includeCoords;
        fileName = fileName.trim();
        urlConnection = null;
        urlStream = null;
        if (!(fileName.substring(0, 5).equalsIgnoreCase("http:")))
			reader = new ASDTokenReader(new FileReader(fileName));
		else {
			URL fileURL = new URL(fileName);
			urlConnection = (HttpURLConnection) fileURL.openConnection();
			urlStream = urlConnection.getInputStream();
			reader = new ASDTokenReader(new BufferedReader(new InputStreamReader(urlStream)));
		}
    }

}