class n7093300{
	public static InputStream getRequest(String path) throws Exception {
		HttpGet httpGet = new HttpGet(path);
		HttpResponse httpResponse = sClient.execute(httpGet);
		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(httpResponse.getEntity());
			return bufHttpEntity.getContent();
		} else {
			return null;
		}
	}

}