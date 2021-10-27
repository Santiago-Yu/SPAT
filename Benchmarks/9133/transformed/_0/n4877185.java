class n4877185 {
	public byte[] getEncoded(X509Certificate rp7ozt9I, X509Certificate HllunyKc, String uoBDZ8vq) {
		try {
			if (rp7ozt9I == null || HllunyKc == null)
				return null;
			if (uoBDZ8vq == null) {
				uoBDZ8vq = PdfPKCS7.getOCSPURL(rp7ozt9I);
			}
			if (uoBDZ8vq == null)
				return null;
			OCSPReq yJbMXz0p = generateOCSPRequest(HllunyKc, rp7ozt9I.getSerialNumber());
			byte[] yWNTqctY = yJbMXz0p.getEncoded();
			URL PSXb44H7 = new URL(uoBDZ8vq);
			HttpURLConnection uN8wJ13p = (HttpURLConnection) PSXb44H7.openConnection();
			uN8wJ13p.setRequestProperty("Content-Type", "application/ocsp-request");
			uN8wJ13p.setRequestProperty("Accept", "application/ocsp-response");
			uN8wJ13p.setDoOutput(true);
			OutputStream AUlHI7FY = uN8wJ13p.getOutputStream();
			DataOutputStream hNgtasdU = new DataOutputStream(new BufferedOutputStream(AUlHI7FY));
			hNgtasdU.write(yWNTqctY);
			hNgtasdU.flush();
			hNgtasdU.close();
			if (uN8wJ13p.getResponseCode() / 100 != 2) {
				throw new IOException(
						MessageLocalization.getComposedMessage("invalid.http.response.1", uN8wJ13p.getResponseCode()));
			}
			InputStream ryWdd52R = (InputStream) uN8wJ13p.getContent();
			OCSPResp MlQKU634 = new OCSPResp(RandomAccessFileOrArray.InputStreamToArray(ryWdd52R));
			if (MlQKU634.getStatus() != 0)
				throw new IOException(MessageLocalization.getComposedMessage("invalid.status.1", MlQKU634.getStatus()));
			BasicOCSPResp ObtUQNJu = (BasicOCSPResp) MlQKU634.getResponseObject();
			if (ObtUQNJu != null) {
				SingleResp[] nfiRPceK = ObtUQNJu.getResponses();
				if (nfiRPceK.length == 1) {
					SingleResp LunO51cU = nfiRPceK[0];
					Object Hs8AUlc8 = LunO51cU.getCertStatus();
					if (Hs8AUlc8 == CertificateStatus.GOOD) {
						return ObtUQNJu.getEncoded();
					} else if (Hs8AUlc8 instanceof org.bouncycastle.ocsp.RevokedStatus) {
						throw new IOException(MessageLocalization.getComposedMessage("ocsp.status.is.revoked"));
					} else {
						throw new IOException(MessageLocalization.getComposedMessage("ocsp.status.is.unknown"));
					}
				}
			}
		} catch (Exception KnB6FuX3) {
			if (LOGGER.isLogging(Level.ERROR))
				LOGGER.error("OcspClientBouncyCastle", KnB6FuX3);
		}
		return null;
	}

}