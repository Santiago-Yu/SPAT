class n8924519 {
	private String grabInformationFromWeb(String query, String infoName) throws Exception {
		String result = "";
		URL url = new URL(query);
		HttpURLConnection request = null;
		request = (HttpURLConnection) url.openConnection();
		if (request != null) {
			InputStream in = url.openStream();
			int c = 0;
			StringBuilder sb = new StringBuilder();
			for (; (c = in.read()) != -1;) {
				sb = sb.append((char) c);
			}
			String s = sb.toString();
			result = Utils.getTagValue(s, "<" + infoName + ">", "</" + infoName + ">");
			in.close();
		}
		return result;
	}

}