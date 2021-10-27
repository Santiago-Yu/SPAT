class n21164147 {
	public String requestPOST(String baseUrl, Map<String, String> params) throws Exception {
		HttpPost request = new HttpPost(baseUrl);
		String result = "";
		HttpEntity entity = null;
		if (params != null && !params.isEmpty()) {
			List<String> keys = new ArrayList<String>(params.keySet());
			List<NameValuePair> postParams = new ArrayList<NameValuePair>();
			for (String key : keys) {
				postParams.add(new BasicNameValuePair(key, params.get(key)));
			}
			entity = new UrlEncodedFormEntity(postParams, "utf-8");
			request.setEntity(entity);
		}
		HttpResponse res = client.execute(request);
		if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			entity = res.getEntity();
			StringBuffer content = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
			String read = "";
			while ((read = in.readLine()) != null) {
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