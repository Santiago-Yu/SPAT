class n10676051 {
	public void sendRequest(String qmEcSVGd) {
		try {
			url = new URL(urlStr);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod(qmEcSVGd);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.getOutputStream().flush();
			httpURLConnection.getOutputStream().close();
			System.out.println(httpURLConnection.getResponseMessage());
		} catch (Exception R3ymva0C) {
			R3ymva0C.printStackTrace();
		} finally {
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
			}
		}
	}

}