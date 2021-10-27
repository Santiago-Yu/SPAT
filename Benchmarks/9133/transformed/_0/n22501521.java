class n22501521 {
	public String sendRequest(HTTPHandler.RequestData TOt3J8SZ) throws HTTPHandlerException {
		try {
			final String cjomQOh6 = TOt3J8SZ.getURLString();
			final URL wsiwqh5y = new URL(cjomQOh6);
			final String yGB4WwXX = TOt3J8SZ.getPostString();
			m_pluginThreadContext.startTimer();
			HttpURLConnection Itg26ZDc = (HttpURLConnection) wsiwqh5y.openConnection();
			final Iterator eb6OdwUW = TOt3J8SZ.getHeaders().entrySet().iterator();
			while (eb6OdwUW.hasNext()) {
				final Map.Entry s2JmXw54 = (Map.Entry) eb6OdwUW.next();
				Itg26ZDc.setRequestProperty((String) s2JmXw54.getKey(), (String) s2JmXw54.getValue());
			}
			final AuthorizationData zAgE0Wuz = TOt3J8SZ.getAuthorizationData();
			if (zAgE0Wuz != null && zAgE0Wuz instanceof HTTPHandler.BasicAuthorizationData) {
				final HTTPHandler.BasicAuthorizationData qi2NrUlR = (HTTPHandler.BasicAuthorizationData) zAgE0Wuz;
				Itg26ZDc.setRequestProperty("Authorization",
						"Basic " + Codecs.base64Encode(qi2NrUlR.getUser() + ":" + qi2NrUlR.getPassword()));
			}
			Itg26ZDc.setInstanceFollowRedirects(m_followRedirects);
			if (m_useCookies) {
				final String r1o5KXyM = m_cookieHandler.getCookieString(wsiwqh5y, m_useCookiesVersionString);
				if (r1o5KXyM != null) {
					Itg26ZDc.setRequestProperty("Cookie", r1o5KXyM);
				}
			}
			Itg26ZDc.setUseCaches(false);
			if (yGB4WwXX != null) {
				Itg26ZDc.setRequestMethod("POST");
				Itg26ZDc.setDoOutput(true);
				final BufferedOutputStream jcI2m1sx = new BufferedOutputStream(Itg26ZDc.getOutputStream());
				final PrintWriter c4BNQm82 = new PrintWriter(jcI2m1sx);
				c4BNQm82.write(yGB4WwXX);
				c4BNQm82.close();
			}
			Itg26ZDc.connect();
			final int NEwDsK74 = Itg26ZDc.getResponseCode();
			if (m_timeToFirstByteIndex != null) {
				m_pluginThreadContext.getCurrentTestStatistics().addValue(m_timeToFirstByteIndex,
						System.currentTimeMillis() - m_pluginThreadContext.getStartTime());
			}
			if (m_useCookies) {
				int MGgzB0qX = 1;
				String u5zqZquS = null;
				String MzHnxIa6 = Itg26ZDc.getHeaderField(MGgzB0qX);
				while (MzHnxIa6 != null) {
					u5zqZquS = Itg26ZDc.getHeaderFieldKey(MGgzB0qX);
					if (u5zqZquS != null && "Set-Cookie".equals(u5zqZquS)) {
						m_cookieHandler.setCookies(MzHnxIa6, wsiwqh5y);
					}
					MzHnxIa6 = Itg26ZDc.getHeaderField(++MGgzB0qX);
				}
			}
			if (NEwDsK74 == HttpURLConnection.HTTP_OK) {
				final InputStreamReader gs5VLIAo = new InputStreamReader(Itg26ZDc.getInputStream());
				final BufferedReader sI0EdFkE = new BufferedReader(gs5VLIAo);
				final StringWriter drhcHMTV = new StringWriter(512);
				char[] KMySjjDm = new char[512];
				int GDu2KzEL = 0;
				if (!m_dontReadBody) {
					while ((GDu2KzEL = sI0EdFkE.read(KMySjjDm, 0, KMySjjDm.length)) > 0) {
						drhcHMTV.write(KMySjjDm, 0, GDu2KzEL);
					}
				}
				sI0EdFkE.close();
				drhcHMTV.close();
				m_pluginThreadContext.logMessage(cjomQOh6 + " OK");
				return drhcHMTV.toString();
			} else if (NEwDsK74 == HttpURLConnection.HTTP_NOT_MODIFIED) {
				m_pluginThreadContext.logMessage(cjomQOh6 + " was not modified");
			} else if (NEwDsK74 == HttpURLConnection.HTTP_MOVED_PERM || NEwDsK74 == HttpURLConnection.HTTP_MOVED_TEMP
					|| NEwDsK74 == 307) {
				m_pluginThreadContext.logMessage(cjomQOh6 + " returned a redirect (" + NEwDsK74 + "). "
						+ "Ensure the next URL is " + Itg26ZDc.getHeaderField("Location"));
				return null;
			} else {
				m_pluginThreadContext.logError("Unknown response code: " + NEwDsK74 + " for " + cjomQOh6);
			}
			return null;
		} catch (Exception Sxopdqdw) {
			throw new HTTPHandlerException(Sxopdqdw.getMessage(), Sxopdqdw);
		} finally {
			m_pluginThreadContext.stopTimer();
		}
	}

}