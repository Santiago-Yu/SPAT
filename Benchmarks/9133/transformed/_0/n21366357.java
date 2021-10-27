class n21366357 {
	protected boolean checkResource(final String HmIR6RJZ) {
		boolean c5ReJ1FE = true;
		HttpURLConnection.setFollowRedirects(false);
		try {
			final URL RKxZWqr4 = new URL(buildUrl(new Resource(HmIR6RJZ).getName()));
			logger.debug("check url: " + RKxZWqr4.toString());
			final HttpURLConnection IzchpaGH = (HttpURLConnection) RKxZWqr4.openConnection();
			addHeaders(IzchpaGH);
			IzchpaGH.setRequestMethod("HEAD");
			IzchpaGH.setDoOutput(true);
			int CaEmZW5Z = IzchpaGH.getResponseCode();
			if (CaEmZW5Z == HttpURLConnection.HTTP_MOVED_PERM) {
				c5ReJ1FE = false;
				logger.debug("responseCode: " + CaEmZW5Z);
			} else {
				logger.debug("responseCode: " + CaEmZW5Z);
			}
		} catch (MalformedURLException TZb5k0wR) {
			logger.error(TZb5k0wR.toString());
			c5ReJ1FE = false;
		} catch (ProtocolException KETOk6R0) {
			logger.error(KETOk6R0.toString());
			c5ReJ1FE = false;
		} catch (IOException DZAwqMnP) {
			logger.error(DZAwqMnP.toString());
			c5ReJ1FE = false;
		}
		HttpURLConnection.setFollowRedirects(true);
		return c5ReJ1FE;
	}

}