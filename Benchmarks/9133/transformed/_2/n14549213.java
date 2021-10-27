class n14549213 {
	public Result search(Object object) {
		if (object == null || !(object instanceof String)) {
			return null;
		}
		String query = (String) object;
		Result hitResult = new Result();
		Set<Hit> hits = new HashSet<Hit>(8);
		try {
			query = URLEncoder.encode(query, "UTF-8");
			URL url = new URL("http://ajax.googleapis.com/ajax/services/search/web?start=0&rsz=large&v=1.0&q=" + query);
			URLConnection connection = url.openConnection();
			connection.addRequestProperty("Referer", HTTP_REFERER);
			String line;
			StringBuilder builder = new StringBuilder();
			InputStream input = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			for (; (line = reader.readLine()) != null;) {
				builder.append(line);
			}
			input.close();
			String response = builder.toString();
			JSONObject json = new JSONObject(response);
			LOGGER.debug(json.getString("responseData"));
			int count = json.getJSONObject("responseData").getJSONObject("cursor").getInt("estimatedResultCount");
			hitResult.setEstimatedCount(count);
			JSONArray ja = json.getJSONObject("responseData").getJSONArray("results");
			for (int i = 0; i < ja.length(); i++) {
				JSONObject j = ja.getJSONObject(i);
				Hit hit = new Hit();
				String result = j.getString("titleNoFormatting");
				hit.setTitle(result == null || result.equals("") ? "${EMPTY}" : result);
				result = j.getString("url");
				hit.setUrl(new URL(result));
				hits.add(hit);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Something went wrong..." + e.getMessage());
		}
		hitResult.setHits(hits);
		return hitResult;
	}

}