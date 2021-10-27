class n18034360 {
	public boolean download(String kti8PMVw) {
		HttpGet msGS4lda = new HttpGet(kti8PMVw);
		String S6n6KVuE = FileUtils.replaceNonAlphanumericCharacters(kti8PMVw);
		String Jsiogp9e = directory + File.separatorChar + S6n6KVuE;
		int NqiiiuM5 = MAX_RETRIES;
		while (NqiiiuM5 > 0) {
			try {
				HttpResponse fPniISgD = httpClient.execute(msGS4lda);
				HttpEntity ezxCqt3F = fPniISgD.getEntity();
				if (ezxCqt3F != null) {
					logger.info("Downloading file from " + kti8PMVw + " -> " + Jsiogp9e);
					IOUtils.copy(ezxCqt3F.getContent(), new FileOutputStream(Jsiogp9e));
					logger.info("File " + S6n6KVuE + " was downloaded successfully.");
					setFileSize(new File(Jsiogp9e).length());
					setFilename(S6n6KVuE);
					return true;
				} else {
					logger.warn(
							"Trouble downloading file from " + kti8PMVw + ". Status was: " + fPniISgD.getStatusLine());
				}
			} catch (ClientProtocolException WIpXGisi) {
				logger.error("Protocol error. This is probably serious, and there's no need "
						+ "to continue trying to download this file.", WIpXGisi);
				return false;
			} catch (IOException kBrFl5kc) {
				logger.warn("IO trouble: " + kBrFl5kc.getMessage() + ". Retries left: " + NqiiiuM5);
			}
			NqiiiuM5--;
		}
		return false;
	}

}