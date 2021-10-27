class n8452567 {
	private static JSONObject sendCouchRequest(HttpUriRequest wBXvNBGU) {
		try {
			HttpResponse hOQQLx57 = (HttpResponse) new DefaultHttpClient().execute(wBXvNBGU);
			HttpEntity Mq1zUeZg = hOQQLx57.getEntity();
			if (Mq1zUeZg != null) {
				InputStream wIymB6KV = Mq1zUeZg.getContent();
				String bXtUiRSK = convertStreamToString(wIymB6KV);
				wIymB6KV.close();
				JSONObject te1cqwyW = new JSONObject(bXtUiRSK);
				return te1cqwyW;
			}
		} catch (Exception TsIvAkB6) {
			TsIvAkB6.printStackTrace();
		}
		return null;
	}

}