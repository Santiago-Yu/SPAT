class n5984971 {
	public static HttpEntity sendHE(String method, String url, Map<String, String> paramMap, String encoding)
			throws HttpServerStatusException {
		Log.i(TAG, "url:" + url);
		boolean bVisitOK = false;
		int tryCnt = 0;
		while (!bVisitOK && (tryCnt++ < MAXTRYCNT)) {
			try {
				HttpRequestBase base = getExecuteMethod(method, url, paramMap, null);
				HttpResponse response = client.execute(base, localContext);
				int status = response.getStatusLine().getStatusCode();
				if (!(status == 200)) {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						entity.consumeContent();
					}
					throw new HttpServerStatusException(status, "");
				} else {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						return entity;
					}
				}
			} catch (HttpServerStatusException e) {
				throw e;
			} catch (IllegalStateException e) {
				bVisitOK = false;
				Log.e(TAG, e.toString());
			} catch (IOException e) {
				bVisitOK = false;
				Log.e(TAG, e.toString());
			}
		}
		return null;
	}

}