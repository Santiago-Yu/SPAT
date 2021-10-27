class n2831663 {
	public void onMessage(Message message) {
		LOG.debug("onMessage");
		DownloadMessage downloadMessage;
		try {
			downloadMessage = new DownloadMessage(message);
		} catch (JMSException e) {
			LOG.error("JMS error: " + e.getMessage(), e);
			return;
		}
		String caName = downloadMessage.getCaName();
		boolean update = downloadMessage.isUpdate();
		LOG.debug("issuer: " + caName);
		CertificateAuthorityEntity certificateAuthority = this.certificateAuthorityDAO.findCertificateAuthority(caName);
		if (null == certificateAuthority) {
			LOG.error("unknown certificate authority: " + caName);
			return;
		}
		if (!update && Status.PROCESSING != certificateAuthority.getStatus()) {
			LOG.debug("CA status not marked for processing");
			return;
		}
		String crlUrl = certificateAuthority.getCrlUrl();
		if (null == crlUrl) {
			LOG.warn("No CRL url for CA " + certificateAuthority.getName());
			certificateAuthority.setStatus(Status.NONE);
			return;
		}
		HttpClient httpClient = new HttpClient();
		NetworkConfig networkConfig = this.configurationDAO.getNetworkConfig();
		if (null != networkConfig) {
			httpClient.getHostConfiguration().setProxy(networkConfig.getProxyHost(), networkConfig.getProxyPort());
		}
		HttpClientParams httpClientParams = httpClient.getParams();
		httpClientParams.setParameter("http.socket.timeout", new Integer(1000 * 20));
		LOG.debug("downloading CRL from: " + crlUrl);
		GetMethod getMethod = new GetMethod(crlUrl);
		getMethod.addRequestHeader("User-Agent", "jTrust CRL Client");
		int statusCode;
		try {
			statusCode = httpClient.executeMethod(getMethod);
		} catch (Exception e) {
			downloadFailed(caName, crlUrl);
			throw new RuntimeException();
		}
		String crlFilePath;
		if (HttpURLConnection.HTTP_OK != statusCode) {
			LOG.debug("HTTP status code: " + statusCode);
			downloadFailed(caName, crlUrl);
			throw new RuntimeException();
		}
		File crlFile = null;
		try {
			crlFile = File.createTempFile("crl-", ".der");
			OutputStream crlOutputStream = new FileOutputStream(crlFile);
			InputStream crlInputStream = getMethod.getResponseBodyAsStream();
			IOUtils.copy(crlInputStream, crlOutputStream);
			IOUtils.closeQuietly(crlInputStream);
			IOUtils.closeQuietly(crlOutputStream);
			crlFilePath = crlFile.getAbsolutePath();
			LOG.debug("temp CRL file: " + crlFilePath);
		} catch (IOException e) {
			downloadFailed(caName, crlUrl);
			throw new RuntimeException(e);
			if (null != crlFile) {
				crlFile.delete();
			}
		}
		try {
			this.notificationService.notifyHarvester(caName, crlFilePath, update);
		} catch (JMSException e) {
			crlFile.delete();
			throw new RuntimeException(e);
		}
	}

}