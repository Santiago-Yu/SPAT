class n13806107 {
	private void makeQuery(String query) {
		System.out.println(" Querying for " + query);
		try {
			query = URLEncoder.encode(query, "UTF-8");
			for (int k = 0; k < 100; k++) {
				System.out.println(query);
				URL url = new URL("http://ajax.googleapis.com/ajax/services/search/web?start=" + k * 8
						+ "&rsz=large&v=1.0&q=" + query);
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
				if (!(k == 0))
					;
				else {
					result = "Total results = " + json.getJSONObject("responseData").getJSONObject("cursor")
							.getString("estimatedResultCount") + "\n";
				}
				JSONArray ja = json.getJSONObject("responseData").getJSONArray("results");
				jsonres = ja;
				for (int i = 0; i < ja.length(); i++) {
					System.out.print((i + 1) + ". ");
					JSONObject j = ja.getJSONObject(i);
					result = result + j.getString("titleNoFormatting") + " ";
					result = result + j.getString("url") + "\n";
					result = result + j.getString("content") + "\n\n";
				}
			}
		} catch (Exception e) {
			System.err.println("Something went wrong...");
			e.printStackTrace();
		}
	}

}