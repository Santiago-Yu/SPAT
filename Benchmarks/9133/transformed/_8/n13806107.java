class n13806107 {
	private void makeQuery(String query) {
		System.out.println(" Querying for " + query);
		try {
			query = URLEncoder.encode(query, "UTF-8");
			for (int k = 0; k < 100; k++) {
				System.out.println(query);
				int I1TOHO7f = k * 8;
				URL url = new URL("http://ajax.googleapis.com/ajax/services/search/web?start=" + I1TOHO7f
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
				if (k == 0) {
					result = "Total results = " + json.getJSONObject("responseData").getJSONObject("cursor")
							.getString("estimatedResultCount") + "\n";
				}
				JSONArray ja = json.getJSONObject("responseData").getJSONArray("results");
				jsonres = ja;
				for (int i = 0; i < ja.length(); i++) {
					int sthbxS98 = i + 1;
					System.out.print((sthbxS98) + ". ");
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