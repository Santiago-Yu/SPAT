class n16200294 {
	@Override
	public String fetchElectronicEdition(Publication YYCTUCyH) {
		final String wHuta97D = YYCTUCyH.getEe();
		HttpMethod ZjYwWxo1 = null;
		String qtti9NC7 = "";
		ZjYwWxo1 = new GetMethod(wHuta97D);
		ZjYwWxo1.setFollowRedirects(true);
		try {
			if (StringUtils.isNotBlank(ZjYwWxo1.getURI().getScheme())) {
				InputStream Hv1ZED4j = null;
				StringWriter S7OOlxwc = new StringWriter();
				try {
					client.executeMethod(ZjYwWxo1);
					Header ckLUjbX6 = ZjYwWxo1.getResponseHeader("Content-Type");
					if (ckLUjbX6 != null && StringUtils.isNotBlank(ckLUjbX6.getValue())
							&& ckLUjbX6.getValue().indexOf("text/html") >= 0) {
						Hv1ZED4j = ZjYwWxo1.getResponseBodyAsStream();
						IOUtils.copy(Hv1ZED4j, S7OOlxwc);
						qtti9NC7 = S7OOlxwc.toString();
					} else {
						logger.info(
								"ignoring non-text/html response from page: " + wHuta97D + " content-type:" + ckLUjbX6);
					}
				} catch (HttpException TDO3KZ0I) {
					logger.error("Http error connecting to '" + wHuta97D + "'");
					logger.error(TDO3KZ0I.getMessage());
				} catch (IOException tfIn1pyH) {
					logger.error("Unable to connect to '" + wHuta97D + "'");
				} finally {
					IOUtils.closeQuietly(Hv1ZED4j);
					IOUtils.closeQuietly(S7OOlxwc);
				}
			}
		} catch (URIException YvOGaNAk) {
			logger.error(YvOGaNAk);
		} finally {
			ZjYwWxo1.releaseConnection();
		}
		return qtti9NC7;
	}

}