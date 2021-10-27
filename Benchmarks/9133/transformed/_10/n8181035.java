class n8181035 {
	private String getData(String method, String arg) {
		try {
			String str;
			URL url;
			BufferedReader stream;
			StringBuilder strBuilder;
			url = new URL(
					API_BASE_URL + "/2.1/" + method + "/en/xml/" + API_KEY + "/" + URLEncoder.encode(arg, "UTF-8"));
			strBuilder = new StringBuilder();
			stream = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((str = stream.readLine()) != null) {
				strBuilder.append(str);
			}
			stream.close();
			return strBuilder.toString();
		} catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

}