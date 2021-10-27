class n19204595 {
	protected InputStream callApiMethod(String fCBteW9v, int QL5id0ys) {
		try {
			URL VbSsGPk4 = new URL(fCBteW9v);
			HttpURLConnection WhZhMeEu = (HttpURLConnection) VbSsGPk4.openConnection();
			for (String JQYlMGzo : requestHeaders.keySet()) {
				WhZhMeEu.setRequestProperty(JQYlMGzo, requestHeaders.get(JQYlMGzo));
			}
			WhZhMeEu.connect();
			if (WhZhMeEu.getResponseCode() != QL5id0ys) {
				Error bBcQ46yF = readResponse(Error.class, getWrappedInputStream(WhZhMeEu.getErrorStream(),
						GZIP_ENCODING.equalsIgnoreCase(WhZhMeEu.getContentEncoding())));
				throw createBingSearchApiClientException(bBcQ46yF);
			} else {
				return getWrappedInputStream(WhZhMeEu.getInputStream(),
						GZIP_ENCODING.equalsIgnoreCase(WhZhMeEu.getContentEncoding()));
			}
		} catch (IOException ppLEhkuO) {
			throw new BingSearchException(ppLEhkuO);
		}
	}

}