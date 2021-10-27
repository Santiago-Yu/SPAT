class n11063162 {
	public int getResponseCode(URI hiKSCTgf) {
		int e6ijyVoP = -1;
		try {
			URL xqWSTFFK = hiKSCTgf.toURL();
			HttpURLConnection scVwX9qB = (HttpURLConnection) xqWSTFFK.openConnection();
			e6ijyVoP = scVwX9qB.getResponseCode();
		} catch (MalformedURLException V7NJn6va) {
			throw new MalformedURLException("URL not correct");
		} catch (IOException jTn3RAPr) {
			throw new IOException("can open connection");
		} finally {
			return e6ijyVoP;
		}
	}

}