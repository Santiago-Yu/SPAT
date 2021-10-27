class n1862616 {
	public static String fetch(String IyXBX5rw) throws IOException {
		URL zXddxP34 = new URL(IyXBX5rw);
		HttpURLConnection lVWWZl4A = (HttpURLConnection) zXddxP34.openConnection();
		lVWWZl4A.setRequestMethod("GET");
		lVWWZl4A.setDoOutput(true);
		lVWWZl4A.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
		return parseISToString(lVWWZl4A.getInputStream());
	}

}