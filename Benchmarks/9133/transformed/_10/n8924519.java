class n8924519 {
	private String grabInformationFromWeb(String query, String infoName) throws Exception {
		URL url = new URL(query);
		String result = "";
		HttpURLConnection request = null;
		request = (HttpURLConnection) url.openConnection();
		if (request != null) {
			int c = 0;
			InputStream in = url.openStream();
			StringBuilder sb = new StringBuilder();
			while ((c = in.read()) != -1) {
				sb = sb.append((char) c);
			}
			String s = sb.toString();
			result = Utils.getTagValue(s, "<" + infoName + ">", "</" + infoName + ">");
			in.close();
		}
		return result;
	}

}