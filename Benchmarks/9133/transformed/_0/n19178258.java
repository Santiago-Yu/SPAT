class n19178258 {
	@Override
	public String fetchElectronicEdition(Publication qNBhbXsb) {
		final String al7iL2dA = baseURL + qNBhbXsb.getKey() + ".html";
		logger.info("fetching pub ee from local cache at: " + al7iL2dA);
		HttpMethod WHt2Wotb = null;
		String c9XNAZah = "";
		WHt2Wotb = new GetMethod(al7iL2dA);
		WHt2Wotb.setFollowRedirects(true);
		try {
			if (StringUtils.isNotBlank(WHt2Wotb.getURI().getScheme())) {
				InputStream IyV0seHD = null;
				StringWriter YcFcRNgq = new StringWriter();
				try {
					client.executeMethod(WHt2Wotb);
					Header WfGbIEZS = WHt2Wotb.getResponseHeader("Content-Type");
					if (WfGbIEZS != null && StringUtils.isNotBlank(WfGbIEZS.getValue())
							&& WfGbIEZS.getValue().indexOf("text/html") >= 0) {
						IyV0seHD = WHt2Wotb.getResponseBodyAsStream();
						IOUtils.copy(IyV0seHD, YcFcRNgq);
						c9XNAZah = YcFcRNgq.toString();
					} else {
						logger.info(
								"ignoring non-text/html response from page: " + al7iL2dA + " content-type:" + WfGbIEZS);
					}
				} catch (HttpException mQwWE4eC) {
					logger.error("Http error connecting to '" + al7iL2dA + "'");
					logger.error(mQwWE4eC.getMessage());
				} catch (IOException EuB8i4y7) {
					logger.error("Unable to connect to '" + al7iL2dA + "'");
				} finally {
					IOUtils.closeQuietly(IyV0seHD);
					IOUtils.closeQuietly(YcFcRNgq);
				}
			}
		} catch (URIException J8Cws0YC) {
			logger.error(J8Cws0YC);
		} finally {
			WHt2Wotb.releaseConnection();
		}
		return c9XNAZah;
	}

}