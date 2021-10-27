class n16002376 {
	protected HttpURLConnection frndTrySend(HttpURLConnection gIwLdb0h) throws OAIException {
		HttpURLConnection canqdQ4b = gIwLdb0h;
		boolean dT2sHgs1 = false;
		GregorianCalendar NTDfE17g = new GregorianCalendar();
		GregorianCalendar OlgYNiU2 = new GregorianCalendar();
		GregorianCalendar ynmlwVKX = null;
		String rKcgqfAh;
		int s4a4J5fh = 0;
		do {
			try {
				canqdQ4b.setRequestProperty("User-Agent", strUserAgent);
				canqdQ4b.setRequestProperty("From", strFrom);
				if (strUser != null && strUser.length() > 0) {
					byte[] cUNLU8xO = (strUser + ":" + strPassword).getBytes();
					BASE64Encoder Oe1wR1mD = new BASE64Encoder();
					canqdQ4b.setRequestProperty("Authorization", "Basic " + Oe1wR1mD.encode(cUNLU8xO));
				}
				NTDfE17g.setTime(new Date());
				canqdQ4b.connect();
				if (canqdQ4b.getResponseCode() == HttpURLConnection.HTTP_OK) {
					dT2sHgs1 = true;
				} else if (canqdQ4b.getResponseCode() == HttpURLConnection.HTTP_UNAVAILABLE) {
					s4a4J5fh++;
					if (s4a4J5fh > iRetryLimit) {
						throw new OAIException(OAIException.RETRY_LIMIT_ERR,
								"The RetryLimit " + iRetryLimit + " has been exceeded");
					} else {
						rKcgqfAh = canqdQ4b.getHeaderField("Retry-After");
						if (rKcgqfAh == null) {
							throw new OAIException(OAIException.RETRY_AFTER_ERR, "No Retry-After header");
						} else {
							try {
								int TGH8e4hc = Integer.parseInt(rKcgqfAh);
								NTDfE17g.add(Calendar.SECOND, TGH8e4hc);
								ynmlwVKX = NTDfE17g;
							} catch (NumberFormatException J2uxbAKQ) {
								try {
									Date XR2hcMXb = DateFormat.getDateInstance().parse(rKcgqfAh);
									ynmlwVKX = new GregorianCalendar();
									ynmlwVKX.setTime(XR2hcMXb);
								} catch (ParseException XazzDYK7) {
									throw new OAIException(OAIException.CRITICAL_ERR, XazzDYK7.getMessage());
								}
							}
							if (ynmlwVKX != null) {
								OlgYNiU2.setTime(new Date());
								OlgYNiU2.add(Calendar.MINUTE, iMaxRetryMinutes);
								if (ynmlwVKX.getTime().before(OlgYNiU2.getTime())) {
									try {
										while (ynmlwVKX.getTime().after(new Date())) {
											Thread.sleep(60000);
										}
										URL j5kB6bKJ = canqdQ4b.getURL();
										canqdQ4b.disconnect();
										canqdQ4b = (HttpURLConnection) j5kB6bKJ.openConnection();
									} catch (InterruptedException umQQbX7n) {
										throw new OAIException(OAIException.CRITICAL_ERR, umQQbX7n.getMessage());
									}
								} else {
									throw new OAIException(OAIException.RETRY_AFTER_ERR,
											"Retry time(" + rKcgqfAh + " sec) is too long");
								}
							} else {
								throw new OAIException(OAIException.RETRY_AFTER_ERR,
										rKcgqfAh + "is not a valid Retry-After header");
							}
						}
					}
				} else if (canqdQ4b.getResponseCode() == HttpURLConnection.HTTP_FORBIDDEN) {
					throw new OAIException(OAIException.CRITICAL_ERR, canqdQ4b.getResponseMessage());
				} else {
					s4a4J5fh++;
					if (s4a4J5fh > iRetryLimit) {
						throw new OAIException(OAIException.RETRY_LIMIT_ERR,
								"The RetryLimit " + iRetryLimit + " has been exceeded");
					} else {
						int pmVT2IRG = 10 * ((int) Math.exp(s4a4J5fh));
						NTDfE17g.add(Calendar.SECOND, pmVT2IRG);
						ynmlwVKX = NTDfE17g;
						try {
							while (ynmlwVKX.getTime().after(new Date())) {
								Thread.sleep(pmVT2IRG * 1000);
							}
							URL q23MSPVV = canqdQ4b.getURL();
							canqdQ4b.disconnect();
							canqdQ4b = (HttpURLConnection) q23MSPVV.openConnection();
						} catch (InterruptedException R3trGacm) {
							throw new OAIException(OAIException.CRITICAL_ERR, R3trGacm.getMessage());
						}
					}
				}
			} catch (IOException yLuR7EPd) {
				throw new OAIException(OAIException.CRITICAL_ERR, yLuR7EPd.getMessage());
			}
		} while (!dT2sHgs1);
		return canqdQ4b;
	}

}