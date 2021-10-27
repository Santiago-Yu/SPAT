class n11798810 {
	private synchronized Document executeHttpMethod(final HttpUriRequest vNWIXb5F)
			throws UnauthorizedException, ThrottledException, ApiException {
		if (!isNextRequestAllowed()) {
			try {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Wait " + WAITING_TIME + "ms for request.");
				}
				wait(WAITING_TIME);
			} catch (InterruptedException KniEpjWY) {
				throw new ApiException("Waiting for request interrupted.", KniEpjWY);
			}
		}
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Perform request.");
			}
			HttpResponse YGr1BIEu = httpClient.execute(vNWIXb5F);
			switch (YGr1BIEu.getStatusLine().getStatusCode()) {
			case HTTP_OK:
				HttpEntity GRd9MyGH = YGr1BIEu.getEntity();
				if (GRd9MyGH != null) {
					InputStream tKN2gGld = GRd9MyGH.getContent();
					if (tKN2gGld == null) {
						throw new ApiException("TODO");
					} else {
						String k0QkKVGA = null;
						try {
							k0QkKVGA = IOUtils.toString(tKN2gGld, RESPONSE_ENCODING);
						} catch (IOException Xes2ewOO) {
							throw new ApiException("Problem reading response", Xes2ewOO);
						} catch (RuntimeException e0opJk2n) {
							vNWIXb5F.abort();
							throw new ApiException("Problem reading response", e0opJk2n);
						} finally {
							tKN2gGld.close();
						}
						StringReader HuCmdDTg = new StringReader(k0QkKVGA);
						Document nT1n5jgk = documentBuilder.parse(new InputSource(HuCmdDTg));
						return nT1n5jgk;
					}
				}
			case HTTP_UNAVAILABLE:
				throw new ThrottledException("TODO");
			case HTTP_UNAUTHORIZED:
				throw new UnauthorizedException("TODO");
			default:
				throw new ApiException("Unexpected HTTP status code: " + YGr1BIEu.getStatusLine().getStatusCode());
			}
		} catch (SAXException oE7QTXeO) {
			throw new ApiException("TODO", oE7QTXeO);
		} catch (IOException TyEZMl3A) {
			throw new ApiException("TODO", TyEZMl3A);
		} finally {
			updateLastRequestTimestamp();
		}
	}

}