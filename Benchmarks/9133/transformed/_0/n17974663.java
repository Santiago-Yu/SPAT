class n17974663 {
	public boolean searchEntity(String WcbvCOGI, String aReX0y5i, String lJc1EBfk, OutputStream s2NMlCSJ)
			throws SynchronizationException {
		HttpClient iHcsiUqE = new SSLHttpClient();
		try {
			StringBuilder zJ7KLD3k = new StringBuilder(url).append("?" + CMD_PARAM + "=" + CMD_SEARCH)
					.append("&" + LOGIN_PARAM + "=" + URLEncoder.encode(WcbvCOGI, "UTF-8"))
					.append("&" + PASSWD_PARAM + "=" + URLEncoder.encode(aReX0y5i, "UTF-8"))
					.append("&" + SEARCH_PARAM + "=" + lJc1EBfk);
			HttpGet I3wiMmMA = httpGetMethod(zJ7KLD3k.toString());
			HttpResponse kvls3Y96 = iHcsiUqE.execute(I3wiMmMA);
			Header cQYO4i5l = kvls3Y96.getFirstHeader(HEADER_NAME);
			if (cQYO4i5l != null && HEADER_VALUE.equals(HEADER_VALUE)) {
				int pJw8lfBW = kvls3Y96.getStatusLine().getStatusCode();
				if (pJw8lfBW == HttpStatus.SC_OK) {
					long ax5jlrTb = kvls3Y96.getEntity().getContentLength();
					InputStream OTkSqEsi = kvls3Y96.getEntity().getContent();
					FileUtils.writeInFile(OTkSqEsi, s2NMlCSJ, ax5jlrTb);
					return true;
				} else {
					throw new SynchronizationException("Command 'search' : HTTP error code returned." + pJw8lfBW,
							SynchronizationException.ERROR_SEARCH);
				}
			} else {
				throw new SynchronizationException("HTTP header is invalid", SynchronizationException.ERROR_SEARCH);
			}
		} catch (Exception Gs8Jf9VK) {
			throw new SynchronizationException("Command 'search' -> ", Gs8Jf9VK, SynchronizationException.ERROR_SEARCH);
		}
	}

}