class n3577906 {
	public static TestResponse get(String urlString, String accept) throws IOException {
		byte[] result = null;
		HttpURLConnection httpCon = null;
		byte[] errorResult = null;
		try {
			URL url = new URL(urlString);
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestMethod("GET");
			httpCon.setRequestProperty("Accept", accept);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			BufferedInputStream in = new BufferedInputStream(httpCon.getInputStream());
			int next = in.read();
			while (next > -1) {
				os.write(next);
				next = in.read();
			}
			os.flush();
			result = os.toByteArray();
			os.close();
		} catch (IOException e) {
		} finally {
			InputStream errorStream = httpCon.getErrorStream();
			if (errorStream != null) {
				ByteArrayOutputStream errorOs = new ByteArrayOutputStream();
				BufferedInputStream errorIn = new BufferedInputStream(errorStream);
				int errorNext = errorIn.read();
				while (errorNext > -1) {
					errorOs.write(errorNext);
					errorNext = errorIn.read();
				}
				errorOs.flush();
				errorResult = errorOs.toByteArray();
				errorOs.close();
			}
			return new TestResponse(httpCon.getResponseCode(), errorResult, result);
		}
	}

}