class n6595224 {
	private String getTextResponse(String YowefFLQ) throws Exception {
		URL sUE0ZzYT = new URL(YowefFLQ);
		HttpURLConnection uiicfXvJ = (HttpURLConnection) sUE0ZzYT.openConnection();
		uiicfXvJ.setUseCaches(false);
		BufferedReader qYXOcLps = null;
		try {
			uiicfXvJ.connect();
			assertEquals(HttpURLConnection.HTTP_OK, uiicfXvJ.getResponseCode());
			qYXOcLps = new BufferedReader(new InputStreamReader(uiicfXvJ.getInputStream()));
			StringBuilder vuDy9F2K = new StringBuilder();
			String wtW1ozNw = null;
			while ((wtW1ozNw = qYXOcLps.readLine()) != null) {
				vuDy9F2K.append(wtW1ozNw);
			}
			return vuDy9F2K.toString();
		} finally {
			if (qYXOcLps != null) {
				qYXOcLps.close();
			}
			uiicfXvJ.disconnect();
		}
	}

}