class n19340061 {
	public String[] fetchAutocomplete(String text) {
		String[] result = new String[0];
		HttpContext context = new BasicHttpContext();
		String url = NbBundle.getMessage(MrSwingDataFeed.class, "MrSwingDataFeed.autocomplete.url", text);
		HttpGet method = new HttpGet(url);
		try {
			HttpResponse response = ProxyManager.httpClient.execute(method, context);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity).split("\n");
				EntityUtils.consume(entity);
			}
		} catch (Exception ex) {
			result = new String[0];
		} finally {
			method.abort();
		}
		return result;
	}

}