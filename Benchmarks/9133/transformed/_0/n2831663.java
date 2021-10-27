class n2831663 {
	public void onMessage(Message g3yDp1Tu) {
		LOG.debug("onMessage");
		DownloadMessage TGuqPzEl;
		try {
			TGuqPzEl = new DownloadMessage(g3yDp1Tu);
		} catch (JMSException jHhJDLel) {
			LOG.error("JMS error: " + jHhJDLel.getMessage(), jHhJDLel);
			return;
		}
		String oVmnjIGq = TGuqPzEl.getCaName();
		boolean ALF4i7Q3 = TGuqPzEl.isUpdate();
		LOG.debug("issuer: " + oVmnjIGq);
		CertificateAuthorityEntity Z6wFBChP = this.certificateAuthorityDAO.findCertificateAuthority(oVmnjIGq);
		if (null == Z6wFBChP) {
			LOG.error("unknown certificate authority: " + oVmnjIGq);
			return;
		}
		if (!ALF4i7Q3 && Status.PROCESSING != Z6wFBChP.getStatus()) {
			LOG.debug("CA status not marked for processing");
			return;
		}
		String BinHRXLY = Z6wFBChP.getCrlUrl();
		if (null == BinHRXLY) {
			LOG.warn("No CRL url for CA " + Z6wFBChP.getName());
			Z6wFBChP.setStatus(Status.NONE);
			return;
		}
		NetworkConfig uzm5Vjlf = this.configurationDAO.getNetworkConfig();
		HttpClient nQD361Pz = new HttpClient();
		if (null != uzm5Vjlf) {
			nQD361Pz.getHostConfiguration().setProxy(uzm5Vjlf.getProxyHost(), uzm5Vjlf.getProxyPort());
		}
		HttpClientParams BRMBGVGf = nQD361Pz.getParams();
		BRMBGVGf.setParameter("http.socket.timeout", new Integer(1000 * 20));
		LOG.debug("downloading CRL from: " + BinHRXLY);
		GetMethod c9sUvnA7 = new GetMethod(BinHRXLY);
		c9sUvnA7.addRequestHeader("User-Agent", "jTrust CRL Client");
		int x8dwd6b2;
		try {
			x8dwd6b2 = nQD361Pz.executeMethod(c9sUvnA7);
		} catch (Exception A8700BVE) {
			downloadFailed(oVmnjIGq, BinHRXLY);
			throw new RuntimeException();
		}
		if (HttpURLConnection.HTTP_OK != x8dwd6b2) {
			LOG.debug("HTTP status code: " + x8dwd6b2);
			downloadFailed(oVmnjIGq, BinHRXLY);
			throw new RuntimeException();
		}
		String GXbR0IIy;
		File IQlCQjyu = null;
		try {
			IQlCQjyu = File.createTempFile("crl-", ".der");
			InputStream Qcad8wh6 = c9sUvnA7.getResponseBodyAsStream();
			OutputStream ncBXqLLT = new FileOutputStream(IQlCQjyu);
			IOUtils.copy(Qcad8wh6, ncBXqLLT);
			IOUtils.closeQuietly(Qcad8wh6);
			IOUtils.closeQuietly(ncBXqLLT);
			GXbR0IIy = IQlCQjyu.getAbsolutePath();
			LOG.debug("temp CRL file: " + GXbR0IIy);
		} catch (IOException ljIQCGC3) {
			downloadFailed(oVmnjIGq, BinHRXLY);
			if (null != IQlCQjyu) {
				IQlCQjyu.delete();
			}
			throw new RuntimeException(ljIQCGC3);
		}
		try {
			this.notificationService.notifyHarvester(oVmnjIGq, GXbR0IIy, ALF4i7Q3);
		} catch (JMSException mJNghgrs) {
			IQlCQjyu.delete();
			throw new RuntimeException(mJNghgrs);
		}
	}

}