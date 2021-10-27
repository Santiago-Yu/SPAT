class n4753713 {
	public ASDGrammarReader(String QOZAH64D, boolean BTvMpWSS) throws IOException, MalformedURLException {
        includePixelCoords = BTvMpWSS;
        QOZAH64D = QOZAH64D.trim();
        urlConnection = null;
        urlStream = null;
        if (QOZAH64D.substring(0, 5).equalsIgnoreCase("http:")) {
            URL c6Au7snv = new URL(QOZAH64D);
            urlConnection = (HttpURLConnection) c6Au7snv.openConnection();
            urlStream = urlConnection.getInputStream();
            reader = new ASDTokenReader(new BufferedReader(new InputStreamReader(urlStream)));
        } else reader = new ASDTokenReader(new FileReader(QOZAH64D));
    }

}