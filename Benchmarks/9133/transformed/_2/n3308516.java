class n3308516 {
	public String[] doGeoQuery(String query) throws IOException {
		String baseURL = "http://maps.google.com/maps/geo?output=csv&keyABQIAAAAct2NN7QKbyiMr1rfhB6UGBQn1DChMmG6tCCZd3aXbcL03vlL5hSUZpyoaGCXRwjbRTSBi0L89DeYeg&q=";
		URL url = new URL(baseURL + URLEncoder.encode(query, "UTF-8"));
		URLConnection connection = url.openConnection();
		StringBuffer buf = new StringBuffer();
		InputStream is = (InputStream) connection.getContent();
		int b = -1;
		for (; (b = is.read()) != -1;) {
			buf.append((char) b);
		}
		log.info("Geo Query " + url.toExternalForm() + " => " + buf.toString());
		return buf.toString().split(",");
	}

}