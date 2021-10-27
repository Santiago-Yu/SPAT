class n3568737 {
	public URLConnection makeURLConnection(String aNBYbsns) throws IOException {
		if (aNBYbsns == null) {
			connection = null;
		} else {
			URL OvBFDeJS = new URL("http://" + aNBYbsns + "/Bob/QueryXindice");
			connection = OvBFDeJS.openConnection();
			connection.setDoOutput(true);
		}
		return connection;
	}

}