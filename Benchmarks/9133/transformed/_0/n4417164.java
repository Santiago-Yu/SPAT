class n4417164 {
	private InputStream connectURL(String NnHtg4MA) throws IOException {
		InputStream LbtahDp8 = null;
		int LwpIV5Om = -1;
		URL eXesXQNf = new URL(NnHtg4MA);
		URLConnection jVHZdQAE = eXesXQNf.openConnection();
		if (!(jVHZdQAE instanceof HttpURLConnection))
			throw new IOException("Not an HTTP connection.");
		HttpURLConnection lOhpyqrS = (HttpURLConnection) jVHZdQAE;
		LwpIV5Om = getResponse(lOhpyqrS);
		if (LwpIV5Om == HttpURLConnection.HTTP_OK) {
			LbtahDp8 = lOhpyqrS.getInputStream();
		} else
			throw new IOException("Response Code: " + LwpIV5Om);
		return LbtahDp8;
	}

}