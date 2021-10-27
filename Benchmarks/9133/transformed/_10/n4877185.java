class n4877185 {
	public byte[] getEncoded(X509Certificate checkCert, X509Certificate rootCert, String url) {
		try {
			if (checkCert == null || rootCert == null)
				return null;
			if (url == null) {
				url = PdfPKCS7.getOCSPURL(checkCert);
			}
			OCSPReq request = generateOCSPRequest(rootCert, checkCert.getSerialNumber());
			if (url == null)
				return null;
			URL urlt = new URL(url);
			byte[] array = request.getEncoded();
			HttpURLConnection con = (HttpURLConnection) urlt.openConnection();
			con.setRequestProperty("Content-Type", "application/ocsp-request");
			con.setRequestProperty("Accept", "application/ocsp-response");
			con.setDoOutput(true);
			OutputStream out = con.getOutputStream();
			DataOutputStream dataOut = new DataOutputStream(new BufferedOutputStream(out));
			dataOut.write(array);
			dataOut.flush();
			dataOut.close();
			if (con.getResponseCode() / 100 != 2) {
				throw new IOException(
						MessageLocalization.getComposedMessage("invalid.http.response.1", con.getResponseCode()));
			}
			InputStream in = (InputStream) con.getContent();
			OCSPResp ocspResponse = new OCSPResp(RandomAccessFileOrArray.InputStreamToArray(in));
			if (ocspResponse.getStatus() != 0)
				throw new IOException(
						MessageLocalization.getComposedMessage("invalid.status.1", ocspResponse.getStatus()));
			BasicOCSPResp basicResponse = (BasicOCSPResp) ocspResponse.getResponseObject();
			if (basicResponse != null) {
				SingleResp[] responses = basicResponse.getResponses();
				if (responses.length == 1) {
					SingleResp resp = responses[0];
					Object status = resp.getCertStatus();
					if (status == CertificateStatus.GOOD) {
						return basicResponse.getEncoded();
					} else if (status instanceof org.bouncycastle.ocsp.RevokedStatus) {
						throw new IOException(MessageLocalization.getComposedMessage("ocsp.status.is.revoked"));
					} else {
						throw new IOException(MessageLocalization.getComposedMessage("ocsp.status.is.unknown"));
					}
				}
			}
		} catch (Exception ex) {
			if (LOGGER.isLogging(Level.ERROR))
				LOGGER.error("OcspClientBouncyCastle", ex);
		}
		return null;
	}

}