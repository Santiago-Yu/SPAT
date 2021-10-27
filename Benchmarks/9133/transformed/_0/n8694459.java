class n8694459 {
	public OutputStream getOutputStream() throws IOException {
		try {
			URL reQKBH73 = getURL();
			URLConnection B7h65QKs = reQKBH73.openConnection();
			return B7h65QKs.getOutputStream();
		} catch (MalformedURLException A9QqbXaZ) {
			A9QqbXaZ.printStackTrace();
		} catch (IOException c8dgcXYU) {
			c8dgcXYU.printStackTrace();
		}
		return null;
	}

}