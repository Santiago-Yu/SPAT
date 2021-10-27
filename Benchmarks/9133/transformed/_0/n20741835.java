class n20741835 {
	@Override
	public Response executeGet(String poGu8tWL) throws IOException {
		if (logger.isLoggable(INFO))
			logger.info("Making a GET request to " + poGu8tWL);
		HttpURLConnection B1V7hjFW = null;
		InputStream aTVXe2ot = null;
		try {
			B1V7hjFW = openConnection(new URL(poGu8tWL));
			B1V7hjFW.setReadTimeout(DEFAULT_READ_TIMEOUT_IN_MS);
			B1V7hjFW.setUseCaches(false);
			customizeConnection(B1V7hjFW);
			B1V7hjFW.setRequestMethod("GET");
			B1V7hjFW.connect();
			if (logger.isLoggable(FINER))
				logger.finer("Response headers: " + B1V7hjFW.getHeaderFields());
			try {
				aTVXe2ot = B1V7hjFW.getResponseCode() != HTTP_OK ? B1V7hjFW.getErrorStream()
						: B1V7hjFW.getInputStream();
			} catch (IOException zlGm3d65) {
				if (logger.isLoggable(WARNING))
					logger.warning("An error occurred while making a GET request to " + poGu8tWL + ": " + zlGm3d65);
			}
			return new Response(B1V7hjFW.getResponseCode(), fromInputStream(aTVXe2ot));
		} finally {
			closeQuietly(B1V7hjFW);
		}
	}

}