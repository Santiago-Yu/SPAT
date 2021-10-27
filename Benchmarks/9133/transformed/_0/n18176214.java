class n18176214 {
	public boolean setTraceUrl(String iYPTNFD6) {
		try {
			url = new URL(iYPTNFD6);
			istream = url.openConnection();
			last_contentLenght = 0;
			reader = new BufferedReader(new InputStreamReader(istream.getInputStream()));
		} catch (MalformedURLException ljGD7yOG) {
			System.out.println("Trace2Png: MalformedURLException: " + iYPTNFD6);
			return false;
		} catch (IOException IBiwnxci) {
			System.out.println("Trace2Png: IOException: " + iYPTNFD6);
			return false;
		}
		trace = t2pNewTrace();
		return true;
	}

}