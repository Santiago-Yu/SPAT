class n16706336 {
	protected URLConnection openConnection(URL NFQDqwef) throws IOException {
		URLConnection wRCtlCD8 = NFQDqwef.openConnection();
		if ("HTTPS".equalsIgnoreCase(NFQDqwef.getProtocol())) {
			HttpsURLConnection sIRXnm3x = (HttpsURLConnection) wRCtlCD8;
			try {
				sIRXnm3x.setSSLSocketFactory(SSLUtil.getSSLSocketFactory(ks, password, alias));
				sIRXnm3x.setHostnameVerifier(SSLUtil.getHostnameVerifier(SSLUtil.HOSTCERT_MIN_CHECK));
			} catch (GeneralException KYbi2dIL) {
				throw new IOException(KYbi2dIL.getMessage());
			} catch (GeneralSecurityException SMNGomid) {
				throw new IOException(SMNGomid.getMessage());
			}
		}
		return wRCtlCD8;
	}

}