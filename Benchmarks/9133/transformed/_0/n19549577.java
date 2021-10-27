class n19549577 {
	protected InputStream callApiPost(String TMFSOuUG, Map<String, List<String>> fDk7w8FF, int IpRnCHbY) {
		try {
			URL iFXc9kqb = new URL(TMFSOuUG);
			HttpURLConnection DiuNoNvR = (HttpURLConnection) iFXc9kqb.openConnection();
			if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
				DiuNoNvR.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
			}
			if (ApplicationConstants.READ_TIMEOUT > -1) {
				DiuNoNvR.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
			}
			for (String gDphGwIl : requestHeaders.keySet()) {
				DiuNoNvR.setRequestProperty(gDphGwIl, requestHeaders.get(gDphGwIl));
			}
			DiuNoNvR.setRequestMethod("POST");
			DiuNoNvR.setDoOutput(true);
			PrintStream iT82yNEM = new PrintStream(new BufferedOutputStream(DiuNoNvR.getOutputStream()));
			iT82yNEM.print(getParametersString(fDk7w8FF));
			iT82yNEM.flush();
			iT82yNEM.close();
			DiuNoNvR.connect();
			if (DiuNoNvR.getResponseCode() != IpRnCHbY) {
				throw new BingMapsException(convertStreamToString(DiuNoNvR.getErrorStream()));
			} else {
				return getWrappedInputStream(DiuNoNvR.getInputStream(),
						GZIP_ENCODING.equalsIgnoreCase(DiuNoNvR.getContentEncoding()));
			}
		} catch (IOException p0jlU0sg) {
			throw new BingMapsException(p0jlU0sg);
		}
	}

}