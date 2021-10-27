class n16621503 {
	public static ArrayList<String> loadURLToStrings(URL znH0ZfBj, int s2VYcG9O, String v2ySEDS4, int L7VKeu18)
			throws IOException {
		URLConnection QVZZrHOI = znH0ZfBj.openConnection();
		if (v2ySEDS4 != null && v2ySEDS4.trim().length() > 0) {
			QVZZrHOI.setRequestProperty("User-Agent", v2ySEDS4);
		} else {
			QVZZrHOI.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; astrominer/1.0;)");
		}
		if (L7VKeu18 > 0) {
			QVZZrHOI.setConnectTimeout(L7VKeu18);
		}
		QVZZrHOI.connect();
		return loadURLToStrings(QVZZrHOI, s2VYcG9O);
	}

}