class n5203784 {
	private String urlConnectionTranslate(String word) {
		try {
			URL url = new URL("http://ajax.googleapis.com/ajax/services/" + "language/translate?v=1.0&q=" + word
					+ "&langpair=is%7Cen");
			URLConnection connection = url.openConnection();
			connection.addRequestProperty("Referer", "http://www.hi.is");
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			JSONObject json = new JSONObject(builder.toString());
			return json.getJSONObject("responseData").getString("translatedText");
		} catch (Exception e) {
			Log.e(TranslatorApplication.tag, e.toString());
		}
		return null;
	}

}