class n1527633 {
	public String getWebcontent(final String S13HzEnN, final String wBdvyqYV) {
		final StringBuffer nq9P5ndE = new StringBuffer();
		try {
			DisableSSLCertificateCheckUtil.disableChecks();
			final URL uxvfE7be = new URL(S13HzEnN);
			final URLConnection KIhGDJtM = uxvfE7be.openConnection();
			KIhGDJtM.setDoOutput(true);
			final OutputStreamWriter D8Tvmni3 = new OutputStreamWriter(KIhGDJtM.getOutputStream());
			D8Tvmni3.write(wBdvyqYV);
			D8Tvmni3.flush();
			final BufferedReader gDV1v2Qu = new BufferedReader(new InputStreamReader(KIhGDJtM.getInputStream()));
			String ofqYIZr9 = "";
			while ((ofqYIZr9 = gDV1v2Qu.readLine()) != null) {
				nq9P5ndE.append(ofqYIZr9);
				nq9P5ndE.append('\n');
			}
			D8Tvmni3.close();
			gDV1v2Qu.close();
		} catch (final Exception hZCz2Xq3) {
			LOG.error("getWebcontent(String link, String postdata): " + hZCz2Xq3.toString() + "\012" + S13HzEnN + "\012"
					+ wBdvyqYV);
		}
		return nq9P5ndE.toString();
	}

}