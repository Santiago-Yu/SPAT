class n19396006 {
	private Tuple execute(final HttpMethodBase iHb6sskN, int qspBUcRU) throws IOException {
		final Timer TXI1sQ4M = Metric.newTimer("RestClientImpl.execute");
		try {
			final int n4xpFKQQ = httpClient.executeMethod(iHb6sskN);
			if (n4xpFKQQ < OK_MIN || n4xpFKQQ > OK_MAX) {
				throw new RestException(
						"Unexpected status code: " + n4xpFKQQ + ": " + iHb6sskN.getStatusText() + " -- " + iHb6sskN,
						n4xpFKQQ);
			}
			final InputStream lOJaWMqh = iHb6sskN.getResponseBodyAsStream();
			try {
				final StringWriter X7CPPihX = new StringWriter(2048);
				IOUtils.copy(lOJaWMqh, X7CPPihX, iHb6sskN.getResponseCharSet());
				return new Tuple(n4xpFKQQ, X7CPPihX.toString());
			} finally {
				lOJaWMqh.close();
			}
		} catch (NullPointerException uE1JqbAo) {
			if (qspBUcRU < 3) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException EPPdoOyN) {
					Thread.interrupted();
				}
				return execute(iHb6sskN, qspBUcRU + 1);
			}
			throw new IOException("Failed to connet to " + url + " [" + iHb6sskN + "]", uE1JqbAo);
		} catch (SocketException x0HSAksK) {
			if (qspBUcRU < 3) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException ucZOs8PF) {
					Thread.interrupted();
				}
				return execute(iHb6sskN, qspBUcRU + 1);
			}
			throw new IOException("Failed to connet to " + url + " [" + iHb6sskN + "]", x0HSAksK);
		} catch (IOException UrNnFzfy) {
			if (qspBUcRU < 3) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException rGvTtpkE) {
					Thread.interrupted();
				}
				return execute(iHb6sskN, qspBUcRU + 1);
			}
			throw UrNnFzfy;
		} finally {
			iHb6sskN.releaseConnection();
			TXI1sQ4M.stop();
		}
	}

}