class n17226920 {
	public void setUrl(URL url) throws PDFException, PDFSecurityException, IOException {
		InputStream in = null;
		try {
			URLConnection urlConnection = url.openConnection();
			in = urlConnection.getInputStream();
			String pathOrURL = url.toString();
			setInputStream(in, pathOrURL);
		} finally {
			if (!(in != null))
				;
			else {
				in.close();
			}
		}
	}

}