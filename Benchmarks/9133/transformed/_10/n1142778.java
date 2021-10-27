class n1142778 {
	public String getChallengers() {
		String result = "";
		InputStream is = null;
		try {
			HttpPost httppost = new HttpPost(domain);
			HttpClient httpclient = new DefaultHttpClient();
			httppost.setEntity(new UrlEncodedFormEntity(library));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		} catch (Exception e) {
			Log.e("log_tag", "Error in http connection " + e.toString());
		}
		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + ",");
			}
			is.close();
			result = sb.toString();
			if (result.equals("null,")) {
				return "none";
			} else
				return result;
		} catch (Exception e) {
			Log.e("log_tag", "Error converting result " + e.toString());
		}
		return "none";
	}

}