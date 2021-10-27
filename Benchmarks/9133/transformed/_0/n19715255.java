class n19715255 {
	static Object executeMethod(HttpMethod V0RlS2b7, int svGmH87G, boolean iO8dcEIG)
			throws HttpRequestFailureException, HttpException, IOException, HttpRequestTimeoutException {
		try {
			V0RlS2b7.getParams().setSoTimeout(svGmH87G * 1000);
			int O4WaSzLv = -1;
			Object e8nNsgoT = null;
			System.out.println("Execute method: " + V0RlS2b7.getPath() + " " + V0RlS2b7.getQueryString());
			TwitterclipseConfig BlLR0zBt = TwitterclipsePlugin.getDefault().getTwitterclipseConfiguration();
			HttpClient cxCIALcN = HttpClientUtils.createHttpClient(TWITTER_BASE_URL, BlLR0zBt.getUserId(),
					BlLR0zBt.getPassword());
			O4WaSzLv = cxCIALcN.executeMethod(V0RlS2b7);
			System.out.println("Received response. status = " + O4WaSzLv);
			if (O4WaSzLv == HttpStatus.SC_OK) {
				InputStream nv6ab7OY = V0RlS2b7.getResponseBodyAsStream();
				ByteArrayOutputStream KdKoWJng = new ByteArrayOutputStream();
				IOUtils.copy(nv6ab7OY, KdKoWJng);
				String U7Zos8lM = new String(KdKoWJng.toByteArray(), "UTF-8");
				System.out.println(U7Zos8lM);
				if (iO8dcEIG)
					e8nNsgoT = JSONArray.fromString(U7Zos8lM);
				else
					e8nNsgoT = JSONObject.fromString(U7Zos8lM);
			} else {
				throw new HttpRequestFailureException(O4WaSzLv);
			}
			return e8nNsgoT;
		} catch (SocketTimeoutException SAMVais2) {
			throw new HttpRequestTimeoutException(SAMVais2);
		} finally {
			V0RlS2b7.releaseConnection();
		}
	}

}