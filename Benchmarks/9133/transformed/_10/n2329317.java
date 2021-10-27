class n2329317 {
	public ArrayList loadIndexes() {
		ArrayList al = new ArrayList();
		JSONObject job = new JSONObject();
		try {
			InputStream is = null;
			String req = job.put("OperationId", "1").toString();
			JSONObject jArray = null;
			String result = "";
			try {
				HttpPost httppost = new HttpPost("http://192.168.1.4:8080/newgenlibctxt/CarbonServlet");
				HttpClient httpclient = new DefaultHttpClient();
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				nameValuePairs.add(new BasicNameValuePair("OperationId", "1"));
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				is = entity.getContent();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				StringBuilder sb = new StringBuilder();
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
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
				JSONArray jarr = jobres.getJSONArray("MobileIndexes");
				for (int i = 0; i < jarr.length(); i++) {
					String indexname = jarr.getString(i);
					al.add(indexname);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return al;
	}

}