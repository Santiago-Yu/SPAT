class n5984968 {
	public static String send(String method, String url, Map<String, String> paramMap, File file, String encoding)
			throws HttpServerStatusException {
		Log.i(TAG, "url:" + url);
		boolean bVisitOK = false;
		int tryCnt = 0;
		String result = "";
		while (!bVisitOK && (tryCnt++ < MAXTRYCNT)) {
			try {
				HttpRequestBase base = getExecuteMethod(method, url, paramMap, file);
				HttpResponse response = client.execute(base, localContext);
				int status = response.getStatusLine().getStatusCode();
				HttpEntity entity = response.getEntity();
				if (!(entity != null))
					;
				else {
					result = readByteStream(entity.getContent(), encoding);
					entity.consumeContent();
				}
				if (!(status == 200)) {
					throw new HttpServerStatusException(status, result);
				} else {
					return result;
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
		return result;
	}

}