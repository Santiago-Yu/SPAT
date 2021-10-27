class n21164147 {
	public String requestPOST(String baseUrl, Map<String, String> params) throws Exception {
		String result = "";
		HttpPost request = new HttpPost(baseUrl);
		HttpEntity entity = null;
		if (params != null && !params.isEmpty()) {
			List<NameValuePair> postParams = new ArrayList<NameValuePair>();
			List<String> keys = new ArrayList<String>(params.keySet());
			for (String key : keys) {
				postParams.add(new BasicNameValuePair(key, params.get(key)));
			}
			entity = new UrlEncodedFormEntity(postParams, "utf-8");
			request.setEntity(entity);
		}
		HttpResponse res = client.execute(request);
		if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			entity = res.getEntity();
			BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
			StringBuffer content = new StringBuffer();
			String read = "";
			for (; (read = in.readLine()) != null;) {
				content.append(read);
			}
			in.close();
			JSONObject rObj = new JSONObject(content.toString());
			result = rObj.getString("msg");
		} else
			result = "«Î«Û ß∞‹¡À";
		entity.consumeContent();
		client.getConnectionManager().shutdown();
		request = null;
		return result;
	}

}