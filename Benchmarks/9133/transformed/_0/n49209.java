class n49209 {
	private void makeConn(String rrGyBZyR, String DIEwH9yw) {
		String o2VbukYc = "http://www.bestmm.com/";
		String hFwtJRrF = o2VbukYc + rrGyBZyR + "/pic/" + DIEwH9yw + ".jpg";
		URL eZJ5CW6L = null;
		try {
			eZJ5CW6L = new URL(hFwtJRrF);
		} catch (MalformedURLException CqxQG5yx) {
			System.err.println("URL Format Error!");
			System.exit(1);
		}
		try {
			conn = (HttpURLConnection) eZJ5CW6L.openConnection();
		} catch (IOException ZlAQj5x3) {
			System.err.println("Error IO");
			System.exit(2);
		}
	}

}