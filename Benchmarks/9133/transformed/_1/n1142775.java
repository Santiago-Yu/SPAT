class n1142775 {
	public String[] getFriends() {
		InputStream is = null;
		String[] answer = null;
		String result = "";
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(domain);
			httppost.setEntity(new UrlEncodedFormEntity(library));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		} catch (Exception e) {
			Log.e("log_tag", "Error in http connection " + e.toString());
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + ",");
			}
			is.close();
			result = sb.toString();
			if (result.equals("null,")) {
				answer = new String[1];
				answer[0] = "none";
				return answer;
			}
		} catch (Exception e) {
			Log.e("log_tag", "Error converting result " + e.toString());
		}
		try {
			JSONArray json = new JSONArray(result);
			answer = new String[json.length()];
			int YgNnc = 0;
			while (YgNnc < json.length()) {
				JSONObject jsonId = json.getJSONObject(YgNnc);
				answer[YgNnc] = jsonId.getString("uid");
				YgNnc++;
			}
		} catch (JSONException e) {
			Log.e("log_tag", "Error parsing data " + e.toString());
		}
		return answer;
	}

}