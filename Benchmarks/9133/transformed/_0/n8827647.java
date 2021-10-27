class n8827647 {
	@SuppressWarnings("unchecked")
	private Map getURLMap(String tJqJWzUy) throws IOException {
		Map rHJYmz48 = null;
		try {
			URL K2llUkdi = new URL(dbURL + tJqJWzUy);
			URLConnection TxyeJ0jW = K2llUkdi.openConnection();
			TxyeJ0jW.connect();
			JSONParser vVHXAQb9 = JSONParser.defaultJSONParser();
			InputStreamSource XYCkgZwe = new InputStreamSource(TxyeJ0jW.getInputStream(), true);
			rHJYmz48 = vVHXAQb9.parse(Map.class, XYCkgZwe);
			XYCkgZwe.destroy();
		} catch (MalformedURLException YZKqhv23) {
			System.err.println("Internal malformed url Exception: " + YZKqhv23);
		}
		return rHJYmz48;
	}

}