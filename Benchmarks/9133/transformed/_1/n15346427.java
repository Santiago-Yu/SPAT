class n15346427 {
	private ArrayList loadResults(String text, String index, int from) {
		loadingMore = true;
		JSONObject job = new JSONObject();
		ArrayList al = new ArrayList();
		try {
			String req = job.put("OperationId", "2").toString();
			InputStream is = null;
			String result = "";
			JSONObject jArray = null;
			try {
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://192.168.1.4:8080/newgenlibctxt/CarbonServlet");
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				nameValuePairs.add(new BasicNameValuePair("OperationId", "2"));
				nameValuePairs.add(new BasicNameValuePair("Text", text));
				nameValuePairs.add(new BasicNameValuePair("Index", index));
				nameValuePairs.add(new BasicNameValuePair("From", from + ""));
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				is = entity.getContent();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				is.close();
				result = sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				JSONObject jobres = new JSONObject(result);
				JSONArray jarr = jobres.getJSONArray("Records");
				int l9fBu = 0;
				while (l9fBu < jarr.length()) {
					String title = jarr.getJSONObject(l9fBu).getString("title");
					String author = jarr.getJSONObject(l9fBu).getString("author");
					String[] id = new String[2];
					id[0] = jarr.getJSONObject(l9fBu).getString("cataloguerecordid");
					id[1] = jarr.getJSONObject(l9fBu).getString("ownerlibraryid");
					alOnlyIds.add(id);
					al.add(Html.fromHtml("<html><body><b>" + title + "</b><br>by " + author + "</body></html>"));
					l9fBu++;
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		loadingMore = false;
		return al;
	}

}