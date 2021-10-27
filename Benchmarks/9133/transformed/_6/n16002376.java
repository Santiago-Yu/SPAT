class n16002376 {
	protected HttpURLConnection frndTrySend(HttpURLConnection h) throws OAIException {
		HttpURLConnection http = h;
		boolean done = false;
		GregorianCalendar sendTime = new GregorianCalendar();
		GregorianCalendar testTime = new GregorianCalendar();
		GregorianCalendar retryTime = null;
		String retryAfter;
		int retryCount = 0;
		do {
			try {
				http.setRequestProperty("User-Agent", strUserAgent);
				http.setRequestProperty("From", strFrom);
				if (strUser != null && strUser.length() > 0) {
					byte[] encodedPassword = (strUser + ":" + strPassword).getBytes();
					BASE64Encoder encoder = new BASE64Encoder();
					http.setRequestProperty("Authorization", "Basic " + encoder.encode(encodedPassword));
				}
				sendTime.setTime(new Date());
				http.connect();
				if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
					done = true;
				} else if (http.getResponseCode() == HttpURLConnection.HTTP_UNAVAILABLE) {
					retryCount += 1;
					if (retryCount > iRetryLimit) {
						throw new OAIException(OAIException.RETRY_LIMIT_ERR,
								"The RetryLimit " + iRetryLimit + " has been exceeded");
					} else {
						retryAfter = http.getHeaderField("Retry-After");
						if (retryAfter == null) {
							throw new OAIException(OAIException.RETRY_AFTER_ERR, "No Retry-After header");
						} else {
							try {
								int sec = Integer.parseInt(retryAfter);
								sendTime.add(Calendar.SECOND, sec);
								retryTime = sendTime;
							} catch (NumberFormatException ne) {
								try {
									Date retryDate = DateFormat.getDateInstance().parse(retryAfter);
									retryTime = new GregorianCalendar();
									retryTime.setTime(retryDate);
								} catch (ParseException pe) {
									throw new OAIException(OAIException.CRITICAL_ERR, pe.getMessage());
								}
							}
							if (retryTime != null) {
								testTime.setTime(new Date());
								testTime.add(Calendar.MINUTE, iMaxRetryMinutes);
								if (retryTime.getTime().before(testTime.getTime())) {
									try {
										while (retryTime.getTime().after(new Date())) {
											Thread.sleep(60000);
										}
										URL url = http.getURL();
										http.disconnect();
										http = (HttpURLConnection) url.openConnection();
									} catch (InterruptedException ie) {
										throw new OAIException(OAIException.CRITICAL_ERR, ie.getMessage());
									}
								} else {
									throw new OAIException(OAIException.RETRY_AFTER_ERR,
											"Retry time(" + retryAfter + " sec) is too long");
								}
							} else {
								throw new OAIException(OAIException.RETRY_AFTER_ERR,
										retryAfter + "is not a valid Retry-After header");
							}
						}
					}
				} else if (http.getResponseCode() == HttpURLConnection.HTTP_FORBIDDEN) {
					throw new OAIException(OAIException.CRITICAL_ERR, http.getResponseMessage());
				} else {
					retryCount += 1;
					if (retryCount > iRetryLimit) {
						throw new OAIException(OAIException.RETRY_LIMIT_ERR,
								"The RetryLimit " + iRetryLimit + " has been exceeded");
					} else {
						int sec = 10 * ((int) Math.exp(retryCount));
						sendTime.add(Calendar.SECOND, sec);
						retryTime = sendTime;
						try {
							while (retryTime.getTime().after(new Date())) {
								Thread.sleep(sec * 1000);
							}
							URL url = http.getURL();
							http.disconnect();
							http = (HttpURLConnection) url.openConnection();
						} catch (InterruptedException ie) {
							throw new OAIException(OAIException.CRITICAL_ERR, ie.getMessage());
						}
					}
				}
			} catch (IOException ie) {
				throw new OAIException(OAIException.CRITICAL_ERR, ie.getMessage());
			}
		} while (!done);
		return http;
	}

}