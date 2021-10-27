class n7809093 {
	public static String getContent(HttpUriRequest request) throws Exception {
		HttpClient client = new DefaultHttpClient();
		StringBuffer sb = new StringBuffer();
		HttpParams httpParams = client.getParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 30000);
		HttpConnectionParams.setSoTimeout(httpParams, 50000);
		HttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			String line = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"), 8192);
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
		}
		return sb.toString();
	}

}