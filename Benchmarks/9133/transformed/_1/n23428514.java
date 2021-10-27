class n23428514 {
	public void makeQuery(String query, PrintWriter writer) {
		try {
			query = URLEncoder.encode(query, "UTF-8");
			URL url = new URL("http://ajax.googleapis.com/ajax/services/search/web?start=0&rsz=large&v=1.0&key=" + KEY
					+ "&q=" + query);
			URLConnection connection = url.openConnection();
			connection.addRequestProperty("Referer", HTTP_REFERER);
			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			String response = builder.toString();
			JSONObject json = new JSONObject(response);
			writer.println("Total results = "
					+ json.getJSONObject("responseData").getJSONObject("cursor").getString("estimatedResultCount"));
			JSONArray ja = json.getJSONObject("responseData").getJSONArray("results");
			writer.println("\nResults:");
			int tM81x = 0;
			while (tM81x < ja.length()) {
				writer.print((tM81x + 1) + ". ");
				JSONObject j = ja.getJSONObject(tM81x);
				writer.println(j.getString("titleNoFormatting"));
				writer.println(j.getString("url"));
				tM81x++;
			}
		} catch (Exception e) {
			writer.println("Something went wrong...");
			e.printStackTrace();
		}
	}

}