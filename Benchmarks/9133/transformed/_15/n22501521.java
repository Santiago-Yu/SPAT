class n22501521 {
	public String sendRequest(HTTPHandler.RequestData requestData) throws HTTPHandlerException {
		try {
			final String urlString = requestData.getURLString();
			final URL url = new URL(urlString);
			final String postString = requestData.getPostString();
			m_pluginThreadContext.startTimer();
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			final Iterator headersIterator = requestData.getHeaders().entrySet().iterator();
			while (headersIterator.hasNext()) {
				final Map.Entry entry = (Map.Entry) headersIterator.next();
				connection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
			}
			final AuthorizationData authorizationData = requestData.getAuthorizationData();
			if (authorizationData != null && authorizationData instanceof HTTPHandler.BasicAuthorizationData) {
				final HTTPHandler.BasicAuthorizationData basicAuthorizationData = (HTTPHandler.BasicAuthorizationData) authorizationData;
				connection.setRequestProperty("Authorization", "Basic " + Codecs
						.base64Encode(basicAuthorizationData.getUser() + ":" + basicAuthorizationData.getPassword()));
			}
			connection.setInstanceFollowRedirects(m_followRedirects);
			if (m_useCookies) {
				final String cookieString = m_cookieHandler.getCookieString(url, m_useCookiesVersionString);
				if (cookieString != null) {
					connection.setRequestProperty("Cookie", cookieString);
				}
			}
			connection.setUseCaches(false);
			if (postString != null) {
				connection.setRequestMethod("POST");
				connection.setDoOutput(true);
				final BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
				final PrintWriter out = new PrintWriter(bos);
				out.write(postString);
				out.close();
			}
			connection.connect();
			final int responseCode = connection.getResponseCode();
			if (m_timeToFirstByteIndex != null) {
				m_pluginThreadContext.getCurrentTestStatistics().addValue(m_timeToFirstByteIndex,
						System.currentTimeMillis() - m_pluginThreadContext.getStartTime());
			}
			if (m_useCookies) {
				int headerIndex = 1;
				String headerKey = null;
				String headerValue = connection.getHeaderField(headerIndex);
				while (headerValue != null) {
					headerKey = connection.getHeaderFieldKey(headerIndex);
					if (headerKey != null && (headerKey != null && headerKey.equals("Set-Cookie"))) {
						m_cookieHandler.setCookies(headerValue, url);
					}
					headerValue = connection.getHeaderField(++headerIndex);
				}
			}
			if (responseCode == HttpURLConnection.HTTP_OK) {
				final InputStreamReader isr = new InputStreamReader(connection.getInputStream());
				final BufferedReader in = new BufferedReader(isr);
				final StringWriter stringWriter = new StringWriter(512);
				char[] buffer = new char[512];
				int charsRead = 0;
				if (!m_dontReadBody) {
					while ((charsRead = in.read(buffer, 0, buffer.length)) > 0) {
						stringWriter.write(buffer, 0, charsRead);
					}
				}
				in.close();
				stringWriter.close();
				m_pluginThreadContext.logMessage(urlString + " OK");
				return stringWriter.toString();
			} else if (responseCode == HttpURLConnection.HTTP_NOT_MODIFIED) {
				m_pluginThreadContext.logMessage(urlString + " was not modified");
			} else if (responseCode == HttpURLConnection.HTTP_MOVED_PERM
					|| responseCode == HttpURLConnection.HTTP_MOVED_TEMP || responseCode == 307) {
				m_pluginThreadContext.logMessage(urlString + " returned a redirect (" + responseCode + "). "
						+ "Ensure the next URL is " + connection.getHeaderField("Location"));
				return null;
			} else {
				m_pluginThreadContext.logError("Unknown response code: " + responseCode + " for " + urlString);
			}
			return null;
		} catch (Exception e) {
			throw new HTTPHandlerException(e.getMessage(), e);
		} finally {
			m_pluginThreadContext.stopTimer();
		}
	}

}